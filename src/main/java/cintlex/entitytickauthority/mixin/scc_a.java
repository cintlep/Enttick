package cintlex.entitytickauthority.mixin;

import net.minecraft.server.level.ChunkMap;
import net.minecraft.server.level.ServerChunkCache;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ServerChunkCache.class)
public abstract class scc_a {
    @WrapOperation(
            method = "tick(Ljava/util/function/BooleanSupplier;Z)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/level/ChunkMap;tick()V"
            )
    )
    private void entitytickauthority$defertick(ChunkMap cm, Operation<Void> wrap) {}
}