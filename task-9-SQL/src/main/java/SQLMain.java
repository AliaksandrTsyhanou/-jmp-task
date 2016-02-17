import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SQLMain {

    private static String className = "com.mysql.jdbc.Driver";
    private static String DB_URL_FROM = "jdbc:mysql://localhost/issuetracker";
    private static String DB_URL_TO = "jdbc:mysql://localhost/copydb";
    private static String user = "root";
    private static String password = "1234";

    static{
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try( Connection con = DriverManager.getConnection(DB_URL_FROM, user, password)){
            Set<String> tableNames = getTableNames(con);
            tableNames.forEach(n ->{
                System.out.println("table:" + n);
                try {
                    getTableColumNames(con, n).forEach(c -> {System.out.println("   " + c);});
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            List<String> listTableNames = new ArrayList<>(tableNames);
            System.out.println(getCreateTableSql(con, listTableNames.get(1)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Set<String> getTableNames(Connection con) throws SQLException {
        Set<String> tableNames = new HashSet<>();
        DatabaseMetaData metaData = con.getMetaData();
        ResultSet metaRS = metaData.getTables(null, null, null, new String[] { "TABLE" });
        while (metaRS.next()) {
            tableNames.add(metaRS.getString(3));
        }
        return tableNames;
    }

    private static Set<String> getTableColumNames(Connection con, String tableName) throws SQLException {
        Set<String> columNames = new HashSet<>();
        DatabaseMetaData metaData = con.getMetaData();
        ResultSet metaRS = metaData.getColumns( null, null, tableName, null);
        while (metaRS.next()) {
            columNames.add(metaRS.getString(4));
        }
        return columNames;
    }

    private static String getCreateTableSql(Connection con, String tableName) throws SQLException {
        DatabaseMetaData metaData = con.getMetaData();

        Set<String> pkNames = new HashSet<String>();

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
            appendFieldCreationClause( sql, columnName, sqlTypeName, columnSize, precision, nullsProhibited, pkNames.contains( columnName ), metaData.getIdentifierQuoteString(), columnsMetadata );
        }
        sql.append( ")" );
        return sql.toString();
    }

    public static void appendFieldCreationClause( StringBuffer buffer, String columnName, String targetTypename, int columnSize, int precision, boolean nullsProhibited, boolean isPrimaryKey, String identifierQuoteString, ResultSet columnMetaData ) {
        if( isPrimaryKey ) {
            targetTypename = "INT";
            precision = 0;
        }
        buffer.append( identifierQuoteString + columnName + identifierQuoteString + " " + targetTypename );
        if( columnSize > 0 ) {
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
