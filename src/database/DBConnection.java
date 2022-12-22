package database;

import java.sql.Connection;

public class DBConnection {
    private DBConnection dbConnection;
    private Connection connection;

    private DBConnection(){}

    public Connection getInstance(){
        return connection;
    }

    public DBConnection getConnection(){
        if(dbConnection==null){
            dbConnection=new DBConnection();
        }
        return dbConnection;
    }
}
