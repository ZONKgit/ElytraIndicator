package org.fl.elytraindicator.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.fl.elytraindicator.client.config.ConfigManager;
import org.fl.elytraindicator.client.config.ElytraHudCommands;

public class ElytraindicatorClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ConfigManager.load();
        HudRenderCallback.EVENT.register(ElytraHud::render);

        // Регистрируем команды
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            ElytraHudCommands.register(dispatcher);
        });
    }
}
