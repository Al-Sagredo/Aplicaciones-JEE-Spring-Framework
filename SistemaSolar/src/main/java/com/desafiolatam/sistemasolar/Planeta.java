package com.desafiolatam.sistemasolar;

import java.util.ArrayList;

public class Planeta implements IPlaneta{

	String nombre;
	int tamanio;
	long distanciaSol;
	ArrayList<Luna> lunas;

	public Planeta(String nombre, int tamanio, long distanciaSol, ArrayList<Luna> lunas) {
		super();
		this.nombre = nombre;
		this.tamanio = tamanio;
		this.distanciaSol = distanciaSol;
		this.lunas = lunas;
	}

	public Planeta() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	public double getDistanciaSol() {
		return distanciaSol;
	}

	public void setDistanciaSol(long distanciaSol) {
		this.distanciaSol = distanciaSol;
	}

	public ArrayList<Luna> getLunas() {
		return lunas;
	}

	public void setLunas(ArrayList<Luna> lunas) {
		this.lunas = lunas;
	}

	@Override
	public String toString() {
		return "El planeta " + nombre + " está a " + distanciaSol + " km del sol, su tamaño es de " + tamanio
				+ " km de diámetro y tiene " + lunas.size() + " luna(s)";
	}

}
