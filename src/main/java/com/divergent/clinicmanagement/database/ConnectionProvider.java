/**
 * This is first Project of Core java i.e, Clinical management system
 * 
 * author @devendra
 */

package com.divergent.clinicmanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

// class for connection 
@Component
public class ConnectionProvider {
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(ConnectionProvider.class);

	/*
	 * @Autowired Environment env;
	 */
	/*
	 * @Value("${db.url}") public String databaseURL;
	 * 
	 * @Value("${db.username}") public String databaseUsername;
	 * 
	 * @Value("${db.password}") public String databasePassword;
	 */

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///clinic","root","");
			return con;

		} catch (Exception e) {
			logger.info(e.toString());
			return null;

		}
	}

}
