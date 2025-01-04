package com.pablopafundi.site;

import com.pablopafundi.site.myprofile.MyProfileService;
import com.pablopafundi.site.user.Role;
import com.pablopafundi.site.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SiteApplication {



	public static void main(String[] args) {SpringApplication.run(SiteApplication.class, args);}

	@Bean
	CommandLineRunner user(UserService userService, MyProfileService myProfileService) {
		return args -> {
			// Verificar si el usuario 'admin' ya existe en la base de datos
			if (!userService.userExistsByUserName("admin")) {
				// Crear el usuario admin utilizando el método del servicio
				userService.createUser("admin", "admin_password", Role.ADMIN);
				System.out.println("Usuario 'admin' creado correctamente.");
			} else {
				System.out.println("El usuario 'admin' ya existe.");
			}

		};
	}
}