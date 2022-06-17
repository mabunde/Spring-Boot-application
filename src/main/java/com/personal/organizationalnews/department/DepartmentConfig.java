package com.personal.organizationalnews.department;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DepartmentConfig {

    @Bean
    CommandLineRunner commandLineRunner(DepartmentRepository repository){
     return args -> {
             Department sales= new Department(
                         "Sales",
                         "Sales department",5,"Martin"
                     );

             Department procurement= new Department(
                     "procurement",
                     "procurement department" ,10,"Chege");

             Department casualWorkers= new Department(
                     "casualWorkers",
                     "casualWorkers department" ,3,"Eliud");
         repository.saveAll(List.of(
                 sales,procurement,casualWorkers));
     };

    };

}
