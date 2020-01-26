package com.sam.util;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dbmanager.connection.setting.AbstractConnectionSettings;
import com.dbmanager.connection.setting.ConnectionSettings;
import com.dbmanager.property.util.PropertyReader;

public class ConnectionUtils {

	private static final Logger LOG = LoggerFactory.getLogger(ConnectionUtils.class);
	private static final String PROPERTIES = "D:\\eclipse-oxygen-workspace\\sam\\src\\mysql.properties";
	private static AbstractConnectionSettings connectionSettings;

	private ConnectionUtils() {
	}

	static {
		try {
			PropertyReader propertyReader = new PropertyReader(new File(PROPERTIES));
			connectionSettings = new ConnectionSettings(propertyReader.propertiesReader());
		} catch (IOException e) {
			LOG.error("Exception {}", e);
		}
	}

	public static AbstractConnectionSettings getConnectionSettings() throws IOException {
		return connectionSettings == null
				? new ConnectionSettings(new PropertyReader(new File(PROPERTIES)).propertiesReader())
				: connectionSettings;
	}
}
