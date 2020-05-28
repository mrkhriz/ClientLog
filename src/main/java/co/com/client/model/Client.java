package co.com.client.model;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Client")
public class Client implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 30)
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @NotNull
    @Size(max = 30)
    @Column(name = "email", length = 30, nullable = false)
    private String email;

    @NotNull
    @Size(max = 32)
    @Column(name = "password", length = 32, nullable = false)
    private String password;

}
