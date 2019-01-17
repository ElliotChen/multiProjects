package tw.elliot.log;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.MDC;

@Slf4j
public class LogTest {

	@BeforeAll
	public static void befor() {
		MDC.put("userid", "elliot");
	}
	@Test
	public void test() {
		log.warn("check!");

	}
}
