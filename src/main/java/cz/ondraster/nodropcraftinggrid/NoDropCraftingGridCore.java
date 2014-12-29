package cz.ondraster.nodropcraftinggrid;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class NoDropCraftingGridCore extends DummyModContainer {

   public NoDropCraftingGridCore() {
      super(new ModMetadata());
      ModMetadata metadata = getMetadata();
      metadata.modId = NoDropCraftingGrid.MODID + "core";
      metadata.name = NoDropCraftingGrid.NAME + " Core";
      metadata.version = NoDropCraftingGrid.VERSION;
      metadata.authorList.add(NoDropCraftingGrid.AUTHOR);
   }

   @Override
   public boolean registerBus(EventBus bus, LoadController controller) {
      bus.register(this);
      return true;
   }

   @Subscribe
   public void modConstruction(FMLConstructionEvent event) {

   }

   @Mod.EventHandler
   public void preinit(FMLPreInitializationEvent event) {

   }

   @Mod.EventHandler
   public void postInit(FMLPostInitializationEvent event) {
   }
}
