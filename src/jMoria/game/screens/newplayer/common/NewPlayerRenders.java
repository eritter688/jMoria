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
  public static void renderChoices(Terminal terminal, EnumSet<?> enumSet, String[] choiceKeys) {

    // Needed because picking sex is m/f instead of a/b. :)
    if (choiceKeys == null) {
      choiceKeys = NewPlayerRenders.choiceKeys;
    }

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

  public static void renderNameBlock(Terminal t, Player p) {
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

  public static void renderAgeBlock(Terminal t, Player p) {
    t.writeStringAt(3, 39, "Age          :");
    t.writeStringAt(4, 39, "Height       :");
    t.writeStringAt(5, 39, "Weight       :");
    t.writeStringAt(6, 39, "Social Class :");

    t.writeRJStringAt(3, 58, String.valueOf(p.age));
    t.writeRJStringAt(4, 58, String.valueOf(p.height));
    t.writeRJStringAt(5, 58, String.valueOf(p.weight));
    t.writeRJStringAt(6, 58, String.valueOf(p.socialClass));
  }

  public static void renderStatBlock(Terminal t, Player p) {
    t.writeStringAt(3, 63, "STR :");
    t.writeStringAt(4, 63, "INT :");
    t.writeStringAt(5, 63, "WIS :");
    t.writeStringAt(6, 63, "DEX :");
    t.writeStringAt(7, 63, "CON :");
    t.writeStringAt(8, 63, "CHR :");

    // TODO Over 18 stats.
    t.writeRJStringAt(3, 75, String.valueOf(p.strength));
    t.writeRJStringAt(4, 75, String.valueOf(p.intelligence));
    t.writeRJStringAt(5, 75, String.valueOf(p.wisdom));
    t.writeRJStringAt(6, 75, String.valueOf(p.dexterity));
    t.writeRJStringAt(7, 75, String.valueOf(p.constitution));
    t.writeRJStringAt(8, 75, String.valueOf(p.charisma));
  }

  public static void renderBonusBlock(Terminal t, Player p) {
    t.writeStringAt(10, 3, "+ To Hit   :");
    t.writeStringAt(11, 3, "+ To Damage:");
    t.writeStringAt(12, 3, "+ To AC    :");
    t.writeStringAt(13, 3, "  Total AC :");

    t.writeRJStringAt(10, 21, String.valueOf(p.bonusToHit));
    t.writeRJStringAt(11, 21, String.valueOf(p.bonusToDamage));
    t.writeRJStringAt(12, 21, String.valueOf(p.bonusToArmorClass));
    t.writeRJStringAt(13, 21, String.valueOf(p.totalArmorClass));
  }

  public static void renderLevelBlock(Terminal t, Player p) {
    t.writeStringAt(10, 29, "Level      :");
    t.writeStringAt(11, 29, "Experience :");
    t.writeStringAt(12, 29, "Max Exp    :");
    t.writeStringAt(13, 29, "Exp to Adv.:"); // TODO
    t.writeStringAt(13, 29, "Gold       :");

    t.writeRJStringAt(10, 48, String.valueOf(p.level));
    t.writeRJStringAt(11, 48, String.valueOf(p.experience));
    t.writeRJStringAt(12, 48, String.valueOf(p.maxExperience));
    t.writeRJStringAt(13, 48, "XX"); // TODO
    t.writeRJStringAt(13, 48, String.valueOf(p.gold));
  }

  public static void renderHPBlock(Terminal t, Player p) {
    t.writeStringAt(10, 52, "Max Hit Points :");
    t.writeStringAt(11, 52, "Cur Hit Points :");
    t.writeStringAt(12, 52, "Max Mana       :");
    t.writeStringAt(13, 52, "Cur Mana       :");

    t.writeRJStringAt(10, 75, String.valueOf(p.maxHitPoints));
    t.writeRJStringAt(11, 75, String.valueOf(p.currentHitPoints));
    t.writeRJStringAt(12, 75, String.valueOf(p.maxMana));
    t.writeRJStringAt(13, 75, String.valueOf(p.currentMana));
  }

  public static void renderCharacterBackgroundBlock(Terminal t, Player p) {
    t.writeStringAt(14, 27, "Character Background");

    // TODO
    t.writeStringAt(15, 4, "You are one of several children of a Yeoman. You are a well-liked");
    t.writeStringAt(16, 4, "child.  You have dark brown eyes, straight brown hair, and an average");
    t.writeStringAt(17, 4, "complexion.");
  }

  public static void renderMiscAbilitiesBlock(Terminal t, Player p) {
    t.writeStringAt(15, 26, "(Miscellaneous Abilities)");

    t.writeStringAt(16, 3, "Fighting    :");
    t.writeStringAt(17, 3, "Bows/Throw  :");
    t.writeStringAt(18, 3, "Saving Throw:");
    t.writeStringAt(16, 17, "");
    t.writeStringAt(17, 17, "");
    t.writeStringAt(18, 17, "");

    t.writeStringAt(16, 29, "Stealth     :");
    t.writeStringAt(17, 29, "Disarming   :");
    t.writeStringAt(18, 29, "Magic Device:");
    t.writeStringAt(16, 43, "");
    t.writeStringAt(17, 43, "");
    t.writeStringAt(18, 43, "");

    t.writeStringAt(16, 55, "Perception  :");
    t.writeStringAt(17, 55, "Searching   :");
    t.writeStringAt(18, 55, "Infra-Vision:");
    t.writeStringAt(16, 69, "");
    t.writeStringAt(17, 69, "");
    t.writeStringAt(18, 69, "");
  }
}
