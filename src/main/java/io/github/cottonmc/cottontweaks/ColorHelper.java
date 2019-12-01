package io.github.cottonmc.cottontweaks;

import net.minecraft.util.math.MathHelper;

public class ColorHelper {

    public static Color clampColor(Color c) {
        c.r = MathHelper.clamp(c.r, 0, 255);
        c.g = MathHelper.clamp(c.g, 0, 255);
        c.b = MathHelper.clamp(c.b, 0, 255);
        return c;
    }

    public static int packColor(int r, int b, int g) {
        int i = (r << 8) + g;
        i = (i << 8) + b;
        return i;
    }

    public static int packColor(Color c) {
        c = clampColor(c);
        int r = c.r;
        int g = c.g;
        int b = c.b;
        int i = (r << 8) + g;
        i = (i << 8) + b;
        return i;
    }

    public static Color unpackColor(int c) {
        int r = (c & 16711680) >> 16;
        int g = (c & '\uff00') >> 8;
        int b = (c & 255) >> 0;
        return clampColor(new Color(r, g, b));
    }
}
