package org.fl.elytraindicator.client.config;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.fl.elytraindicator.client.config.ConfigManager;

public class ElytraHudCommands {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                CommandManager.literal("elytrahud")
                        .then(CommandManager.literal("offsetX")
                                .then(CommandManager.argument("value", IntegerArgumentType.integer())
                                        .executes(ctx -> {
                                            int value = IntegerArgumentType.getInteger(ctx, "value");
                                            ConfigManager.config.offsetX = value;
                                            ConfigManager.save();
                                            ctx.getSource().sendFeedback(() -> Text.literal("Elytra HUD offsetX set to " + value), false);
                                            return 1;
                                        })
                                )
                        )
                        .then(CommandManager.literal("offsetY")
                                .then(CommandManager.argument("value", IntegerArgumentType.integer())
                                        .executes(ctx -> {
                                            int value = IntegerArgumentType.getInteger(ctx, "value");
                                            ConfigManager.config.offsetY = value;
                                            ConfigManager.save();
                                            ctx.getSource().sendFeedback(() -> Text.literal("Elytra HUD offsetY set to " + value), false);

                                            return 1;
                                        })
                                )
                        )
                        .then(CommandManager.literal("size")
                                .then(CommandManager.argument("value", IntegerArgumentType.integer(8, 64))
                                        .executes(ctx -> {
                                            int value = IntegerArgumentType.getInteger(ctx, "value");
                                            ConfigManager.config.size = value;
                                            ConfigManager.save();
                                            ctx.getSource().sendFeedback(() -> Text.literal("Elytra HUD size to " + value), false);

                                            return 1;
                                        })
                                )
                        )
//                        .then(CommandManager.literal("icon")
//                                .then(CommandManager.argument("value", StringArgumentType.word())
//                                        .executes(ctx -> {
//                                            String value = StringArgumentType.getString(ctx, "value");
//                                            if (!value.equals("default") && !value.equals("alt")) {
//                                                ctx.getSource().sendError(Text.literal("Icon must be 'default' or 'alt'"));
//                                                return 0;
//                                            }
//                                            ConfigManager.config.icon = value;
//                                            ConfigManager.save();
//                                            ctx.getSource().sendFeedback(Text.literal("Elytra HUD icon set to " + value), false);
//                                            return 1;
//                                        })
//                                )
//                        )
        );}
    }
