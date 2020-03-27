package jMoria.game.screens;

import jMoria.game.ResourcePackage;
import jMoria.game.enums.Sex;
import jMoria.ui.Terminal;

public class ChooseSex extends AbstractScreen {

  public ChooseSex(ResourcePackage gameResources) {
    super(gameResources);
  }

  @Override
  public void init() {
    gameResources.terminal.clearScreen();
  }

  @Override
  public void render() {
    Terminal t = gameResources.terminal;
    t.writeLine(3, "  Name     :");
    t.writeLine(4, "  Race     : " + gameResources.player.race.getRace());
    t.writeLine(5, "  Sex      :");
    t.writeLine(6, "  Class    :");

    t.writeLine(19, "  Choose a sex:");
    t.writeLine(20, "  m) Male        f) Female");
  }

  @Override
  public void handleKey(String key) {
    if (this.listening == Boolean.TRUE) {
     switch (key) {
       case "m":
         gameResources.player.sex = Sex.MALE;
         break;
       case "f":
         gameResources.player.sex = Sex.FEMALE;
         break;
     }
      gameResources.game.setCurrentScreen(new ChooseStats(gameResources));
    }
  }

}
