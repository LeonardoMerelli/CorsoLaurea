package Es1;

import java.util.*;

public class Esami {
	Scanner in = new Scanner(System.in);
	private String nome;
	private int crediti;
	private int voto;

	// Costruttore
	public Esami(String nome, int crediti, int voto) {
		this.nome = nome;
		this.crediti = crediti;
		this.voto = voto;
	}

	// Getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public int getCrediti() {
		return crediti;
	}

	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}
}
