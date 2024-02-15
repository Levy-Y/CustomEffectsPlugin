package potioneffects.customeffects;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class DamageListener implements Listener {
    private static final HashMap<UUID, Double> invinciblePlayers = new HashMap<>();

    private static JavaPlugin plugin;

    public DamageListener(JavaPlugin plugin) {
        this.plugin = plugin; // Store the plugin instance
    }
    public static void makeInvincible(Player player) {
        invinciblePlayers.put(player.getUniqueId(), 0.0);
    }

    public static void applyRecordedDamage(Player player) {
        UUID playerId = player.getUniqueId();
        if (invinciblePlayers.containsKey(playerId)) {
            double damage = invinciblePlayers.get(playerId);

            invinciblePlayers.remove(playerId);
            player.setMetadata("LastDamageByInvincibility", new FixedMetadataValue(plugin, true));
            player.damage(damage);

            player.removeMetadata("LastDamageByInvincibility", plugin);
        }
    }


    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        UUID playerId = player.getUniqueId();
        if (invinciblePlayers.containsKey(playerId)) {
            double damage = event.getFinalDamage();
            invinciblePlayers.put(playerId, invinciblePlayers.get(playerId) + damage);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (player.hasMetadata("LastDamageByInvincibility")) {
            // Set a custom death message
            event.setDeathMessage(player.getName() + " couldn't survive the aftermath of the numbness.");

        }
    }
}