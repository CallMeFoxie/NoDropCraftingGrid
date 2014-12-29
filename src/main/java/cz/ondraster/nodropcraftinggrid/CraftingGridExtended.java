package cz.ondraster.nodropcraftinggrid;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class CraftingGridExtended implements IExtendedEntityProperties {
   public static final String EXT_PROP = "nodropcraftinv";

   EntityPlayer player;

   public CraftingGridExtended(EntityPlayer player) {
      this.player = player;
   }

   @Override
   public void saveNBTData(NBTTagCompound compound) {
      ContainerPlayer container = (ContainerPlayer) player.inventoryContainer;
      NBTTagList list = new NBTTagList();
      for (int i = 0; i < container.craftMatrix.getSizeInventory(); i++) {
         NBTTagCompound compound1 = new NBTTagCompound();
         compound1.setByte("Slot", (byte) i);
         ItemStack stack = container.craftMatrix.getStackInSlot(i);
         if (stack != null)
            stack.writeToNBT(compound1);
         list.appendTag(compound1);

      }
      compound.setTag(EXT_PROP, list);
   }

   @Override
   public void loadNBTData(NBTTagCompound compound) {
      ContainerPlayer container = (ContainerPlayer) player.inventoryContainer;
      NBTTagList list = (NBTTagList) compound.getTag(EXT_PROP);
      if (list == null)
         return;

      for (int i = 0; i < list.tagCount(); i++) {
         NBTTagCompound at = list.getCompoundTagAt(i);
         int j = at.getByte("Slot") & 0xFF;
         if (j >= 0 && j < container.craftMatrix.getSizeInventory()) {
            container.craftMatrix.setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(at));
         }
      }
   }

   @Override
   public void init(Entity entity, World world) {

   }

   public static void register(EntityPlayer player) {
      player.registerExtendedProperties(EXT_PROP, new CraftingGridExtended(player));
   }
}
