package tw.elliot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tw.elliot.model.RoleEnum;
import tw.elliot.repo.UserRepo;
import tw.elliot.util.EnumUtils;

import java.util.Iterator;
import java.util.stream.Collectors;

@Service
public class DBUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		tw.elliot.model.User user = this.userRepo.findByName(name);
		UserDetails ud = null;
		if (user != null) {
			User.UserBuilder builder = User.withUsername(name);

			String[] roles = EnumUtils.names(user.getRoles());

			builder
					.password("{MD5}"+user.getPassword())
					.roles(roles)
					.disabled(Boolean.FALSE)
					.accountExpired(Boolean.FALSE);

			ud = builder.build();
		} else {
			throw new UsernameNotFoundException("User named ["+name+"] can't be found.");
		}


		return ud;
	}
}
