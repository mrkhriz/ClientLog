package co.com.client.datos.impl;
import co.com.client.datos.interfaz.PostgreSQLJDBC;
import co.com.client.dto.DtoCliente;
import java.sql.Statement;

import java.sql.*;

public class ImplPostgreSQLJDBC implements PostgreSQLJDBC {

    Connection c = null;

    public void conectarDB (){

        try {
            //Class.forName("org.postgresql.Driver");
            this.c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "postgres");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    public DtoCliente consultarCliente(String email){

        DtoCliente dtoCliente = new DtoCliente();

        try {
            conectarDB();

            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.client WHERE email = '"+email+"'");

            if (rs.next()){
                dtoCliente.setId(rs.getLong(1));
                dtoCliente.setName(rs.getString(2));
                dtoCliente.setEmail(rs.getString(3));
                dtoCliente.setPassword(rs.getString(4));
            }

            c.close();

        }catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            return null;
        }

        return dtoCliente;
    }

    public int insertarCliente (DtoCliente dtoCliente){

        try {
            conectarDB();

            PreparedStatement pst = this.c.prepareStatement("INSERT INTO client (name, email, password) VALUES" +
                    " ('"+dtoCliente.getName()+"','"+dtoCliente.getEmail()+"','"+dtoCliente.getPassword()+"')");

            pst.executeUpdate();
            c.close();

        }catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            return 1;
        }

        return 0;
    }

}