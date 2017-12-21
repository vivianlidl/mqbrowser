package com.ibm.eshub.mqbrowser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.ibm.eshub.mqbrowser.entity.data.User;
import com.ibm.eshub.mqbrowser.entity.repository.UserRepository;
 
 
@SpringBootApplication
//(scanBasePackages={"com.ibm.eshub.qmbrowser"})
@EnableScheduling
@EnableCaching
public class MQBrowserApplication   extends SpringBootServletInitializer {
	
	private static final Logger log = LoggerFactory.getLogger(MQBrowserApplication.class);
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MQBrowserApplication.class);
    }
	 
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MQBrowserApplication.class, args);
        
    }
    
    @Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			// save a couple of customers
			/*User user = new User();
			user.setUsername("lixiaow");
			user.setPassword("password");
			Role role = new Role();
			Set<Role> roles = new HashSet<Role>();
			role.setName("user");
			roles.add(role);
			Role role2 = new Role();
			role2.setName("admin");
			roles.add(role2);
			roleRepository.save(roles);
 
			
			roles.add(role);
			roles.add(role2);
			user.setRoles(roles);
			repository.save(user);
			 */
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (User users : repository.findAll()) {
				log.info(users.toString());
			}
            log.info("");

			 
            log.info("");
		};
	}
}
