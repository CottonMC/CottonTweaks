package io.github.cottonmc.cottontweaks.mixin;

import io.github.cottonmc.cottontweaks.Color;
import io.github.cottonmc.cottontweaks.ColorHelper;
import io.github.cottonmc.cottontweaks.CottonTweaks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Biome.class)
public class BiomeMixin {

    @Inject(method = "getGrassColorAt", at = @At("RETURN"), cancellable = true)
    public void getGreenerGrassColorAt(BlockPos pos, CallbackInfoReturnable<Integer> c) {
        Color color = ColorHelper.unpackColor(c.getReturnValue());
        color.r = color.r + CottonTweaks.config.shift_r;
        color.g = color.g + CottonTweaks.config.shift_g;
        color.b = color.b + CottonTweaks.config.shift_b;
        c.setReturnValue(ColorHelper.packColor(color));
    }

    @Inject(method = "getFoliageColorAt", at = @At("RETURN"), cancellable = true)
    public void getGreenerFoliageColorAt(BlockPos pos, CallbackInfoReturnable<Integer> c) {
        Color color = ColorHelper.unpackColor(c.getReturnValue());
        color.r = color.r + CottonTweaks.config.shift_r;
        color.g = color.g + CottonTweaks.config.shift_g;
        color.b = color.b + CottonTweaks.config.shift_b;
        c.setReturnValue(ColorHelper.packColor(color));
    }

}
