package org.windy.iridiumskyblockforgetweaks;

import com.simibubi.create.AllItems;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import com.simibubi.create.AllItems;



@Mod(IridiumSkyblockForgeTweaks.MODID)
public class IridiumSkyblockForgeTweaks {

    // Define mod id in a common place for global access
    public static final String MODID = "iridiumskyblockforgetweaks";
    private static final Logger LOGGER = LogManager.getLogger();

    public IridiumSkyblockForgeTweaks() {
        IEventBus modEventBus = MinecraftForge.EVENT_BUS;
        modEventBus.addListener(this::commonSetup);
        modEventBus.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void useOwnWrenchLogicForCreateBlocks(RightClickBlock event) {
        Player player = event.getEntity();
        ItemStack itemStack = event.getItemStack();
        if (event.isCanceled()) return;
        if (event.getLevel() == null) return;
        // Check if item is a wrench (assuming Create mod wrench or your custom wrench)
        // 获取当前玩家所持的物品
        Item item = itemStack.getItem();

        // 手动比较物品
        if (item == AllItems.WRENCH.get()) {  // 假设 WRENCH 是 Create 中的扳手
            LOGGER.info("Detected a wrench interaction.");
            event.setCanceled(true);  // 取消事件
        }
    }
}
