package com.lycoon.clashapi.cocmodels.player;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lycoon.clashapi.cocmodels.clan.ClanModel;
import com.lycoon.clashapi.cocmodels.clan.Label;

public class Player
{
	@SerializedName("clan")
	@Expose
	private ClanModel clan;
	
	@SerializedName("league")
	@Expose
	private Label league;
	
	@SerializedName("role")
	@Expose
	private String role;
	
	@SerializedName("attackWins")
	@Expose
	private Integer attackWins;
	
	@SerializedName("defenseWins")
	@Expose
	private Integer defenseWins;
	
	@SerializedName("townHallLevel")
	@Expose
	private Integer townHallLevel;
	
	@SerializedName("townHallWeaponLevel")
	@Expose
	private Integer townHallWeaponLevel;
	
	@SerializedName("versusBattleWins")
	@Expose
	private Integer versusBattleWins;
	
	@SerializedName("legendStatistics")
	@Expose
	private LegendStatistics legendStatistics;
	
	@SerializedName("troops")
	@Expose
	private List<Troop> troops = null;
	
	@SerializedName("heroes")
	@Expose
	private List<Troop> heroes = null;
	
	@SerializedName("spells")
	@Expose
	private List<Troop> spells = null;
	
	@SerializedName("labels")
	@Expose
	private List<Label> labels = null;
	
	@SerializedName("tag")
	@Expose
	private String tag;
	
	@SerializedName("name")
	@Expose
	private String name;
	
	@SerializedName("expLevel")
	@Expose
	private Integer expLevel;
	
	@SerializedName("trophies")
	@Expose
	private Integer trophies;
	
	@SerializedName("bestTrophies")
	@Expose
	private Integer bestTrophies;
	
	@SerializedName("donations")
	@Expose
	private Integer donations;
	
	@SerializedName("donationsReceived")
	@Expose
	private Integer donationsReceived;
	
	@SerializedName("builderHallLevel")
	@Expose
	private Integer builderHallLevel;
	
	@SerializedName("versusTrophies")
	@Expose
	private Integer versusTrophies;
	
	@SerializedName("bestVersusTrophies")
	@Expose
	private Integer bestVersusTrophies;
	
	@SerializedName("warStars")
	@Expose
	private Integer warStars;
	
	@SerializedName("achievements")
	@Expose
	private List<Achievement> achievements = null;
	
	@SerializedName("versusBattleWinCount")
	@Expose
	private Integer versusBattleWinCount;

	/**
	 * Returns the clan the player belongs to.
	 * 
	 * @return a <code>ClanModel</code> object with all clan data the player belongs to
	 * @see ClanModel
	 */
	public ClanModel getClan()
	{
		return clan;
	}
	
	public Label getLeague()
	{
		return league;
	}
	
	/**
	 * Returns a <code>String</code> of the player's role in the clan he belongs to.
	 * 
	 * @return <code>member</code> if the player has not been given any role in the clan<br>
	 * <code>admin</code> if the player has been given the elder role<br>
	 * <code>coLeader</code> if the player has been given the co-leader role<br>
	 * <code>leader</code> if it is the leader of the clan
	 */
	public String getRole()
	{
		return role;
	}

	/**
	 * Returns how many attacks the player won during the current season.<br>
	 * A won attack is an attack where the player earned at least 1 star.<br><br>
	 * 
	 * It <b>does</b> only include attacks from the main village.<br>
	 * It <b>does not</b> include attacks from clan wars.
	 * 
	 * @return an integer corresponding to how many attacks the player won during the current season
	 */
	public Integer getAttackWins()
	{
		return attackWins;
	}
	
	/**
	 * Returns how many defenses the player won during the current season.<br>
	 * A won defense is a defense where the attacker earned no star against your village.<br><br>
	 * 
	 * It <b>does</b> only include defenses from the main village.<br>
	 * It <b>does not</b> include defenses from clan wars.
	 * 
	 * @return an integer corresponding to how many defenses the player won during the current season
	 */
	public Integer getDefenseWins()
	{
		return defenseWins;
	}
	
	/**
	 * Returns the current level of the player's townhall.<br><br>
	 * Ranges from <code>1</code> to <code>13</code>.
	 * 
	 * @return an integer corresponding to the current level of the player's townhall
	 */
	public Integer getTownHallLevel()
	{
		return townHallLevel;
	}
	
	/**
	 * Returns the current level of the player's townhall weapon.<br>
	 * The townhall weapon level only concerns townhall level 13.<br><br>
	 * Ranges from <code>1</code> to <code>5</code>.
	 * 
	 * @return an integer corresponding to the current level of the townhall weapon
	 */
	public Integer getTownHallWeaponLevel()
	{
		return townHallWeaponLevel;
	}
	
