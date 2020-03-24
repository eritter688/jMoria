package jMoria.game.modules;

import jMoria.game.ResourcePackage;
import jMoria.game.screens.AbstractScreen;

public abstract class AbstractModule {

    public AbstractScreen currentScreen;
    public ResourcePackage gameResources;

    public AbstractModule(ResourcePackage gameResources) {
        this.gameResources = gameResources;
    }

    public abstract void init();

    public abstract void run();

    public abstract void handleKey(String key);
}
