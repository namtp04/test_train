package nam.dev.test_training.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_name")
    @NotBlank(message = "Tên sản phẩm trống")
    private String productName;

    @Column(name = "sell_price")
    @NotNull(message = "Giá bán trống")
    private Double sellPrice;

    @Column(name = "color")
    @NotBlank(message = "Màu sắc trống")
    private String color;

    @Column(name = "quantity")
    @NotNull(message = "Số lượng trống")
    private Long quantity;

    @Column(name = "origin_price")
    @NotNull(message = "Giá gốc trống")
    private Double originPrice;

    @ManyToOne
    @JoinColumn(name = "subcate_id",referencedColumnName = "id")
    private SubCate subCate;

    @ManyToOne
    @JoinColumn(name = "status_id",referencedColumnName = "id")
    private Status status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_brand",
               joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "brand_id")
    )
    private Set<Brand> brandSet;
}
