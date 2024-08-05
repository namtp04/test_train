package nam.dev.test_training.repo;

import nam.dev.test_training.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepo extends JpaRepository<Status,Long> {
}
