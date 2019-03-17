package io.github.cottonmc.cottontweaks;

import io.github.cottonmc.cotton.config.annotations.ConfigFile;
import io.github.cottonmc.repackage.blue.endless.jankson.Comment;

@ConfigFile(name="TweakConfig")
public class TweakConfig {

    @Comment("Enable the Cotton Tweaks module.")
    public boolean include_tweaks = true;

    @Comment("Enable dispenser tweaks, like seed planting?")
    public boolean enable_dispenser_tweaks = true;

    @Comment("Enable dispenser placing blocks if no behaviour is found otherwise.")
    public boolean dispenser_place_blocks = true;

    @Comment("Tweaks: Enable the shape-based torch placement algorithm. " +
            "Allows you to place torches on more blocks.")
    public boolean custom_torch_placement = true;

    @Comment("Enable lava in cauldrons.")
    public boolean lava_in_cauldrons = true;

    @Comment("Enable wet blocks.")
    public boolean enable_wet_blocks = true;

    @Comment("Enable world effects for wet blocks (drying, getting wet from rain).")
    public boolean enable_wet_block_world_effects = true;

    @Comment("Enable reduced potion glint")
    public boolean reduced_potion_glint = true;
}
