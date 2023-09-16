package src.Conections;
    import Connection.ConnectionDB;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
public class InsertData {
    Connection conn = ConnectionDB.getConnectionDB();

    public boolean createUser(String username, String password){
        
    }
}
