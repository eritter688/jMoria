package jMoria.game;

import java.util.Random;

public class Dice {

    private Random generator;

    public Dice() {
        // TODO
        // Remove this before actually finalizing the game.
        if (Game.DEBUG) {
            generator = new Random(Game.RANDOM_SEED);
        } else {
            generator = new Random();
        }
    }

    // TODO Maybe find a new home for these?
    // Also maybe store the generator somewhere else?

    public int rollDice(int rolls, int sides) {
        int sum = 0;
        for (int x = 0; x < rolls; x++) {
            sum += (generator.nextInt(sides) + 1);
        }
        return sum;
    }

    public int randInt(int bound) {
        return generator.nextInt(bound) + 1;
    }

    public int randNor(int mean, int stand) {

        int tmp, offset, low, iindex, high;

        return 1;

    }
}
