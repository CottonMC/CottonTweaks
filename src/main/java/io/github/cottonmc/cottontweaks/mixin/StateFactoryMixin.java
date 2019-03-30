package io.github.cottonmc.cottontweaks.mixin;

import net.minecraft.state.StateFactory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.regex.Pattern;

@Mixin(StateFactory.class)
public class StateFactoryMixin {
    @Shadow @Final @Mutable
    private static Pattern NAME_MATCHER;

    static {
        NAME_MATCHER = Pattern.compile("^[a-z0-9_:]+$");
    }
}
