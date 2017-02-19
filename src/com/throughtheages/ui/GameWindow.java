package com.throughtheages.ui;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import com.throughtheages.util.WindowSize;

public class GameWindow {

	private static long window;
	private static Renderer renderer;

	public static void init() {
		GLFW.glfwInit();
		window = GLFW.glfwCreateWindow(800, 600, "ThroughTheAges", 0, 0);
		GLFW.glfwMakeContextCurrent(window);
		
		renderer = new Renderer();
		
		//setup();
		//loop();
	}
	
	public static void setup() {
		GL.createCapabilities();
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		GL11.glClearColor(0, 0, 0, 0);
	}

	public static void loop() {
		while (!GLFW.glfwWindowShouldClose(window)) {
			WindowSize wsize = WindowSize.getWindowSize(window);
			GL11.glViewport(0, 0, wsize.getWidth(), wsize.getHeight());
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(0, 1, 0, 1, 0, 1);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();
			GL11.glPushMatrix();
			
			renderer.drawGUI();
			
			GL11.glPopMatrix();
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(-10, 10, -10, 10, -10, 10);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();
			GL11.glPushMatrix();
			//GL11.glTranslated(0, 0, -5);
			GL11.glRotated(-45, 1, 0, 0);
			GL11.glRotated(45, 0, 0, 1);
			
			GL11.glColor3d(1, 1, 1);
			renderer.drawEntities();
			GL11.glColor3d(1, 1, 1);
			renderer.drawWorld();
			
			GL11.glPopMatrix();
			
			GLFW.glfwPollEvents();
			GLFW.glfwSwapInterval(1);
			GLFW.glfwSwapBuffers(window);
		}
	}

	public static void exit() {
		GLFW.glfwDestroyWindow(window);
		GLFW.glfwTerminate();
	}
	
}
