package Es1;

import java.util.*;

public class CorsoLaurea {
	Scanner in = new Scanner(System.in);
	private String nome;
	private int mincrediti;
	private ArrayList<Studente> listaStudenti = new ArrayList<>();

	// Costruttore classe corso laurea
	public CorsoLaurea(String nome, int mincrediti) {
		this.nome = nome;
		this.mincrediti = mincrediti;
	}

	// Menu che appare dopo aver scelto il corso di laurea, gestisce ogni operazione
	// riguardante lo studente
	public void Menu(String nome) {
		int input;
		do {
			do {
				System.out.println(
						'\n' + "Benvenuto nel corso di laurea di ingegneria " + nome + '\n' + "Cosa vuoi fare" + '\n');
				System.out.println("1) Iscriviti");
				System.out.println("2) Menu studente");
				System.out.println("3) Visualizza studenti");
				System.out.println("4) Cercare uno studente");
				System.out.println("5) Ritirare uno studente");
				System.out.println("6) Laureare uno studente");
				System.out.println("7) Promuovere uno studente");
				System.out.println("8) Visualizza gli esami sostenuti dallo studente");
				System.out.println("0) Esci");
				input = in.nextInt();
			} while (input <= 0 && input >= 8);

			switch (input) {
			case 1: {
				System.out.println("Inserire il nome dello studente");
				String nomeStudente = in.next();
				if (Iscrizione(nomeStudente)) // FATTO
					System.out.println("Studente inserito");
			}
				;
				break;
			case 2: {
				System.out.println("Inserire il nome dello studente");
				String nomeStudente = in.next();
				if (MenuStudente(nomeStudente))
					MenuEsami(nomeStudente);
			}
				;
				break;
			case 3: {
				System.out.println("Vuole vedere gli studenti iscritti o laureati a questo corso di laurea?");
				int risposta = in.nextInt();
				if (risposta == 0)
					VisualizzaStudentiIscritti(); // FATTO - void
				else
					VisualizzaStudentiLaureati(); // FATTO - void
			}
				;
				break;
			case 4: {
				System.out.println('\n' + "-> Nome studente:");
				String n = in.next();
				System.out.println("L'utente " + n + " è presente in questo corso laurea con "
						+ listaStudenti.get(CercaStudente(n)).getCrediti() + " crediti ");
			}
				;
				break;
			case 5: {
				System.out.println('\n' + "-> Nome studente:");
				String n = in.next();
				if (RitirareStudente(n)) // FATTO - boolean
					System.out.println("Studente " + n + " ritirato");
			}
				;
				break;
			case 6: {
				System.out.println('\n' + "-> Nome studente:");
				String n = in.next();
				if (LaureareStudente(n)) // FATTO - boolean
					System.out.println("Studente laureato");
				else
					System.out.println(
							"Lo studente " + n + " non ha raggiunto ancora il minimo di crediti per laurearsi");
			}
				;
				break;
			case 7: {
				System.out.println('\n' + "-> Nome studente:");
				String n = in.next();
				System.out.println("Esame e voto ottenuto:");
				String e = in.next();
				int voto = in.nextInt();
				PromuovereStudente(n, e, voto); // FATTO - void
			}
				;
				break;
			case 8: {
				System.out.println('\n' + "-> Nome studente:");
				String n = in.next();
				VisualizzaEsami(n); // FATTO - void
			}
				;
				break;
			case 0:
				return;
			}
		} while (true);

	}

	// Crea un nuovo studente e lo aggiunge nell'array listaStudenti
	public boolean Iscrizione(String nome) {
		if (!CercaNome(nome)) {
			listaStudenti.add(new Studente(nome));
			return true;
		}
		return false;

	}

	// Menu che permette l'iterazione con tutte le operazioni riguardanti gli esami
	public boolean MenuStudente(String nome) {
			if (CercaNome(nome))
				return true;
			else
				System.out.println("Lo studente non è iscritto a questo corso di laurea");
		return false;
	}

	// Stampa gli studenti che sono presenti nella lista
	public void VisualizzaStudentiIscritti() {
		for (int i = 0; i < listaStudenti.size(); i++) {
			if (!CercaNome(nome))
				System.out.println("-> Nome: " + listaStudenti.get(i).getNome() + '\n' + "   Matricola: "
						+ listaStudenti.get(i).getMatricola() + '\n' + "   Crediti totoali: "
						+ listaStudenti.get(i).getCrediti());
		}
	}

	// Stampa gli studenti che sono presenti nella lista e che hanno almeno 180
	// crediti, successivamente li rimuove dalla lista studenti
	public void VisualizzaStudentiLaureati() {
		for (int i = 0; i < listaStudenti.size(); i++) {
			if (!CercaNome(listaStudenti.get(i).getNome()) && listaStudenti.get(i).getCrediti() >= this.mincrediti) {
				System.out.println("-> Nome: " + listaStudenti.get(i).getNome() + '\n' + "   Matricola: "
						+ listaStudenti.get(i).getMatricola() + '\n' + "   Crediti totoali: "
						+ listaStudenti.get(i).getCrediti());
				listaStudenti.remove(i);
			} else
				System.out.println("Non sono presenti studenti laureati");
		}
	}

