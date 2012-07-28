package com.gceylan.ajanda;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class JLayerDemo {
	
	String path;
	Player p;
	
	public JLayerDemo() throws JavaLayerException {
		try {
			path = "sound/Wake_Up_Guitar.mp3";
			FileInputStream file = new FileInputStream(path);
			p = new Player(file);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void oynat() throws JavaLayerException {
		p.play();
	}
	
	public void kapat() {
		p.close();
	}
}
