package co.com.client.funciones.interfaz;
import co.com.client.dto.DtoCliente;
import org.springframework.stereotype.Component;

@Component
public interface Funciones {

    public int validarDatos(DtoCliente dtoCliente);

    public String cifrarMD5(String dato);

    public int validarEmail(String email);

}
