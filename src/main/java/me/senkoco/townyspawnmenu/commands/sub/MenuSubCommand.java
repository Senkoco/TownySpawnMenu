package me.senkoco.townyspawnmenu.commands.sub;

import me.senkoco.townyspawnmenu.events.PlayerOpenedMenu;
import me.senkoco.townyspawnmenu.utils.menu.Nations;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.LinkedList;
import java.util.List;

import static org.bukkit.Bukkit.getPluginManager;

public class MenuSubCommand {
    public static boolean execute(Player player) {
        if (!player.hasPermission("townyspawnmenu.menu.open")) {
            player.sendMessage("§6[Towny Spawn Menu] §cYou can't do that!");
            return false;
        }
        List<Inventory> inventories = new LinkedList<>(Nations.getPages());
        player.openInventory(inventories.getFirst());
        PlayerOpenedMenu playerOpenedMenu = new PlayerOpenedMenu(player);
        getPluginManager().callEvent(playerOpenedMenu);
        return true;
    }
}
