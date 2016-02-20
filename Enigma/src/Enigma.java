import java.util.ArrayList;

public class Enigma {
	
	private Rotor rotor1,rotor2,rotor3;
	private Inel inel1,inel2,inel3;
	private Reflector reflector;
	private Plugboard plugboard;
	private String alfabet;
	private int type1,type2,type3;
	@SuppressWarnings("unused")
	private int over = 832, under = 26;
	char pozitiar1,pozitiar2,pozitiar3,pozitiai1,pozitiai2,pozitiai3;
	public char[] basic = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
			'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	public Enigma() {
		super();
	}
	
	public Enigma(int type1, int type2, int type3, char pozitiar1, char pozitiar2,
			char pozitiar3, char pozitiai1, char pozitiai2, char pozitiai3,
			String reflector, String alfabet, Plugboard board){
		this.rotor1 = new Rotor(type1);
		this.rotor2 = new Rotor(type2);
		this.rotor3 = new Rotor(type3);
		this.inel1 = new Inel(type1);
		this.inel2 = new Inel(type2);
		this.inel3 = new Inel(type3);
		this.reflector = new Reflector(reflector);
		this.plugboard = board;
		this.alfabet = alfabet;
		this.type1 = type1;
		this.type2 = type2;
		this.type3 = type3;
		this.pozitiar1 = pozitiar1;
		this.pozitiar2 = pozitiar2;
		this.pozitiar3 = pozitiar3;
		this.pozitiai1 = pozitiai1;
		this.pozitiai2 = pozitiai2;
		this.pozitiai3 = pozitiai3;
	}
	
	public int getOffset(char input){
		int ret = 0;
		for(int i = 0 ; i < basic.length ; i++){
			if(input == basic[i]){
				ret = i;
				break;
			}
		}
		return ret;
	}
	
	public char compute(char input, String DC){
		
		ArrayList<Character> Trace = new ArrayList<Character>();
		
		int litera, before, litera2, after;
		char nextletter, outletter;
		int R1 = getOffset(pozitiar1);
		int R2 = getOffset(pozitiar2);
		int R3 = getOffset(pozitiar3);
		int I1 = getOffset(pozitiai1);
		int I2 = getOffset(pozitiai2);
		int I3 = getOffset(pozitiai3);
		
		if(DC.equals("C")){
			rotor3.contor++;//setContor();
			if(inel2.notch == basic[(R2 + rotor2.getContor() + 1) % 26] ||
					inel2.notch2 == basic[(R2 + rotor2.getContor() + 1) % 26]){
				rotor1.contor++;//setContor();
				rotor2.contor++;//setContor();
			}else if(inel3.notch == basic[(R3 + rotor3.getContor()) % 26] ||
					inel3.notch2 == basic[(R3 + rotor3.getContor()) % 26]){
				rotor2.contor++;//setContor();
			}
			//debug code
			//int rs1 = rotor1.getContor() % 26;
			//int rs2 = rotor2.getContor() % 26;
			//int rs3 = rotor3.getContor() % 26;
			rotor1.setContor(rotor1.getContor() % 26);
			rotor2.setContor(rotor2.getContor() % 26);
			rotor3.setContor(rotor3.getContor() % 26);
			//litera prin plugboard
			Trace.add(input);
			outletter = plugboard.getLetter(input);
			Trace.add(outletter);
			//letter on right rotor
			
			litera = getOffset(outletter);
			before = ((litera + R3 - I3 + rotor3.getContor() + 26) % 26);
			nextletter = rotor3.changeLetter(basic[(before + 26) % 26]);
			litera2 = getOffset(nextletter);
			after = ((litera2 - R3 + I3 - rotor3.getContor() + over) % 26);
			outletter = basic[after % 26];
			
			Trace.add(outletter);
			//letter on middle rotor
			
			litera = getOffset(outletter);
			before = ((litera + R2 - I2 + rotor2.getContor() + 26) % 26);
			nextletter = rotor2.changeLetter(basic[before % 26]);
			litera2 = getOffset(nextletter);
			after = ((litera2 - R2 + I2 - rotor2.getContor() + over) % 26);
			outletter = basic[after % 26];
			
			Trace.add(outletter);
			//letter on left rotor
			
			litera = getOffset(outletter);
			before = ((litera + R1 - I1 + rotor1.getContor() + 26) % 26);
			nextletter = rotor1.changeLetter(basic[before % 26]);
			litera2 = getOffset(nextletter);
			after = ((litera2 - R1 + I1 - rotor1.getContor() + over) % 26);
			outletter = basic[after % 26];
			
			Trace.add(outletter);
			//letter on relfector
			
			outletter = reflector.changeLetter(outletter);
			
			Trace.add(outletter);
			//letter on left rotor (back)
			
			litera = getOffset(outletter);
			before = ((litera + R1 - I1 + rotor1.getContor() + 26) % 26);
			nextletter = rotor1.changeInverseLetter(basic[before % 26]);
			litera2 = getOffset(nextletter);
			after = ((litera2 - R1 + I1 - rotor1.getContor() + over) % 26);
			outletter = basic[after % 26];
			
			Trace.add(outletter);
			//letter on middle rotor (back)
			
			litera = getOffset(outletter);
			before = ((litera + R2 - I2 + rotor2.getContor() + 26) % 26);
			nextletter = rotor2.changeInverseLetter(basic[before % 26]);
			litera2 = getOffset(nextletter);
			after = ((litera2 - R2 + I2 - rotor2.getContor() + over) % 26);
			outletter = basic[after % 26];
			
			Trace.add(outletter);
			//letter on right rotor (back)
			
			litera = getOffset(outletter);
			before = ((litera + R3 - I3 + rotor3.getContor() + 26) % 26);
			nextletter = rotor3.changeInverseLetter(basic[before % 26]);
			litera2 = getOffset(nextletter);
			after = ((litera2 - R3 + I3 - rotor3.getContor() + over) % 26);
			outletter = basic[after % 26];
			
			Trace.add(outletter);
			//litera la final
			//debug code
			//int r1 = rotor1.getContor();
			//int r2 = rotor2.getContor();
			//int r3 = rotor3.getContor();
			outletter = plugboard.getInverseLetter(outletter);
			
			Trace.add(outletter);
			
			//debug section
			/*System.out.print("Trace :");
			for(Character c: Trace)
				System.out.print("->"+c);
			*/
			return outletter;
			
		}else{//code or decode if
			//decode part
			
			rotor3.contor++;//setContor();
			if(inel2.notch == basic[(R2 + rotor2.getContor() + 1) % 26] ||
					inel2.notch2 == basic[(R2 + rotor2.getContor() + 1) % 26]){
				rotor1.contor++;//setContor();
				rotor2.contor++;//setContor();
			}else if(inel3.notch == basic[(R3 + rotor3.getContor()) % 26] ||
					inel3.notch2 == basic[(R3 + rotor3.getContor()) % 26]){
				rotor2.contor++;//setContor();
			}
			//debug code
			//int rs1 = rotor1.getContor() % 26;
			//int rs2 = rotor2.getContor() % 26;
			//int rs3 = rotor3.getContor() % 26;
			rotor1.setContor(rotor1.getContor() % 26);
			rotor2.setContor(rotor2.getContor() % 26);
			rotor3.setContor(rotor3.getContor() % 26);
			//litera prin plugboard
			Trace.add(input);
			outletter = plugboard.getLetter(input);
			Trace.add(outletter);
			//letter on right rotor
			
			litera = getOffset(outletter);
			before = ((litera + R3 - I3 + rotor3.getContor() + 26) % 26);
			nextletter = rotor3.changeLetter(basic[(before + 26) % 26]);
			litera2 = getOffset(nextletter);
			after = ((litera2 - R3 + I3 - rotor3.getContor() + over) % 26);
			outletter = basic[after % 26];
			
			Trace.add(outletter);
			//letter on middle rotor
			
			litera = getOffset(outletter);
			before = ((litera + R2 - I2 + rotor2.getContor() + 26) % 26);
			nextletter = rotor2.changeLetter(basic[before % 26]);
			litera2 = getOffset(nextletter);
			after = ((litera2 - R2 + I2 - rotor2.getContor() + over) % 26);
			outletter = basic[after % 26];
			
			Trace.add(outletter);
			//letter on left rotor
			
			litera = getOffset(outletter);
			before = ((litera + R1 - I1 + rotor1.getContor() + 26) % 26);
			nextletter = rotor1.changeLetter(basic[before % 26]);
			litera2 = getOffset(nextletter);
			after = ((litera2 - R1 + I1 - rotor1.getContor() + over) % 26);
			outletter = basic[after % 26];
			
			Trace.add(outletter);
			//letter on relfector
			
			outletter = reflector.changeLetter(outletter);
			
			Trace.add(outletter);
			//letter on left rotor (back)
			
			litera = getOffset(outletter);
			before = ((litera + R1 - I1 + rotor1.getContor() + 26) % 26);
			nextletter = rotor1.changeInverseLetter(basic[before % 26]);
			litera2 = getOffset(nextletter);
			after = ((litera2 - R1 + I1 - rotor1.getContor() + over) % 26);
			outletter = basic[after % 26];
			
			Trace.add(outletter);
			//letter on middle rotor (back)
			
			litera = getOffset(outletter);
			before = ((litera + R2 - I2 + rotor2.getContor() + 26) % 26);
			nextletter = rotor2.changeInverseLetter(basic[before % 26]);
			litera2 = getOffset(nextletter);
			after = ((litera2 - R2 + I2 - rotor2.getContor() + over) % 26);
			outletter = basic[after % 26];
			
			Trace.add(outletter);
			//letter on right rotor (back)
			
			litera = getOffset(outletter);
			before = ((litera + R3 - I3 + rotor3.getContor() + 26) % 26);
			nextletter = rotor3.changeInverseLetter(basic[before % 26]);
			litera2 = getOffset(nextletter);
			after = ((litera2 - R3 + I3 - rotor3.getContor() + over) % 26);
			outletter = basic[after % 26];
			
			Trace.add(outletter);
			//litera la final
			//debug code
			//int r1 = rotor1.getContor();
			//int r2 = rotor2.getContor();
			//int r3 = rotor3.getContor();
			outletter = plugboard.getInverseLetter(outletter);
			
			Trace.add(outletter);
			
			//debug section
			/*System.out.print("Trace :");
			for(Character c: Trace)
				System.out.print("->"+c);
			*/
			return outletter;
		}
	}

	public Rotor getRotor1() {
		return rotor1;
	}

	public void setRotor1(Rotor rotor1) {
		this.rotor1 = rotor1;
	}

	public Rotor getRotor2() {
		return rotor2;
	}

	public void setRotor2(Rotor rotor2) {
		this.rotor2 = rotor2;
	}

	public Rotor getRotor3() {
		return rotor3;
	}

	public void setRotor3(Rotor rotor3) {
		this.rotor3 = rotor3;
	}

	public Inel getInel1() {
		return inel1;
	}

	public void setInel1(Inel inel1) {
		this.inel1 = inel1;
	}

	public Inel getInel2() {
		return inel2;
	}

	public void setInel2(Inel inel2) {
		this.inel2 = inel2;
	}

	public Inel getInel3() {
		return inel3;
	}

	public void setInel3(Inel inel3) {
		this.inel3 = inel3;
	}

	public Reflector getReflector() {
		return reflector;
	}

	public void setReflector(Reflector reflector) {
		this.reflector = reflector;
	}

	public Plugboard getPlugboard() {
		return plugboard;
	}

	public void setPlugboard(Plugboard plugboard) {
		this.plugboard = plugboard;
	}

	public String getAlfabet() {
		return alfabet;
	}

	public void setAlfabet(String alfabet) {
		this.alfabet = alfabet;
	}

	public int getType1() {
		return type1;
	}

	public void setType1(int type1) {
		this.type1 = type1;
	}

	public int getType2() {
		return type2;
	}

	public void setType2(int type2) {
		this.type2 = type2;
	}

	public int getType3() {
		return type3;
	}

	public void setType3(int type3) {
		this.type3 = type3;
	}

	public char getPozitiar1() {
		return pozitiar1;
	}

	public void setPozitiar1(char pozitiar1) {
		this.pozitiar1 = pozitiar1;
	}

	public char getPozitiar2() {
		return pozitiar2;
	}

	public void setPozitiar2(char pozitiar2) {
		this.pozitiar2 = pozitiar2;
	}

	public char getPozitiar3() {
		return pozitiar3;
	}

	public void setPozitiar3(char pozitiar3) {
		this.pozitiar3 = pozitiar3;
	}

	public char getPozitiai1() {
		return pozitiai1;
	}

	public void setPozitiai1(char pozitiai1) {
		this.pozitiai1 = pozitiai1;
	}

	public char getPozitiai2() {
		return pozitiai2;
	}

	public void setPozitiai2(char pozitiai2) {
		this.pozitiai2 = pozitiai2;
	}

	public char getPozitiai3() {
		return pozitiai3;
	}

	public void setPozitiai3(char pozitiai3) {
		this.pozitiai3 = pozitiai3;
	}

	@Override
	public String toString() {
		return "Enigma [rotor1=" + rotor1 + ", rotor2=" + rotor2 + ", rotor3=" + rotor3 + ", inel1=" + inel1
				+ ", inel2=" + inel2 + ", inel3=" + inel3 + ", reflector=" + reflector + ", plugboard=" + plugboard
				+ ", alfabet=" + alfabet + "]";
	}
	
}
