package jMoria.game.random;

import java.util.Random;

/* A simple wrapper of the java.util.Random class.
 * Includes only integer functionality and the ability to change the seed.
 * 
 * Load these and keep them in classes that need random numbers often.
 * Don't load them and dump them in tightly scoped areas.
 */
public class Rand
{
	
	private long seed;
	private Random random;
	
	public Rand (long seed)
	{
		this.seed = seed;
		this.random = new Random(seed);
	}

	public long getSeed()
	{
		return this.seed;
	}
	
	public void setSeed(long seed)
	{
		this.seed = seed;
		random.setSeed(seed);
	}
	
	// All 2^32 values of int are possible.
	public int nextInt()
	{
		return random.nextInt();
	}
	
	// Int value between 1 and the specified value (inclusive).
	// 100 = 1 -> 100
	public int nextInt(int bound)
	{
		return random.nextInt(bound) + 1;
	}

}