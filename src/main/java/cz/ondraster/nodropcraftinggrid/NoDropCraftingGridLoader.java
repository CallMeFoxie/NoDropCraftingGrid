package cz.ondraster.nodropcraftinggrid;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.Name(NoDropCraftingGridCore.NAME)
public class NoDropCraftingGridLoader implements IFMLLoadingPlugin {
   @Override
   public String[] getASMTransformerClass() {
      return new String[]{NDCGTransformer.class.getName()};
   }

   @Override
   public String getModContainerClass() {
      return NoDropCraftingGridCore.class.getName();
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
