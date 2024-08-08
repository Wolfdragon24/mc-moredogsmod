package wolfdragon24.moredogs.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import wolfdragon24.moredogs.MoreDogs;

public class SoundInit {
	
	public static final DeferredRegister<SoundEvent> Sounds = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, MoreDogs.modid);

	public static final RegistryObject<SoundEvent> WhistleInteract = Sounds.register("item.whistle.use", () -> new SoundEvent(new ResourceLocation(MoreDogs.modid, "item.whistle.use")));
}
