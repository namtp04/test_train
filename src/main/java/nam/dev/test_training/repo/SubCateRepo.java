package nam.dev.test_training.repo;

import nam.dev.test_training.entity.SubCate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCateRepo extends JpaRepository<SubCate,Long> {
}
