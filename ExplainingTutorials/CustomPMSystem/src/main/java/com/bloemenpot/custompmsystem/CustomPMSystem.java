package com.bloemenpot.custompmsystem;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class CustomPMSystem extends JavaPlugin {

    private HashMap<UUID, UUID> recentMessages;

    @Override
    public void onEnable() {
        getCommand("pm").setExecutor(new PMCommand(this));
        getCommand("reply").setExecutor(new replyCommand(this));

        recentMessages = new HashMap<>();
    }

    public HashMap<UUID, UUID> getRecentMessages() { return recentMessages; }
}
