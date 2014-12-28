package cz.ondraster.nodropinventory;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class NoDropInventoryCore extends DummyModContainer {
   public static final String MODID = "nodropinventorycore";
   public static final String VERSION = "1.0";
   public static final String NAME = "NoDropInventoryCore";

   public static boolean serverEnabled = false;

   public NoDropInventoryCore() {
      super(new ModMetadata());
      ModMetadata metadata = getMetadata();
      metadata.modId = MODID;
      metadata.name = NAME;
      metadata.version = VERSION;
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
