package ru.darksavant.omegacrmservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Omega CRM",
                version = "0.0",
                description = "The best CRM",
                license = @License(name = "Apache 2.0", url = "http://foo.bar"),
                contact = @Contact(url = "http://xxxxxx.com", name = "DarkSavant7", email = "xxxxx@xxxxx.com")
        )
)
@SpringBootApplication
public class OmegaCrmServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OmegaCrmServiceApplication.class, args);
    }

}
