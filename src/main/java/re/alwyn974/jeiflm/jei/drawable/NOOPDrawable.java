package re.alwyn974.jeiflm.jei.drawable;

import mezz.jei.api.gui.drawable.IDrawable;
import net.minecraft.client.gui.GuiGraphics;

public record NOOPDrawable(int width, int height) implements IDrawable {
    public NOOPDrawable(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
    }

    public int width() {
        return this.width;
    }

    public int height() {
        return this.height;
    }
}