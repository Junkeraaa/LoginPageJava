package src.Conections;
    import Connection.ConnectionDB;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;

public class GetData {
     Connection conn = ConnectionDB.getConnectionDB();

    public boolean checkUsername(String username){
        boolean usernameExists = false; // Inicializa como falso, pois ainda não sabemos se o nome de usuário existe.
        
        if(conn != null){
            try {
                String sql = "SELECT username FROM credentials WHERE username = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, username); // Define o valor do parâmetro para o valor de 'username'
                ResultSet resultSet = statement.executeQuery();
                
                // Verifique se há algum resultado retornado
                if (resultSet.next()) {
                    usernameExists = true; // Se houver resultados, o nome de usuário existe
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return usernameExists;
    }

    public int getIdUsername(String username){
        if(conn != null){
            try {
                String sql = "SELECT id FROM credentials WHERE username = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, username); // Define o valor do parâmetro para o valor de 'username'
                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()){
                int id = resultSet.getInt("id");
                return id;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean checkPassword(int id, String password){
        Connection conn = ConnectionDB.getConnectionDB();
        boolean correctPassword = false;
        
        if(conn != null){
            try {
                String sql = "SELECT password FROM credentials WHERE id = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                
                if (resultSet.next()) {
                    if(resultSet.getString("password").equals(password)){
                        correctPassword = true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return correctPassword;
    }
} 
