package io.github.cottonmc.cottontweaks.mixin;

import io.github.cottonmc.cottontweaks.Wettable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.class_852;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.chunk.ChunkRenderData;
import net.minecraft.client.render.chunk.ChunkRenderTask;
import net.minecraft.client.render.chunk.ChunkRenderer;
import net.minecraft.client.world.SafeWorldView;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

@Mixin(ChunkRenderer.class)
public class ChunkRendererMixin {
    private BlockState cotton_state;

    // A hacky way to store locals for a Redirect.
    @Inject(method = "rebuildChunk", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/world/SafeWorldView;getBlockState(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/BlockState;", ordinal = 0, shift = At.Shift.BY, by = 2), locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private void storeBlockState(float f1, float f2, float f3, ChunkRenderTask task, CallbackInfo info, ChunkRenderData data, BlockPos pos1, BlockPos pos2, class_852 c852, Set set, SafeWorldView view, boolean bs[], Random r, BlockRenderManager brm, Iterator i, BlockPos pos3, BlockState state) {
        cotton_state = state;
    }

    @Redirect(method = "rebuildChunk", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRenderLayer()Lnet/minecraft/block/BlockRenderLayer;", ordinal = 0))
    private BlockRenderLayer getRenderLayerProxy(Block block) {
        if (cotton_state.getBlock() instanceof Wettable && cotton_state.get(Properties.WATERLOGGED)) {
            return BlockRenderLayer.TRANSLUCENT;
        }

        return block.getRenderLayer();
    }
}
