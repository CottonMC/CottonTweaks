package io.github.cottonmc.cottontweaks;

import io.github.cottonmc.cotton.config.annotations.ConfigFile;
import io.github.cottonmc.repackage.blue.endless.jankson.Comment;

@ConfigFile(name="TweakConfig")
public class TweakConfig {

    @Comment("Enable the Cotton Tweaks module.")
    public boolean include_tweaks = true;

    @Comment("Enable dispenser tweaks, like block placing?")
    public boolean enable_dispenser_tweaks = true;

    @Comment("Enable lava in cauldrons.")
    public boolean lava_in_cauldrons = true;

    @Comment("Enable wet sand.")
    public boolean enable_wet_sand = true;

    @Comment("Enable reduced potion glint")
    public boolean reduced_potion_glint = true;

    @Comment("Enable this to get rid of those annoying Phantoms")
    public boolean disable_phantom_spawning = false;
}
