package co.com.client.datos.interfaz;
import co.com.client.model.Client;
import java.math.BigInteger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, BigInteger> {

    List<Client> findByEmail(String email);

}
