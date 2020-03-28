package jMoria.game.screens;

import static java.util.Map.entry;

import jMoria.game.ResourcePackage;
import jMoria.game.enums.Race;
import jMoria.game.statics.CharacterCreation;
import jMoria.ui.Terminal;
import java.util.Map;

public class ChooseRace extends AbstractScreen {

    private Map<String, Race> choices = Map.ofEntries(
        entry("a", Race.HUMAN),
        entry("b", Race.HALF_ELF),
        entry("c", Race.ELF),
        entry("d", Race.HALFLING),
        entry("e", Race.GNOME),
        entry("f", Race.DWARF),
        entry("g", Race.HALF_ORC),
        entry("h", Race.HALF_TROLL)
    );

    public ChooseRace(ResourcePackage gameResources) {
        super(gameResources);
    }

    @Override
    public void init() {
        gameResources.terminal.clearScreen();
    }

    @Override
    public void render() {
        CharacterCreation.renderPersonalStats(gameResources.terminal, gameResources.player);

        Terminal t = gameResources.terminal;
        t.writeLine(19, "  Choose a race:");
        t.writeLine(
            20, "  a) Human       b) Half-Elf    c) Elf         d) Halfling    e) Gnome");
        t.writeLine(21, "  f) Dwarf       g) Half-Orc    h) Half-Troll");
    }

    @Override
    public void handleKey(String key) {
        if (this.listening == Boolean.TRUE && choices.containsKey(key)) {
            gameResources.player.race = choices.get(key);
            gameResources.game.setCurrentScreen(new ChooseSex(gameResources));
        }
    }

}
