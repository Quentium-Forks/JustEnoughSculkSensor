package be.lorexe.jess;

import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

public class VibratorCategory implements IRecipeCategory<VibratorRecipe> {
    public static final RecipeType<VibratorRecipe> TYPE = RecipeType.create("jess", "jess", VibratorRecipe.class);

    private final IDrawable icon;
    private final IDrawable background;

    public VibratorCategory(IGuiHelper guiHelper) {
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
                new ItemStack((ItemLike) Items.SCULK_SENSOR));
        this.background = (IDrawable) guiHelper.createBlankDrawable(150, 125);
    }

    public RecipeType<VibratorRecipe> getRecipeType() {
        return TYPE;
    }

    public Component getTitle() {
        return (Component) Component.translatable("jess.category.vibrator");
    }

    public IDrawable getBackground() {
        return this.background;
    }

    public IDrawable getIcon() {
        return this.icon;
    }

    public void setRecipe(IRecipeLayoutBuilder builder, VibratorRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.CATALYST, 50, 0)
                .addItemStack(new ItemStack((ItemLike) Items.COMPARATOR));
    }

    public void draw(VibratorRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics graphics, double mouseX,
            double mouseY) {
        recipe.draw(recipeSlotsView, graphics, mouseX, mouseY);
    }
}
