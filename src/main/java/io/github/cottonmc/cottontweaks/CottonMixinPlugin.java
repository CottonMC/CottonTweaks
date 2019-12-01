package io.github.cottonmc.cottontweaks;

import com.google.common.collect.ImmutableMap;
import io.github.cottonmc.cotton.config.ConfigManager;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;
import java.util.function.BooleanSupplier;

/**
 * Used for loading config-dependent mixins. INTERNAL.
 */
public class CottonMixinPlugin implements IMixinConfigPlugin {
    private static final String PACKAGE = "io.github.cottonmc.cottontweaks.mixin";

    // Using Cotton.config would require loading Fabric's mixins (because of the commonGroup field).
    // That won't be done yet when this class loads.
    private static final TweakConfig CONFIG = ConfigManager.loadConfig(TweakConfig.class);
    private static final ImmutableMap<String, BooleanSupplier> MIXIN_STATES =
            new ImmutableMap.Builder<String, BooleanSupplier>().put(PACKAGE + ".DispenserBlockMixin", () -> CONFIG.include_tweaks && CONFIG.enable_dispenser_tweaks).
                    put(PACKAGE + ".ItemRendererMixin", () -> CONFIG.include_tweaks && CONFIG.reduced_potion_glint).
                    put(PACKAGE + ".CauldronBlockMixin", () -> CONFIG.include_tweaks && CONFIG.lava_in_cauldrons).
                    put(PACKAGE + ".SandBlockMixin", () -> CONFIG.include_tweaks && CONFIG.enable_wet_sand).
                    put(PACKAGE + ".PhantomSpawnerMixin", () -> CONFIG.include_tweaks && CONFIG.disable_phantom_spawning)
                    .build();

    @Override
    public void onLoad(String mixinPackage) {
        if (!mixinPackage.startsWith(PACKAGE)) {
            throw new IllegalArgumentException(
                    String.format("Invalid package: Expected %s, found %s", PACKAGE, mixinPackage)
            );
        }
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        BooleanSupplier supplier = MIXIN_STATES.get(mixinClassName);
        // If the supplier is not found, ignore it and return true
        return supplier == null || supplier.getAsBoolean();
    }

    // Boring boilerplate below

    @Override
    public List<String> getMixins() {
        // null = loaded from the JSON
        return null;
    }

    @Override
    public void preApply(String targetClassName, org.objectweb.asm.tree.ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        //nothing
    }

    @Override
    public void postApply(String targetClassName, org.objectweb.asm.tree.ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        //nothing
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }
}
