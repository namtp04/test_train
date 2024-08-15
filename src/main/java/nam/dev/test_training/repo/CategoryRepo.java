package nam.dev.test_training.repo;

import nam.dev.test_training.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
    @Query("SELECT c FROM Category c WHERE c.cateName =:cateName")
    Category getByCateName(@Param("cateName") String cateName);

}
