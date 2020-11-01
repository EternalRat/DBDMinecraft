package fr.eternal.dbd.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.eternal.dbd.GStates;
import fr.eternal.dbd.DBDMinecraft;


/**
 * Class which manage events done when someone join the server
 * 
 * @author EternalRat
 * @version 1.0
 * @since 01/11/2020
 *
 */
public class OnJoin implements Listener {
	
	/**
	 * Main class
	 */
	private DBDMinecraft main;

	/**
	 * Constructor for OnJoin class
	 * 
	 * @param main	Principal class
	 */
	public OnJoin(DBDMinecraft main) {
		this.main = main;
	}

	/**
	 * onJoin event function, triggered when someone join the server
	 * 
	 * @param e	Event triggered
	 */
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		player.sendTitle("Welcome", "Dead By Daylight made by EternalRat", 10, 80, 20);
		Location spawn = new Location(player.getWorld(), 91.815, 4, -37.031, 90f, -0.9f);
		player.teleport(spawn);
		player.getInventory().clear();
		player.setFoodLevel(20);
		player.setHealth(20);
		
		if (!main.isState(GStates.WAITING)) {
			player.setGameMode(GameMode.SPECTATOR);
			player.sendMessage("The game already started.");
			e.setJoinMessage(null);
			return;
		}
		
		if (!main.getPlayers().contains(player)) main.getPlayers().add(player);
		player.setGameMode(GameMode.ADVENTURE);
		e.setJoinMessage("§7[§cDEAD BY DAYLIGHT MINECRAFT VERSION§7]§r " + player.getName() + " has joined the game.");
	}

}
