package io.github.vicen621.loriath.common.item.accessories;

import io.github.vicen621.loriath.common.init.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Language;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.List;

public abstract class AbstractAccessoryItem extends Item {

    public AbstractAccessoryItem() {
        this(new FabricItemSettings().group(ModItems.ITEM_GROUP).maxCount(1).rarity(Rarity.RARE));
    }

    public AbstractAccessoryItem(Settings settings) {
        super(settings.group(ModItems.ITEM_GROUP).maxCount(1).rarity(Rarity.RARE));
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext flags) {
        appendTooltipDescription(tooltip, this.getTranslationKey() + ".tooltip");
    }

    protected void appendTooltipDescription(List<Text> tooltip, String translKey) {
        String[] lines = String.format(Language.getInstance().get(translKey), getTooltipDescriptionArguments().toArray()).split("\n");

        for (String line : lines) {
            tooltip.add(new LiteralText(line).formatted(Formatting.GRAY));
        }
    }

    protected List<String> getTooltipDescriptionArguments() {
        return Collections.emptyList();
    }
}
