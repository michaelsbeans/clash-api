package com.lycoon.clashapi.core.auth

import com.lycoon.clashapi.core.CoreUtils.deserialize
import com.lycoon.clashapi.core.CoreUtils.getRequestBody
import com.lycoon.clashapi.core.auth.dtos.Key
import com.lycoon.clashapi.core.auth.dtos.KeyCreation
import com.lycoon.clashapi.core.auth.dtos.KeyDeletion
import com.lycoon.clashapi.core.auth.dtos.ListKeyResponse
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.EMPTY_REQUEST
import java.io.IOException
import java.net.URL

typealias Keys = HashMap<String, List<String>> // [key: String]: List<ip: String>

class KeyManager
{
    val IP_CHECKER_URL = "http://checkip.amazonaws.com"
    val KEY_API_URL = "https://developer.clashofclans.com/api/apikey"

    private val ip: String = getIP()

    @Throws(IOException::class)
    private fun getIP(): String {
        return URL(IP_CHECKER_URL).readText()
    }

    private fun getKeyCreation(ips: List<String>): KeyCreation {
        return KeyCreation("ClashAPI Key", "This key has been automatically generated because an instance of ClashAPI has been created with these account credentials.", ips)
    }

    /**
     * Fetches the current keys from the developer
     * @param client The OkHttpClient needs to own auth cookies by calling login(email, password) before
     * @return List of keys
     */
    fun fetchKeys(client: OkHttpClient): List<Key>
    {
        val req = Request.Builder().url("$KEY_API_URL/list").post(EMPTY_REQUEST).build()
        val res = client.newCall(req).execute()
        val keys = deserialize<ListKeyResponse>(res).keys
        return keys
    }

    /**
     * Creates a new key for given IPs, also checks if there exists valid tokens to avoid duplicates
     * @param client The OkHttpClient needs to own auth cookies by calling login(email, password) before
     * @return generated token from the key
     */
    fun createKey(client: OkHttpClient): String { return createKey(client, listOf(ip)) }
    fun createKey(client: OkHttpClient, ips: List<String>): String
    {
        if (getValidTokens(client, ips).isNotEmpty())
            throw Exception("There are already valid tokens, please delete them before creating a new key.")

        val keyCreation = getKeyCreation(listOf(ip))
        val body = getRequestBody(keyCreation)
        val req = Request.Builder().url("$KEY_API_URL/create").post(body).build()

        val res = client.newCall(req).execute()
        if (!res.isSuccessful)
            throw Exception("Failed to generate new key")

        return deserialize<Key>(res).key
    }

    /**
     * Deletes a key
     * @param client The OkHttpClient needs to own auth cookies by calling login(email, password) before
     * @param key The key to delete
     */
    fun deleteKey(client: OkHttpClient, key: String)
    {
        val body = getRequestBody(KeyDeletion(key))
        val req = Request.Builder().url("$KEY_API_URL/revoke").post(body).build()
        client.newCall(req).execute()
    }

    /**
     * Returns a list of valid tokens for given IPs
     */
    fun getValidTokens(client: OkHttpClient): List<String> { return getValidTokens(client, listOf(ip), fetchKeys(client)) }
    fun getValidTokens(client: OkHttpClient, ips: List<String>): List<String> { return getValidTokens(client, ips, fetchKeys(client)) }
    fun getValidTokens(client: OkHttpClient, ips: List<String>, keys: List<Key>): List<String>
    {
        val validTokens = keys.filter{ it.cidrRanges.contains(ip) }.map{ it.key }
        return validTokens
    }
}