package jMoria.game.utils;

import jMoria.game.Game;

import java.util.Random;

public class Math {

    public static final long RANDOM_SEED = 123456789L;
    public static final Random GENERATOR;

    static {
        if (Game.DEBUG) {
            GENERATOR = new Random(RANDOM_SEED);
        } else {
            GENERATOR = new Random();
        }
    }

    public static int rollDice(int rolls, int sides) {
        int sum = 0;
        for (int x = 0; x < rolls; x++) {
            sum += (GENERATOR.nextInt(sides) + 1);
        }
        return sum;
    }

    public static int randInt(int bound) {
        return GENERATOR.nextInt(bound) + 1;
    }

    public static int randNor(int mean, int stand) {

        int NORMAL_TABLE_SIZE = 256;
        int NORMAL_TABLE_SD = 64;

        int tmp, offset, low, iindex, high;

        tmp = randInt(32767);

        /* off scale, assign random value between 4 and 5 times SD */
        if (tmp == 32767) {
            offset = 4 * stand + randInt(stand);

            /* one half are negative */
            if (randInt(2) == 1)
                offset = -offset;

            return mean + offset;
        }

        /* binary search normal normal_table to get index that matches tmp */
        /* this takes up to 8 iterations */
        low = 0;
        iindex = NORMAL_TABLE_SIZE >> 1;
        high = NORMAL_TABLE_SIZE;
        while ((normal_table[iindex] != tmp) && (high != (low + 1))) {
            if (normal_table[iindex] > tmp) {
                high = iindex;
                iindex = low + ((iindex - low) >> 1);
            } else {
                low = iindex;
                iindex = iindex + ((high - iindex) >> 1);
            }
        }

        /* might end up one below target, check that here */
        if (normal_table[iindex] < tmp)
            iindex = iindex + 1;

  /* normal_table is based on SD of 64, so adjust the index value here,
     round the half way case up */
        offset = ((stand * iindex) + (NORMAL_TABLE_SD >> 1)) / NORMAL_TABLE_SD;

        /* one half should be negative */
        if (randInt(2) == 1)
            offset = -offset;

        return mean + offset;
    }

    /* this table is used to generate a psuedo-normal distribution.	 See the
   function randnor() in misc1.c, this is much faster than calling
   transcendental function to calculate a true normal distribution */
    public static int[] normal_table = new int[]{
            206, 613, 1022, 1430, 1838, 2245, 2652, 3058,
            3463, 3867, 4271, 4673, 5075, 5475, 5874, 6271,
            6667, 7061, 7454, 7845, 8234, 8621, 9006, 9389,
            9770, 10148, 10524, 10898, 11269, 11638, 12004, 12367,
            12727, 13085, 13440, 13792, 14140, 14486, 14828, 15168,
            15504, 15836, 16166, 16492, 16814, 17133, 17449, 17761,
            18069, 18374, 18675, 18972, 19266, 19556, 19842, 20124,
            20403, 20678, 20949, 21216, 21479, 21738, 21994, 22245,
            22493, 22737, 22977, 23213, 23446, 23674, 23899, 24120,
            24336, 24550, 24759, 24965, 25166, 25365, 25559, 25750,
            25937, 26120, 26300, 26476, 26649, 26818, 26983, 27146,
            27304, 27460, 27612, 27760, 27906, 28048, 28187, 28323,
            28455, 28585, 28711, 28835, 28955, 29073, 29188, 29299,
            29409, 29515, 29619, 29720, 29818, 29914, 30007, 30098,
            30186, 30272, 30356, 30437, 30516, 30593, 30668, 30740,
            30810, 30879, 30945, 31010, 31072, 31133, 31192, 31249,
            31304, 31358, 31410, 31460, 31509, 31556, 31601, 31646,
            31688, 31730, 31770, 31808, 31846, 31882, 31917, 31950,
            31983, 32014, 32044, 32074, 32102, 32129, 32155, 32180,
            32205, 32228, 32251, 32273, 32294, 32314, 32333, 32352,
            32370, 32387, 32404, 32420, 32435, 32450, 32464, 32477,
            32490, 32503, 32515, 32526, 32537, 32548, 32558, 32568,
            32577, 32586, 32595, 32603, 32611, 32618, 32625, 32632,
            32639, 32645, 32651, 32657, 32662, 32667, 32672, 32677,
            32682, 32686, 32690, 32694, 32698, 32702, 32705, 32708,
            32711, 32714, 32717, 32720, 32722, 32725, 32727, 32729,
            32731, 32733, 32735, 32737, 32739, 32740, 32742, 32743,
            32745, 32746, 32747, 32748, 32749, 32750, 32751, 32752,
            32753, 32754, 32755, 32756, 32757, 32757, 32758, 32758,
            32759, 32760, 32760, 32761, 32761, 32761, 32762, 32762,
            32763, 32763, 32763, 32764, 32764, 32764, 32764, 32765,
            32765, 32765, 32765, 32766, 32766, 32766, 32766, 32766,
    };

}
