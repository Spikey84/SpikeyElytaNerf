package io.github.spikey84.spikeyelytranerf;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import static org.bukkit.enchantments.Enchantment.*;

public class eListener implements Listener {

    public boolean checkItem(ItemStack I, ItemStack O, ItemStack C) {
        if(O.getType() != Material.ELYTRA) return false;
        if(O.containsEnchantment(MENDING) && !I.containsEnchantment(MENDING)) return true;
        return C.containsEnchantment(MENDING);
    }


    @EventHandler
    public void AnvilEvent(PrepareAnvilEvent event) {
        if (event.getResult() == null || event.getInventory().getItem(0) == null || event.getInventory().getItem(1) == null) return;

        ItemStack inputItem = event.getInventory().getItem(0);
        ItemStack outputItem = event.getResult();
        ItemStack combinedItem = event.getInventory().getItem(1);

        if (!checkItem(inputItem, outputItem, combinedItem)) return;
        event.setResult(new ItemStack(Material.AIR));


    }


}
