package jMoria.game.screens;

import jMoria.game.ResourcePackage;

public abstract class AbstractScreen {

  public boolean listening = false;
  public ResourcePackage gameResources;

  public AbstractScreen(ResourcePackage gameResources) {
    this.gameResources = gameResources;
  }

  public abstract void init();

  public abstract void render();

  public void startListening() {
    this.listening = true;
  }

  public void stopListening() {
    this.listening = false;
  }

  public abstract void handleKey(String key);
}
