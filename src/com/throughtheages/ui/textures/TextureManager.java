package com.throughtheages.ui.textures;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.lwjgl.opengl.GL11;

public class TextureManager {

	private static HashMap<String, Texture> textures = new HashMap<String, Texture>();

	/**
	 * Loads a texture from the specified location using reflection
	 * 
	 * @param location The location in the classpath of the texture
	 * @param name The name of the texture
	 */
	public static void addTexture(String location, String name) {
		try {
			InputStream s = ClassLoader.class.getResourceAsStream(location);
			BufferedImage img = ImageIO.read(s);
			int tex = GL11.glGenTextures();
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, tex);
			GL11.glPixelStorei(GL11.GL_UNPACK_ALIGNMENT, 1);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
			GL11.glTexEnvf(GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_MODE, GL11.GL_MODULATE);
			float[] data = new float[img.getWidth() * img.getHeight() * 3];
			for (int i = 0; i < img.getWidth() * img.getHeight(); i++) {
				int x = i % img.getWidth();
				int y = i / img.getWidth();
				Color c = new Color(img.getRGB(x, y));
				data[i * 3 + 0] = (float) c.getRed() / 255;
				data[i * 3 + 1] = (float) c.getGreen() / 255;
				data[i * 3 + 2] = (float) c.getBlue() / 255;
				GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGB, img.getWidth(), img.getHeight(), 0, GL11.GL_RGB, GL11.GL_FLOAT, data);
				Texture t = new Texture(tex, img.getWidth(), img.getHeight());
				textures.put(name, t);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void bindTexture(String name) {
		if (textures.containsKey(name)) {
			textures.get(name).bind();
		}
	}
	
	public static void unbindTexture(String name) {
		if (textures.containsKey(name)) {
			textures.get(name).unbind();
		}
	}

}
