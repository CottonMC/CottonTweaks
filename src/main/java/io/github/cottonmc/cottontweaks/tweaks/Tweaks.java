package io.github.cottonmc.cottontweaks.tweaks;

import io.github.cottonmc.cottontweaks.CottonTweaks;

public class Tweaks {

    public static void initialize() {
        if (CottonTweaks.config.include_tweaks) {
            CottonTweaks.logger.info("Tweaks initialized.");
        }
    }

}