	/**
	 * Returns the number of won attacks in the builder base.
	 * 
	 * @return an integer corresponding to the number of won attacks in the builder base
	 */
	public Integer getVersusBattleWins()
	{
		return versusBattleWins;
	}

	/**
	 * Returns a set of season data<br>
	 * 
	 * @return a <code>LegendStatistics</code> object gathering scores of player's seasons
	 * @see Season
	 */
	public LegendStatistics getLegendStatistics()
	{
		return legendStatistics;
	}
	
	/**
	 * Returns all the troops the player has<br>
	 * 
	 * @return a <code>List</code> containing all the troops the player unlocked
	 * @see Troop
	 */
	public List<Troop> getTroops()
	{
		return troops;
	}
	
	/**
	 * Returns all the heroes the player has<br>
	 * 
	 * @return a <code>List</code> containing all the heroes the player unlocked
	 * @see Troop
	 */
	public List<Troop> getHeroes()
	{
		return heroes;
	}
	
	/**
	 * Returns all the spells the player has<br>
	 * 
	 * @return a <code>List</code> containing all the spells the player unlocked
	 * @see Troop
	 */
	public List<Troop> getSpells()
	{
		return spells;
	}
	
	/**
	 * Returns the labels the player has on its profile<br>
	 * 
	 * @return a <code>List</code> containing the labels displayed on the player's profile
	 * @see Label
	 */
	public List<Label> getLabels()
	{
		return labels;
	}
	
	/**
	 * Returns the tag of the player.<br>
	 * The tag is a unique identifier each player has, in the form of #A0B1C2.<br>
	 * It appears on your profile under your nickname.
	 * 
	 * @return a <code>String</code> containing the player's tag
	 */
	public String getTag()
	{
		return tag;
	}
	
	/**
	 * Returns the name of the player.<br>
	 * The name is the identity behind which you appear when you write in chat.
	 * 
	 * @return a <code>String</code> containing the player's nickname
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the current experience level of the player.<br>
	 * 
	 * @return an integer corresponding to the current experience level of the player
	 */
	public Integer getExpLevel()
	{
		return expLevel;
	}
	
	/**
	 * Returns the current number of trophies of the player.<br>
	 * 
	 * @return an integer corresponding to the current number of trophies of the player
	 */
	public Integer getTrophies()
	{
		return trophies;
	}
	
	/**
	 * Returns the highest number of trophies the player had.<br>
	 * 
	 * @return an integer corresponding to the highest number of trophies the player had
	 */
	public Integer getBestTrophies()
	{
		return bestTrophies;
	}
	
	/**
	 * Returns the number of donations the player did in its clan during the season.<br>
	 * 
	 * @return an integer corresponding to the number of donations the player did in its clan during the season
	 */
	public Integer getDonations()
	{
		return donations;
	}
	
	/**
	 * Returns the number of donations the player received in its clan during the season.<br>
	 * 
	 * @return an integer corresponding to the number of donations the player received in its clan during the season
	 */
	public Integer getDonationsReceived()
	{
		return donationsReceived;
	}
	
	/**
	 * Returns the level of the player's builder hall.<br><br>
	 * Ranges from <code>1</code> to <code>9</code>.
	 * 
	 * @return an integer corresponding to the level of the player's builder hall
	 */
	public Integer getBuilderHallLevel()
	{
		return builderHallLevel;
	}
	
	/**
	 * Returns the number of trophies earned in the main village of the player.<br>
	 * 
	 * @return an integer corresponding to the number of trophies earned in the main village of the player
	 */
	public Integer getVersusTrophies()
	{
		return versusTrophies;
	}
	
	/**
	 * Returns the highest number of trophies the player had in the builder base.
	 * 
	 * @return an integer corresponding to the highest number of trophies the player had in the builder base
	 */
	public Integer getBestVersusTrophies()
	{
		return bestVersusTrophies;
	}
	
	/**
	 * Returns a number corresponding to the total number of stars earned in clan wars
	 * 
	 * @return an integer corresponding to the total number of stars earned in clan wars
	 */
	public Integer getWarStars()
	{
		return warStars;
	}
	
	/**
	 * Returns the achievements of the player<br>
	 * 
	 * @return a <code>List</code> containing <code>Achievement</code> objects holding achievements of the player
	 * @see Achievement
	 */
	public List<Achievement> getAchievements()
	{
		return achievements;
	}
	
	/**
	 * Returns the number of won battles in the builder base.<br>
	 * 
	 * @return an integer corresponding to the number of won battles in the builder base
	 */
	public Integer getVersusBattleWinCount()
	{
		return versusBattleWinCount;
	}
}
