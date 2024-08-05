package nam.dev.test_training.repo;

import nam.dev.test_training.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepo extends JpaRepository<Brand,Long> {

}
