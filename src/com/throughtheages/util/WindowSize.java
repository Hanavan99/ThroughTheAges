package com.throughtheages.util;

import org.lwjgl.glfw.GLFW;

public class WindowSize {

	private final int width;
	private final int height;

	public WindowSize(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public static WindowSize getWindowSize(long window) {
		int[] x = new int[1];
		int[] y = new int[1];
		GLFW.glfwGetWindowSize(window, x, y);
		return new WindowSize(x[0], y[0]);
	}

}
