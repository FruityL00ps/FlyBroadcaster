package me.decyphr.StaffTools;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffTools extends JavaPlugin {
    FileConfiguration config = getConfig();
    @Override
    public void onEnable() {
        config.addDefault("prefix", "§7[§6FlyBroadcast§7] §f");
        config.options().copyDefaults(true);
        saveConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (label.equalsIgnoreCase("fbc")) {
                if (args.length < 1) {
                    player.sendMessage("§cSyntax error! Usage: §4/fbc [message]");
                }
                else {
                    String message = config.getString("prefix");
                    for (String arg : args) {
                        message += arg + " ";
                    }
                    for (Player selplayer : Bukkit.getServer().getOnlinePlayers()) {
                        selplayer.sendRawMessage(message.replace("&","§"));
                    }
                }
            }
        }
        return false;
    }
}
