package Es2;

import java.util.*;



public class Studente 
{
	Scanner in = new Scanner (System.in);
	private String nome;
	
	protected static ArrayList<Studente> listaStudenti= new ArrayList<>();
	protected static ArrayList<Studente> listaStudentiLaureati= new ArrayList<>();
	
	private static int matricola = 1000000;
	private int matricolaStu;
	private int creditiStu;
	
	Esami e;
	
	public Studente(String nome, int crediti) 
	{
		this.nome = nome;
        this.matricolaStu= matricola;
        matricola++;
        creditiStu = crediti;
	}
	
	public boolean Iscrizione(String nome, Studente s)
	{
		if (CercaS(nome))return false;
	    listaStudenti.add(s);
		return true;
	}
	
	public boolean CercaS(String nome)
	{
		for (int i = 0; i<listaStudenti.size();i++)
		{
		  if (listaStudenti.get(i).getNome().equals(nome)) return true;
		}
		return false;
	}

	public boolean Ritira(String nome)
	{
		for (int i = 0; i<listaStudenti.size(); i++)
		{
			if (listaStudenti.get(i).getNome().equals(nome)) 
				{
				  listaStudenti.remove(i);		
				  return true;
				}
		}
		return false;
	}
	
	public boolean CreaPiano (String nome)
	{
		int input;
		if (CercaS(nome)) 
		{
		for (int i = 0;i<listaStudenti.size();i++)
		{
			if (listaStudenti.get(i).getNome().equals(nome)) 
			{
				do 
				{
					System.out.println("-> Nome dell'esame:");
					String nomeEsame = in.next();
					
					System.out.println("-> Crediti dell'esame:");
					int creditiEsame = in.nextInt();
					
					e = new Esami(nomeEsame, creditiEsame,0);
					if (!e.CercaE(nomeEsame)) e.AggiungiEsame(nomeEsame,creditiEsame,i);
					
					else System.out.println("-> Esame gia presente:" + '\n');
					System.out.println('\n'+"1) Continua");
					System.out.println("0) Torna al menu");
					input = in.nextInt();
				}while(input != 0);
			  return true;
			}
		}
		}
		return false;
		
	}

	public void VisualizzaStudenti()
	{
		for (int i = 0; i<listaStudenti.size();i++)
	    {
			
	    System.out.println("-> Nome: " + listaStudenti.get(i).getNome() + '\n' + "   Matricola: " + listaStudenti.get(i).getMatricola() +
	    		'\n' + "   Crediti totoali: " + listaStudenti.get(i).getCreditiStu() );
	    if(Esami.listaEsami!= null)
	    {
	    	for (int j= 0; j< Esami.listaEsami.size();j++)
	    	{
	    	
	    		if (!e.controlloVoto(Esami.listaEsami.get(j).getVoto()))  
	    			System.out.println("-> Nome esame: " + Esami.listaEsami.get(j).getNome() + 
	    					'\n' + "	-> Crediti esame: " + Esami.listaEsami.get(j).getCrediti() + 
	    					'\n' + "	-> Voto esame: ESAME NON FATTO");
	    		else System.out.println("-> Nome esame: " + Esami.listaEsami.get(j).getNome() + 
	    				'\n' + "	-> Crediti esame: " + Esami.listaEsami.get(j).getCrediti() + 
	    				'\n' + "	-> Voto esame: " + Esami.listaEsami.get(j).getVoto());
	    	}
	    }
	    else System.out.println("Piano di studio vuoto");
	}
	}
	
	/*public void VisualizzaLaureati()
	{
		//controlo per studetni con crediti giusti
		for (int i = 0; i<listaStudenti.size();i++)
	    {
			if (listaStudenti.get(i).getCrediti() > 179) //crediti di un singolo studente
			{
				System.out.println("-> Nome: " + listaStudenti.get(i).getNome() + '\n' + "-> Matricola: " + listaStudenti.get(i).getMatricola());
	  
				for (int j= 0; j< e.listaEsami.size();j++)
				{
	    	
					if (e.controlloVoto(e.listaEsami.get(j).getVoto()))  
						System.out.println("-> Nome esame: " + e.listaEsami.get(j).getNome() + 
								'\n' + "-> Crediti esame: " + e.listaEsami.get(j).getCrediti() + 
								'\n' + "-> Voto esame: ESAME NON FATTO");
					else System.out.println("-> Nome esame: " + e.listaEsami.get(j).getNome() + 
							'\n' + "-> Crediti esame: " + e.listaEsami.get(j).getCrediti() + 
							'\n' + "-> Voto esame: " + e.listaEsami.get(j).getVoto());
				}
			}
	    }
		
	}*/
	
	
	

	public void Menu2()
	{
		int input;
		do 
		{
			do 
			{
				System.out.println('\n' + "Menu Piano Di Studio" + '\n' +"Cosa vuoi fare" + '\n');
				System.out.println("1) Aggingi esame");
				System.out.println("2) Cerca esame");
				System.out.println("3) Rimuovi esame");
				System.out.println("4) Promozione");
				System.out.println("5) Visualizza Studenti");
				System.out.println("6) Visualizza Laureati");
				System.out.println("0) Esci");
				input = in.nextInt();
			}while(input <= 0 && input >= 4);
			
			switch(input) 
			{
			case 1: 
				{
					System.out.println ("Quale esame vuoi aggiungere al piano ?");
					String nome= in.next();
					System.out.println ("Crediti del dato esame:");
					int crediti = in.nextInt();
					e.AggiungiEsame(nome, crediti);	
				};break;
			case 2: 
			    {
			    	System.out.println ("Quale esame vuoi cercare ?");
			    	String nome= in.next();
			    	e.CercaEsame(nome);
			    };break;
			case 3: 
			    {
			    	System.out.println ("Quale esame vuoi cercare ?");
			    	String nome= in.next();
			    	e.RimuoviEsame(nome);
			    };break;
			case 4:
			    {
			    	int voto;
			    	do
			    	{
			    		System.out.println ("Quale esame Hai passato?");
				    	String nome= in.next();
				    	System.out.println ("Voto:");
				    	voto= in.nextInt();
				    	switch (e.Promozione(nome, voto))
				    	{
				    	case 0: System.out.println ("Esame non presente nella lista esami!!!");break;
				    	case 1: System.out.println ("Voto non permesso!!!"); break;
				    	case 2:break;
				    	}
			    	}while (e.Promozione(nome, voto) != 2);
			    	
			    };break;   
			case 5:
		    {
		    	VisualizzaStudenti();
		    };break;
			case 6:
		    {
		    	//VisualizzaLaureati();
		    };break;
		    
			case 0:return;
			}
		}while(true);

	}
	
	
	public static int getCreditiStu() { return creditiStu; }

	public static void setCreditiStu(int crediti) { creditiStu = crediti; }
	
	public String getNome() { return nome; } 

	public void setNome(String nome) { this.nome = nome; }

	public int getMatricola() { return matricolaStu; }
}
