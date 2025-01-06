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


}