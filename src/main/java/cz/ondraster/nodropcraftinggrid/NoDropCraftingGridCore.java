package cz.ondraster.nodropcraftinggrid;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

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

   @EventHandler
   public void preinit(FMLPreInitializationEvent event) {

   }

   @EventHandler
   public void postInit(FMLPostInitializationEvent event) {
   }
}
