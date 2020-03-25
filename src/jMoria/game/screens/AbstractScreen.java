package jMoria.game.screens;

import jMoria.game.ResourcePackage;

public abstract class AbstractScreen {

    public Boolean listening = Boolean.FALSE;
    public ResourcePackage gameResources;

    public AbstractScreen(ResourcePackage gameResources) {
        this.gameResources = gameResources;
    }

    public abstract void init();

    public abstract void render();

    public void startListening() {
        this.listening = Boolean.TRUE;
    }

    public void stopListening() {
        this.listening = Boolean.FALSE;
    }

    public abstract void handleKey(String key);

}
