package jMoria.game.screens.playercreation;

import static java.util.EnumSet.allOf;
import static java.util.Map.entry;

import jMoria.game.ResourcePackage;
import jMoria.game.player.Player;
import jMoria.game.player.enums.Race;
import jMoria.game.player.enums.Sex;
import jMoria.game.screens.AbstractScreen;
import jMoria.game.screens.playercreation.statics.PlayerCreationRenders;
import jMoria.ui.Terminal;
import java.util.EnumSet;
import java.util.Map;

public class ChooseRaceScreen extends AbstractScreen {

  private final Map<String, Race> choices =
      Map.ofEntries(
          entry("a", Race.HUMAN),
          entry("b", Race.HALF_ELF),
          entry("c", Race.ELF),
          entry("d", Race.HALFLING),
          entry("e", Race.GNOME),
          entry("f", Race.DWARF),
          entry("g", Race.HALF_ORC),
          entry("h", Race.HALF_TROLL));

  private final String[] keys = new String[]{"a", "b", "c"};
  private final EnumSet<Race> races = allOf(Race.class);
  private final EnumSet<Sex> sexes = allOf(Sex.class);

  public ChooseRaceScreen(ResourcePackage gameResources) {
    super(gameResources);
  }

  @Override
  public void init() {
    gameResources.terminal.clearScreen();
//    System.out.println(Arrays.toString(keys));
//    System.out.println(races);
//
//    for (Enum<Race> e : races) {
//      System.out.println(e);
//    }
    PlayerCreationRenders.renderChoices(gameResources.terminal, races);
    PlayerCreationRenders.renderChoices(gameResources.terminal, sexes);

  }

  @Override
  public void render() {
    Terminal t = gameResources.terminal;
    Player p = gameResources.player;

    PlayerCreationRenders.renderPersonalStats(t, p);

    t.writeLine(19, "  Choose a race:");
    t.writeLine(20, "  a) Human       b) Half-Elf    c) Elf         d) Halfling    e) Gnome");
    t.writeLine(21, "  f) Dwarf       g) Half-Orc    h) Half-Troll");
  }

  @Override
  public void handleKey(String key) {
    if (this.listening && choices.containsKey(key)) {
      gameResources.player.race = choices.get(key);
      gameResources.game.setCurrentScreen(new ChooseSexScreen(gameResources));
    }
  }
}
