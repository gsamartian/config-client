package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
	
	
	
	@Value("${name:noname}")
	private String name;
	
	@GetMapping("/home")
	public String getHome(){
		return "welcome:" + name;
	}
	
	@GetMapping("/names/{id}")
	public String getNames(@PathVariable("id") Integer id) throws Exception{
		if(id==1){
			throw new EntityNotFoundException(String.class, "id", id.toString());
		}else{
			return "name list is 100";
		}
		
	}
	
	@GetMapping("/surnames/{id}")
	public String getSurnames(@PathVariable("id") int id) throws Exception{
		if(id==1){
			return "value is;" + id/0;
		}else{
			return "name list is 100";
		}
		
	}
	
	@GetMapping("/checkme/{name}")
	public String getSurnames(@PathVariable("name") String name) throws Exception{
		String muname=null;
		return muname.substring(1, 2);
		
	}
}
