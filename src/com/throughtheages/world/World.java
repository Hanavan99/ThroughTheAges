package com.throughtheages.world;

public class World {

	private final int width;
	private final int height;
	private int[][] world;
	
	public World(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void generate() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				world[x][y] = 0;
			}
		}
	}
	
	public int getTile(int x, int y) {
		return world[x][y];
	}
	
}
