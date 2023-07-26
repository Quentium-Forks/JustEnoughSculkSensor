package be.lorexe.jess;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import java.util.Objects;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;

public class VibratorRecipe {
    public Integer frequency;
    public List<String> events;

    public VibratorRecipe(Integer frequency, List<String> events) {
        this.frequency = frequency;
        this.events = events;
    }

    public void draw(IRecipeSlotsView slots, PoseStack stack, double mouseX, double mouseY) {
        Minecraft mc = Minecraft.getInstance();
        Font font = mc.font;

        font.drawShadow(stack, "→ " + this.frequency.toString(), 75.0F, 5.0F, 16711680);

        for (int i = 0; i < this.events.size(); i++) {
            String event = this.events.get(i);
            Objects.requireNonNull(font);
            font.drawShadow(stack, "• " + Component.translatable("jess.event." + event).getString(), 10.0F,
                    (37 + i * 9), 16777215);
        }
    }
}
