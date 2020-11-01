package fr.eternal.dbd;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.eternal.dbd.GStates;
import fr.eternal.dbd.commands.StartCommand;
import fr.eternal.dbd.listener.Manager;
import fr.eternal.dbd.listener.blocks.OnBlocksEvent;
import fr.eternal.dbd.listener.players.OnJoin;


/**
 * Principal class, triggered when the plugin is placed into a server
 * 
 * @author EternalRat
 * @version 1.0
 * @since 01/11/2020
 *
 */
public class DBDMinecraft extends JavaPlugin {
	/**
	 * List of player marked as Survivors
	 */
	private List<Player> survivors = new ArrayList<Player>();
	/**
	 * List of player
	 */
	private List<Player> players = new ArrayList<Player>();
	/**
	 * Player marked as a Guard
	 */
	private Player guard = null;
	/**
	 * Player marked as the killer
	 */
	private Player killer = null;
	/**
	 * Game states
	 */
	private GStates states;
	
	/**
	 * On function
	 */
	@Override
	public void onEnable() {
		/* Console log to check if the plugin is loaded. */
		System.out.println(this.getName() + " on!");
		
		/* Listener manager */
		Manager lManager = new Manager(this);
		lManager.ListenerManager();
		
		/* Commands Manager */
		getCommand("start").setExecutor(new StartCommand(this));
	}

	/**
	 * Off function
	 */
	@Override
	public void onDisable() {
		System.out.println(this.getName() + " off!");
	}
	
	/**
	 * Set a new state to the game
	 * 
	 * @param states	States contained by GStates enum
	 */
	public void setState(GStates states) {
		this.states = states;
	}
	
	/**
	 * Compare the two states
	 * 
	 * @param states	States which need to be check
	 * @return	boolean type : true/false
	 */
	public boolean isState(GStates states) {
		return this.states == states;
	}
	
	
	/**
	 * Get the list of all players marked as "Survivors"
	 * @return Survivors list
	 */
	public List<Player> getSurvivantPlayers() {
		return survivors;
	}
	
	/**
	 * Get the list of all players
	 * 
	 * @return players list
	 */
	public List<Player> getPlayers() {
		return players;
	}
	
	/**
	 * Set the killer
	 * @param p	Player destined to be the killer
	 */
	public void setKiller(Player p) {
		this.killer = p;
	}
	
	/**
	 * Get the current killer
	 * 
	 * @return killer variable
	 */
	public Player getKiller() {
		return this.killer;
	}
	
	/**
	 * Set the guard
	 * 
	 * @param p	Player destined to be the guard
	 */
	public void setGuard(Player p) {
		this.guard = p;
	}
	
	/**
	 * Get the current guard
	 * 
	 * @return guard variable
	 */
	public Player getGuard() {
		return this.guard;
	}
}
