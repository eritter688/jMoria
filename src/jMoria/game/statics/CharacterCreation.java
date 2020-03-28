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
    t.writeStringAt(10, 3, "+ To Hit   :" + " ".repeat(5));
    t.writeStringAt(11, 3, "+ To Damage:" + " ".repeat(5));
    t.writeStringAt(12, 3, "+ To AC    :" + " ".repeat(5));
    t.writeStringAt(13, 3, "  Total AC :" + " ".repeat(5));

    // TODO Right Justified Needed Here!
    t.writeStringAt(10, 21, "0");
    t.writeStringAt(11, 21, "0");
    t.writeStringAt(12, 21, "0");
    t.writeStringAt(13, 21, "0");
  }

  public static void renderPhyicalStats(Terminal t, Player p) {
    t.writeStringAt(3, 39, "Age          :" + " ".repeat(8));
    t.writeStringAt(4, 39, "Weight       :" + " ".repeat(8));
    t.writeStringAt(5, 39, "Height       :" + " ".repeat(8));
    t.writeStringAt(6, 39, "Social Class :" + " ".repeat(8));

    // TODO Right Justified Needed Here!
    t.writeStringAt(3, 59, "0");
    t.writeStringAt(4, 59, "0");
    t.writeStringAt(5, 59, "0");
    t.writeStringAt(6, 59, "0");
  }

  public static void renderPlayerStats(Terminal t, Player p) {
    t.writeStringAt(3, 64, "STR :" + " ".repeat(8));
    t.writeStringAt(4, 64, "INT :" + " ".repeat(8));
    t.writeStringAt(5, 64, "WIS :" + " ".repeat(8));
    t.writeStringAt(6, 64, "DEX :" + " ".repeat(8));
    t.writeStringAt(7, 64, "CON :" + " ".repeat(8));
    t.writeStringAt(8, 64, "CHR :" + " ".repeat(8));

    // TODO Right Justified Needed Here!
    t.writeStringAt(3, 74, "0");
    t.writeStringAt(4, 74, "0");
    t.writeStringAt(5, 74, "0");
    t.writeStringAt(6, 74, "0");
    t.writeStringAt(7, 74, "0");
    t.writeStringAt(8, 74, "0");
  }

}
