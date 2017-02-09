package factory;

import constants.Database;
import domain.DatabaseBean;
import enums.Vender;

public class DatabaseFactory {
	public static DatabaseBean createDatabase(Vender vendor, String username, String password) {
		String driver = "", url = "";
		switch(vendor) {
			case DB2 :
				driver = Database.DB2_DRIVER;
				url = Database.DB2_URL;
				 break;
			case MARIADB : 
				driver = Database.MARIADB_DRIVER;
				url = Database.MARIADB_URL;
				break;
			case MSSQL : 
				driver = Database.MSSQL_DRIVER;
				url = Database.MSSQL_URL;
				break;
			case MYSQL : 
				driver = Database.MYSQL_DRIVER;
				url = Database.MYSQL_URL;
				break;
			case ORACLE : 
				driver = Database.ORACLE_DRIVER;
				url = Database.ORACLE_URL;
				break;
			default: break;
		}
		return new DatabaseBean(driver, url, username, password); // Factory Pattern의 특징
	}
}
