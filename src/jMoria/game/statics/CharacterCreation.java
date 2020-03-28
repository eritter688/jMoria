package jMoria.game.statics;

import jMoria.game.living.Player;
import jMoria.ui.Terminal;

public class CharacterCreation {

  public static void renderPersonalStats(Terminal t, Player p) {
    t.writeStringAt(3, 0, "  Name     :" + " ".repeat(10));
    t.writeStringAt(4, 0, "  Race     :" + " ".repeat(10));
    t.writeStringAt(5, 0, "  Sex      :" + " ".repeat(10));
    t.writeStringAt(6, 0, "  Class    :" + " ".repeat(10));

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

  public static void renderHitACStats(Terminal t, Player p) {
    t.writeStringAt(10, 0, "   + To Hit   :" + " ".repeat(5));
    t.writeStringAt(11, 0, "   + To Damage:" + " ".repeat(5));
    t.writeStringAt(12, 0, "   + To AC    :" + " ".repeat(5));
    t.writeStringAt(13, 0, "     Total AC :" + " ".repeat(5));

    // TODO
    t.writeStringAt(10, 21, "0");
    t.writeStringAt(11, 21, "0");
    t.writeStringAt(12, 21, "0");
    t.writeStringAt(13, 21, "0");
  }

  public static void renderPhyicalStats(Terminal t, Player p) {

  }

  public static void renderPlayerStats(Terminal t, Player p) {

  }

}
