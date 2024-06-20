package re.alwyn974.jeiflm.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IAdvancedRegistration;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRuntimeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import mezz.jei.api.runtime.config.IJeiConfigManager;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import re.alwyn974.jeiflm.JEI_FLM;
import re.alwyn974.jeiflm.Resources;

@JeiPlugin
public class JeiFLMPlugin implements IModPlugin {
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
    public void registerAdvanced(@NotNull final IAdvancedRegistration registration) {
        JEI_FLM.getLOGGER().info("JEI Advanced registration");
    }

    @Override
    public void registerRuntime(@NotNull final IRuntimeRegistration registration) {
        JEI_FLM.getLOGGER().info("JEI Runtime registration");
    }

    @Override
    public void registerGuiHandlers(@NotNull final IGuiHandlerRegistration registration) {
        JEI_FLM.getLOGGER().info("JEI GUI Handler registration");
    }
}