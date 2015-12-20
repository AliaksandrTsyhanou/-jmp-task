package by.epam.jmp.facade;

import java.sql.Connection;

/**
 * Created by Alexandr on 21.12.2015.
 */
public class MongoHelper {

    public static Connection getMongoDBConnection() throws Exception{
        System.out.println("getting MongoDBConnection.");
        throw new Exception("Mongo BD is not exit.");
    }
}
