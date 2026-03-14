package hu.jgj52.huTiersMessenger;

import org.bukkit.plugin.java.JavaPlugin;
import redis.clients.jedis.JedisPooled;

public final class HuTiersMessenger extends JavaPlugin {

    public static JedisPooled jedis;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults(true);
        saveConfig();
        try {
            jedis = new JedisPooled(getConfig().getString("host"), getConfig().getInt("port"), getConfig().getString("user"), getConfig().getString("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
