package cz.ondraster.nodropcraftinggrid;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.8")
@IFMLLoadingPlugin.Name(NoDropCraftingGrid.NAME)
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
