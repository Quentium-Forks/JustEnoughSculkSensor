package be.lorexe.jess;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;

public class JESSMod {
    public static final String MOD_ID = "jess";
    public static final List<VibratorRecipe> FREQUENCIES;

    static {
        FREQUENCIES = (VibrationListener.VIBRATION_FREQUENCY_FOR_EVENT.object2IntEntrySet().stream()
                .collect(Collectors.groupingBy(Object2IntMap.Entry::getIntValue,
                        Collectors.mapping(entry -> ((GameEvent) entry.getKey()).getName(), Collectors.toList()))))
                .entrySet().stream()
                .map(entry -> new VibratorRecipe((Integer) entry.getKey(), (List<String>) entry.getValue())).toList();
    }

    public static void init() {
    }
}
