package jMoria.game.dungeon;

import jMoria.game.enums.Tiles;

public class Map
{
	private int cols;
	private int rows;
	
	private Tiles[][] map;
	
	public Map(int rows, int cols)
	{
		map = new Tiles[rows][cols];
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				map[i][j] = Tiles.NULLWALL;
			}
		}
	}
	
	public int getCols()
	{
		return this.cols;
	}
	
	public int getRows()
	{
		return this.rows;
	}
	
	public Tiles getTile(int row, int col)
	{
		return map[row][col];
	}
	
	public void setTile(int row, int col, Tiles tile)
	{
		map[row][col] = tile;
	}
	


}
