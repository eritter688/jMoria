package jMoria.game.screens;

import jMoria.game.ResourcePackage;
import jMoria.ui.Terminal;
import java.util.Collections;
import java.util.HashSet;

public class ChooseRace extends AbstractScreen {

    public HashSet<String> acceptedKeys = new HashSet<>();

    public ChooseRace(ResourcePackage gameResources) {
        super(gameResources);
    }

    @Override
    public void init() {
        Collections.addAll(acceptedKeys, "a", "b", "c", "d", "e", "f", "g", "h");
    }

    @Override
    public void render() {
        Terminal t = gameResources.terminal;
        t.writeLine(3, "  Name     :");
        t.writeLine(4, "  Race     :");
        t.writeLine(5, "  Sex      :");
        t.writeLine(6, "  Class    :");

        t.writeLine(19, "  Choose a race:");
        t.writeLine(
            20, "  a) Human       b) Half-Elf    c) Elf         d) Halfling    e) Gnome");
        t.writeLine(21, "  f) Dwarf       g) Half-Orc    h) Half-Troll");
    }

    @Override
    public void handleKey(String key) {
        if (this.listening == Boolean.TRUE && acceptedKeys.contains(key)) {
            gameResources.player.race = key;
            gameResources.game.setCurrentScreen(this);
        }
    }
}
