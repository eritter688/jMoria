package jMoria.game.screens.newplayer;

import jMoria.game.ResourcePackage;
import jMoria.game.player.enums.Class;
import jMoria.game.screens.AbstractScreen;
import jMoria.game.screens.newplayer.common.NewPlayerRenders;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChooseClassScreen extends AbstractScreen {

  private final EnumSet<Class> classes = EnumSet.allOf(Class.class);
  private final Map<String, Class> choiceMap = new HashMap<>();

  public ChooseClassScreen(ResourcePackage gameResources) {
    super(gameResources);

    // call to get appropriate classes

    Iterator<Class> classIterator = classes.iterator();
    for (int index = 0; index < classes.size(); index++) {
      choiceMap.put(NewPlayerRenders.choiceKeys[index], classIterator.next());
    }
  }

  @Override
  public void init() {
    gameResources.terminal.clearScreen();
  }

  @Override
  public void render() {
    NewPlayerRenders.renderNameBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderAgeBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderStatBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderBonusBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderCharacterBackgroundBlock(gameResources.terminal, gameResources.player);
    gameResources.terminal.writeLine(20, "   Choose a class:");
    NewPlayerRenders.renderChoices(gameResources.terminal, classes, null);
  }

  @Override
  public void handleKey(String key) {
    if (this.listening && choiceMap.containsKey(key)) {
      gameResources.player.playerClass = choiceMap.get(key);
      gameResources.game.setCurrentScreen(new ChooseNameScreen(gameResources));
    }
  }
}
