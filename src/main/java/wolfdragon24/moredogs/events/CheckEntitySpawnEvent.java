package wolfdragon24.moredogs.events;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import wolfdragon24.moredogs.MoreDogs;
import wolfdragon24.moredogs.entities.AltWolfEntity;

@Mod.EventBusSubscriber(modid = MoreDogs.modid, bus = Bus.FORGE)
public class CheckEntitySpawnEvent {
	
	@SubscribeEvent
	public static void EntitySpawnEvent(LivingSpawnEvent event) {
		
		Entity entity = event.getEntity();
		
		World world = (World) event.getWorld();
		
		if (WolfEntity.class.isAssignableFrom(entity.getClass())) {
			
			if(!world.isRemote) {
				AltWolfEntity newWolf = new AltWolfEntity(world);
				
				newWolf.setLocationAndAngles(entity.getPosX(), entity.getPosY(), entity.getPosZ(), entity.rotationYaw, entity.rotationPitch);
				
				world.addEntity(newWolf);
	            entity.remove();
	            
	            Random ran = new Random();
				int type = ran.nextInt(6);
				
				CompoundNBT compound = new CompoundNBT();
				CompoundNBT nbtvalue = compound.getCompound("Variant");
				
				if (nbtvalue == null) {
					newWolf.getPersistentData().putInt("Variant", type);
				}
			}
		}
	}

}
