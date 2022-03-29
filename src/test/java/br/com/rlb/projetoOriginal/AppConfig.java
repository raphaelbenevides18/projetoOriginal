package br.com.rlb.projetoOriginal;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"br.com.rlb.projetoOriginal",
							   "br.com.rlb.projetoOriginal.resources",
							   "br.com.rlb.projetoOriginal.service",
							   "br.com.rlb.projetoOriginal.repository", 
							   "br.com.rlb.projetoOriginal.entity" })
public class AppConfig {

}
