<div align="center">

<img src="assets/banner.svg" alt="IridiumSkyblockForgeTweaks" width="100%">

# IridiumSkyblockForgeTweaks

**Forge 端空岛 Mod 物品保护** —— 面向 Forge 系混合端（Mohist 等）的 IridiumSkyblock 扳手拦截，走 Forge 事件层，覆盖插件层拦不住的场景。

![Platform](https://img.shields.io/badge/Platform-Mohist%20%2F%20Forge%20Hybrid-62bda8?style=flat-square&logo=minecraft&logoColor=white)
![Minecraft](https://img.shields.io/badge/MC-1.20.x-8a9a5b?style=flat-square)
![Java](https://img.shields.io/badge/Java-17%2B-f89820?style=flat-square&logo=openjdk&logoColor=white)

[功能](#-功能) · [配置](#️-配置)

</div>

## ✨ 功能

- **Forge 事件拦截**：通过 Mixingradle + ForgeGradle 构建，在 Forge 事件层（`ForgeEventListener`）拦截交互，Bukkit 侧纯插件方案漏掉的 Mod 物品交互也能拦住
- **IridiumSkyblock 联动**：只在空岛世界生效，判断目标是否位于玩家自己的岛屿
- **扳手黑名单**：`disabledItems` 可配，默认拦截 `CREATE_WRENCH`

> 同系列插件（Bukkit 侧）：[IridiumSkyblockModTweaks](https://github.com/windy664/IridiumSkyblockModTweaks)

## ⚙️ 配置

```yaml
disabledItems:
  - CREATE_WRENCH
```

## 🔨 构建

```bash
./gradlew build
```
