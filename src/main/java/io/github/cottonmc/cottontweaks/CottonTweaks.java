package io.github.cottonmc.cottontweaks;

import io.github.cottonmc.cotton.config.ConfigManager;
import io.github.cottonmc.cotton.logging.Ansi;
import io.github.cottonmc.cotton.logging.ModLogger;
import io.github.cottonmc.cottontweaks.tweaks.Tweaks;
import net.fabricmc.api.ModInitializer;

public class CottonTweaks implements ModInitializer {

	public static final String MODID = "cotton-tweaks";

	public static ModLogger logger = new ModLogger(MODID, "COTTON TWEAKS");
	public static TweakConfig config;

	@Override
	public void onInitialize() {
		logger.setPrefixFormat(Ansi.Green);

		//example config and logger code
		config = ConfigManager.loadConfig(TweakConfig.class);
		logger.info("loaded config");
		Tweaks.initialize();

	}
}
