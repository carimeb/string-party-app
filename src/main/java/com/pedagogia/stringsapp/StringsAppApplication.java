package com.pedagogia.stringsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StringsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsAppApplication.class, args);
	}
    //não esquecer de trocar o escopo do tomcat de "provided" para "compile" no pom.xml
}
