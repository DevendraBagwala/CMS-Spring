/**
 * This is first Project of Core java i.e, Clinical management system
 * 
 * author @devendra
 */
package com.divergent.clinicmanagement.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
//class for selection
@Component
public class Select {
	@Autowired
	ConnectionProvider connectionProvider;
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(Select.class);
public ConnectionProvider getConnectionProvider() {
		return connectionProvider;
	}
	public void setConnectionProvider(ConnectionProvider connectionProvider) {
		this.connectionProvider = connectionProvider;
	}
	@Autowired
	Environment env;
	
	public  ResultSet getData(String query) {
		/*
		 * Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		 * logger.setLevel(Level.FINE); ConsoleHandler handler = new ConsoleHandler();
		 * handler.setLevel(Level.FINE); logger.addHandler(handler);
		 */
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = connectionProvider.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			return rs;

		} catch (Exception e) {

			logger.info(e.getMessage());//System.out.println(e);
			return null;
		}

	}
	
}
