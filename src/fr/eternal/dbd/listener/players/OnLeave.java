package fr.eternal.dbd.listener.players;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.eternal.dbd.DBDMinecraft;

public class OnLeave implements Listener {
	/**
	 * Main class
	 */
	private DBDMinecraft main;

	/**
	 * Constructor for OnJoin class
	 * 
	 * @param main	Principal class
	 */
	public OnLeave(DBDMinecraft main) {
		this.main = main;
	}

	/**
	 * onJoin event function, triggered when someone join the server
	 * 
	 * @param e	Event triggered
	 */
	@EventHandler
	public void onJoin(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		Location spawn = new Location(player.getWorld(), 91.815, 4, -37.031, 90f, -0.9f);
		player.teleport(spawn);
		player.getInventory().clear();
		player.setFoodLevel(20);
		player.setHealth(20);
		if (this.main.getPlayers().contains(player)) this.main.getPlayers().remove(this.main.getPlayers().indexOf(player));
		if (this.main.getSurvivantPlayers().contains(player)) this.main.getSurvivantPlayers().remove(this.main.getSurvivantPlayers().indexOf(player));
		if (this.main.getKiller() == player) this.main.setKiller(null);
		if (this.main.getGuard() == player) this.main.setGuard(null);
		player.setGameMode(GameMode.ADVENTURE);
		Bukkit.broadcastMessage("§7[§cDEAD BY DAYLIGHT MINECRAFT VERSION§7]§r " + player.getName() + " has left the game.");
	}
}
