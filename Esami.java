package Es2;
import java.util.*;

public class Esami 
{
	Scanner in = new Scanner(System.in);
	protected static ArrayList<Esami> listaEsami= new ArrayList<>();
	private String nome;
	private int crediti;
	private int voto;
	Studente s;

	
	public Esami(String nome, int crediti, int voto) 
	{
		this.nome = nome;
		this.crediti = crediti;
		this.voto = voto;
	}

	
	public void AggiungiEsame(String nome,int crediti)
	{

		int voto = 0;
		listaEsami.add(new Esami(nome, crediti, voto));
	}
	
	public void RimuoviEsame(String nome)
	{
		for (int i = 0;i<listaEsami.size();i++)
		{
			if (listaEsami.get(i).getNome().equals(nome)) listaEsami.remove(i);
		}
	}
	
	public void CercaEsame(String nome)
	{
		for (int i= 0; i<listaEsami.size();i++)
		{
			if (listaEsami.get(i).getNome().equals(nome))
                System.out.println(listaEsami.get(i).getNome() + " " +listaEsami.get(i).getCrediti());
		}
	}
	
	/*public void VisualizzaEsami()
	{
		int i= 0;
		System.out.println(listaEsami.get(i).getNome() + " " + listaEsami.get(i).getVoto() 
				+ " " + listaEsami.get(i).getCrediti());
	}*/
	
	public int Promozione(String nome, int voto)
	{
		for (int i = 0; i < listaEsami.size();i++)
		{
			if (!listaEsami.get(i).getNome().equals(nome)) return 0;
			if (!controlloVoto(voto)) return 1;
			if (listaEsami.get(i).getNome().equals(nome)) 
				{
					listaEsami.set(i, new Esami(nome,listaEsami.get(i).getCrediti(), voto));
					Studente.setCreditiStu(Studente.getCreditiStu() + listaEsami.get(i).getCrediti());
					return 2;
	    		}
		}
		return 2;
	}
	
	
	public boolean controlloVoto(int voto)
	{
		if (voto <32 && voto >17) return true;
		return false;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public int getVoto() 
	{
		return voto;
	}

	public void setVoto(int voto) 
	{
		this.voto = voto;
	}

	public int getCrediti() 
	{
		return crediti;
	}

	public void setCrediti(int crediti) 
	{
		this.crediti = crediti;
	}

}
