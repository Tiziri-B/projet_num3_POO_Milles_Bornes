package cartes;

public class Borne extends Carte {
   private int km;
   
	public Borne(int km ) {
		this.km=km;
	}
	
 public int getkm() {
	 return km; }
 
@Override 
 public String toString() {
	 return km + "KM";
 }

@Override 
public boolean equals(Object obj) {
	if (super.equals(obj)) {
		Borne autre = (Borne) obj;
		return km   == autre.km;
	}
	return false;
}

@Override 
public int hashCode() {
	 return 31 * super.hashCode() + km;
}

}