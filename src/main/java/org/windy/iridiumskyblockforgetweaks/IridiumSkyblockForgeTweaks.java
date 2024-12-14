package org.windy.iridiumskyblockforgetweaks;

import com.simibubi.create.AllTags.AllItemTags;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import com.mohistmc.api.event.BukkitHookForgeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class IridiumSkyblockForgeTweaks extends JavaPlugin implements Listener {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onEnable() {
        // 注册 Bukkit 和 Forge 事件监听器
        Bukkit.getPluginManager().registerEvents(this, this);
        // 注册 Forge 事件监听器
        net.minecraftforge.eventbus.api.IEventBus modEventBus = net.minecraftforge.common.MinecraftForge.EVENT_BUS;
        modEventBus.register(this);
        LOGGER.info("插件已启用，日志测试！！！！！！！！！！！！！！！！！！");
    }

    @Override
    public void onDisable() {
        // 在插件禁用时执行的代码（如果有）
    }



    // Forge 事件监听示例
    @SubscribeEvent
    public void onForgeWrenchEvent(net.minecraftforge.event.entity.player.PlayerInteractEvent event) {
        LOGGER.info("Forge事件触发");

        // 将 Forge 事件转换为 Bukkit 事件
        Bukkit.getPluginManager().callEvent(new BukkitHookForgeEvent(event));

        // 处理该事件
        Player player = event.getEntity();
        ItemStack itemStack = event.getItem();

        if (event.isCanceled()) return;
        if (player == null || !player.mayBuild()) return;
        if (itemStack.isEmpty()) return;

        // 从配置文件获取 CREATE_WRENCH 材质名称
        String wrenchMaterialName = "CREATE_WRENCH";
        Material wrenchMaterial = Material.getMaterial(wrenchMaterialName);

        if (wrenchMaterial == null || !itemStack.getItem().toString().contains(wrenchMaterial.name())) {
            return;
        }

        if (AllItemTags.WRENCH.matches(itemStack.getItem())) {
            LOGGER.info("监听到Forge扳手事件，准备取消");

            // 获取方块状态和扳手操作
            BlockState blockState = event.getLevel().getBlockState(event.getPos());
            Block block = blockState.getBlock();

            if (!(block instanceof IWrenchable)) return;

            // 执行扳手操作（这里只需要取消事件）
            event.setCanceled(true);
            LOGGER.info("Forge扳手事件已取消");
        }
    }
}
