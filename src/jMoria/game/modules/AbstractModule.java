package jMoria.game.modules;

import jMoria.game.screens.AbstractScreen;
import jMoria.ui.Terminal;

public abstract class AbstractModule {

    public Terminal terminal;
    public AbstractScreen currentScreen;

    public void setCurrentScreen(AbstractScreen currentScreen) {
        this.currentScreen = currentScreen;
    }

    public abstract void init();

    public abstract void run();

    public abstract void handleKey(String key);
}
