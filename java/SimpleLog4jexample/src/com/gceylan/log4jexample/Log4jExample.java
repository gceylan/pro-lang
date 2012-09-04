package com.gceylan.log4jexample;

import org.apache.log4j.Logger;

public class Log4jExample {

	private static final Logger logger = Logger.getLogger(Log4jExample.class);
	
	public static void main(String[] args) {
		
		logger.info("STARTED!");
		
		logger.trace("Trace");
		logger.debug("Debug");
		logger.info("Info");
		logger.warn("Warn");
		logger.error("Error");
		logger.fatal("Fatal");
		
		logger.info("FINISHED!");
	}

}
