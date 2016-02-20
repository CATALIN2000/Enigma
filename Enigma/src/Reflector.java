import java.util.*;

public class Reflector {
	public ArrayList<Pair> reflector = new ArrayList<Pair>();
	
	public Reflector(){
		reflector = null;
	}
	
	public Reflector(String input){
		if(input.equals("B")){
			reflector.add(new Pair('A','Y'));
			reflector.add(new Pair('B','R'));
			reflector.add(new Pair('C','U'));
			reflector.add(new Pair('D','H'));
			reflector.add(new Pair('E','Q'));
			reflector.add(new Pair('F','S'));
			reflector.add(new Pair('G','L'));
			reflector.add(new Pair('I','P'));
			reflector.add(new Pair('J','X'));
			reflector.add(new Pair('K','N'));
			reflector.add(new Pair('M','O'));
			reflector.add(new Pair('T','Z'));
			reflector.add(new Pair('V','W'));
		}else{
			reflector.add(new Pair('A','F'));
			reflector.add(new Pair('B','V'));
			reflector.add(new Pair('C','P'));
			reflector.add(new Pair('D','J'));
			reflector.add(new Pair('E','I'));
			reflector.add(new Pair('G','O'));
			reflector.add(new Pair('H','Y'));
			reflector.add(new Pair('K','R'));
			reflector.add(new Pair('L','Z'));
			reflector.add(new Pair('M','X'));
			reflector.add(new Pair('N','W'));
			reflector.add(new Pair('T','Q'));
			reflector.add(new Pair('S','U'));
		}
	}
	
	public char changeLetter(char input){
		char ret = input;
		for(Pair p: reflector){
			if(p.getX() == input){
				ret = p.getY();
			}else if(p.getY() == input){
				ret = p.getX();
			}
		}
		return ret;
	}

	public ArrayList<Pair> getReflector() {
		return reflector;
	}

	public void setReflector(ArrayList<Pair> reflector) {
		this.reflector = reflector;
	}

	@Override
	public String toString() {
		return "Reflector [Reflector=" + reflector + "]";
	}
	
}
