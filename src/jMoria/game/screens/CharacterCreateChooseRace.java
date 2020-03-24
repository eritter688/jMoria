package jMoria.game.screens;

import jMoria.game.living.Player;
import jMoria.ui.Terminal;
import java.util.Collections;
import java.util.HashSet;

public class CharacterCreateChooseRace extends AbstractScreen {

    public Player player;

    public HashSet<String> acceptedKeys = new HashSet<>();

    public CharacterCreateChooseRace(Terminal terminal, Player player) {
        this.terminal = terminal;
        this.player = player;
    }

    @Override
    public void init() {
        render();
    }

    @Override
    public void run() {
        this.listening = Boolean.TRUE;
    }

    @Override
    public void render() {
        terminal.writeLine(3, "  Name     :");
        terminal.writeLine(4, "  Race     :");
        terminal.writeLine(5, "  Sex      :");
        terminal.writeLine(6, "  Class    :");

        terminal.writeLine(19, "  Choose a race:");
        terminal.writeLine(
            20, "  a) Human       b) Half-Elf    c) Elf         d) Halfling    e) Gnome");
        terminal.writeLine(21, "  f) Dwarf       g) Half-Orc    h) Half-Troll");
    }

    @Override
    public void handleKey(String key) {

        Collections.addAll(acceptedKeys, "a", "b", "c", "d", "e", "f", "g", "h");

        if (this.listening == Boolean.TRUE && acceptedKeys.contains(key)) {
            player.race = key;
        }
    }
}
