package cz.ondraster.nodropinventory;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.Name(NoDropInventoryCore.NAME)
public class NoDropInventoryLoader implements IFMLLoadingPlugin {
   @Override
   public String[] getASMTransformerClass() {
      return new String[]{NDITransformer.class.getName()};
   }

   @Override
   public String getModContainerClass() {
      return NoDropInventoryCore.class.getName();
   }

   @Override
   public String getSetupClass() {
      return null;
   }

   @Override
   public void injectData(Map<String, Object> data) {

   }

   @Override
   public String getAccessTransformerClass() {
      return null;
   }
}
