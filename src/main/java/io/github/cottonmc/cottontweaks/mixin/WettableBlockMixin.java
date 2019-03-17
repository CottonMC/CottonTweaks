package io.github.cottonmc.cottontweaks.mixin;

import io.github.cottonmc.cottontweaks.api.Wettable;
import net.minecraft.block.*;
import net.minecraft.entity.VerticalEntityPosition;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin({SnowyBlock.class, SandBlock.class})
public abstract class WettableBlockMixin extends Block implements Wettable {
    WettableBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return Wettable.getPlacementState(super.getPlacementState(context), context);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, VerticalEntityPosition vep) {
        return Wettable.getOutlineShape(super.getOutlineShape(state, view, pos, vep), state, view, pos, vep);
    }

    @Override
    public void onRainTick(World world, BlockPos pos) {
        Wettable.onRainTick(world, pos);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void onRandomTick(BlockState state, World world, BlockPos pos, Random random) {
        Wettable.onRandomTick(state, world, pos, random);
    }
}
