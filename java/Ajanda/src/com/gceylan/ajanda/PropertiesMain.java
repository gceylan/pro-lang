package com.gceylan.ajanda;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;


public class PropertiesMain {
	
	private static final Logger logger = Logger.getLogger(PropertiesMain.class);
	
	private String filePath = "config/config.properties";
	
	private String host = null;
	private String database = null;
	private String user = null;
	private String password = null;
	private String positionX = null;
	private String positionY = null;
	
	Properties prop;
	
	public PropertiesMain() {
		prop = new Properties();
		
		this.host = "";
		this.database = "";
		this.user = "";
		this.password = "";
		
		this.positionX = "0";
		this.positionY = "0";
	}
	
	/**
	 * 
	 * @param config "config.properties" dosyasýndan çekmek istediðin data
	 * @return config datasýnýn karþýlýðý
	 */
	
	public String getProperties(String config) {
		try {
			prop.load(new FileInputStream(filePath));
		} catch (FileNotFoundException fileEx) {
			logger.error("FILE NOT FOUND! " + config + " DOSYADAN ÇEKÝLEMEDÝ!");
			fileEx.printStackTrace();
		} catch (IOException ioEx) {
			logger.error("IOEXCEPTION!");
			ioEx.printStackTrace();
		}
		
		// config dosyasýnda gerekli ayar yoksa null dönder.
		// return (prop.getProperty(config) != null && !prop.getProperty(config).equals("")) ? prop.getProperty(config) : null;
		// belki de adamýn þifresi "" dir.
		return (prop.getProperty(config) != null) ? prop.getProperty(config) : null;
	}
	
	// sepeti doldur ve 1 kerede öde.
	public void addAllConfigFile() {
		FileOutputStream output;
		try {
			output = new FileOutputStream(filePath);
			
			// config.properties' e ekle(set et)
			prop.setProperty("host", getHost());
			prop.setProperty("database", getDatabase());
			prop.setProperty("user", getUser());
			prop.setProperty("password", getPassword());
			
			prop.setProperty("positionX", getPositionX());
			prop.setProperty("positionY", getPositionY());
			
			try {
				prop.store(output, null);
			} catch (IOException ioEx) {
				// TODO
				logger.error("IOEXCEPTION! CONFIG NOT SAVED!");
				ioEx.printStackTrace();
			}
		} catch (FileNotFoundException foundEx) {
			logger.error("FILE NOT FOUND! " + "\"" + filePath + "\"");
			foundEx.printStackTrace();
		}
	}
	
	public void printAllConfig() {
		try {
			prop.load(new FileInputStream(filePath));
			
			System.out.println();
		} catch (FileNotFoundException fileEx) {
			logger.error("FILE NOT FOUND! " + "\"" + filePath + "\"");
			fileEx.printStackTrace();
		} catch (IOException ioEx) {
			logger.error("IOEXCEPTION! CONFIG FILE NOT PRINT!");
			ioEx.printStackTrace();
		}
	}
	

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPositionX() {
		return positionX;
	}

	public void setPositionX(String positionX) {
		this.positionX = positionX;
	}

	public String getPositionY() {
		return positionY;
	}

	public void setPositionY(String positionY) {
		this.positionY = positionY;
	}
	
	public static void main(String[] args) {
		PropertiesMain conf = new PropertiesMain();
		conf.setHost("localhost");
		conf.setDatabase("myDatabaseName");
		conf.setUser("root");
		conf.setPassword("");
		
		conf.addAllConfigFile();
		
		System.out.println(conf.getProperties("host"));
		System.out.println(conf.getProperties("deneme"));
	}

}
