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
		if (this.main.getPlayers().size() < 3) {
			Bukkit.broadcastMessage("You need to be atleast 3 for launching this game !");
			return false;
		}
		this.main.setKiller(this.main.getPlayers().get((int)(Math.random() * this.main.getPlayers().size())));
		Player p = this.main.getPlayers().get((int)(Math.random() * this.main.getPlayers().size()));
		if (this.main.getKiller() == p) {
			p = this.main.getPlayers().get((int)(Math.random() * this.main.getPlayers().size()));
			this.main.setGuard(p);
		} else {
			this.main.setGuard(p);
		}
		for (Player pl : this.main.getPlayers()) {
			if (pl == this.main.getKiller()) {
				pl.sendMessage("§4" + pl.getName() + " you are the killer !§r");
				//TP Tueur + rest
			} else if (pl == this.main.getGuard()) {
				pl.sendMessage("§9" + pl.getName() + " you are the guard !§r");
				//TP Guard + rest
			} else {
				this.main.getSurvivantPlayers().add(pl);
				pl.sendMessage("§2" + pl.getName() + " you are a survivor !§r");
				//TP Player + rest
			}
		}
		return true;
	}

}
