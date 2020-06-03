package co.com.client.web;

import co.com.client.datos.interfaz.ClientRepository;
import co.com.client.dto.DtoCliente;
import co.com.client.dto.DtoLogin;
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableAsync
@EnableJpaRepositories(basePackages = "co.com.client.datos.interfaz")
@ComponentScan(basePackages = {"co.com.client", "co.com.client.algoritmos.impl"})
@EntityScan(basePackages = "co.com.client.model")
@Component
public class ClientLog extends SpringBootServletInitializer {

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(ClientLog.class);
//
//    }

    public static void main(String[] args) {
        SpringApplication.run(ClientLog.class, args);
    }

    @Bean
    public CommandLineRunner demo(ClientRepository clientRepository) {
        return (args) -> {
            clientRepository.findByEmail("tuquis@mariquita.com");

            DtoCliente dtoCliente = new DtoCliente();
            DtoLogin dtoLogin = new DtoLogin();

            Scanner reader = new Scanner(System.in);
            System.out.println(" 1.Consultar cliente \n 2. Crear cliente \n 3. Hacer LogIn");
            int seleccion = Integer.parseInt(reader.nextLine());

            if (seleccion == 1){
                System.out.println("Ingresar e-mail:");
                String email= reader.nextLine();

                if (dtoCliente == null || dtoCliente.getId() == 0){
                    System.out.println("El cliente no existe.");
                }else {
//                logicaService.imprimirCliente(dtoCliente);
                }

            }else if (seleccion == 2){

                System.out.println("Ingresar nombre:");
                dtoCliente.setName(reader.nextLine());
                System.out.println("Ingresar clave:");
                dtoCliente.setPassword(reader.nextLine());
                System.out.println("Ingresar e-mail:");
                dtoCliente.setEmail(reader.nextLine());
                //System.out.println("Resultado creacion usuario: "+ logica.crearUsuario(dtoCliente));

            }else if (seleccion == 3){
                System.out.println("Ingresar e-mail:");
                dtoLogin.setEmail(reader.nextLine());
                System.out.println("Ingresar clave:");
                dtoLogin.setPassword(reader.nextLine());
                //logica.loguearUsuario(dtoLogin);

            }
        };
    }

    public void imprimirCliente (DtoCliente dtoCliente){
        System.out.println("Id: "+dtoCliente.getId()+"\n Nombre: "+dtoCliente.getName()+"\n Password: "+dtoCliente.getPassword()+"\n email: "+dtoCliente.getEmail());
    }
}
