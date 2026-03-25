package red.jackf.whereisit.client.mixin;

import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.resource.GraphicsResourceAllocator;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.chunk.ChunkSectionsToRender;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.Minecraft;
import org.joml.Matrix4fc;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import red.jackf.whereisit.client.render.Rendering;

@Mixin(LevelRenderer.class)
public abstract class LevelRendererMixin {

    @Inject(
            method = "renderLevel",
            at = @At("TAIL")
    )
    private void onRenderLevelEnd(
            GraphicsResourceAllocator graphicsResourceAllocator,
            DeltaTracker deltaTracker,
            boolean renderBlockOutline,
            CameraRenderState cameraState,
            Matrix4fc modelViewMatrix,
            GpuBufferSlice terrainFog,
            Vector4f fogColor,
            boolean shouldRenderSky,
            ChunkSectionsToRender chunkSectionsToRender,
            CallbackInfo ci
    ) {
        if (!Rendering.shouldBeRendering()) return;

        float tickDelta = deltaTracker.getGameTimeDeltaPartialTick(false);

        Camera camera = Minecraft.getInstance().gameRenderer.getMainCamera();

        //GL11.glDisable(GL11.GL_DEPTH_TEST);
        //GL11.glDepthFunc(GL11.GL_ALWAYS);

        // Creating empty PoseStack
        PoseStack poseStack = new PoseStack();

        MultiBufferSource.BufferSource bufferSource =
                net.minecraft.client.Minecraft.getInstance()
                        .renderBuffers()
                        .bufferSource();

        // Rendering boxes
        Rendering.renderBoxes(bufferSource, camera, tickDelta);
        Rendering.renderEntityHighlights(bufferSource, camera, tickDelta);

        // Rendering labels
        Rendering.renderLabels(poseStack, camera, bufferSource);

        bufferSource.endBatch();

        //GL11.glDepthFunc(GL11.GL_LEQUAL);
        //GL11.glEnable(GL11.GL_DEPTH_TEST);
    }
}