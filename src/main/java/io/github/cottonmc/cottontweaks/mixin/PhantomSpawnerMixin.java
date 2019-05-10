package io.github.cottonmc.cottontweaks.mixin;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.source.TheEndBiomeSource;
import net.minecraft.world.dimension.TheEndDimension;
import net.minecraft.world.gen.PhantomSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PhantomSpawner.class)
public class PhantomSpawnerMixin {

    @Inject(method = "spawn", at = @At("HEAD"))
    public void doNotSpawn(World world_1, boolean boolean_1, boolean boolean_2, CallbackInfoReturnable<Integer> cir) {
        if (!(world_1.dimension instanceof TheEndDimension)) {
            cir.cancel();
        }
    }
}
