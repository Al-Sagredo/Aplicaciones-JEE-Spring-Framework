package com.desafiolatam.sistemasolar;

import java.util.ArrayList;

public class SistemaSolar {

	ArrayList<Planeta> planetas;

	public SistemaSolar(ArrayList<Planeta> planetas) {
		super();
		this.planetas = planetas;

	}
	
	public SistemaSolar() {
		super();
	}



	// recorre el array de planetas mostrando sus datos mediante toString
	public void mostrarPlanetas() {
		for (Planeta planeta : planetas) {
			System.out.println(planeta.toString());
		}
		System.out.println("");
	}

	// recorre el array de planetas obteniendo para cada uno su nombre y su array de lunas
	public void infoLunas() {
		for (Planeta planeta : planetas) {

			System.out.println(planeta.getNombre() + " :");

			ArrayList<Luna> lunas = planeta.getLunas();

			// verifica que el planeta tenga lunas
			if (lunas.size() == 0) {
				System.out.println("No tiene lunas");
			} else {
				for (Luna luna : lunas) {//recorre el array de lunas obteniendo su info mediante toString
					System.out.println(luna.toString());
				}

			}
			System.out.println("");
		}
	}
}
