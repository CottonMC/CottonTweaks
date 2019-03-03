package io.github.cottonmc.cottontweaks.mixin;

import io.github.cottonmc.cottontweaks.FluidAccessor;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BucketItem.class)
public class BucketItemMixin implements FluidAccessor {
    @Shadow @Final
    private Fluid fluid;

    @Override
    public Fluid cotton_getFluid() {
        return fluid;
    }
}
