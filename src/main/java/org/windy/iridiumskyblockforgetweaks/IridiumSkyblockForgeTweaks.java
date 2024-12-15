package org.windy.iridiumskyblockforgetweaks;

import com.simibubi.create.AllItems;
import com.simibubi.create.AllTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(IridiumSkyblockForgeTweaks.MODID)
public class IridiumSkyblockForgeTweaks {

    // Define mod id in a common place for global access
    public static final String MODID = "iridiumskyblockforgetweaks";
    private static final Logger LOGGER = LogManager.getLogger();

    public IridiumSkyblockForgeTweaks()     {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void useWrench(PlayerInteractEvent.RightClickBlock event) {
        LOGGER.info("触发交互事件")
            
        // 获取玩家和物品
        Player player = event.getEntity();
        ItemStack itemStack = event.getItemStack();

        // 判断事件是否已取消
        if (event.isCanceled()) {
            LOGGER.info("Event already canceled, returning early.");
            return;
        }

        // 检查世界是否有效
        if (event.getLevel() == null) {
            LOGGER.warn("世界为空，不处理.");
            return;
        }

        // 记录物品信息，检查是否是扳手
        LOGGER.info("手持扳手: " + AllItems.WRENCH.isIn(itemStack));

        // 如果是扳手，取消事件
        if (AllItems.WRENCH.isIn(itemStack)) {
            LOGGER.info("开始取消扳手事件");
            event.setCanceled(true);
            LOGGER.info("扳手事件已取消");
        } else {
            LOGGER.info("非扳手也");
        }
    }
}
