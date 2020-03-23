package jMoria.game.modules;

import jMoria.game.living.Player;
import jMoria.game.screens.CharacterCreateChooseRace;
import jMoria.ui.Terminal;

public class CharacterCreationModule extends AbstractModule {

    public Player player;

    public CharacterCreationModule(Terminal terminal)
    {
        this.terminal = terminal;
    }

    @Override
    public void init() {
        player = new Player();
    }

    @Override
    public void run() {

        currentScreen = new CharacterCreateChooseRace(terminal, player);
        currentScreen.init();
        currentScreen.run();

    }

    @Override
    public void handleKey(String key) {

        currentScreen.handleKey();

    }
}
