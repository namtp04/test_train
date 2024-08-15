package nam.dev.test_training.repo;

import nam.dev.test_training.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDTORepo extends JpaRepository<ProductDTO, Long> {
    @Query(
            value = "SELECT product.id, product.product_name, brand.brand_name, sub_category.sub_cate_name, product.sell_price, status.status_name\n" +
                    "FROM     brand INNER JOIN\n" +
                    "                  product ON brand.id = product.id INNER JOIN\n" +
                    "                  product_brand ON brand.id = product_brand.brand_id AND product.id = product_brand.product_id INNER JOIN\n" +
                    "                  status ON product.status_id = status.id INNER JOIN\n" +
                    "                  sub_category ON product.subcate_id = sub_category.id",
            nativeQuery = true
    )
    List<ProductDTO> getAll();

    @Query(
            value = "SELECT product.id, product.product_name, brand.brand_name, sub_category.sub_cate_name, product.sell_price, status.status_name\n" +
                    "FROM     brand INNER JOIN\n" +
                    "                  product ON brand.id = product.id INNER JOIN\n" +
                    "                  product_brand ON brand.id = product_brand.brand_id AND product.id = product_brand.product_id INNER JOIN\n" +
                    "                  status ON product.status_id = status.id INNER JOIN\n" +
                    "                  sub_category ON product.subcate_id = sub_category.id\n" +
                    "where product.id=:id",
            nativeQuery = true
    )
    ProductDTO getById(@Param("id") Long id);
}
