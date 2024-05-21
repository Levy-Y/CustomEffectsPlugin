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
        // Check if the player has permission
        if (!sender.hasPermission("numbness.use")) {
            sender.sendMessage("You do not have permission to use this command.");
            return true;
        }
        if (args.length != 2) {
            sender.sendMessage("Usage: /numbness <player> [duration]");
            return true;
        }
        Player player = Bukkit.getPlayer(args[0]);
        if (player == null) {
            sender.sendMessage("Player not found.");
            return true;
        }

        DamageListener.makeInvincible(player);

        int duration;

        try {
            duration = args[1] != null ? Integer.parseInt(args[1]) : 30;
        } catch (NumberFormatException e) {
            sender.sendMessage("Invalid duration. Please provide a valid number.");
            return true;
        }

        int durationTicks = duration * 20; // 20 ticks = 1 second
        new BukkitRunnable() {
            @Override
            public void run() {
                DamageListener.applyRecordedDamage(player);
            }
        }.runTaskLater(plugin, durationTicks); // 600 ticks = 30 seconds
        return true;
    }
}