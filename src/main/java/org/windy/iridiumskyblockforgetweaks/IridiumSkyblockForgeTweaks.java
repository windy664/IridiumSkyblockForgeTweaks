package org.windy.iridiumskyblockforgetweaks;

import com.simibubi.create.AllTags.AllItemTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The value here should match an entry in the META-INF/mods.toml file
 */
@Mod(IridiumSkyblockForgeTweaks.MODID)
public class IridiumSkyblockForgeTweaks {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    // Define mod id in a common place for global access
    public static final String MODID = "iridiumskyblockforgetweaks";
    // Directly reference a log4j logger
    private static final Logger LOGGER = LogManager.getLogger();

    // Create a simple instance variable so we can access it in a static context
    public IridiumSkyblockForgeTweaks() {
        // Register the commonSetup method for modloading
        IEventBus modEventBus = MinecraftForge.EVENT_BUS;
        // This will run during Minecraft's initialization phase
        modEventBus.register(this);

        // Register the deferred register for items, blockstates, and recipes
        // You can use SubscribeEvent and let the Event Bus discover all methods to call
        // on the mod side (i.e. common and client)
    }

    // You can use SubscribeEvent and let the Event Bus discover all methods to call
    // on the mod side (i.e. common and client)
    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover all methods to call
    // on the mod side (i.e. common and client)
    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent event) {
        // Log event details
        LOGGER.info("Forge Event Triggered: " + event.getAction());

        // 只处理右键点击事件
        if (event.getAction() == PlayerInteractEvent.Action.RIGHT_CLICK_AIR ||
                event.getAction() == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {

            Player player = event.getEntity();
            ItemStack itemStack = event.getItemStack();

            // 检查玩家是否按住 Shift 键
            if (player.isSneaking() && itemStack != null && !itemStack.isEmpty()) {
                // 获取扳手的材料名称，这里我们假设扳手有一个定义好的名称
                String wrenchMaterialName = "CREATE_WRENCH";

                // 检查物品是否包含扳手的名称
                if (itemStack.toString().contains(wrenchMaterialName)) {
                    // 输出日志
                    LOGGER.info("监听到Forge扳手事件，准备取消");
                    // 取消事件
                    event.setCanceled(true);
                    LOGGER.info("Forge扳手事件已取消");
                }
            }
        }
    }

    // You can use EventBus to discover events to fire
    // Some common events are registered here for convenience
    @SubscribeEvent
    public void onClientSetup(final FMLClientSetupEvent event) {
        // Some common setup code for the client
        LOGGER.info("HELLO FROM CLIENT SETUP");
    }

    // You can use EventBus to discover events to fire
    // Some common events are registered here for convenience
    @SubscribeEvent
    public void onServerSetup(final FMLCommonSetupEvent event) {
        // Some common setup code for the server
        LOGGER.info("HELLO FROM SERVER SETUP");
    }
}
