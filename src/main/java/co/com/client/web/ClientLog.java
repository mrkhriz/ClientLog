package co.com.client.web;
import co.com.client.HibernateFactory;
import co.com.client.algoritmos.impl.ImplLogica;
import co.com.client.dto.DtoCliente;
import co.com.client.dto.DtoLogin;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Scanner;

@SpringBootApplication
@EnableAsync
public class ClientLog {

    public static void main(String[] args) {

        HibernateFactory.getSessionFactory().getCurrentSession();

        ClientLog clienteLog = new ClientLog();
        DtoCliente dtoCliente = new DtoCliente();
        DtoLogin dtoLogin = new DtoLogin();
        ImplLogica logica = new ImplLogica();

        Scanner reader = new Scanner(System.in);
        System.out.println(" 1.Consultar cliente \n 2. Crear cliente \n 3. Hacer LogIn");
        int seleccion = Integer.parseInt(reader.nextLine());

        if (seleccion == 1){

            System.out.println("Ingresar e-mail:");
            String email= reader.nextLine();

            //dtoCliente = logica.consultarUsuario(email);

            if (dtoCliente == null || dtoCliente.getId() == 0){
                System.out.println("El cliente no existe.");
            }else {
                clienteLog.imprimirCliente(dtoCliente);
            }

        }else if (seleccion == 2){

            System.out.println("Ingresar nombre:");
            dtoCliente.setName(reader.nextLine());
            System.out.println("Ingresar clave:");
            dtoCliente.setPassword(reader.nextLine());
            System.out.println("Ingresar e-mail:");
            dtoCliente.setEmail(reader.nextLine());
            // System.out.println("Resultado creacion usuario: "+ logica.crearUsuario(dtoCliente));

        }else if (seleccion == 3){
            System.out.println("Ingresar e-mail:");
            dtoLogin.setEmail(reader.nextLine());
            System.out.println("Ingresar clave:");
            dtoLogin.setPassword(reader.nextLine());
            //logica.loguearUsuario(dtoLogin);

        }

    }

    public void imprimirCliente (DtoCliente dtoCliente){
        System.out.println("Id: "+dtoCliente.getId()+"\n Nombre: "+dtoCliente.getName()+"\n Password: "+dtoCliente.getPassword()+"\n email: "+dtoCliente.getEmail());
    }
}