package school.be.hackaton_christmas_wallet.infrastructure.dbEntities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "purchases")
@Data
@NoArgsConstructor
public class DbPurchases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float amount;
    private int userId;
    private int categoryId;

//    amount decimal(10,2) not null,
//    userId bigint not null,
//    categoryId bigint not null,
//    purchaseDate datetime not null,
}
