package ru.edu.caldav_demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import net.fortuna.ical4j.model.Calendar;
import org.mnode.ical4j.serializer.JCalSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

	@Bean
	public ObjectMapper objectMapper() {
		SimpleModule module = new SimpleModule();
		module.addSerializer(Calendar.class, new JCalSerializer(Calendar.class));
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(module);
		return mapper;
	}

}
