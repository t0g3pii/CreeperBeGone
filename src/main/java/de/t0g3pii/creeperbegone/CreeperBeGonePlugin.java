package de.t0g3pii.creeperbegone;

import org.bukkit.plugin.java.JavaPlugin;

public class CreeperBeGonePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new CreeperListener(), this);
        getLogger().info("CreeperBeGone enabled: Creeper explosions will not damage blocks.");
    }
}

