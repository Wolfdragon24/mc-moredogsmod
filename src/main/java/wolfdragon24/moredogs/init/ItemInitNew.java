package wolfdragon24.moredogs.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import wolfdragon24.moredogs.MoreDogs;
import wolfdragon24.moredogs.MoreDogs.MoreDogsItemGroup;
import wolfdragon24.moredogs.objects.items.Whistle;

public class ItemInitNew {
	
	public static final DeferredRegister<Item> Items = new DeferredRegister<>(ForgeRegistries.ITEMS, MoreDogs.modid);
		
	public static final RegistryObject<Item> whistle = Items.register("whistle", () -> new Whistle(new Item.Properties().group(MoreDogsItemGroup.instance)));
	public static final RegistryObject<Item> tennis_ball = Items.register("tennis_ball", () -> new Item(new Item.Properties().group(MoreDogsItemGroup.instance)));
}
