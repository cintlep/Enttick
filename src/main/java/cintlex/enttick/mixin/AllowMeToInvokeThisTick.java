package cintlex.enttick.mixin;

import net.minecraft.server.level.ChunkMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ChunkMap.class)
public interface AllowMeToInvokeThisTick {
    @Invoker("tick")
    void enttick$tick();
}