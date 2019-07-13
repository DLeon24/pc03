package cjava.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConn {

    private static String driver = null;
    private static String usuario = null;
    private static String password = null;
    private static String url = null;
    static PropertyResourceBundle properties;

    static {
        try {
		properties = new PropertyResourceBundle(new FileInputStream("cjava.util.config"));
		url= properties.getString("URL");
		driver= properties.getString("DRIVER");
		usuario= properties.getString("USER");
		password= properties.getString("PASSWORD");
            Class.forName(driver);

        }catch(IOException e){
		System.out.println("Error:"+e);
	}catch (ClassNotFoundException e) {
            System.out.println("");
            }
	}
    

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, usuario,password);
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return connection;
    }

}
