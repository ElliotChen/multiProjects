package tw.elliot.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tw.elliot.model.Task;

@Repository
public interface TaskRepo extends PagingAndSortingRepository<Task, String> {

}
