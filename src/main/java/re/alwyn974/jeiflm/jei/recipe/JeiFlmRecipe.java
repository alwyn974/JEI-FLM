package re.alwyn974.jeiflm.jei.recipe;

import net.minecraft.world.item.ItemStack;

public record JeiFlmRecipe(ItemStack input) {
    public JeiFlmRecipe {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input must not be empty");
        }
    }

    @Override
    public ItemStack input() {
        return input;
    }
}
