package com.throughtheages.main;

import com.throughtheages.ui.GameWindow;
import com.throughtheages.ui.textures.TextureManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GameWindow.init();
		GameWindow.setup();
		TextureManager.addTexture("/assets/grass.png", "grass");
		GameWindow.loop();
		GameWindow.exit();
	}

}
