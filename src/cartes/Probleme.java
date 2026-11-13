package cartes;

public abstract  class Probleme extends Carte {

	private Type type;
	
	protected Probleme(Type type) {
		this.type = type;
	}
	public Type getType() {
		return type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && super.equals(obj)) {
			Probleme prob = (Probleme) obj;
			return type == prob.type;
		}
		return false;
	}
	
	@Override 
	public int hashCode() {
		return 31 * super.hashCode() + type.hashCode();
	}
}
