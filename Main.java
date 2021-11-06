package Es1;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		int mincrediti = 180;
		CorsoLaurea[] listaCorsi = { new CorsoLaurea("Informatica", mincrediti),
				new CorsoLaurea("Meccanica", mincrediti), new CorsoLaurea("Biomedica", mincrediti),
				new CorsoLaurea("Elettronica", mincrediti), new CorsoLaurea("Meccanica", mincrediti),
				new CorsoLaurea("Gestionale", mincrediti), new CorsoLaurea("Civile", mincrediti) };
		int input;
		Scanner in = new Scanner(System.in);
		do {
			do {
				System.out.println('\n' + "Benvenuto, quale corso di laurea in ingegneria ti interessa?");
				System.out.println("1) Informatica");
				System.out.println("2) Meccanica");
				System.out.println("3) Biomedica");
				System.out.println("4) Elettronica");
				System.out.println("5) Meccanica");
				System.out.println("6) Gestionale");
				System.out.println("7) Civile");
				System.out.println("0) Esci");
				input = in.nextInt();
			} while (input <= 0 && input >= 7);

			switch (input) {
			case 1:
				listaCorsi[0].Menu("Informatica");
				break;
			case 2:
				listaCorsi[1].Menu("Meccanica");
				break;
			case 3:
				listaCorsi[2].Menu("Biomedica");
				break;
			case 4:
				listaCorsi[3].Menu("Elettronica");
				break;
			case 5:
				listaCorsi[4].Menu("Meccanica");
				break;
			case 6:
				listaCorsi[5].Menu("Elettronica");
				break;
			case 7:
				listaCorsi[6].Menu("Elettronica");
				break;
			case 0:
				return;
			}
		} while (true);
	}
}
