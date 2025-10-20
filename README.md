# Where Is It (Unofficial port)
---
## [Original Mod](https://github.com/JackFred2/WhereIsIt)
---
Minecraft mod to locate items in nearby inventories. Press Y over an item to search.

![An example image of the mod showing 4 results](https://i.imgur.com/lvebo0v.png)

## Requirements
- [Fabric API](https://modrinth.com/mod/fabric-api)
- [YACL](https://modrinth.com/mod/yacl)
Also embeds [JackFredLib](https://github.com/ponuing/JackFredLib) and [MixinExtras](https://github.com/LlamaLad7/MixinExtras/).

Features
- Not required - vanilla clients can join without restricting mod users.
- Detailed searching - search by item ID, name, item tag, fluid contents, enchantment, potions, and more, and any combination of the previous.
- Server-side functionality - clients without the mod can use the command /whereis (default, changeable) to use the mod.
- Support for recipe viewers, including the vanilla Recipe Book, and for JEI, REI, EMI:
  - Ability to search for items containing specific fluids, and tags for recipes.
  - Custom searches (search for enchantments using enchanted books, and potion effects using potions).
  - Smart favourite handling - add a named Shulker Box in your favourites, and search for it regardless of the contents.
## Usage
Press **Y** (by default) to search by item ID.

### Inventory
Hold shift to also search for NBT data.

### Recipes (Recipe Book / JEI / REI / EMI)
Will search for tags in the recipe if applicable. If hovered over a fluid, will search for items containing said fluid.

### Item Overlays (JEI / REI / EMI)
Normally matches the inventory, however certain items contain different behavior:

- Enchanted books will search for any items with that enchantment. Holding shift will specify the level as well.
- Potions will search for the potion effect on any item. Holding shift will match the specific item.
### Item Favourites/Bookmarks (JEI / REI / EMI)
Will try to look for the specific item by looking at name, enchantments or potion effects.
