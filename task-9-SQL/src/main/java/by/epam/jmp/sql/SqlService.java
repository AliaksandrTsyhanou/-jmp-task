package by.epam.jmp.sql;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * Created by Alexandr on 25.02.2016.
 */
public class SqlService {
    public static void createTable(Statement stFrom, Statement stTo, String tableName) throws SQLException {
        String createTableSql = getCreateTableSql(stFrom, tableName);
        System.out.println(createTableSql);
        stTo.execute("DROP TABLE IF EXISTS `" + tableName + "`");
        stTo.execute(createTableSql);
    }

    public static void insertDataToTable( Statement stFrom, Statement stTo, String tableName) throws SQLException {
        String startInsertSql = "INSERT INTO `" + tableName + "` VALUES (";
        ResultSet rs = stFrom.executeQuery("SELECT * FROM " + tableName);
        int columnCont =  rs.getMetaData().getColumnCount();
        while(rs.next()){
            StringJoiner sj = new StringJoiner(",");
            IntStream.rangeClosed(1, columnCont).forEach((i) -> {
                try {
                    System.out.println("rs.getMetaData().getColumnType("+i+"):" + rs.getMetaData().getColumnType(i));
                    String value = rs.getObject(i) == null ? "NULL" : "'" + rs.getObject(i).toString() + "'";
                    sj.add(value);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            String insertSQL = (new StringJoiner("")).add(startInsertSql).add(sj.toString()).add(");").toString();
            System.out.println("insertSQL:" + insertSQL);
            stTo.addBatch(insertSQL);
        }
        stTo.executeBatch();
    }

    public static Set<String> getTableNames(Connection con) throws SQLException {
        Set<String> tableNames = new HashSet<>();
        DatabaseMetaData metaData = con.getMetaData();
        ResultSet metaRS = metaData.getTables(null, null, null, new String[] { "TABLE" });
        while (metaRS.next()) {
            tableNames.add(metaRS.getString(3));
        }
        return tableNames;
    }

    public static Set<String> getTableColumNames(Connection con, String tableName) throws SQLException {
        Set<String> columNames = new HashSet<>();
        DatabaseMetaData metaData = con.getMetaData();
        ResultSet metaRS = metaData.getColumns( null, null, tableName, null);
        while (metaRS.next()) {
            columNames.add(metaRS.getString(4));
        }
        return columNames;
    }

    public static String getCreateTableSql(Statement st, String tableName) throws SQLException {
        DatabaseMetaData metaData = st.getConnection().getMetaData();

        Set<String> pkNames = new HashSet<>();

        ResultSet pkResultSet = metaData.getPrimaryKeys( null, null, tableName );
        while( pkResultSet.next() ) {
            pkNames.add( pkResultSet.getString(4) );
        }

        ResultSet columnsMetadata = metaData.getColumns( null, null, tableName, null);
        StringBuffer sql = new StringBuffer();
        sql.append( "CREATE TABLE " + tableName + " (" );
        String delim = "";
        while( columnsMetadata.next() ) {
            sql.append( delim );
            delim = ", ";

            String columnName = columnsMetadata.getString( 4 );
            String sqlTypeName = columnsMetadata.getString(6);
            int typeCode = columnsMetadata.getInt( 5 );
            if( sqlTypeName == null ) {
                System.out.println( "Unknown typename for type code " + typeCode + "; SQL type name is " + sqlTypeName );
                continue;
            }
            int columnSize = columnsMetadata.getInt( 7 );
            boolean nullsProhibited = "NO".equalsIgnoreCase( columnsMetadata.getString(18));
            int precision = columnsMetadata.getInt( 9 );
            appendFieldCreationClause( sql, columnName, sqlTypeName, columnSize, precision, nullsProhibited,
                    pkNames.contains( columnName ), metaData.getIdentifierQuoteString(), columnsMetadata );
        }
        sql.append( ")" );
        return sql.toString();
    }

    public static void appendFieldCreationClause( StringBuffer buffer, String columnName, String targetTypename,
                                                  int columnSize, int precision, boolean nullsProhibited,
                                                  boolean isPrimaryKey, String identifierQuoteString,
                                                  ResultSet columnMetaData ) {
        if( isPrimaryKey ) {
            targetTypename = "INT";
            precision = 0;
        }
        buffer.append( identifierQuoteString + columnName + identifierQuoteString + " " + targetTypename );
        if( columnSize > 0 && !"DATETIME".equals(targetTypename)) {
            buffer.append( "(" + columnSize );
            if( precision > 0 ) {
                buffer.append( "," + precision );
            }
            buffer.append( ")" );
        }
        if( "id".equalsIgnoreCase( columnName ) ) {
            buffer.append( " UNIQUE" );
        }
        if( nullsProhibited ) {
            buffer.append( " NOT NULL" );
        }
        if( isPrimaryKey ) {
            buffer.append( " AUTO_INCREMENT" );
            buffer.append( " PRIMARY KEY" );
        }
    }

}
