package Es1;

import java.util.*;

public class Studente {

	Scanner in = new Scanner(System.in);
	private String nome;

	private ArrayList<Esami> listaEsami = new ArrayList<>();
	private static int ultimaMatricola = 1000000;
	private int matricola;
	private int crediti;

	// Costruttore
	public Studente(String nome) {
		this.nome = nome;
		matricola = ultimaMatricola;
		ultimaMatricola++;
	}

	// Menu per gestire la lista degli esami dello studente
	public void MenuEsami() {
		int input;
		do {
			do {
				System.out.println('\n' + "Benvenuto nel corso di laurea di ingegneria\nCosa vuoi fare" + '\n');
				System.out.println("1) Creare un piano di studio");
				System.out.println("2) Aggiungere un esame al piano di studio");
				System.out.println("3) Rimuovere un esame al piano di studio");
				System.out.println("4) Cercare un esame nel piano di studio");
				System.out.println("0) Esci");
				input = in.nextInt();
			} while (input <= 0 && input >= 4);

			switch (input) {
			case 1: {
				if (CreaPiano()) // FATTO - boolean
					System.out.println("Piano aggiunto");
				else
					System.out.println("Piano già presente");
			}
				;
				break;
			case 2: {
				System.out.println("Inserire il nome dell'esame e i crediti da aggiungere al piano di studio");
				String nome = in.next();
				int crediti = in.nextInt();
				if (AggiungiEsame(nome, crediti)) // FATTO - boolean
					System.out.println("Esame aggiunto");
				else
					System.out.println("Esame già presente nel piano di studio");
			}
				;
				break;
			case 3: {
				System.out.println("Inserire il nome dell'esame da rimuovere dal piano di studio");
				String nome = in.next();
				if (RimuoviEsame(nome))
					System.out.println("Esame rimosso");
				else
					System.out.println("Esame non presente nel piano di studio");
			}
				;
				break;
			case 4: {
				System.out.println("Inserire il nome dell'esame da cercare nel piano di studio");
				String nome = in.next();
				if (CercaEsame(nome))
					System.out.println("Esame presente nel piano di studi");
				else
					System.out.println("Esame non presente nel piano di studio");
			}
				;
				break;
			case 0:
				return;
			}
		} while (true);
	}

	// Crea un piano tramite il metodo 'AggiungiEsame' chiamato ripetutamente fino
	// alla fine del ciclo
	public boolean CreaPiano() {
		int risposta;
		if (listaEsami.size() == 0) {
			do {
				System.out.println("Inserire il nome dell'esame ed i crediti");
				String nome = in.next();
				int crediti = in.nextInt();
				if (AggiungiEsame(nome, crediti))
					System.out.println("Esame aggiunto");
				System.out.println("Vuole continuare ad inserire esami? [0/1]");
				risposta = in.nextInt();
			} while (risposta == 0);
			return true;
		}
		return false;
	}

	// Metodo per l'aggiunta di un'esame
	public boolean AggiungiEsame(String nome, int crediti) {
		int voto = 0;
		if (!CercaEsame(nome)) {
			listaEsami.add(new Esami(nome, crediti, voto));
			return true;
		} else
			return false;
	}

	// Rimuove l'esame se è presente nella lista
	public boolean RimuoviEsame(String nome) {
		for (int i = 0; i < listaEsami.size(); i++)
			if (listaEsami.get(i).getNome().equals(nome)) {
				listaEsami.remove(i);
				return true;
			}
		return false;
	}

	// Cerca un'esame all'interno della lista, se è presente resituisce vero
	public boolean CercaEsame(String nome) {
		for (int i = 0; i < listaEsami.size(); i++)
			if (listaEsami.get(i).getNome().equals(nome))
				return true;
		return false;
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

	public static int getUltimaMatricola() {
		return ultimaMatricola;
	}

	public static void setUltimaMatricola(int ultimaMatricola) {
		Studente.ultimaMatricola = ultimaMatricola;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public int getCrediti() {
		return crediti;
	}

	public void setCrediti(int crediti) {
		this.crediti += crediti;
	}
}
