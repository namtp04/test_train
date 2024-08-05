package nam.dev.test_training.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @Id
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "sub_cate_name")
    private String subCateName;

    @Column(name = "sell_price")
    private Double sellPrice;

    @Column(name = "status_name")
    private String statusName;
}
