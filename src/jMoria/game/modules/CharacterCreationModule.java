package jMoria.game.modules;

import jMoria.game.ResourcePackage;
import jMoria.game.living.Player;
import jMoria.game.screens.AbstractScreen;
import jMoria.game.screens.ChooseClass;
import jMoria.game.screens.ChooseRace;
import jMoria.game.screens.ChooseSex;
import jMoria.game.screens.ChooseStats;
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
        creationScreens.add(new ChooseRace(gameResources));
        creationScreens.add(new ChooseSex(gameResources));
        creationScreens.add(new ChooseStats(gameResources));
        creationScreens.add(new ChooseClass(gameResources));
    }

    @Override
    public void run() {
        currentScreen = new ChooseRace(gameResources);
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
