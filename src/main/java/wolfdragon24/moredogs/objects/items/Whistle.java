package wolfdragon24.moredogs.objects.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import wolfdragon24.moredogs.init.SoundInit;
import wolfdragon24.moredogs.util.helpers.KeyboardHelper;

public class Whistle extends Item{
	
	public Whistle(Properties properties) {
		super(properties);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		
		if (KeyboardHelper.IsHoldingShift()) {
			tooltip.add(new StringTextComponent("\u00A7f" + "This whistle will highlight any nearby tamed wolves when you" + "\u00a7e" + " right click " + "\u00a7f" + "and all nearby wolves if you" + "\u00a7e" + " shift and right click"));
		
		} else {
			tooltip.add(new StringTextComponent("\u00A77" + "Hold down shift for more information"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		BlockPos centerPos = playerIn.getPosition();
		AxisAlignedBB area = new AxisAlignedBB(centerPos).grow(20,20,20);
		
		worldIn.playSound(playerIn, centerPos, SoundInit.WhistleInteract.get(), null, 0.5f, 1.0f);
		
		for (Object entity : worldIn.getEntitiesWithinAABBExcludingEntity(playerIn, area)) {
			if (WolfEntity.class.isAssignableFrom(entity.getClass())) {
				if (KeyboardHelper.IsHoldingShift()) {
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING, 40, 255, true, false));	
				} else {
					if (((WolfEntity) entity).isOwner(playerIn)) {
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING, 40, 255, true, false));
					}
				}
			}
		}
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
