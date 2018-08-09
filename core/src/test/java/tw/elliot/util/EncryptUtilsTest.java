package tw.elliot.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class EncryptUtilsTest {
	@Test
	void testMd5() {
		String source = "password";
		String md5String = EncryptUtils.md5(source);
		log.info(md5String);
		System.out.println(md5String);
	}

	void test() {
		PasswordEncoder pe = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}