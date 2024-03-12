import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
class DAOConcrete implements DAO {
    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result;
    static String url = BusinessDataConnection.getURL();
    static String username = BusinessDataConnection.getURL();
    static String pwd = BusinessDataConnection.getURL();

    DAOConcrete() {

        try {

            connection = BusinessDataConnection.getDBConnection();

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }

    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {connection.close();}
    }

    @Override //insert user to DB
    public int insert(Business emp) throws SQLException {
        int res = -1;
        pStatement = connection.prepareStatement(BusinessDataConnection.getInsert());
        pStatement.setString(1, emp.getUsername());
        pStatement.setString(2, emp.getEmail());
        res = pStatement.executeUpdate();
        disconnect();

        return res;
    }

    @Override //retrieve user from DB via ID
    public Business get(int anID) throws SQLException {

        pStatement = connection.prepareStatement(BusinessDataConnection.getSelect());
        pStatement.setInt(1,anID);
        result = pStatement.executeQuery();

        Business updatedEmp = null;
        if (result.next()) {
            Business e = new Business();
            updatedEmp = new Business( result.getInt("id"), result.getString("username"), result.getString("email"), result.getString("phone"));
        }

        return updatedEmp;
    }

    //update user in DB
    public int update(Business emp) throws SQLException {

        int result = -1;

        pStatement = connection.prepareStatement(BusinessDataConnection.getUpdate());
        pStatement.setString(1, emp.getUsername());
        pStatement.setString(2, emp.getEmail());
        pStatement.setString(3, emp.getPhone());
        pStatement.setInt(4, emp.getID());
        result = pStatement.executeUpdate();

        return result;
    }

    // Delete user in DB
    @Override
    public int delete(Business emp) throws SQLException {

        int res = -1;

        pStatement = connection.prepareStatement(BusinessDataConnection.getDelete());
        pStatement.setInt(1,emp.getID());
        res = pStatement.executeUpdate();
}