	// Controlla se lo studente è presente nella lista e ne restituisce la posizione
	public int CercaStudente(String nomeStudente) {
		for (int i = 0; i < listaStudenti.size(); i++)
			if (CercaNome(nomeStudente))
				return i;
		return -1;
	}

	// Passo il nome dello studente, se è presente nella lista lo cancello
	public boolean RitirareStudente(String nome) {
		for (int i = 0; i < listaStudenti.size(); i++)
			if (listaStudenti.get(i).getNome().equals(nome)) {
				listaStudenti.remove(i);
				return true;
			}
		return false;
	}

	// Passo il nome dello studente, se è presente nella lista ed ha più di 180
	// crediti -> restituisco vero
	public boolean LaureareStudente(String nome) {
		for (int i = 0; i < listaStudenti.size(); i++)
			if (listaStudenti.get(i).getCrediti() >= 180)
				return true;
		return false;
	}

	// Passo il nome dello studente, il nome dell'esame e il voto dell'esame
	// Controllo se lo studente è presente
	// Controllo se ha esami -> se non li ha chiedo se vuole creare un piano di
	// studio
	// Controllo se l'esame è presente -> se non c'è chiedo se vuole aggiungerlo al
	// piano di studio
	// Prendo l'esame con lo stesso nome
	// Setto il voto per quello specifico esame
	// Setto i crediti -> li vado ad incrementare a quelli che lo studente ha
	// Infine Dio por*o spero che funziona perchè non ce metto più le mani
	public void PromuovereStudente(String nome, String e, int voto) {
		boolean flag = true; // mi serve per controllo se l'esame è presente
		boolean flag1 = true; // mi serve per controllo se lo srudente è presente
		for (int i = 0; i < listaStudenti.size(); i++) {
			if (listaStudenti.get(i).getNome().equals(nome)) {
				flag1 = false;
				if (listaStudenti.get(i).getListaEsami().size() != 0) {
					for (int j = 0; j < listaStudenti.get(i).getListaEsami().size(); j++) {
						if (listaStudenti.get(i).getListaEsami().get(j).getNome().equals(e)) {
							listaStudenti.get(i).getListaEsami().get(j).setVoto(voto);
							System.out.println("Studente " + nome + " promosso all'esame di " + e + " con " + voto);
							listaStudenti.get(i).setCrediti(listaStudenti.get(i).getListaEsami().get(j).getCrediti());
							flag = false;
						}
					}
					if (flag) {
						System.out.println("Esame non presente nel piano di studio");
						System.out.println("Vuoi aggiungere questo esame al piano di studio? [0/1]");
						int risposta = in.nextInt();
						if (risposta == 0) {
							System.out.println("Inserire i crediti dell'esame " + nome);
							int crediti = in.nextInt();
							if (AggiungiEsame(listaStudenti.get(i).getNome(), nome, crediti))
								System.out.println("Esame aggiunto");
						}
					}
				} else {
					System.out.println("Piano di studio vuoto");
					System.out.println("Vuoi crearlo? [0/1]");
					int risposta = in.nextInt();
					if (risposta == 0)
						if (CreaPiano(listaStudenti.get(i).getNome()))
							System.out.println("Piano creato");
				}
			}
		}
			if (flag1) {
				System.out.println("Studente non presente nella lista, vuoi aggiungerlo? [0/1]");
				int risposta = in.nextInt();
				if (risposta == 0)
					if (Iscrizione(nome))
						System.out.println("Studente creato");
			}
	}

	// Passo il nome dello studente
	// Controllo se lo studente è presente -> se non è presente chiedo se vuole
	// aggiungerlo
	// Controllo se ha esami -> se non li ha chiedo se vuole creare un piano di
	// studio
	// Stampo tutti gli esami con il ciclo for
	// Stampo i crediti totali dello studente che sarebbe l'attributo 'crediti'
	// dello studente
	// Calcolo la media dei voti e la stampo
	public void VisualizzaEsami(String nome) {
		boolean flag = true;
		for (int i = 0; i < listaStudenti.size(); i++)
			if (listaStudenti.get(i).getNome().equals(nome)) {
				flag = false;
				if (listaStudenti.get(i).getListaEsami().size() != 0) {

					System.out.println(nome + " ha sostenuto i seguenti esami");
					for (int j = 0; j < listaStudenti.get(i).getListaEsami().size(); j++)
						if( listaStudenti.get(i).getListaEsami().get(j).getVoto() != 0)
						System.out.println(listaStudenti.get(i).getListaEsami().get(j).getNome());

					System.out.println("Ha un totale di " + listaStudenti.get(i).getCrediti() + " crediti");
					System.out.println("Con una media voto: " + MediaVotiStudentePonderata(nome));
				} else {
					System.out.println("Piano di studio vuoto");
					System.out.println("Vuoi crearlo? [0/1]");
					int risposta = in.nextInt();
					if (risposta == 0)
						if (CreaPiano(listaStudenti.get(i).getNome()))
							System.out.println("Piano creato");
				}
			} 
			if(flag) {
				System.out.println("Studente non presente nella lista, vuoi aggiungerlo? [0/1]");
				int risposta = in.nextInt();
				if (risposta == 0)
					if (Iscrizione(nome))
						System.out.println("Studente creato");
			}
	}

