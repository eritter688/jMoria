package jMoria.game.player.enums;

public enum Sex {
  MALE("Male"),
  FEMALE("Female");

  private final String sex;

  Sex(String sex) {
    this.sex = sex;
  }

  public String getSex() {
    return this.sex;
  }
}
