package wolfdragon24.moredogs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import wolfdragon24.moredogs.init.BlockInitNew;
import wolfdragon24.moredogs.init.ItemInitNew;
import wolfdragon24.moredogs.init.SoundInit;

@Mod("moredogsmod")
@Mod.EventBusSubscriber(modid = MoreDogs.modid, bus = Bus.MOD)
public class MoreDogs {
	
	public static MoreDogs instance;
	public static final String modid = "moredogsmod";
	public static final Logger logger = LogManager.getLogger(modid);
	
	public MoreDogs() {
		
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		
		SoundInit.Sounds.register(modEventBus);
		ItemInitNew.Items.register(modEventBus);
		BlockInitNew.Blocks.register(modEventBus);
		
		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		
		BlockInitNew.Blocks.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(MoreDogsItemGroup.instance);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});
	}
	
	private void setup(final FMLCommonSetupEvent event) {
	}
	
	@SubscribeEvent
	public static void onServerStarting(FMLServerStartingEvent event) {
		
	}
	
	public static class MoreDogsItemGroup extends ItemGroup {
		
		public static final MoreDogsItemGroup instance = new MoreDogsItemGroup(ItemGroup.GROUPS.length, "moredogstab");
		
		private MoreDogsItemGroup(int index, String label) {
			super(index, label);
		}
		
		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInitNew.dog_bed.get());
		}
	}
}
