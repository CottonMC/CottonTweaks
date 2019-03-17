package io.github.cottonmc.cottontweaks.mixin;

import io.github.cottonmc.cottontweaks.api.Wettable;
import io.github.cottonmc.cottontweaks.client.WettableModels;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.block.BlockModels;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.state.property.Properties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockModels.class)
public class BlockModelsMixin {
    @Inject(method = "getModel", at = @At("HEAD"), cancellable = true)
    private void onGetModel(BlockState state, CallbackInfoReturnable<BakedModel> info) {
        if (state.getBlock() instanceof Wettable && state.get(Properties.WATERLOGGED)) {
            info.setReturnValue(WettableModels.getWetModel(state, (BlockModels) (Object) this));
        }
    }
}
