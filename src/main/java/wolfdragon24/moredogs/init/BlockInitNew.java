package wolfdragon24.moredogs.init;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import wolfdragon24.moredogs.MoreDogs;
import wolfdragon24.moredogs.objects.blocks.DogBed;

public class BlockInitNew {
	
	public static final DeferredRegister<Block> Blocks = new DeferredRegister<>(ForgeRegistries.BLOCKS, MoreDogs.modid);
		
	public static final RegistryObject<Block> dog_bed = Blocks.register("dog_bed", () -> new DogBed(Block.Properties.create(Material.IRON).hardnessAndResistance(0.75f).sound(SoundType.WOOD)));
}
