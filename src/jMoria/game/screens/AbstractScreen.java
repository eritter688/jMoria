package jMoria.game.screens;

import java.util.HashSet;

public abstract class AbstractScreen {

    public HashSet<String> acceptedKeys;

    public abstract void render();

    public abstract void handleInput();




}
