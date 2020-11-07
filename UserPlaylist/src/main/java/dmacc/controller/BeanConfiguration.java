package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Playlist;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Playlist playlist() {
		Playlist bean = new Playlist();
		return bean;
	}
}
