package tw.elliot.web.conf;

import org.springframework.lang.Nullable;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import tw.elliot.conf.ApplicationConfig;

import javax.servlet.Filter;

public class WebMVCInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { ApplicationConfig.class, WebSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebApplicationConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}


	@Nullable
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		/*
		ThreadLocalHolderFilter threadLocalHolderFilter = new ThreadLocalHolderFilter();

		return new Filter[] {encodingFilter, threadLocalHolderFilter};
		*/
		return new Filter[] {encodingFilter};
	}





}
