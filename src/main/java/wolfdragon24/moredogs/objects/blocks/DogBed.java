package wolfdragon24.moredogs.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class DogBed extends Block{
	
	
	public DogBed(Properties properties) {
		super(properties);
	}
	
	private static final VoxelShape SHAPE = Stream.of(
			Block.makeCuboidShape(14, 0, 0, 16, 8, 16),
			Block.makeCuboidShape(0, 0, 14, 16, 8, 16),
			Block.makeCuboidShape(0, 0, 0, 2, 8, 16),
			Block.makeCuboidShape(0, 0, 0, 16, 3, 16),
			Block.makeCuboidShape(0, 0, 0, 16, 8, 2),
			Block.makeCuboidShape(0, 3, 0, 16, 8, 2)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}

}
