package tw.elliot.lombok;

import tw.elliot.model.User;

public class LombokTest {
	public void testGetSet() {
		User user = new User();
		user.getEmail();
		user.getOid();
	}
}
