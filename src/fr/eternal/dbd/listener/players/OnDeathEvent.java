package fr.eternal.dbd.listener.players;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import fr.eternal.dbd.DBDMinecraft;

public class OnDeathEvent implements Listener {

	/**
	 * main for constructor
	 */
	private DBDMinecraft main;
	
	/**
	 * Constructor for manager class
	 * 
	 * @param main
	 */
	public OnDeathEvent(DBDMinecraft main) {
		this.main = main;
	}

	public void onDeathEvent(PlayerDeathEvent e) {
		Player player = e.getEntity();
		if (this.main.getSurvivantPlayers().get(this.main.getSurvivantPlayers().indexOf(player)) != null) {
			this.main.getSurvivantPlayers().remove(player);
			player.setGameMode(GameMode.SPECTATOR);
		}
		if (this.main.getKiller() == player) {
			this.main.setKiller(null);
			player.setGameMode(GameMode.SPECTATOR);
		}
	}
	
}
