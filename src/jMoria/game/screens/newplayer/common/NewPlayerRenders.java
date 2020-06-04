package jMoria.game.screens.newplayer.common;

import jMoria.game.player.Player;
import jMoria.ui.Terminal;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public class NewPlayerRenders {

  public static String[] choiceKeys = {
      "a", "b", "c", "d", "e",
      "f", "g", "h", "i", "j",
      "k", "l", "m", "n", "o"
  };

  /**
   * Dynamically render choices at the bottom of the screen based on the given enumset. Caution,
   * don't send more than 15 choices or the UI will break! Caution, choices should be a max length
   * of 11 characters or the UI will break!
   *
   * @param terminal The terminal to output to.
   * @param enumSet  An EnumSet of Enum choices which override toString to present it's elements.
   *                 See player.enums.Race for example.
   */
  public static void renderChoices(Terminal terminal, EnumSet<?> enumSet) {

    int choiceMaxWidth = 15;
    List<String> lines = new ArrayList<>();
    StringBuilder line = new StringBuilder("  ");
    Iterator<?> enumSetIterator = enumSet.iterator();

    for (int index = 0; index < enumSet.size(); index++) {

      // Assemble the choice string and add it to the line.
      StringBuilder choice = new StringBuilder();
      choice.append(choiceKeys[index]);
      choice.append(") ");
      choice.append(enumSetIterator.next().toString());
      if (choice.length() < choiceMaxWidth) {
        choice.append(" ".repeat(choiceMaxWidth - choice.length()));
      }
      line.append(choice.toString());

      // Are we at the end of a line or out of elements?
      if (index != 0) {
        if (((index + 1) % 5 == 0) ||
            (!enumSetIterator.hasNext())) {
          lines.add(line.toString());
          if (enumSetIterator.hasNext()) {
            line = new StringBuilder("  ");
          }
        }
      }
    }

    // Render
    int currentLine = 20;
    for (String output : lines) {
      terminal.writeLine(currentLine, output);
      currentLine++;
    }

  }

  public static void renderAll(Terminal t, Player p) {
    renderPersonalStats(t, p);
    renderHitACStats(t, p);
    renderPhyicalStats(t, p);
    renderPlayerStats(t, p);
    renderCharacterBackground(t, p);
  }

  public static void renderPersonalStats(Terminal t, Player p) {
    t.writeStringAt(3, 0, "  Name      :");
    t.writeStringAt(4, 0, "  Race      :");
    t.writeStringAt(5, 0, "  Sex       :");
    t.writeStringAt(6, 0, "  Class     :");

    if (p.name != null) {
      t.writeStringAt(3, 14, p.name);
    }

    if (p.race != null) {
      t.writeStringAt(4, 14, p.race.toString());
    }

    if (p.sex != null) {
      t.writeStringAt(5, 14, p.sex.toString());
    }

    if (p.playerClass != null) {
      t.writeStringAt(6, 14, p.playerClass.toString());
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
    t.writeRJStringAt(3, 58, String.valueOf(p.age));
    t.writeRJStringAt(4, 58, String.valueOf(p.height));
    t.writeRJStringAt(5, 58, String.valueOf(p.weight));
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
