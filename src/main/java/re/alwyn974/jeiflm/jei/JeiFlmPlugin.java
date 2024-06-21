package re.alwyn974.jeiflm.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IColorHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.helpers.IModIdHelper;
import mezz.jei.api.helpers.IPlatformFluidHelper;
import mezz.jei.api.registration.*;
import mezz.jei.api.runtime.IEditModeConfig;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.api.runtime.IJeiRuntime;
import mezz.jei.api.runtime.IScreenHelper;
import mezz.jei.api.runtime.config.IJeiConfigManager;
import mezz.jei.common.Internal;
import mezz.jei.common.config.*;
import mezz.jei.common.gui.textures.Textures;
import mezz.jei.common.input.IInternalKeyMappings;
import mezz.jei.common.network.IConnectionToServer;
import mezz.jei.core.util.LoggedTimer;
import mezz.jei.gui.bookmarks.BookmarkList;
import mezz.jei.gui.config.IBookmarkConfig;
import mezz.jei.gui.overlay.bookmarks.BookmarkOverlay;
import mezz.jei.gui.startup.GuiConfigData;
import mezz.jei.gui.startup.OverlayHelper;
import mezz.jei.gui.util.CheatUtil;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import re.alwyn974.jeiflm.JEI_FLM;
import re.alwyn974.jeiflm.Resources;

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
//        registration.addRecipeCategories(new JeiFlmRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerAdvanced(final IAdvancedRegistration registration) {
        JEI_FLM.getLOGGER().info("JEI Advanced registration");
    }

    @Override
    public void registerRuntime(final IRuntimeRegistration registration) {
        JEI_FLM.getLOGGER().info("JEI Runtime registration");
        LoggedTimer timer = new LoggedTimer();

        IConnectionToServer serverConnection = Internal.getServerConnection();
        Textures textures = Internal.getTextures();
        IInternalKeyMappings keyMappings = Internal.getKeyMappings();

        IScreenHelper screenHelper = registration.getScreenHelper();
        IIngredientManager ingredientManager = registration.getIngredientManager();
        IEditModeConfig editModeConfig = registration.getEditModeConfig();

        IJeiHelpers jeiHelpers = registration.getJeiHelpers();
        IColorHelper colorHelper = jeiHelpers.getColorHelper();
        IModIdHelper modIdHelper = jeiHelpers.getModIdHelper();

        timer.start("Building ingredient filter");
        GuiConfigData configData = GuiConfigData.create();

        IClientToggleState toggleState = Internal.getClientToggleState();
        IBookmarkConfig bookmarkConfig = configData.bookmarkConfig();

        IJeiClientConfigs jeiClientConfigs = Internal.getJeiClientConfigs();
        IClientConfig clientConfig = jeiClientConfigs.getClientConfig();
        IIngredientGridConfig bookmarkListConfig = jeiClientConfigs.getBookmarkListConfig();
        IIngredientFilterConfig ingredientFilterConfig = jeiClientConfigs.getIngredientFilterConfig();

        timer.stop();

        CheatUtil cheatUtil = new CheatUtil(ingredientManager);

        BookmarkList bookmarkList = new BookmarkList(ingredientManager, bookmarkConfig, clientConfig);
        bookmarkConfig.loadBookmarks(ingredientManager, bookmarkList);

        BookmarkOverlay bookmarkOverlay = OverlayHelper.createBookmarkOverlay(
                ingredientManager,
                screenHelper,
                bookmarkList,
                modIdHelper,
                keyMappings,
                bookmarkListConfig,
                editModeConfig,
                ingredientFilterConfig,
                clientConfig,
                toggleState,
                serverConnection,
                textures,
                colorHelper,
                cheatUtil
        );
        registration.setBookmarkOverlay(bookmarkOverlay);
    }

    @Override
    public void registerGuiHandlers(final IGuiHandlerRegistration registration) {
        JEI_FLM.getLOGGER().info("JEI GUI Handler registration");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        JEI_FLM.getLOGGER().info("JEI Recipe registration");
//        registration.addRecipes(JeiFlmRecipeCategory.RECIPE_TYPE,List.of(new JeiFlmRecipe(new ItemStack(Items.STICKY_PISTON))));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
//        registration.addRecipeCatalyst(new ItemStack(Items.STICKY_PISTON), JeiFlmRecipeCategory.RECIPE_TYPE);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        IModPlugin.super.registerRecipeTransferHandlers(registration);
    }

    @Override
    public void registerVanillaCategoryExtensions(IVanillaCategoryExtensionRegistration registration) {
        IModPlugin.super.registerVanillaCategoryExtensions(registration);
    }

    @Override
    public void registerIngredients(IModIngredientRegistration registration) {
        IModPlugin.super.registerIngredients(registration);
    }

    @Override
    public <T> void registerFluidSubtypes(ISubtypeRegistration registration, IPlatformFluidHelper<T> platformFluidHelper) {
        IModPlugin.super.registerFluidSubtypes(registration, platformFluidHelper);
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
        IModPlugin.super.registerItemSubtypes(registration);
    }
}
