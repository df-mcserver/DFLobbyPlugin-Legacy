package uk.co.nikodem.dFLobbyPlugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.co.nikodem.dFLobbyPlugin.Handlers.KitUtils;

public class Clr implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player plr) {
            if (KitUtils.playerHasOldInventory(plr)) {
                KitUtils.setOldInventory(plr);
            } else {
                plr.getInventory().clear();
            }
        }
        return true;
    }
}
