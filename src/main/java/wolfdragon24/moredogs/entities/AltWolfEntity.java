package wolfdragon24.moredogs.entities;

import javax.annotation.Nullable;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.passive.horse.DonkeyEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;
import wolfdragon24.moredogs.MoreDogs;

public class AltWolfEntity extends WolfEntity {
	@ObjectHolder(MoreDogs.modid + ":wolf") public static EntityType<AltWolfEntity> type;
	private static final DataParameter<Integer> Variant = EntityDataManager.createKey(AltWolfEntity.class, DataSerializers.VARINT);
	
	public AltWolfEntity(EntityType<? extends WolfEntity> type, World world) {
	      super(type, world);
	      this.setTamed(false);
	   }
	
	public AltWolfEntity(World world) {
		this(type, world);
	}

	protected void registerData() {
	      super.registerData();
	      this.dataManager.register(Variant, 0);
	   }
	
	public void writeAdditional(CompoundNBT compound) {
	      super.writeAdditional(compound);
	      compound.putInt("Variant", this.getWolfVariant());

	   }
	
	public void readAdditional(CompoundNBT compound) {
	      super.readAdditional(compound);
	      this.setWolfVariant(compound.getInt("Variant"));
	   }
	
	public void setWolfVariant(int type) {
		dataManager.set(Variant, type);
	}
	
	public int getWolfVariant() {
		return dataManager.get(Variant);
	}
	
}
