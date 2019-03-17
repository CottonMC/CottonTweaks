package io.github.cottonmc.cottontweaks.mixin;

import net.minecraft.block.*;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.Properties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SandBlock.class)
public abstract class SandBlockMixin extends Block {
    SandBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("RETURN"), method = "<init>")
    private void onConstruct(int var1, Block.Settings var2, CallbackInfo info) {
        setDefaultState(getDefaultState().with(Properties.WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateFactory.Builder<Block, BlockState> var1) {
        var1.with(Properties.WATERLOGGED);
    }
}
