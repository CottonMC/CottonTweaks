package io.github.cottonmc.cottontweaks.tweaks;

import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class DispenserPlacementContext extends ItemPlacementContext {
    protected DispenserPlacementContext(World world, ItemStack stack, BlockHitResult hitResult) {
        super(world, null, Hand.MAIN_HAND, stack, hitResult);
    }

    @Override
    public Direction getPlayerFacing() {
        return hit.getSide();
    }

    @Override
    public Direction[] getPlacementDirections() {
        return new Direction[] { getPlayerFacing() };
    }
}
