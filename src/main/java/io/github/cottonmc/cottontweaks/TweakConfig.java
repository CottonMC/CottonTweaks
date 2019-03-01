package io.github.cottonmc.cottontweaks;

import io.github.cottonmc.cotton.config.annotations.ConfigFile;
import io.github.cottonmc.repackage.blue.endless.jankson.Comment;

@ConfigFile(name="TweakConfig")
public class TweakConfig {

    @Comment("Add some sample splashes. Very dank ones, indeed.")
    public boolean add_cotton_splashes = true;

    @Comment("Prioritize user-added splashes instead of vanilla ones.")
    public boolean prioritize_custom_splashes = true;

    @Comment("If custom splashes are prioritized, how many times so? " +
            "1 is equal priority, 2 is '2 to 1', 3 is '3 to 1', etc.")
    public int custom_splash_priority = 3;

    @Comment("Enable the Cotton Tweaks module.")
    public boolean include_tweaks = true;

    @Comment("Enable dispenser tweaks, like seed planting?")
    public boolean enable_dispenser_tweaks = true;

    @Comment("Enable dispenser placing blocks if no behaviour is found otherwise.")
    public boolean enable_dispenser_place_blocks = true;

    @Comment("Tweaks: Enable the shape-based torch placement algorithm. " +
            "Allows you to place torches on more blocks.")
    public boolean enable_custom_torch_placement = true;

    @Comment("Enable recolouring of the loading bar?")
    public boolean enable_coloured_loading_bar = true;

    @Comment("The colour of the loading bar.")
    public int loading_bar_colour_red = 2;

    public int loading_bar_colour_green = 40;

    public int loading_bar_colour_blue = 255;

    @Comment("Enable lava in cauldrons.")
    public boolean enable_cauldron_lava = true;

    @Comment("Enable wet sand.")
    public boolean enable_wet_sand = true;
}
