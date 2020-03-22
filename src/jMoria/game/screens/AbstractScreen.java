package jMoria.game.screens;

import jMoria.ui.Terminal;

public abstract class AbstractScreen {

    public Terminal terminal;

    public abstract void initialize();

    public abstract void render();

    public abstract void handleInput();

}
