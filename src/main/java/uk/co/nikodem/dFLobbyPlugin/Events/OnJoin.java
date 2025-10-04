package uk.co.nikodem.dFLobbyPlugin.Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import uk.co.nikodem.dFLobbyPlugin.Handlers.KitUtils;

public class OnJoin implements Listener {
    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent e)
    {
        e.setJoinMessage(null);
        Player plr = e.getPlayer();
        plr.setCollidable(false);
        World world = Bukkit.getWorld("world");
        Location spawnPoint = world.getSpawnLocation();
        spawnPoint.add(0.5, 0, 0.5);
        plr.teleport(spawnPoint);
        for (PotionEffect effect : plr.getActivePotionEffects()) {
            plr.removePotionEffect(effect.getType());
        }

        if (KitUtils.oldInventories.containsKey(plr)) {
            ItemStack[] inv = KitUtils.oldInventories.get(plr);
            plr.getInventory().setContents(inv);
        }
    }
}
