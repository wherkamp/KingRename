package me.kingtux.kingrename.commands;

import me.kingtux.kingrename.KingRenameMain;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemModCommand implements CommandExecutor{
    private KingRenameMain plugin;
    public ItemModCommand(KingRenameMain kingRenameMain) {
        plugin = kingRenameMain;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p  = (Player) sender;
            if(p.getInventory().getItemInMainHand().getType().equals(null)||p.getInventory().getItemInMainHand().getType().equals(Material.AIR)){
                p.sendMessage(color("&4[ERROR] You must be holding a item"));
                return true;}
            ItemStack itemStack = p.getInventory().getItemInMainHand();
            ItemMeta itemMeta = itemStack.getItemMeta();
            if(args.length==0){
                p.sendMessage(color("&2Your current item is: "+itemStack.getType().toString()+"\n" +
                        "&2For more commands type /itemmod help"));
            }else if(args.length ==1){
                if(args[0].equalsIgnoreCase("help")){
                }else if(args[0].equalsIgnoreCase("glow")){
                    itemMeta.addEnchant(Enchantment.LUCK, 1, false);
                    itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    itemStack.setItemMeta(itemMeta);
                }else if(args[0].equalsIgnoreCase("deglow")){
                    itemMeta.removeEnchant(Enchantment.LUCK);
                    itemMeta.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
                    itemStack.setItemMeta(itemMeta);
                }else if(args[0].equalsIgnoreCase("lore")){
                    p.sendMessage(color(""));
                }else if(args[0].equalsIgnoreCase("displayname")){
                    p.sendMessage(color(""));
                }
            }else if(args.length>=2){

            }
        }else{
            sender.sendMessage(color("&4You must be a player to run this command"));
            return true;
        }
        return false;
    }
    private String color(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
