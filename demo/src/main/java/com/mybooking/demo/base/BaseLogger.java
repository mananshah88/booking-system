package com.mybooking.demo.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseLogger {
	
	public Logger appLogger;

	public Logger getLogger() {
		return LogManager.getLogger(this.getClass());
	}

	public void debug(Object obj) {
		if (appLogger == null) {
			appLogger = getLogger();
		}
		appLogger.debug(obj);
	}

	public void error(Object obj) {
		if (appLogger == null) {
			appLogger = getLogger();
		}
		appLogger.error(obj);
	}


	public void info(Object obj) {
		if (appLogger == null) {
			appLogger = getLogger();
		}
		appLogger.info(obj);
	}


}
