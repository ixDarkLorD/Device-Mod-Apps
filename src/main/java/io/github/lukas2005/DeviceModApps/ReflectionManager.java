package io.github.lukas2005.DeviceModApps;

import javassist.ClassPool;
import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.openjpa.enhance.InstrumentationFactory;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionManager {

	public static final Instrumentation instrumentationInstance = InstrumentationFactory.getInstrumentation(new CustomVerboseLogger());

    public static ClassPool pool = ClassPool.getDefault();

	public static void preInit(FMLPreInitializationEvent e) {
		pool.importPackage("java.util");
		pool.importPackage("java.lang.ref");

		pool.importPackage("net.minecraft.util");

		pool.importPackage("net.minecraftforge.fml.relauncher");

		pool.importPackage("com.mrcrayfish.device.api");
		pool.importPackage("com.mrcrayfish.device.network");
		pool.importPackage("com.mrcrayfish.device.network.task");
		//pool.importPackage("com.mrcrayfish.device.object");
		pool.importPackage("com.mrcrayfish.device.proxy");
		pool.importPackage("com.mrcrayfish.device");

		pool.importPackage("io.github.lukas2005.DeviceModApps.apps");
		pool.importPackage("io.github.lukas2005.DeviceModApps");

        Main.proxy.preInitReflect(e);
	}

	public static void init(FMLInitializationEvent e) {
        Main.proxy.initReflect(e);
	}

	public static void postInit(FMLPostInitializationEvent e) {
        Main.proxy.postInitReflect(e);
	}

}
