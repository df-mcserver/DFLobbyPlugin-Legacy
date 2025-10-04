package uk.co.nikodem.dFLobbyPlugin.Handlers;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashMap;

public class KitUtils {
    public static HashMap<Player, ItemStack[]> oldInventories = new HashMap<Player, ItemStack[]>();

    public static boolean playerHasOldInventory(Player plr) {
        return oldInventories.containsKey(plr);
    }

    public static void setOldInventory(Player plr) {
        ItemStack[] inv = KitUtils.oldInventories.get(plr);
        plr.getInventory().setContents(inv);
        KitUtils.oldInventories.remove(plr);
    }

    public static void saveInventory(Player plr) {
        PlayerInventory inv = plr.getInventory();
        KitUtils.oldInventories.put(plr, inv.getContents());
    }
}
