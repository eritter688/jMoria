package jMoria.game.screens;

import jMoria.ui.Terminal;

public abstract class AbstractScreen {

    public Terminal terminal;
    public Boolean listening = Boolean.FALSE;

    public abstract void init();

    public abstract void run();

    public abstract void render();

    public abstract void handleKey(String key);

}
