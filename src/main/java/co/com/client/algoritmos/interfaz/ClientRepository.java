package co.com.client.algoritmos.interfaz;

import co.com.client.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository {

    List<Client> findByEmail(String email);

}
