package tw.elliot.repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import tw.elliot.conf.ApplicationConfig;
import tw.elliot.model.Task;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(value = ApplicationConfig.class)
class TaskRepoTest {
	@Autowired
	private TaskRepo taskRepo;

	@Test
	public void testPage1() {
		Pageable pageable = PageRequest.of(1, 5);
		Page<Task> page = taskRepo.findAll(pageable);

		Assertions.assertEquals(5, page.getTotalPages());
	}
}