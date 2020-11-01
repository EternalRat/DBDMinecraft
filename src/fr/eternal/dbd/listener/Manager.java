package fr.eternal.dbd.listener;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.eternal.dbd.DBDMinecraft;
import fr.eternal.dbd.listener.blocks.OnBlocksEvent;
import fr.eternal.dbd.listener.players.OnDeathEvent;
import fr.eternal.dbd.listener.players.OnJoin;
import fr.eternal.dbd.listener.players.OnLeave;

/**
 * Class which manage events
 * 
 * @author EternalRat
 * @version 1.0
 * @since 01/11/2020
 *
 */
public class Manager extends JavaPlugin {

	/**
	 * main for constructor
	 */
	private DBDMinecraft main;
	
	/**
	 * Constructor for manager class
	 * 
	 * @param main
	 */
	public Manager(DBDMinecraft main) {
		this.main = main;
	}
	
	/**
	 * Listener manager
	 */
	public void ListenerManager() {
		/* Join event done by using a Listener */
		Listener joinEvent = new OnJoin(this.main);
		PluginManager joinEventPM = getServer().getPluginManager();
		joinEventPM.registerEvents(joinEvent, this.main);
		
		/* Leave event done by using a Listener */
		Listener leaveEvent = new OnLeave(this.main);
		PluginManager leaveEventPM = getServer().getPluginManager();
		leaveEventPM.registerEvents(leaveEvent, this.main);
		
		/* Cancel event done on blocks by using a Listener */
		Listener blocksEvent = new OnBlocksEvent();
		PluginManager blocksEventPM = getServer().getPluginManager();
		blocksEventPM.registerEvents(blocksEvent, this.main);
		
		/* Death event done when a player die by using a Listener */
		Listener deathEvent = new OnDeathEvent(this);
		PluginManager deathEventPM = getServer().getPluginManager();
		deathEventPM.registerEvents(deathEvent, this.main);
	}

}
