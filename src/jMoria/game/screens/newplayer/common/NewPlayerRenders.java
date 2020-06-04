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
    StringBuilder line = new StringBuilder("   ");
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
            line = new StringBuilder("   ");
          }
        }
      }
    }

    // Render
    int currentLine = 21;
    for (String output : lines) {
      terminal.writeLine(currentLine, output);
      currentLine++;
    }

  }

  public static void renderNameBlock(Terminal t, Player p) {
    t.writeStringAt(2, 0, "  Name        :");
    t.writeStringAt(3, 0, "  Race        :");
    t.writeStringAt(4, 0, "  Sex         :");
    t.writeStringAt(5, 0, "  Class       :");

    if (p.name != null) {
      t.writeStringAt(2, 16, p.name);
    }

    if (p.race != null) {
      t.writeStringAt(3, 16, p.race.toString());
    }

    if (p.sex != null) {
      t.writeStringAt(4, 16, p.sex.toString());
    }

    if (p.playerClass != null) {
      t.writeStringAt(5, 16, p.playerClass.toString());
    }
  }

  public static void renderAgeBlock(Terminal t, Player p) {
    t.writeStringAt(2, 39, "Age          :");
    t.writeStringAt(3, 39, "Height       :");
    t.writeStringAt(4, 39, "Weight       :");
    t.writeStringAt(5, 39, "Social Class :");

    t.writeRJStringAt(2, 58, String.valueOf(p.age));
    t.writeRJStringAt(3, 58, String.valueOf(p.height));
    t.writeRJStringAt(4, 58, String.valueOf(p.weight));
    t.writeRJStringAt(5, 58, String.valueOf(p.socialClass));
  }

  public static void renderStatBlock(Terminal t, Player p) {
    t.writeStringAt(2, 61, "STR :");
    t.writeStringAt(3, 61, "INT :");
    t.writeStringAt(4, 61, "WIS :");
    t.writeStringAt(5, 61, "DEX :");
    t.writeStringAt(6, 61, "CON :");
    t.writeStringAt(7, 61, "CHR :");

    // TODO Over 18 stats.
    t.writeRJStringAt(2, 73, String.valueOf(p.strength));
    t.writeRJStringAt(3, 73, String.valueOf(p.intelligence));
    t.writeRJStringAt(4, 73, String.valueOf(p.wisdom));
    t.writeRJStringAt(5, 73, String.valueOf(p.dexterity));
    t.writeRJStringAt(6, 73, String.valueOf(p.constitution));
    t.writeRJStringAt(7, 73, String.valueOf(p.charisma));
  }

  public static void renderBonusBlock(Terminal t, Player p) {
    t.writeStringAt(9, 2, "+ To Hit    :");
    t.writeStringAt(10, 2, "+ To Damage :");
    t.writeStringAt(11, 2, "+ To AC     :");
    t.writeStringAt(12, 2, "  Total AC  :");

    t.writeRJStringAt(9, 21, String.valueOf(p.bonusToHit));
    t.writeRJStringAt(10, 21, String.valueOf(p.bonusToDamage));
    t.writeRJStringAt(11, 21, String.valueOf(p.bonusToArmorClass));
    t.writeRJStringAt(12, 21, String.valueOf(p.totalArmorClass));
  }

  public static void renderLevelBlock(Terminal t, Player p) {
    t.writeStringAt(9, 29, "Level      :");
    t.writeStringAt(10, 29, "Experience :");
    t.writeStringAt(11, 29, "Max Exp    :");
    t.writeStringAt(12, 29, "Exp to Adv.:"); // TODO
    t.writeStringAt(13, 29, "Gold       :");

    t.writeRJStringAt(9, 48, String.valueOf(p.level));
    t.writeRJStringAt(10, 48, String.valueOf(p.experience));
    t.writeRJStringAt(11, 48, String.valueOf(p.maxExperience));
    t.writeRJStringAt(12, 48, "XX"); // TODO
    t.writeRJStringAt(13, 48, String.valueOf(p.gold));
  }

  public static void renderHPBlock(Terminal t, Player p) {
    t.writeStringAt(9, 52, "Max Hit Points :");
    t.writeStringAt(10, 52, "Cur Hit Points :");
    t.writeStringAt(11, 52, "Max Mana       :");
    t.writeStringAt(12, 52, "Cur Mana       :");

    t.writeRJStringAt(9, 75, String.valueOf(p.maxHitPoints));
    t.writeRJStringAt(10, 75, String.valueOf(p.currentHitPoints));
    t.writeRJStringAt(11, 75, String.valueOf(p.maxMana));
    t.writeRJStringAt(12, 75, String.valueOf(p.currentMana));
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

    t.writeStringAt(16, 2, "Fighting    :");
    t.writeStringAt(17, 2, "Bows/Throw  :");
    t.writeStringAt(18, 2, "Saving Throw:");
    t.writeStringAt(16, 16, "Very Good");
    t.writeStringAt(17, 16, "Fair");
    t.writeStringAt(18, 16, "Fair");

    t.writeStringAt(16, 29, "Stealth     :");
    t.writeStringAt(17, 29, "Disarming   :");
    t.writeStringAt(18, 29, "Magic Device:");
    t.writeStringAt(16, 43, "Poor");
    t.writeStringAt(17, 43, "Fair");
    t.writeStringAt(18, 43, "Fair");

    t.writeStringAt(16, 55, "Perception  :");
    t.writeStringAt(17, 55, "Searching   :");
    t.writeStringAt(18, 55, "Infra-Vision:");
    t.writeStringAt(16, 69, "Bad");
    t.writeStringAt(17, 69, "Poor");
    t.writeStringAt(18, 69, "0 feet");
  }
}
