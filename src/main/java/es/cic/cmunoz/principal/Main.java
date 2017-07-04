/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.cic.cmunoz.principal;

import es.cic.cmunoz.backend.dominio.Curvas;
import es.cic.cmunoz.backend.repository.CurvasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

	@Autowired
	private CurvasRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Curvas(6, "soy un Cups", 7, "Soy una fecha", "Soy  un valor", "Soyun flag"));
		repository.save(new Curvas(9, "soy un Cups", 7, "Soy una fecha", "Soy  un valor", "Soyun flag"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Curvas curvaSacada : repository.findAll()) {
			System.out.println(curvaSacada);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with CUPS:");
		System.out.println("--------------------------------");
		System.out.println(repository.findbyCups("soy un Cups"));

		System.out.println("Customers found with FECHA:");
		System.out.println("--------------------------------");
		for (Curvas curvaSacada : repository.findbyFecha("Soy una fecha")) {
			System.out.println(curvaSacada);
		}

	}

}