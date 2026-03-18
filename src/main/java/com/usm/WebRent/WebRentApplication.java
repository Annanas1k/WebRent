package com.usm.WebRent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebRentApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebRentApplication.class, args);
	}}


//service - logica programului. Functiile de exemplu creare update delete si read. ca o clasa simpla
//repository - vorbeste cu baza de date, extinde jpaRepository
//entity - modelul in sine, tabelul de baza
//controller - apelam functionalul. cand primesti request - intelege ce sa execute