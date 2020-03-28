package jMoria.game.screens;

import jMoria.game.ResourcePackage;
import jMoria.game.enums.Race;
import jMoria.game.living.Player;
import jMoria.ui.Terminal;

public class ChooseRace extends AbstractScreen {

    public ChooseRace(ResourcePackage gameResources) {
        super(gameResources);
    }

    @Override
    public void init() {
        gameResources.terminal.clearScreen();
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
        if (this.listening == Boolean.TRUE) {
            Player player = gameResources.player;
            switch (key) {
                case "a":
                    player.race = Race.HUMAN;
                    advance();
                    break;
                case "b":
                    player.race = Race.HALF_ELF;
                    advance();
                    break;
                case "c":
                    player.race = Race.ELF;
                    advance();
                    break;
                case "d":
                    player.race = Race.HALFLING;
                    advance();
                    break;
                case "e":
                    player.race = Race.GNOME;
                    advance();
                    break;
                case "f":
                    player.race = Race.DWARF;
                    advance();
                    break;
                case "g":
                    player.race = Race.HALF_ORC;
                    advance();
                    break;
                case "h":
                    player.race = Race.HALF_TROLL;
                    advance();
                    break;
            }
        }
    }

    private void advance() {
        gameResources.game.setCurrentScreen(new ChooseSex(gameResources));
    }
}
