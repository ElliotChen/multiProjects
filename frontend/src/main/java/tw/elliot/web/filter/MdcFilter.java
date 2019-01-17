package tw.elliot.web.filter;

import org.slf4j.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import java.io.IOException;

public class MdcFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
			Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			System.out.println("123");
			if (obj instanceof UserDetails) {
				UserDetails ud = (UserDetails) obj;
				MDC.put("userid", ud.getUsername());
			}
		}

		filterChain.doFilter(servletRequest, servletResponse);

		MDC.clear();
	}

}
