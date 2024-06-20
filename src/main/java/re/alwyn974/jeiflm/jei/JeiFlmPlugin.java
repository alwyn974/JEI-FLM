package re.alwyn974.jeiflm.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.*;
import mezz.jei.api.runtime.IJeiRuntime;
import mezz.jei.api.runtime.config.IJeiConfigManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import re.alwyn974.jeiflm.JEI_FLM;
import re.alwyn974.jeiflm.Resources;
import re.alwyn974.jeiflm.jei.recipe.JeiFlmRecipe;

import java.util.List;

@JeiPlugin
public class JeiFlmPlugin implements IModPlugin {
    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return Resources.LOCATION;
    }

    @Override
    public void onConfigManagerAvailable(@NotNull final IJeiConfigManager configManager) {
        JEI_FLM.getLOGGER().info("JEI Config Manager available");
    }

    @Override
    public void onRuntimeAvailable(@NotNull final IJeiRuntime jeiRuntime) {
        JEI_FLM.getLOGGER().info("JEI Runtime available");
    }

    @Override
    public void onRuntimeUnavailable() {
        JEI_FLM.getLOGGER().info("JEI Runtime unavailable");
    }

    @Override
    public void registerCategories(final IRecipeCategoryRegistration registration) {
        JEI_FLM.getLOGGER().info("JEI Category registration");
        registration.addRecipeCategories(new JeiFlmRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerAdvanced(final IAdvancedRegistration registration) {
        JEI_FLM.getLOGGER().info("JEI Advanced registration");
    }

    @Override
    public void registerRuntime(final IRuntimeRegistration registration) {
        JEI_FLM.getLOGGER().info("JEI Runtime registration");
    }

    @Override
    public void registerGuiHandlers(final IGuiHandlerRegistration registration) {
        JEI_FLM.getLOGGER().info("JEI GUI Handler registration");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        JEI_FLM.getLOGGER().info("JEI Recipe registration");
        registration.addRecipes(JeiFlmRecipeCategory.RECIPE_TYPE,List.of(new JeiFlmRecipe(new ItemStack(Items.STICKY_PISTON))));
    }
}
