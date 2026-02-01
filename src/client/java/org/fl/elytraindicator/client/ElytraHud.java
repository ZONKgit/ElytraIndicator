package org.fl.elytraindicator.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.fl.elytraindicator.client.config.ConfigManager;
import org.fl.elytraindicator.client.config.ElytraHudConfig;


public class ElytraHud {

    private static final Identifier ICON =
            Identifier.of("elytraindicator", "textures/gui/elytra.png");

    public static void render(DrawContext context, RenderTickCounter tickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player == null || client.options.hudHidden) return;

        ItemStack chest = client.player.getEquippedStack(EquipmentSlot.CHEST);
        if (!chest.isOf(Items.ELYTRA)) return;

        int w = context.getScaledWindowWidth();
        int h = context.getScaledWindowHeight();

        ElytraHudConfig cfg = ConfigManager.config;

        int size = cfg.size;
        int x = w / 2 + cfg.offsetX;
        int y = h / 2 + cfg.offsetY;

        context.drawTexture(
                RenderLayer::getGuiTextured,
                ICON,
                x, y,
                0f, 0f,
                size, size,
                size, size
        );
    }
}
