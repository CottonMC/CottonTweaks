package io.github.cottonmc.cottontweaks.mixin;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.gen.PhantomSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PhantomSpawner.class)
public class PhantomSpawnerMixin {

    @Inject(method = "spawn", at = @At("HEAD"), cancellable = true)
    public void plsDoNotSpawn(ServerWorld world_1, boolean boolean_1, boolean boolean_2, CallbackInfoReturnable<Integer> cir) {
        cir.cancel();
    }
}
