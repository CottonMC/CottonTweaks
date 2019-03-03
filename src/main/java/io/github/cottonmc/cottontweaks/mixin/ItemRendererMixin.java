package io.github.cottonmc.cottontweaks.mixin;

import net.minecraft.client.render.item.ItemRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {

    //@SuppressWarnings("UnresolvedMixinReference")
    //@ModifyConstant(method = "method_4015", constant = @Constant(intValue = -8372020), remap = false)
    //private int getGlintColour(int originalValue) {
    //    // TODO just change the first 2 bytes from FF to 22
    //    //return 0x228040CC;
    //    return 0x2200FF00;
    //}
}
