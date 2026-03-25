package red.jackf.whereisit.client.mixin;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import red.jackf.whereisit.client.render.Rendering;
import red.jackf.whereisit.config.WhereIsItConfig;

@Mixin(AbstractContainerScreen.class)
public class AbstractContainerScreenMixinBack {
    @Inject(
            method = "extractContents(Lnet/minecraft/client/gui/GuiGraphicsExtractor;IIF)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;extractSlotHighlightBack(Lnet/minecraft/client/gui/GuiGraphicsExtractor;)V",
                    shift = At.Shift.AFTER
            )
    )
    private void afterExtractSlotHighlightBack(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTick, CallbackInfo ci) {
        if (!WhereIsItConfig.INSTANCE.instance().getClient().renderHighlightAboveItems) {
            Rendering.renderSlotHighlight((AbstractContainerScreen<?>) (Object) this, guiGraphics, partialTick, false, mouseX, mouseY);
        }
    }
}
