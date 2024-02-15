package potioneffects.customeffects;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class CustomEffects extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Objects.requireNonNull(this.getCommand("numbness")).setExecutor(new NumbnessCommand(this));

        // Register the DamageListener
        getServer().getPluginManager().registerEvents(new DamageListener(this), this);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
