package potioneffects.customeffects;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class NumbnessCommand implements CommandExecutor {
    private final CustomEffects plugin;

    public NumbnessCommand(CustomEffects plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage("Usage: /numbness <player>");
            return true;
        }
        Player player = Bukkit.getPlayer(args[0]);
        if (player == null) {
            sender.sendMessage("Player not found.");
            return true;
        }

        DamageListener.makeInvincible(player);
        new BukkitRunnable() {
            @Override
            public void run() {
                DamageListener.applyRecordedDamage(player);
            }
        }.runTaskLater(plugin, 600); // 600 ticks = 30 seconds
        return true;
    }
}