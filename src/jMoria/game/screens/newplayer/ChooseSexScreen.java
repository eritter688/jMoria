package jMoria.game.screens.newplayer;

import jMoria.game.ResourcePackage;
import jMoria.game.player.enums.Sex;
import jMoria.game.screens.AbstractScreen;
import jMoria.game.screens.newplayer.common.NewPlayerRenders;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class ChooseSexScreen extends AbstractScreen {

  private final EnumSet<Sex> sexes = EnumSet.allOf(Sex.class);
  private final Map<String, Sex> choiceMap = new HashMap<>();

  public ChooseSexScreen(ResourcePackage gameResources) {
    super(gameResources);
    choiceMap.put("m", Sex.MALE);
    choiceMap.put("f", Sex.FEMALE);
  }

  @Override
  public void init() {
    gameResources.terminal.clearScreen();
  }

  @Override
  public void render() {
    NewPlayerRenders.renderNameBlock(gameResources.terminal, gameResources.player);
    gameResources.terminal.writeLine(20, "   Choose a sex:");
    NewPlayerRenders.renderChoices(gameResources.terminal, sexes, new String[]{"m", "f"});
  }

  @Override
  public void handleKey(String key) {
    if (this.listening && choiceMap.containsKey(key)) {
      gameResources.player.sex = choiceMap.get(key);
      gameResources.game.setCurrentScreen(new ChooseStatsScreen(gameResources));
    }
  }
}
