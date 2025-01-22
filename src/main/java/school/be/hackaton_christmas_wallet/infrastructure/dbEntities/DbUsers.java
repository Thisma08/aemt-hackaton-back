package school.be.hackaton_christmas_wallet.infrastructure.dbEntities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import lombok.*;

import java.util.ArrayList;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@ToString(exclude = "budget")
public class DbUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<DbBudgets> budget = new ArrayList<>();
}
