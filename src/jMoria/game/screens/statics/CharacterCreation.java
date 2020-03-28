package jMoria.game.screens.statics;

import jMoria.game.living.Player;
import jMoria.ui.Terminal;

public class CharacterCreation {

  public static void renderPersonalStats(Terminal t, Player p) {
    t.writeStringAt(3, 0, "  Name      :");
    t.writeStringAt(4, 0, "  Race      :");
    t.writeStringAt(5, 0, "  Sex       :");
    t.writeStringAt(6, 0, "  Class     :");

    if (p.name != null) {
      t.writeStringAt(3, 14, p.name);
    }

    if (p.race != null) {
      t.writeStringAt(4, 14, p.race.getRace());
    }

    if (p.sex != null) {
      t.writeStringAt(5, 14, p.sex.getSex());
    }

    if (p.playerClass != null) {
      t.writeStringAt(6, 14, p.playerClass.getPlayerClass());
    }
  }

  public static void renderHitACStats(Terminal t, Player p) {
    t.writeStringAt(10, 3, "+ To Hit   :");
    t.writeStringAt(11, 3, "+ To Damage:");
    t.writeStringAt(12, 3, "+ To AC    :");
    t.writeStringAt(13, 3, "  Total AC :");

    // TODO
    t.writeRJStringAt(10, 21, "0");
    t.writeRJStringAt(11, 21, "00");
    t.writeRJStringAt(12, 21, "000");
    t.writeRJStringAt(13, 21, "0000");
  }

  public static void renderPhyicalStats(Terminal t, Player p) {
    t.writeStringAt(3, 39, "Age          :");
    t.writeStringAt(4, 39, "Height       :");
    t.writeStringAt(5, 39, "Weight       :");
    t.writeStringAt(6, 39, "Social Class :");

    // TODO
    t.writeRJStringAt(3, 58, "0");
    t.writeRJStringAt(4, 58, "00");
    t.writeRJStringAt(5, 58, "000");
    t.writeRJStringAt(6, 58, "0000");
  }

  public static void renderPlayerStats(Terminal t, Player p) {
    t.writeStringAt(3, 63, "STR :");
    t.writeStringAt(4, 63, "INT :");
    t.writeStringAt(5, 63, "WIS :");
    t.writeStringAt(6, 63, "DEX :");
    t.writeStringAt(7, 63, "CON :");
    t.writeStringAt(8, 63, "CHR :");

    // TODO
    t.writeRJStringAt(3, 75, "0");
    t.writeRJStringAt(4, 75, "00");
    t.writeRJStringAt(5, 75, "000");
    t.writeRJStringAt(6, 75, "0");
    t.writeRJStringAt(7, 75, "00");
    t.writeRJStringAt(8, 75, "000");
  }

  public static void renderCharacterBackground(Terminal t, Player p) {
    t.writeStringAt(14, 27, "Character Background");

    // TODO
    t.writeStringAt(15, 4, "You are one of several children of a Yeoman. You are a well-liked");
    t.writeStringAt(16, 4, "child.  You have dark brown eyes, straight brown hair, and an average");
    t.writeStringAt(17, 4, "complexion.");
  }
}
