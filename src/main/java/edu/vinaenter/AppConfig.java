package edu.vinaenter;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class AppConfig {
	@Bean("viewResolver1")
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/views/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(1);
		return resolver;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages/messages");
		source.setDefaultEncoding("UTF-8");
		return source;
	}

	@Bean(name = "multipartResolver")
	public MultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}

	@Bean(name = "viewResolver")
	public ViewResolver tilesViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(TilesView.class);
		resolver.setOrder(0);
		return resolver;
	}

	@Bean(name = "tilesConfigurer")
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions("/WEB-INF/templates/cland-template.xml", "/WEB-INF/templates/admin-template.xml");
		configurer.setCheckRefresh(true);
		return configurer;
	}
}