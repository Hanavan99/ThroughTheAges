package com.throughtheages.ui;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class GameWindow {

	private static long window;
	private static Renderer renderer;

	public static void init() {
		GLFW.glfwInit();
		window = GLFW.glfwCreateWindow(800, 600, "ThroughTheAges", 0, 0);
		GLFW.glfwMakeContextCurrent(window);
		
		renderer = new Renderer();
		
		setup();
		loop();
	}
	
	private static void setup() {
		GL.createCapabilities();
		GL11.glClearColor(0, 0, 0, 0);
	}

	private static void loop() {
		while (!GLFW.glfwWindowShouldClose(window)) {
			GL11.glViewport(0, 0, 800, 600);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(0, 1, 0, 1, 0, 1);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();
			GL11.glPushMatrix();
			
			renderer.drawGUI();
			
			GL11.glPopMatrix();
			renderer.drawWorld();
			
			GLFW.glfwPollEvents();
			GLFW.glfwSwapInterval(1);
			GLFW.glfwSwapBuffers(window);
		}
	}

}
