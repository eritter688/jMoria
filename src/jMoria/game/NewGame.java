package jMoria.game;

import jMoria.ui.Terminal;

public class NewGame {

    private Terminal terminal;

    public NewGame(Terminal terminal)
    {
        this.terminal = terminal;
    }

    public void run() {
        terminal.clearScreen();
        printScreenOne();
    }

    private void printScreenOne()
    {
        terminal.writeLine(3, "  Name     :");
        terminal.writeLine(4, "  Race     :");
        terminal.writeLine(5, "  Sex      :");
        terminal.writeLine(6, "  Class    :");

        terminal.writeLine(19, "  Choose a race:");
        terminal.writeLine(20, "  a) Human       b) Half-Elf    c) Elf         d) Halfling    e) Gnome");
        terminal.writeLine(21, "  f) Dwarf       g) Half-Orc    h) Half-Troll");
    }

}
