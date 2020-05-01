package jMoria.game.monster.attack;

public enum AttackDescriptionType {

  HIT("hits you."),
  BITE("bites you."),
  CLAW("claws you."),
  STING("stings you."),
  TOUCH("touches you."),
  KICK("kicks you."),
  GAZE("gazes at you."),
  BREATHE("breathes on you."),
  SPIT("spits on you."),
  WAIL("makes a horrible wail."),
  EMBRACE("embraces you."),
  CRAWL("crawls on you."),
  SPORE("releases a cloud of spores."),
  BEG("begs you for money."),
  SLIME("You've been slimed!"),
  CRUSH("crushes you."),
  TRAMPLE("tramples you."),
  DROOL("drools on you."),
  INSULT_YOU("insults you!"),
  INSULT_MOTHER("insults your mother!"),
  FINGER("gives you the finter!"),
  HUMILIATE("humiliates you!"),
  WET("wets on your leg!"),
  DEFILE("defiles you!"),
  DANCE("dances around you!"),
  GESTURE("makes obscene gestures!"),
  MOON("moons you!!!"),
  REPEL("is repelled.");

  private final String text;

  AttackDescriptionType(String text) {
    this.text = text;
  }

  public String getText() {
    return this.text;
  }
}
