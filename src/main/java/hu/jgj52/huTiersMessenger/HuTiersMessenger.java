package hu.jgj52.huTiersMessenger;

import org.bukkit.plugin.java.JavaPlugin;
import redis.clients.jedis.JedisPooled;

public final class HuTiersMessenger extends JavaPlugin {

    public static JedisPooled jedis;
    public static String host;
    public static int port;
    public static String user;
    public static String password;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults(true);
        saveConfig();
        host = getConfig().getString("host");
        port = getConfig().getInt("port");
        user = getConfig().getString("user");
        password = getConfig().getString("password");
        try {
            jedis = new JedisPooled(host, port, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
