package cz.ondraster.nodropinventory;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;

@Mod(modid = "nodropinventory", version = "1.0", name = "No Drop Inventory")
public class NoDropInventory {
   @Mod.Instance
   public static NoDropInventory instance;

   @Mod.EventHandler
   public void preinit(FMLPreInitializationEvent event) {
   }

   @Mod.EventHandler
   public void postinit(FMLPostInitializationEvent event) {
   }

   @Mod.EventHandler
   public void init(FMLInitializationEvent event) {
      MinecraftForge.EVENT_BUS.register(this);
   }

   @SubscribeEvent
   public void onEntityConstructing(EntityEvent.EntityConstructing event) {
      if (event.entity instanceof EntityPlayer)
         CraftingGridExtended.register((EntityPlayer) event.entity);
   }

   @SubscribeEvent
   public void onPlayerDropsEvent(PlayerDropsEvent event) {
      ContainerPlayer container = (ContainerPlayer) event.entityPlayer.inventoryContainer;
      for (int i = 0; i < container.craftMatrix.getSizeInventory(); i++) {
         ItemStack stack = container.craftMatrix.getStackInSlot(i);
         if (stack != null)
            event.drops.add(new EntityItem(event.entityPlayer.worldObj, event.entityPlayer.posX,
                  event.entityPlayer.posY - 0.30000001192092896D + (double) event.entityPlayer.getEyeHeight(),
                  event.entityPlayer.posZ, stack));
      }

   }
}
