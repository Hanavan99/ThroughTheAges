package com.throughtheages.ui;

import org.lwjgl.opengl.GL11;

import com.throughtheages.ui.textures.TextureManager;
import com.throughtheages.world.World;

public class Renderer {

	private World world = new World(100, 100);
	
	/**
	 * Draws the GUI for the window.
	 */
	public void drawGUI() {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3d(1, 0, 0);
		GL11.glVertex2d(0, 0);
		GL11.glVertex2d(0, 0.1);
		GL11.glVertex2d(1, 0.1);
		GL11.glVertex2d(1, 0);
		GL11.glEnd();
	}
	
	/**
	 * Draws everything else other than the world.
	 */
	public void drawEntities() {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex3d(5, 5, 0);
		GL11.glVertex3d(5, 6, 10);
		GL11.glVertex3d(6, 6, 10);
		GL11.glVertex3d(6, 5, 0);
		GL11.glEnd();
	}
	
	/**
	 * Draws the world.
	 */
	public void drawWorld() {
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glBegin(GL11.GL_QUADS);
		for (int x = 0; x < world.getWidth(); x++) {
			for (int y = 0; y < world.getHeight(); y++) {
				//GL11.glColor3d(Math.random(), Math.random(), Math.random());
				TextureManager.bindTexture("grass");
				GL11.glTexCoord2d(0, 0);
				GL11.glVertex2d(x, y);
				GL11.glTexCoord2d(0, 1);
				GL11.glVertex2d(x, y + 1);
				GL11.glTexCoord2d(1, 1);
				GL11.glVertex2d(x + 1, y + 1);
				GL11.glTexCoord2d(1, 0);
				GL11.glVertex2d(x + 1, y);
			}
		}
		GL11.glEnd();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
	}
	
}
