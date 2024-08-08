package wolfdragon24.moredogs.util.helpers;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class KeyboardHelper {
	
	private final static long window = Minecraft.getInstance().getMainWindow().getHandle();
	
	@OnlyIn(Dist.CLIENT)
	public static boolean IsHoldingShift() {
		
		return InputMappings.isKeyDown(window, GLFW.GLFW_KEY_LEFT_SHIFT) || InputMappings.isKeyDown(window, GLFW.GLFW_KEY_RIGHT_SHIFT);
	}
	
	@OnlyIn(Dist.CLIENT)
	public static boolean IsHoldingCtrl() {
		
		return InputMappings.isKeyDown(window, GLFW.GLFW_KEY_LEFT_CONTROL) || InputMappings.isKeyDown(window, GLFW.GLFW_KEY_RIGHT_CONTROL);
	}
}
