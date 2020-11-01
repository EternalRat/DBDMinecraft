package fr.eternal.dbd.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.eternal.dbd.DBDMinecraft;

/**
 * Start command class, triggered when the command start is done
 * 
 * @author EternalRat
 * @version 1.0
 * @since 01/11/2020
 *
 */
public class StartCommand implements CommandExecutor {

	/**
	 * Main class
	 */
	private DBDMinecraft main;

	/**
	 * Constructor for StartCommand
	 * 
	 * @param main
	 */
	public StartCommand(DBDMinecraft main) {
		this.main = main;
	}
	
	/**
	 * Command manager for the "start" command
	 * 
	 * @return boolean
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (main.getPlayers().size() < 3) {
			Bukkit.broadcastMessage("You need to be atleast 3 for launching this game !");
			return false;
		}
		main.setKiller(main.getPlayers().get((int)(Math.random() * main.getPlayers().size())));
		Player p = main.getPlayers().get((int)(Math.random() * main.getPlayers().size()));
		if (main.getKiller() == p) {
			p = main.getPlayers().get((int)(Math.random() * main.getPlayers().size()));
			main.setGuard(p);
		} else {
			main.setGuard(p);
		}
		for (Player pl : main.getPlayers()) {
			if (pl == main.getKiller()) {
				//TP Tueur + rest
			} else if (pl == main.getGuard()) {
				//TP Guard + rest
			} else {
				main.getSurvivantPlayers().add(pl);
				//TP Player + rest
			}
		}
		return true;
	}

}
