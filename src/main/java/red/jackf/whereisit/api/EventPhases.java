package red.jackf.whereisit.api;

import net.fabricmc.fabric.api.event.Event;
import net.minecraft.resources.Identifier;
import red.jackf.whereisit.WhereIsIt;

public interface EventPhases {
    Identifier PRIORITY = WhereIsIt.id("priority");
    Identifier DEFAULT = Event.DEFAULT_PHASE;
    Identifier FALLBACK = WhereIsIt.id("fallback");
}
