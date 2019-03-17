package io.github.cottonmc.cottontweaks.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SnowyBlock;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.Properties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SnowyBlock.class)
public abstract class SnowyBlockMixin extends Block {
    SnowyBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("RETURN"), method = "<init>")
    private void onConstruct(Settings var2, CallbackInfo info) {
        setDefaultState(getDefaultState().with(Properties.WATERLOGGED, false));
    }

    @Inject(at = @At("RETURN"), method = "appendProperties")
    private void onAppendProperties(StateFactory.Builder<Block, BlockState> builder, CallbackInfo info) {
        builder.with(Properties.WATERLOGGED);
    }
}
