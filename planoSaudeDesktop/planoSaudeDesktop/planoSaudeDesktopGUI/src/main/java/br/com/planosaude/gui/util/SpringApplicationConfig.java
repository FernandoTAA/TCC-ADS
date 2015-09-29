package br.com.planosaude.gui.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "br.com.planosaude.gui.controller", "br.com.planosaude.service" , "br.com.planosaude.repository" })
public class SpringApplicationConfig {

}
