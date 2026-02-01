package org.fl.elytraindicator.client.config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = FabricLoader.getInstance()
            .getConfigDir()
            .resolve("elytraindicator.json");

    public static ElytraHudConfig config = new ElytraHudConfig();

    public static void load() {
        try {
            if (Files.exists(PATH)) {
                config = GSON.fromJson(Files.readString(PATH), ElytraHudConfig.class);
            } else {
                save();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        try {
            Files.writeString(PATH, GSON.toJson(config));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
