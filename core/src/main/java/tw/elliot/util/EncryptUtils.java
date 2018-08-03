package tw.elliot.util;

import org.springframework.util.DigestUtils;

public class EncryptUtils {

	public static final String md5(String source) {
		return DigestUtils.md5DigestAsHex(source.getBytes());
	}
}
