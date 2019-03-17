package io.github.cottonmc.cottontweaks;

import io.github.cottonmc.cottontweaks.CottonTweaks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.VerticalEntityPosition;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

/**
 * A marker interface for blocks that can get wet.
 *
 * Contains default implementations for wet behavior.
 * Wettable blocks should also have random ticks enabled.
 */
public interface Wettable extends Waterloggable {
    VoxelShape WET_OUTLINE_SHAPE = Block.createCuboidShape(-0.02, -0.02, -0.02, 16.02, 16.02, 16.02);

    /**
     * @param superState Intended to be {@code super.getPlacementState(context)}
     */
    static BlockState getPlacementState(BlockState superState, ItemPlacementContext context) {
        FluidState state = context.getWorld().getFluidState(context.getBlockPos());
        return superState.with(Properties.WATERLOGGED, state.matches(FluidTags.WATER));
    }

    /**
     * @param superShape Intended to be {@code super.getOutlineShape(state, view, pos, vep)}
     */
    static VoxelShape getOutlineShape(VoxelShape superShape, BlockState state, BlockView view, BlockPos pos, VerticalEntityPosition vep) {
        if (state.get(Properties.WATERLOGGED))
            return WET_OUTLINE_SHAPE;
        else
            return superShape;
    }

    /**
     * Randomly makes some wettable blocks wet when it rains.
     */
    static void onRainTick(World world, BlockPos pos) {
        if (CottonTweaks.config.wet_block_ticking && world.getRandom().nextInt(5) == 0) {
            world.setBlockState(pos, world.getBlockState(pos).with(Properties.WATERLOGGED, true));
        }
    }

    /**
     * Randomly makes some wettable blocks dry when it doesn't rain.
     */
    static void onRandomTick(BlockState state, World world, BlockPos pos, Random random) {
        if (CottonTweaks.config.wet_block_ticking && random.nextInt(16) == 0 && !world.isRaining()) {
            world.setBlockState(pos, world.getBlockState(pos).with(Properties.WATERLOGGED, false));
        }
    }
}
