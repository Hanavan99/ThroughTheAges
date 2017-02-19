package com.throughtheages.ui;

import org.lwjgl.opengl.GL11;

public class Renderer {

	public void drawGUI() {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2d(0.1, 0.1);
		GL11.glVertex2d(0.1, 0.9);
		GL11.glVertex2d(0.9, 0.9);
		GL11.glVertex2d(0.9, 0.1);
		GL11.glEnd();
	}
	
	public void drawWorld() {
		
	}
	
}
