package com.throughtheages.ui.textures;

import org.lwjgl.opengl.GL11;

public class Texture {

	private final int textureID;
	private final int width;
	private final int height;

	public Texture(int textureID, int width, int height) {
		super();
		this.textureID = textureID;
		this.width = width;
		this.height = height;
	}

	public int getTextureID() {
		return textureID;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void bind() {
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureID);
	}
	
	public void unbind() {
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
	}

}
