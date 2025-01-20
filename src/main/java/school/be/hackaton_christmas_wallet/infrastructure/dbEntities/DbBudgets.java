package school.be.hackaton_christmas_wallet.infrastructure.dbEntities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "budgets")
@Data
@NoArgsConstructor
@ToString(exclude = "purchases")
public class DbBudgets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float budget;
    private int month;
    private int year;

    @OneToMany(mappedBy = "budget", fetch = FetchType.LAZY)
    private List<DbPurchases> purchases = new ArrayList<>();
}
