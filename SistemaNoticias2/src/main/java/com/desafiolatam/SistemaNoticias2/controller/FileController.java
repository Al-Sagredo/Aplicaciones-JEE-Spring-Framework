package com.desafiolatam.SistemaNoticias2.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileController {

	private final static Logger logger = LoggerFactory.getLogger(FileController.class);

	@GetMapping("/")
	public String greeting(Model modelo) {
		
		String hola = "hola";
		modelo.addAttribute("nombre2", hola);
		String nombre = "src/main/resources/static/noticias.txt";
		ArrayList<String> p = new ArrayList<String>();
		
		try {
			FileReader fr = new FileReader(nombre);
			BufferedReader br = new BufferedReader(fr);
			String data = br.readLine();

			while (data != null) {//separa el texto por lineas y las agrega al arrayList
				p.add(data);
				data = br.readLine();
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			logger.error("Error leyendo el fichero " + nombre + ": " + e);
		}
		
		String [] noticiaArr;
		List<String> noticias = new ArrayList<String>();
		
		for(int i =0; i < p.size(); i++) { //separa las lineas por @@ y las agrega a un nuevo arrayList
			noticiaArr = p.get(i).split("@@");
			noticias.addAll(Arrays.asList(noticiaArr));
		}
		String url1 = noticias.get(2);
		String url2 = noticias.get(6);
		String url3 = noticias.get(10);
		String url4 = noticias.get(14);
		String url5 = noticias.get(18);
		String titulo1 = noticias.get(0);
		String titulo2 = noticias.get(4);
		String titulo3 = noticias.get(8);
		String titulo4 = noticias.get(12);
		String titulo5 = noticias.get(16);
		String cuerpo1 = noticias.get(1);
		String cuerpo2 = noticias.get(5);
		String cuerpo3 = noticias.get(9);
		String cuerpo4 = noticias.get(13);
		String cuerpo5 = noticias.get(17);
		
		
		modelo.addAttribute("url1", url1);
		modelo.addAttribute("url2", url2);
		modelo.addAttribute("url3", url3);
		modelo.addAttribute("url4", url4);
		modelo.addAttribute("url5", url5);
		modelo.addAttribute("cuerpo1", cuerpo1);
		modelo.addAttribute("cuerpo2", cuerpo2);
		modelo.addAttribute("cuerpo3", cuerpo3);
		modelo.addAttribute("cuerpo4", cuerpo4);
		modelo.addAttribute("cuerpo5", cuerpo5);
		modelo.addAttribute("titulo1", titulo1);
		modelo.addAttribute("titulo2", titulo2);
		modelo.addAttribute("titulo3", titulo3);
		modelo.addAttribute("titulo4", titulo4);
		modelo.addAttribute("titulo5", titulo5);
		
		return "index";
	}
}
