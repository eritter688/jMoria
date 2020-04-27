package jMoria.game.screens;

import jMoria.game.ResourcePackage;
import jMoria.game.keyhandlers.AbstractKeyHandler;
import jMoria.game.keyhandlers.GameKeyHandler;
import jMoria.ui.Terminal;

public class GameScreen extends AbstractScreen {

    private AbstractKeyHandler gameKeyHandler;

    public GameScreen(ResourcePackage gameResources) {
        super(gameResources);
    }

    @Override
    public void init() {
        this.gameKeyHandler = new GameKeyHandler();
    }

    @Override
    public void render() {
        Terminal t = gameResources.terminal;
        t.clearScreen();
        renderStats(t);
        renderBorder(t);

    }

    @Override
    public void handleKey(String key) {
        if (this.listening) {
            gameKeyHandler.handleKey(key);
        }
    }

    private void renderStats(Terminal t) {
        t.writeStringAt(2, 0, "Human");
        t.writeStringAt(3, 0, "Warrior");
        t.writeStringAt(4, 0, "Rookie");

        t.writeStringAt(6, 0, "STR :     17");
        t.writeStringAt(7, 0, "INT :     13");
        t.writeStringAt(8, 0, "WIS :     10");
        t.writeStringAt(9, 0, "DEX :     10");
        t.writeStringAt(10, 0, "CON :     10");
        t.writeStringAt(11, 0, "CHR :     10");

        t.writeStringAt(13, 0, "LEV :");
        t.writeStringAt(14, 0, "EXP :");
        t.writeStringAt(15, 0, "MANA:");
        t.writeStringAt(16, 0, "MHP :");
        t.writeStringAt(17, 0, "CHP :");

        t.writeStringAt(19, 0, "AC  :");
        t.writeStringAt(20, 0, "GOLD:    487");
    }

    private void renderBorder(Terminal t) {
        char BLOCK = '\u2588';

        // TOP
        //t.writeRJStringAt(1, 78, String.valueOf(BLOCK).repeat(66));
        t.writeStringAt(1, 13, String.valueOf(BLOCK).repeat(66));
        // BOTTOM
        //t.writeRJStringAt(22, 78, String.valueOf(BLOCK).repeat(66));
        t.writeStringAt(22, 13, String.valueOf(BLOCK).repeat(66));
        // LEFT/RIGHT
        for (int x = 1; x < 23; x++) {
            t.writeStringAt(x, 13, String.valueOf(BLOCK));
            t.writeStringAt(x, 78, String.valueOf(BLOCK));
        }

    }

    private void renderMap(Terminal t) {

    }

    private void renderDepthAndStudy(Terminal t) {

    }
}
