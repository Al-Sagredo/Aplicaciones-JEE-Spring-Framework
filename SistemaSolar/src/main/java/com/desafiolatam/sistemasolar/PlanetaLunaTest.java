package com.desafiolatam.sistemasolar;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class PlanetaLunaTest {

	private final Luna luna = new Luna();

	@Test
	public void testAgregarLunas() {
		Luna lunaTest = new Luna("Callisto", 4800, 16689);
		ArrayList<Luna> listaLunasTest = luna.agregarLunas(lunaTest);
		assertEquals(1, listaLunasTest.size());
		
		ArrayList<Luna> listaLunasTest2 = new ArrayList<Luna>();
		listaLunasTest2.add(lunaTest);
		assertTrue(listaLunasTest.get(0) == listaLunasTest2.get(0));
		
	}

	@Test
	public void testNombrePlanetas() {
		Planeta testPlaneta = new Planeta("test", 1, 1, null);
		ArrayList<Planeta> listaTest = new ArrayList<Planeta>();
		listaTest.add(testPlaneta);
		assertNotNull(listaTest.get(0).getNombre());
	}

	@Test
	public void testNumeroLunas() {
		Luna lunaTest = new Luna("x", 1, 1);
		Luna lunaTest2 = new Luna("y", 2, 2);
		ArrayList<Luna> listaLunasTest = luna.agregarLunas(lunaTest, lunaTest2);
		Planeta planetaTest = new Planeta();
		planetaTest.setLunas(listaLunasTest);
		assertTrue(planetaTest.getLunas().size() == 2);
		
	}
	
}
