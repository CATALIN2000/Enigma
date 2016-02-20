import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		List<String> input;
		
		String FileName = args[0];
		
		FileParser parser = new FileParser(FileName);
		parser.open();
		
		//Alphabet
		input = parser.parseNextLine();
		String alfabet = input.get(0).toUpperCase();
		//debug code
		//System.out.println(alfabet);
		
		//Plugboard
		ArrayList<Pair> pluginput = new ArrayList<Pair>();
		input = parser.parseNextLine();
		String plug = "";
		
		for(String st: input){
			plug += st;
		}
		
		String[] boar = plug.split("\\(");
		for(int i = 1 ; i < boar.length; i++){
			String[] tmp = boar[i].split("\\)");
			char[] emp = tmp[0].toUpperCase().toCharArray();
			char x = emp[0], y = emp[1];
			pluginput.add(new Pair(x,y));
		}
		//debug code
		//for(Pair p: pluginput)
			//System.out.println(p);
		
		//Reflector and rotors
		input = parser.parseNextLine();
		String reflector = input.get(0).toUpperCase();
		int rotor1 = Integer.parseInt(input.get(1));
		int rotor2 = Integer.parseInt(input.get(2));
		int rotor3 = Integer.parseInt(input.get(3));
		//debug code
		//System.out.println(reflector + " " + rotor1 + " " + rotor2 + " " + rotor3);
		
		//ring pozition
		input = parser.parseNextLine();
		String inel = input.get(0).toUpperCase();
		char[] inele = inel.toCharArray();
		//debug code
		//System.out.println(inele[0]+" "+inele[1]+" "+inele[2]);
		
		//rotors pozition
		input = parser.parseNextLine();
		String rotor = input.get(0).toUpperCase();
		char[] rotoare = rotor.toCharArray();
		//debug code
		//System.out.println(rotoare[0]+" "+rotoare[1]+" "+rotoare[2]);
		
		//cod
		input = parser.parseNextLine();
		String code = input.get(0).toUpperCase();
		//debug code
		//System.out.println(code);
		
		try{
		//mesage
		String mesaj;
		char[] mesajintrare;
		input = parser.parseNextLine();
		mesaj = input.get(0).toUpperCase();
		mesajintrare = mesaj.toCharArray();
		//debug code
		//System.out.println(mesaj);
		
		Plugboard plugboard = new Plugboard(pluginput);
		Enigma enigma =  new Enigma(rotor1,rotor2,rotor3,rotoare[0],rotoare[1],
				rotoare[2],inele[0],inele[1],inele[2],reflector,alfabet,plugboard);
		
		
		for(int i = 0 ; i < mesajintrare.length ; i++){
			String s = "" + mesajintrare[i];
			//debug code
			//System.out.println(s);
			if(alfabet.contains(s)){
				System.out.print(enigma.compute(mesajintrare[i], code));
			}
		}
		
		while(input != null){
			//mesage
			input = parser.parseNextLine();

			try{
				mesaj = input.get(0).toUpperCase();
				mesajintrare = mesaj.toCharArray();
				//debug code
				//System.out.println(mesaj);
				for(int i = 0 ; i < mesajintrare.length ; i++){
					String s = "" + mesajintrare[i];
					//debug code
					//System.out.println(s);
					if(alfabet.contains(s)){
						System.out.print(enigma.compute(mesajintrare[i], code));
					}
				}
			}catch(NullPointerException e){
				//throw new NullPointerException("E null"); pot arunca exceptia
	            //System.out.print("NullPointerException caught");
				//pot afisa un text custom pentru exceptie
	        }
		}
		}catch(NullPointerException e){}
		
		//debug code - show state machine
		//System.out.println(enigma);
		//end of Enigma
		parser.close();
		//End of party
	}

}
