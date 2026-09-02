package cintlex.enttick.mixin;

import net.minecraft.server.level.ChunkMap;
import net.minecraft.server.level.ServerChunkCache;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ServerChunkCache.class)
public abstract class DontTickHere {
    //? if >=1.20.3 {
    @WrapOperation(
            method = "tick(Ljava/util/function/BooleanSupplier;Z)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/level/ChunkMap;tick()V"
            )
    )
    /*?} else {*/
    /*@WrapOperation(
            method = "tickChunks()V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/level/ChunkMap;tick()V"
            ),
            allow = 2
    )*/
    //?}
    private void enttick$cancel(ChunkMap cm, Operation<Void> wrap) {}
}