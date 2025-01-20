package school.be.hackaton_christmas_wallet.infrastructure.dbEntities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "purchases")
@Data
@NoArgsConstructor
public class DbPurchases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float amount;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private DbUsers user;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    private DbCategories category;

    private LocalDateTime purchaseDate;
}

