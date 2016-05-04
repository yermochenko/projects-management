package by.vsu.mf.ammc.pm.dao.mysql;

import java.sql.Connection;

public class BaseDao {
	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
