package re.alwyn974.jeiflm.jei;

import com.mojang.blaze3d.vertex.PoseStack;
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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import re.alwyn974.jeiflm.Resources;
import re.alwyn974.jeiflm.jei.drawable.NOOPDrawable;
import re.alwyn974.jeiflm.jei.recipe.JeiFlmRecipe;

public class JeiFlmRecipeCategory implements IRecipeCategory<JeiFlmRecipe> {
    private final IGuiHelper guiHelper;
    public static final RecipeType<JeiFlmRecipe> RECIPE_TYPE = new RecipeType<>(Resources.JEI_LOCATION, JeiFlmRecipe.class);

    public JeiFlmRecipeCategory(IGuiHelper guiHelper) {
        this.guiHelper = guiHelper;
    }

    @Override
    public @NotNull RecipeType<JeiFlmRecipe> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.literal("Full Lazy Mode");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return new NOOPDrawable(182, 60);
    }

    @Override
    public @NotNull IDrawable getIcon() {
//        return this.guiHelper.createDrawableItemStack(new ItemStack(Items.PAPER));
        return  guiHelper.drawableBuilder(new ResourceLocation("paper"), 0, 0, 18, 18).setTextureSize(18, 18).build();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, JeiFlmRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 0, 0);
//        builder.addSlot(RecipeIngredientRole.OUTPUT, 1, 0);
    }

    @Override
    public void draw(JeiFlmRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        PoseStack pose = guiGraphics.pose();
        pose.pushPose();
        pose.translate(-6, -13, 0.0F);
//        this.renderElements(recipe, recipeSlotsView, guiGraphics, (int)mouseX, (int)mouseY);
        pose.popPose();
    }
}
