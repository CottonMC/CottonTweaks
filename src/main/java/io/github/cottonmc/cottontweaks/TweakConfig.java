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
    public boolean enable_dispenser_place_blocks = true;

    @Comment("Tweaks: Enable the shape-based torch placement algorithm. " +
            "Allows you to place torches on more blocks.")
    public boolean enable_custom_torch_placement = true;

    @Comment("Enable lava in cauldrons.")
    public boolean enable_cauldron_lava = true;

    @Comment("Enable wet sand.")
    public boolean enable_wet_sand = true;
}
