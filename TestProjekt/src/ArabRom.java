import java.util.Scanner;
import java.util.StringJoiner;

public class ArabRom {

	int[] arabic = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
	String[] roman = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};

	
	public static void main(String[] args) {

		ArabRom arbRom = new ArabRom();

		if(args.length>0 && args[0]!=null){
			
			System.out.println(arbRom.getUmwandlungstabelle());
		}
		else{
			
			Scanner sc = new Scanner(System.in);
			
			String input = sc.nextLine();
			
			if(isArab(input)){
				
				int i = Integer.parseInt(input);
				System.out.println(arbRom.arabToRom(i)+"\t"+i);
			}
			else{
				
				System.out.println(arbRom.romToArab(input)+" "+input);
			}	
		}
	}
	
	
	public CharSequence getUmwandlungstabelle(){
		
		StringJoiner tab = new StringJoiner("\n", "Umwandlungstabelle:\n", ".");

		for (int i=1;i<=3999;i++){
			
			tab.add(String.format("rom: %s\t ara: %d", arabToRom(i), i));
		}
		
		return tab.toString();
	}

	
	public CharSequence arabToRom(int arab){

		StringBuilder result = new StringBuilder(15);
		int counter=arabic.length-1;

		while (arab>0 && arab<4000  && counter>=0){

			if (arab>=arabic[counter]){

				result.append(roman[counter]);
				arab=arab-arabic[counter];

			}else{

				counter--;
			}
		}

		return result;
	}
	

	public int romToArab(CharSequence rom){

		StringBuilder romBuilder = new StringBuilder(rom);
		
		int result = 0;
		int counter=arabic.length-1;

		while (romBuilder.length()>0 && counter>=0){

			if (romBuilder.toString().startsWith(roman[counter])){

				result=result+arabic[counter];
				
				romBuilder.delete(0, roman[counter].length());

			}else{

				counter--;
			}
		}

		return result;
	}
	
	
	public static boolean isArab(String input){
		
		try{
			
			Integer.parseInt(input);
		
		}catch(NumberFormatException e){
			
			return false;
		}
		
		return true;
	}

}

// ungültig römisch: 0
// ungültig arabisch: leerer String
