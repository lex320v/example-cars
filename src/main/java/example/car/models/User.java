package example.car.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Entity()
@Table(name = "users")
@DynamicInsert
public class User {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Getter
    @Setter
    @Column(name = "password", nullable = false)
    private String password;

    @Getter
    @Setter
    @Column(name = "username", nullable = false)
    private String username;

    @Getter
    @Setter
    @Column(name = "firstname")
    private String firstname;

    @Getter
    @Setter
    @Column(name = "lastname")
    private String lastname;

    @Getter
    @Setter
    @ColumnDefault("false")
    @Column(name = "is_active")
    private Boolean isActive;

    @Getter
    @ColumnDefault("NOW()")
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
