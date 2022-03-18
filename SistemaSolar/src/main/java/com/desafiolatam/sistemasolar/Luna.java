package com.desafiolatam.sistemasolar;

import java.util.ArrayList;

public class Luna implements ILuna {

	String nombre;
	int diametro;
	double tiempoOrbita;
	
	public ArrayList<Luna> agregarLunas(Luna... lunas){
		
		ArrayList<Luna> listaLunas = new ArrayList<Luna>();
		for (Luna luna : lunas) {
			listaLunas.add(luna);
		}	
		return listaLunas;
	}
	
	public Luna() {
		super();
	}

	public Luna(String nombre, int diametro, double tiempoOrbita) {
		super();
		this.nombre = nombre;
		this.diametro = diametro;
		this.tiempoOrbita = tiempoOrbita;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDiametro() {
		return diametro;
	}

	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}

	public double getTiempoOrbita() {
		return tiempoOrbita;
	}

	public void setTiempoOrbita(int tiempoOrbita) {
		this.tiempoOrbita = tiempoOrbita;
	}

	@Override
	public String toString() {
		return "Luna de nombre " + nombre + " que mide " + diametro + " km de diámetro y el tiempo de órbita es de " + tiempoOrbita + " días";
	}
	
	
	
}
