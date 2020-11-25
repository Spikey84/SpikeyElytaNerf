package io.github.spikey84.spikeyelytranerf;

import org.bukkit.plugin.java.JavaPlugin;

public class spikeyelytranerf extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new eListener(),this);
    }

    @Override
    public void onDisable() {

    }
}
