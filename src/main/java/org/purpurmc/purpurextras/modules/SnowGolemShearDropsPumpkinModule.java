package org.purpurmc.purpurextras.modules;

import org.bukkit.Material;
import org.bukkit.entity.Snowman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockShearEntityEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.purpurmc.purpurextras.PurpurExtras;

public class SnowGolemShearDropsPumpkinModule implements PurpurExtrasModule, Listener {

    @Override
    public void enable() {
        PurpurExtras plugin = PurpurExtras.getInstance();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public boolean shouldEnable() {
        return PurpurExtras.getPurpurConfig().getBoolean("settings.mobs.snow_golem.drop-pumpkin-when-sheared", false);
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onSnowGolemShear(PlayerShearEntityEvent event) {
        if (!(event.getEntity() instanceof Snowman snowman)) return;
        if (snowman.isDerp()) return;
        snowman.setDerp(true);
        snowman.getLocation().getWorld().dropItem(snowman.getLocation(), new ItemStack(Material.CARVED_PUMPKIN));
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onSnowGolemShear(BlockShearEntityEvent event) {
        if (!(event.getEntity() instanceof Snowman snowman)) return;
        if (snowman.isDerp()) return;
        snowman.setDerp(true);
        snowman.getLocation().getWorld().dropItem(snowman.getLocation(), new ItemStack(Material.CARVED_PUMPKIN));
    }

}