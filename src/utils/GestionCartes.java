package utils;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {
	
private static final Random  random = new Random();

	public  static <T>  T extraire (List<T> liste){
		int index = random.nextInt(liste.size());
		return liste.remove(index);
	}
	
	public  static <T> T extraireIterator (List<T> liste) {
		int index = random.nextInt(liste.size());
		ListIterator<T> it = liste.listIterator(index);
		T element = it.next();
		it.remove();
		return element ;
		}

	public static <T> List <T>  melanger (List<T> liste) {
		List<T> melangee = new ArrayList<>(); // crée la nvll liste de carte melangé 
		while(!liste.isEmpty()) { // tq la 1er n est pas vide 
			T element = extraire(liste); // je prend une de la 1er
			melangee.add(element); // ajout dans la nvl liste 	
		}
		return melangee;
	}
	
	
	public static <T> boolean verifierMelange(List <T> l1 , List <T> l2) {
		if( l1.size() != l2.size()) {
			return false;
		}
		for( T elem  :l1) {
			int count1 = Collections.frequency( l1 , elem);
			int count2 = Collections.frequency(l2, elem);
			if( count1 != count2) {
				return false;
			}
		}
		return true;
	}
	

	public static <T> List<T> rassembler(List<T> liste) {
        List<T> resultat = new ArrayList<>();
        List<T> copie = new ArrayList<>(liste);

        while (!copie.isEmpty()) {
            T element = copie.remove(0);
            resultat.add(element);

            ListIterator<T> it = copie.listIterator();
            while (it.hasNext()) {
                T courant = it.next();
                if (element.equals(courant)) {
                    resultat.add(courant);
                    it.remove();
                }
            }
        }
        return resultat;
    }

public static <T> boolean verifierRassemblement(List<T> liste) {
    if (liste.isEmpty() || liste.size() == 1) {
        return true;
    }

    ListIterator<T> it1 = liste.listIterator();
    T precedent = it1.next();

    while (it1.hasNext()) {
        T courant = it1.next();
        if (!courant.equals(precedent)) {
          
            ListIterator<T> it2 = liste.listIterator(it1.nextIndex());
            while (it2.hasNext()) {
                if (precedent.equals(it2.next())) {
                    return false; 
                }
            }
            precedent = courant;
        }
    }
    return true;
}
}


