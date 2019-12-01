package io.github.cottonmc.cottontweaks;

import blue.endless.jankson.Comment;
import io.github.cottonmc.cotton.config.annotations.ConfigFile;

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

    //@Comment("Enable reduced potion glint")
    //public boolean reduced_potion_glint = true;

    @Comment("Enable this to get rid of those annoying Phantoms.")
    public boolean disable_phantom_spawning = true;

    @Comment("Enable the greener grass feature.")
    public boolean enable_greener_grass = true;

    @Comment("How much to shift grass/foliage colour on the red component.")
    public int shift_r = -30;

    @Comment("How much to shift grass/foliage colour on the green component.")
    public int shift_g = 30;

    @Comment("How much to shift grass/foliage colour on the blue component.")
    public int shift_b = -30;
}
