package cintlex.entitytickauthority.mixin;

import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.function.BooleanSupplier;

@Mixin(ServerLevel.class)
public abstract class sl_a {
    @Inject(
            method = "tick(Ljava/util/function/BooleanSupplier;)V",
            at = @At("TAIL")
    )
    private void entitytickauthority$chunkmaptick(BooleanSupplier haveTime, CallbackInfo ci) {
        ServerLevel sl = (ServerLevel) (Object) this;
        ((invoker_a) sl.getChunkSource().chunkMap).entitytickauthority$tick();
    }
}