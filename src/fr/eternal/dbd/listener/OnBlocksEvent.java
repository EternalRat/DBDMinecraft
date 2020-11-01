package fr.eternal.dbd.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

/**
 * Class which manage events done on block
 * 
 * @author EternalRat
 * @version 1.0
 * @since 01/11/2020
 *
 */
public class OnBlocksEvent implements Listener {

	/**
	 * onBreakBlocks event triggered when someone is touching to a block
	 * 
	 * @param block	Block which triggered the event
	 */
	@EventHandler
	public void onBreakBlocks(BlockDamageEvent block) {
		block.setCancelled(true);
	}
	
}