package co.com.client.algoritmos.impl;
import co.com.client.algoritmos.interfaz.Logica;
import co.com.client.datos.impl.ImplPostgreSQLJDBC;
import co.com.client.datos.interfaz.PostgreSQLJDBC;
import co.com.client.dto.DtoCliente;
import co.com.client.dto.DtoLogin;
import co.com.client.funciones.impl.ImplFunciones;
import co.com.client.funciones.interfaz.Funciones;

public class ImplLogica implements Logica {

    Funciones funciones = new ImplFunciones();
    /*
    public DtoCliente consultarUsuario (String email){

        if (funciones.validarEmail(email)==0){
            ImplPostgreSQLJDBC conexion  = new ImplPostgreSQLJDBC();
            DtoCliente dtoClienteCons = conexion.consultarCliente(email);
            return dtoClienteCons;
        }
        return null;
    }

    public int crearUsuario (DtoCliente dtoCliente){

       if (this.funciones.validarDatos(dtoCliente) == 0){

           ImplPostgreSQLJDBC conexion  = new ImplPostgreSQLJDBC();
           DtoCliente dtoClienteCons = conexion.consultarCliente(dtoCliente.getEmail());

           if (dtoClienteCons == null || dtoClienteCons.getId() > 0 ){

               return 3;
           }

           dtoCliente.setPassword(funciones.cifrarMD5(dtoCliente.getPassword()));
           return conexion.insertarCliente(dtoCliente);
       }
       return 2;
   }

    public boolean loguearUsuario (DtoLogin dtoLogin){

        if (this.funciones.validarEmail(dtoLogin.getEmail()) == 0){

            PostgreSQLJDBC postgreSQLJDBC = new ImplPostgreSQLJDBC();
            DtoCliente dtoClienteLog = postgreSQLJDBC.consultarCliente(dtoLogin.getEmail());

            if ( dtoClienteLog.getPassword().equals(this.funciones.cifrarMD5(dtoLogin.getPassword()))
                    && dtoClienteLog.getEmail().equals(dtoLogin.getEmail())){
                System.out.println("Login Exitoso.");
                return true;
            }
        }
        System.out.println("Login No Exitoso.");
        return false;
    }*/
}