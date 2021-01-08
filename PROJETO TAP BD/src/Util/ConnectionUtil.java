package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionUtil {
	public static Connection getConnection() {
		Properties properties = new Properties();
		try {
			ResourceBundle resouces = ResourceBundle.getBundle("Util.DatabaseProperties");
			for (@SuppressWarnings("rawtypes")
			Enumeration keys = resouces.getKeys(); keys.hasMoreElements();) {
				final String key = (String) keys.nextElement();
				final String value = resouces.getString(key);
				properties.put(key, value);
			}
			Class.forName(properties.getProperty("jdbcDriver")).newInstance();
			return (Connection) DriverManager.getConnection(properties.getProperty("url"));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}