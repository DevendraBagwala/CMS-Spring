/**
 * This is first Project of Core java i.e, Clinical management system
 * 
 * author @devendra
 */
package com.divergent.clinicmanagement.database;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
//class is used for insert update And delete data from database
@Component
public class InsertUpdateDelete {
	@Autowired
	ConnectionProvider connectionProvider;
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(InsertUpdateDelete.class);
	@Autowired
	Environment env;
public ConnectionProvider getConnectionProvider() {
		return connectionProvider;
	}
	public void setConnectionProvider(ConnectionProvider connectionProvider) {
		this.connectionProvider = connectionProvider;
	}



public  void setData(String Query, String msg){
	/*
	 * Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	 * logger.setLevel(Level.FINE); ConsoleHandler handler = new ConsoleHandler();
	 * handler.setLevel(Level.FINE); logger.addHandler(handler);
	 */
	    
        Connection con=null;
        Statement st=null;
        try{
            con=connectionProvider.getConnection();
            st=con.createStatement();
            st.executeUpdate(Query);
            
            if(!msg.equals("")){
                
            	logger.info(msg);
            }
            
        }catch(Exception e){
        	
        	logger.info(e.getMessage());//System.out.println(e);
        }
        finally{
        
            try{
            }catch(Exception e){
            	logger.info(e.toString());
            }
        }
    }
}
