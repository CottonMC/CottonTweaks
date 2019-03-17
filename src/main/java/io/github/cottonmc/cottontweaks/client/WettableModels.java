package io.github.cottonmc.cottontweaks.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.block.BlockModels;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.client.render.model.BasicBakedModel;
import net.minecraft.client.render.model.MultipartBakedModel;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.SystemUtil;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
public final class WettableModels {
    private static final Identifier OVERLAY_BLOCK_ID = new Identifier("cottontweaks", "wet_overlay_dummy");
    private static final Map<BlockState, BakedModel> MODELS = new HashMap<>();

    public static BakedModel getWetModel(BlockState state, BlockModels models) {
        return MODELS.computeIfAbsent(
            state,
            s -> SystemUtil.consume(new MultipartBakedModel.Builder(), b -> {
                b.addComponent(
                    s2 -> true,
                    models.getModel(
                        s.with(Properties.WATERLOGGED, false)
                    )
                );

                b.addComponent(
                    s2 -> true,
                    models.getModel(Registry.BLOCK.get(OVERLAY_BLOCK_ID).getDefaultState())
                );
            }).build()
        );
    }
}
