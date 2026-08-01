package cintlex.entitytickauthority.mixin;

import net.minecraft.server.level.ChunkMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ChunkMap.class)
public interface invoker_a {
    @Invoker("tick")
    void entitytickauthority$tick();
}