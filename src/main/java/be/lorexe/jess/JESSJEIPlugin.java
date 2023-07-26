package be.lorexe.jess;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

@JeiPlugin
public class JESSJEIPlugin implements IModPlugin {
    public ResourceLocation getPluginUid() {
        return new ResourceLocation("jess", "jeiplugin");
    }

    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new IRecipeCategory[] { new VibratorCategory(registration.getJeiHelpers().getGuiHelper()) });
    }

    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(VibratorCategory.TYPE, JESSMod.FREQUENCIES);
    }

    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack((ItemLike) Items.SCULK_SENSOR),
                new RecipeType[] { VibratorCategory.TYPE });
    }
}
