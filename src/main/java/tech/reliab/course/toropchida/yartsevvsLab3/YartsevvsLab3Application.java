package tech.reliab.course.toropchida.yartsevvsLab3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;
import tech.reliab.course.toropchida.yartsevvsLab3.entity.Bank;
import tech.reliab.course.toropchida.yartsevvsLab3.entity.BankOffice;
import tech.reliab.course.toropchida.yartsevvsLab3.service.BankService;
import tech.reliab.course.toropchida.yartsevvsLab3.serviceImpl.BankServiceImpl;

import java.util.List;

@SpringBootApplication
public class YartsevvsLab3Application {

	public static void main(String[] args) {
		SpringApplication.run(YartsevvsLab3Application.class, args);

		out();
	}

	public static void out(){

	}
}
