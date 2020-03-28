package jMoria.game.statics;

import jMoria.game.living.Player;
import jMoria.ui.Terminal;

public class CharacterCreation {

  public static void renderPersonalStats(Terminal t, Player p) {
    t.writeLine(3, "  Name     :");
    t.writeLine(4, "  Race     :");
    t.writeLine(5, "  Sex      :");
    t.writeLine(6, "  Class    :");

    if (p.name != null) {
      t.writeStringAt(3, 13, p.name);
    }

    if (p.race != null) {
      t.writeStringAt(4, 13, p.race.getRace());
    }

    if (p.sex != null) {
      t.writeStringAt(5, 13, p.sex.getSex());
    }

    if (p.playerClass != null) {
      t.writeStringAt(6, 13, p.playerClass.getPlayerClass());
    }

  }

}
