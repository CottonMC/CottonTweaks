package io.github.cottonmc.cottontweaks.mixin;

import io.github.cottonmc.cottontweaks.CottonTweaks;
import net.minecraft.client.gui.SplashScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(SplashScreen.class)
public class SplashScreenMixin {

    @ModifyConstant(method = "method_18103", constant = @Constant(floatValue = 226.0F))
    public float modifyRed(float i) {
        return CottonTweaks.config.loading_bar_colour_red;
    }

    @ModifyConstant(method = "method_18103", constant = @Constant(floatValue = 40.0F))
    public float modifyGreen(float i) {
        return CottonTweaks.config.loading_bar_colour_green;
    }

    @ModifyConstant(method = "method_18103", constant = @Constant(floatValue = 55.0F))
    public float modifyBlue(float i) {
        return CottonTweaks.config.loading_bar_colour_blue;
    }
}
