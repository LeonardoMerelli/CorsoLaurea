package Es1;

import java.util.*;

public class Studente {

	Scanner in = new Scanner(System.in);
	Random generatore = new Random();
	
	private String nome;
	private ArrayList<Esami> listaEsami = new ArrayList<>();
	private String matricola;
	private int crediti;

	// Costruttore
	public Studente(String nome) {
		this.nome = nome;
		matricola = "S" + GeneraNumeroCauale();
	}

	public int GeneraNumeroCauale() {
		int minimo = 1000000; // numero minimo
		int massimo = 2000000; // numero massimo
		int numeroRandom = generatore.nextInt((massimo - minimo) + 1) + minimo;
		return numeroRandom;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Esami> getListaEsami() {
		return listaEsami;
	}

	public void setListaEsami(ArrayList<Esami> listaEsami) {
		this.listaEsami = listaEsami;
	}

	public String getMatricola() {
		return matricola;
	}

	public int getCrediti() {
		return crediti;
	}

	public void setCrediti(int crediti) {
		this.crediti += crediti;
	}
}
