package co.com.client.datos.interfaz;
import co.com.client.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface ClientRepository extends CrudRepository <Client, BigInteger>{

    List<Client> findByEmail(String email);

}
