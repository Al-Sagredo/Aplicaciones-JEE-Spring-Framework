package com.desafiolatam.sistemasolar;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		//crea una lista de lunas con sus atributos para cada planeta
		ArrayList<Luna> sinLunas = new ArrayList<Luna>();//este array sera usado para darselo a planetas sin lunas
		
		Luna luna = new Luna("Luna", 3476, 27322);
		ArrayList<Luna> lunasTierra = luna.agregarLunas(luna);
		
		Luna deimos = new Luna("Deimos", 8, 1263);
		Luna phobos = new Luna("Phobos", 22, 0.319);
		ArrayList<Luna> lunasMarte = luna.agregarLunas(deimos, phobos);
		
		Luna callisto = new Luna("Callisto", 4800, 16689);
		Luna europa = new Luna("Europa", 3126, 3551);
		ArrayList<Luna> lunasJupiter = luna.agregarLunas(europa, callisto);
		
		Luna titan = new Luna("Titan", 5150, 15945);
		Luna dione = new Luna("Dione", 1120, 2737);
		ArrayList<Luna> lunasSaturno = luna.agregarLunas(titan, dione);
		
		Luna oberon = new Luna("Oberon", 1526, 13463);
		Luna titania = new Luna("Titania", 1580, 8706);
		ArrayList<Luna> lunasUrano = luna.agregarLunas(oberon, titania);
		
		Luna triton = new Luna("Triton", 2705, 5877);
		Luna galatea = new Luna("Galatea", 140, 0.33);
		ArrayList<Luna> lunasNeptuno = luna.agregarLunas(triton, galatea);
	
		//los planetas son creados y sus array lunas le son inyectados
		Planeta mercurio = new Planeta("Mercurio", 4880,57910000, sinLunas);
		Planeta venus = new Planeta("Venus", 12104, 108200000, sinLunas);
		Planeta tierra = new Planeta("Tierra", 12756, 149600000, lunasTierra);
		Planeta marte = new Planeta("Marte", 6794, 227940000, lunasMarte);
		Planeta jupiter = new Planeta("Júpiter", 142984, 778330000, lunasJupiter);
		Planeta saturno = new Planeta("Saturno", 108728, 1429400000, lunasSaturno);
		Planeta urano = new Planeta("Urano", 51118, 2870990000L, lunasUrano);
		Planeta neptuno = new Planeta("Neptuno", 49532, 4504300000L, lunasNeptuno);
		
		//crea una lista de planetas donde agrega los planetas creados
		ArrayList<Planeta> planetas = new ArrayList<Planeta>();
		planetas.add(mercurio);
		planetas.add(venus);
		planetas.add(tierra);
		planetas.add(marte);
		planetas.add(jupiter);
		planetas.add(saturno);
		planetas.add(urano);
		planetas.add(neptuno);
		
		//Inyecta la lista creada a SistemaSolar
		SistemaSolar sistema = new SistemaSolar(planetas);
		
		//llama a los metodos de sistema solar
		sistema.mostrarPlanetas();
		sistema.infoLunas();
		

	}

}
