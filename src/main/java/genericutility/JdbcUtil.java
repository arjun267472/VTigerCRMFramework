package genericutility;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class JdbcUtil {
    public static Connection con;

    /**
     * Sets connection with database(MySQL)
     * @throws SQLException
     */
    public void createCon() throws SQLException {
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        con = DriverManager.getConnection(IPathConstants.dburl,IPathConstants.dbun,IPathConstants.dbpw);

    }

    /**
     * Reads TestScript data from Database
     * @param table
     * @param tc
     * @param column
     * @return String testdata
     * @throws SQLException
     */
    public String readFromDB(String table,String tc, String column) throws SQLException {
        Statement stat = con.createStatement();
        ResultSet result = stat.executeQuery("select * from "+table+" where tc_no = '"+tc+"';");
        if(result.next()) {
            return result.getString(column);
        }
        return null;
    }

    /**
     * Executes based on the query given.
     * @param query
     * @return ResultSet result
     * @throws SQLException
     */
    public ResultSet executeSelect(String query) throws SQLException {
        Statement stat = con.createStatement();
        ResultSet result = stat.executeQuery(query);
        return result;
    }

    /**
     * Executes non-select queries
     * @param query
     * @return int value
     * @throws SQLException
     */
    public int executeUpdate(String query) throws SQLException {
        Statement stat = con.createStatement();
        int result = stat.executeUpdate(query);
        return result;
    }
    public void addCreation(String table,String column,String tc,String value) throws SQLException {
        Statement stat = con.createStatement();
         stat.executeUpdate("update "+table+" set "+column+" = '"+value+"' where tc_no = '"+tc+"';");
    }
    /**
     * Ends the connection with the database
     * @throws SQLException
     */
    public void closeCon() throws SQLException {
        con.close();
    }
}
