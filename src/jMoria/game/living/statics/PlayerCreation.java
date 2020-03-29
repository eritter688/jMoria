package jMoria.game.living.statics;

import jMoria.game.enums.Race;

import java.util.Map;

import static java.util.Map.entry;

public class PlayerCreation {

    public static Map<Race, int[]> baseAgeAndModifier = Map.ofEntries(
            entry(Race.HUMAN, new int[]{14, 6}),
            entry(Race.HALF_ELF, new int[]{24, 16}),
            entry(Race.ELF, new int[]{75, 75}),
            entry(Race.HALFLING, new int[]{21, 12}),
            entry(Race.GNOME, new int[]{50, 40}),
            entry(Race.DWARF, new int[]{35, 15}),
            entry(Race.HALF_ORC, new int[]{11, 4}),
            entry(Race.HALF_TROLL, new int[]{20, 10})
    );

    public static int getPlayerAge(Race race) {
        int[] baseAndMod = baseAgeAndModifier.get(race);

        return 1;
    }

}
