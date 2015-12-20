package by.epam.jmp.facade;

import java.sql.Connection;

/**
 * Created by Alexandr on 21.12.2015.
 */
public class DBConnectionFacade {

    public static Connection getConnection(DBTypes dbType){
        Connection con = null;
        try {
            switch (dbType){
                case MYSQL:
                    con = MySqlHelper.getMySqlDBConnection();
                    break;
                case ORACLE:
                    con = OracleHelper.getOracleDBConnection();
                    break;
                case MONGO:
                    con = MongoHelper.getMongoDBConnection();
                    break;
                default:
                    con = null;
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static enum DBTypes{
        MYSQL,ORACLE, MONGO;
    }

}
