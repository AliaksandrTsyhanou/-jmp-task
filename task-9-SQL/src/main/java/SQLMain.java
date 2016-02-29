import by.epam.jmp.sql.SqlService;

import java.sql.*;

public class SQLMain {

    private static final String CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String DB_URL_FROM = "jdbc:mysql://localhost/issuetracker";
    private static final String DB_URL_TO = "jdbc:mysql://localhost/copydb";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    static{
        try {
            Class.forName(CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try(Connection conFrom = DriverManager.getConnection(DB_URL_FROM, USER, PASSWORD);
            Connection conTo = DriverManager.getConnection(DB_URL_TO, USER, PASSWORD);){
            SqlService.getTableNames(conFrom).forEach(tableName ->{
                try (Statement stFrom = conFrom.createStatement();
                     Statement stTo = conTo.createStatement()){
                    SqlService.createTable(stFrom, stTo, tableName);
                    SqlService.insertDataToTable(stFrom, stTo, tableName);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
