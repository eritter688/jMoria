package jMoria.game.modules;

import jMoria.game.ResourcePackage;
import jMoria.game.living.Player;
import jMoria.game.screens.AbstractScreen;
import jMoria.game.screens.CharacterCreateChooseRace;
import java.util.ArrayList;
import java.util.List;

public class CharacterCreationModule extends AbstractModule {

    private List<AbstractScreen> creationScreens = new ArrayList<>();

    public CharacterCreationModule(ResourcePackage gameResources) {
        super(gameResources);
    }

    @Override
    public void init() {
        this.gameResources.player = new Player();
    }

    @Override
    public void run() {
        currentScreen = new CharacterCreateChooseRace(terminal, player);
        currentScreen.init();
        currentScreen.run();
    }

    @Override
    public void handleKey(String key) {
        if (this.currentScreen != null) {
            currentScreen.handleKey(key);
        }
    }
}