	// Serve per controllare se un nome di uno studente è presente nella lista
	public boolean CercaNome(String nome) {
		for (int i = 0; i < listaStudenti.size(); i++)
			if (listaStudenti.get(i).getNome().equals(nome))
				return true;
		return false;
	}

	// Calcola la media ponderata dei voti dello studente, passo in input il nome ed
	// eseguo il controllo, non verifico se esiste lo studente o l'esame visto che
	// l'ho fatto già prima della chiamata alla funzione
	public float MediaVotiStudentePonderata(String nome) {
		int sommaVoti = 0;
		float media = 0;
		for (int i = 0; i < listaStudenti.size(); i++)
			if (listaStudenti.get(i).getNome().equals(nome)) {
				for (int j = 0; j < listaStudenti.get(i).getListaEsami().size(); j++)
					sommaVoti = sommaVoti + (listaStudenti.get(i).getListaEsami().get(j).getVoto()
							* listaStudenti.get(i).getListaEsami().get(j).getCrediti());
				media = (float) sommaVoti / listaStudenti.get(i).getCrediti();
			}
		return media;
	}

	// Menu per gestire la lista degli esami dello studente
	public void MenuEsami(String nomeStudente) {
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
				if (CreaPiano(nomeStudente)) // FATTO - boolean
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
				if (AggiungiEsame(nomeStudente, nome, crediti)) // FATTO - boolean
					System.out.println("Esame aggiunto");
				else
					System.out.println("Esame già presente nel piano di studio");
			}
				;
				break;
			case 3: {
				System.out.println("Inserire il nome dell'esame da rimuovere dal piano di studio");
				String nome = in.next();
				if (RimuoviEsame(nomeStudente, nome))
					System.out.println("Esame rimosso");
				else
					System.out.println("Esame non presente nel piano di studio");
			}
				;
				break;
			case 4: {
				System.out.println("Inserire il nome dell'esame da cercare nel piano di studio");
				String nome = in.next();
				if (CercaEsame(nomeStudente, nome))
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
	public boolean CreaPiano(String nomeStudente) {
		int risposta;
		for (int i = 0; i < listaStudenti.size(); i++)
			if (listaStudenti.get(i).getNome().equals(nomeStudente))
				if (listaStudenti.get(i).getListaEsami().size() == 0) {
					do {
						System.out.println("Inserire il nome dell'esame ed i crediti");
						String nome = in.next();
						int crediti = in.nextInt();
						if (AggiungiEsame(nomeStudente, nome, crediti))
							System.out.println("Esame aggiunto");
						System.out.println("Vuole continuare ad inserire esami? [0/1]");
						risposta = in.nextInt();
					} while (risposta == 0);
					return true;
				}
		return false;
	}

	// Metodo per l'aggiunta di un'esame
	public boolean AggiungiEsame(String nomeStudente, String nome, int crediti) {
		int voto = 0;
		for (int i = 0; i < listaStudenti.size(); i++) {
			if (listaStudenti.get(i).getNome().equals(nomeStudente))
				if (!CercaEsame(nomeStudente, nome)) {
					listaStudenti.get(i).getListaEsami().add(new Esami(nome, crediti, voto));
					return true;
				}
		}
		return false;
	}

	// Rimuove l'esame se è presente nella lista
	public boolean RimuoviEsame(String nomeStudente, String nome) {
		for (int i = 0; i < listaStudenti.size(); i++) {
			if (listaStudenti.get(i).getNome().equals(nomeStudente))
				for (int j = 0; j < listaStudenti.get(i).getListaEsami().size(); j++)
					if (listaStudenti.get(i).getListaEsami().get(i).getNome().equals(nome)) {
						listaStudenti.get(i).getListaEsami().remove(i);
						return true;
					}
		}
		return false;
	}

	// Cerca un'esame all'interno della lista, se è presente resituisce vero
	public boolean CercaEsame(String nomeStudente, String nome) {
		for (int i = 0; i < listaStudenti.size(); i++) {
			if (listaStudenti.get(i).getNome().equals(nomeStudente))
				for (int j = 0; j < listaStudenti.get(i).getListaEsami().size(); j++)
					if (listaStudenti.get(i).getListaEsami().get(j).getNome().equals(nome))
						return true;
		}
		return false;
	}

	// Getter e setter
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMincrediti() {
		return mincrediti;
	}

	public void setMincrediti(int mincrediti) {
		this.mincrediti = mincrediti;
	}

	public ArrayList<Studente> getListaStudenti() {
		return listaStudenti;
	}

	public void setListaStudenti(ArrayList<Studente> listaStudenti) {
		this.listaStudenti = listaStudenti;
	}
}
