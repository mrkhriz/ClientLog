package co.com.client.datos.interfaz;

import co.com.client.dto.DtoCliente;

public interface PostgreSQLJDBC {

    public void conectarDB ();

    public DtoCliente consultarCliente(String email);

    public int insertarCliente (DtoCliente dtoCliente);
}
