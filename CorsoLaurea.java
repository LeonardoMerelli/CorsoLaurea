package Es2;
import java.util.*;

public class CorsoLaurea 
{
	Scanner in = new Scanner(System.in);
	private String nome;
	private int mincrediti;
	protected ArrayList<Studente> listaStudenti;
	Studente s;

	public CorsoLaurea(String nome, int mincrediti)
	{
		this.nome = nome;
		this.mincrediti= mincrediti;
	}
	public void Menu(String nome)
	{
		int input;
		do 
		{
			do 
			{
				System.out.println('\n' + "Benvenuto nel corso di laurea di ingegneria " + nome + 
						'\n' +"Cosa vuoi fare" + '\n');
				System.out.println("1) Iscriviti");
				System.out.println("2) Crea piano di studio");
				System.out.println("3) Menu piano di studio");
				System.out.println("4) Rinuncia agli studi");
				System.out.println("0) Esci");
				input = in.nextInt();
			}while(input <= 0 && input >= 4);
			
			switch(input) 
			{
			case 1: 
				{
					System.out.println('\n' + "-> Nome studente:");
					String n =in.next(); 
					s = new Studente(n, 0);
					if(!s.Iscrizione(n,s))System.out.println('\n' + "-> Studente già presente" + '\n');
				};break;
			case 2: 
			    {
			    	System.out.println('\n' + "-> Nome studente:");
			    	if(!s.CreaPiano(in.next())) System.out.println('\n' + "-> Utente non iscritto" + '\n');
	
			    };break;
			case 3: 
			    {
			    	s.Menu2();
			    };break;
			case 4:
			    {
			    	System.out.println('\n' + "-> Nome studente:");
					String n = in.next();
					s.Ritira(n);
			    };break;
			case 0:return;
			}
		}while(true);
	
		
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public void checkLaurea(String nome)
	{
		for (int i = 0; i< listaStudenti.size();i++)
		{
		  if (listaStudenti.get(i).getNome().equals(nome))
		  {
			System.out.println("Congratulazioni "+ nome+ " ha concluso il suo piano carriera");
			Studente.listaStudenti.remove(i);
		  }
		}
	}
	

	public int getMincrediti() 
	{
		return mincrediti;
	}

	public void setMincrediti(int mincrediti) 
	{
		this.mincrediti = mincrediti;
	}
}
