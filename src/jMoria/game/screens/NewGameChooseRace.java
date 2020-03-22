package jMoria.game.screens;

import jMoria.ui.Terminal;
import jMoria.game.living.Player;

public class NewGameChooseRace extends AbstractScreen {

    public Player player;

    public NewGameChooseRace(Terminal terminal, Player player)
    {
        this.terminal = terminal;
        this.player = player;
    }

    @Override
    public void initialize() {
        render();
    }

    @Override
    public void render() {
        terminal.writeLine(3, "  Name     :");
        terminal.writeLine(4, "  Race     :");
        terminal.writeLine(5, "  Sex      :");
        terminal.writeLine(6, "  Class    :");

        terminal.writeLine(19, "  Choose a race:");
        terminal.writeLine(20, "  a) Human       b) Half-Elf    c) Elf         d) Halfling    e) Gnome");
        terminal.writeLine(21, "  f) Dwarf       g) Half-Orc    h) Half-Troll");

        handleInput();
    }

    @Override
    public void handleInput() {

    }
}
