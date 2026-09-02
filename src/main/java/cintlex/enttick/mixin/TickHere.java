package cintlex.enttick.mixin;

import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.function.BooleanSupplier;

@Mixin(ServerLevel.class)
public abstract class TickHere {
    @Inject(
            method = "tick(Ljava/util/function/BooleanSupplier;)V",
            at = @At("TAIL")
    )
    private void enttick$tickchunkmap(BooleanSupplier haveTime, CallbackInfo ci) {
        ServerLevel sl = (ServerLevel) (Object) this;
        ((AllowMeToInvokeThisTick) sl.getChunkSource().chunkMap).enttick$tick();
    }
}