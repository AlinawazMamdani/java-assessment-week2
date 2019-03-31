package main;

import java.util.ArrayList;

public class OfflineExercises {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") → "TTThhheee"
	// multChar("AAbb") → "AAAAAAbbbbbb"
	// multChar("Hi-There") → "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		char[] inputArray=input.toCharArray();
		String output="";
		int inputLen=input.length();
		for(int i=0;i<inputLen;i++) {
			for (int num=0;num<3;num++) {
				output= output.concat(input.substring(i, i+1));
			}
			
		}
		//System.out.println(output);
		return output;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") → "evilc"
	// getBert("xxbertfridgebertyy") → "egdirf"
	// getBert("xxBertfridgebERtyy") → "egdirf"
	// getBert("xxbertyy") → ""
	// getBert("xxbeRTyy") → ""

	public String getBert(String input) {
		int inputLen=input.length();
		boolean isBert1=false;
		boolean isBert2=false;
		int bert1Location=0;
		int bert2Location=0;
		String output="";
		for (int i=0;i<inputLen-3;i++) {
			if (input.substring(i, i+4).toLowerCase().equals("bert") && isBert1==false) {
			isBert1=true;
			bert1Location=i+4;
			
			}else if(input.substring(i, i+4).toLowerCase().equals("bert") && isBert1==true) {
				isBert2=true;
				bert2Location=i;
			}
		}
		if(isBert1==true&& isBert2==true) {
			for (int i=bert2Location;i>bert1Location;i--) {
				output=output.concat(input.substring(i-1,i));
			}
		}
		return output;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false
	// evenlySpaced(4, 60, 9) → false

	public boolean evenlySpaced(int a, int b, int c) {
		int numberDistance=0;
		int big=0;
		int notBig1=0;
		int notBig2=0;
		int medium=0;
		int small=0;
		boolean evenSpaced=false;
		if (a>b && a>c) {
		
			big=a;
			notBig1=b;
			notBig2=c;
		}
		if (b>a && b>c) {
			big=b;
			notBig1=a;
			notBig2=c;
		}
		if (c>a && c>b) {
			big=c;
			notBig1=a;
			notBig2=b;
		}
		if (big-notBig2>big-notBig1) {
			numberDistance=big-notBig1;
			medium=notBig1;
			small=notBig2;
			
		}else {
			numberDistance=big-notBig2;
			medium=notBig2;
			small=notBig1;
		}
		if (numberDistance==(medium-small)) {
			evenSpaced=true;
		}
		return evenSpaced;
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) → "Ho"
	// nMid("Chocolate", 3) → "Choate"
	// nMid("Chocolate", 1) → "Choclate"

	public String nMid(String input, int a) {
		String output="";
		int midPoint=(input.length()/2)+1;
		int amountToLeft=(a-1)/2;
		int amountToRight=(a-1)/2;
		if (amountToLeft==0) {
			output=output.concat(input.substring(0,(midPoint-1)));
			output=output.concat(input.substring((midPoint)));
		}else {
			output=output.concat(input.substring(0,(midPoint-amountToLeft-1)));
			output=output.concat(input.substring((midPoint+amountToRight)));
		}	
		
		return output;
	}

	// Given a string, return true if it ends in "dev". Ignore Case

	// endsDev("ihatedev") → true
	// endsDev("wehateDev") → true
	// endsDev("everoyonehatesdevforreal") → false
	// endsDev("devisnotcool") → false

	public boolean endsDev(String input) {
		int inputLen=input.length();
		boolean devEnd=false;
		boolean longEnough=false;
		if (inputLen<3){
			return devEnd;
		}
		if ((input.substring(inputLen-3,inputLen).toLowerCase().equals("dev"))) {
			devEnd=true;
		}
		return devEnd;
		
	}



	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") → 2
	// superBlock("abbCCCddDDDeeEEE") → 3
	// superBlock("") → 0

	public int superBlock(String input) {
		int topBlock=0;
		int newBlock=1;
		for (int i=0;i<(input.length()-2);i++){
			if (newBlock>topBlock) {
				topBlock=newBlock;
			}
			if (input.substring(i, i+1).equals(input.substring(i+1, i+2))) {
				newBlock=newBlock+1;
			}else {
				newBlock=1;
			}
			
		}
		
		return topBlock;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") → 1
	//amISearch("I am in Amsterdam am I?") → 2
	//amISearch("I have been in Amsterdam") → 0

	public int amISearch(String arg1) {
		int amCount=0;
		for(int i =0;i<arg1.length()-3;i++) {
			if (arg1.substring(i, i+2).toLowerCase().equals("am") && arg1.substring(i+2,i+3).equals(" ") && i==0){
				amCount=amCount+1;
				
			}else if (arg1.substring(i, i+2).toLowerCase().equals("am")&& i+3==arg1.length()&&arg1.substring(i-1,i).equals(" ")) {
				amCount=amCount+1;
	
			}else if(arg1.substring(i, i+2).toLowerCase().equals("am") && arg1.substring(i-1,i).equals(" ") &&arg1.substring(i+2,i+3).equals(" ") ) {
				amCount=amCount+1;
			}
		}
		return amCount;
		
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) → "fizz"
	//fizzBuzz(10) → "buzz"
	//fizzBuzz(15) → "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		String output="";
		
		if (arg1%3==0) {
			output=output.concat("fizz");
		}
		if (arg1%5==0) {
			output=output.concat("buzz");
		}
		return output;
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") → 14
	//largest("15 72 80 164") → 11
	//largest("555 72 86 45 10") → 15
	
	public int largest(String arg1) {
		arg1=arg1.concat(" ");
		
		ArrayList<Integer> spaceLocations=new ArrayList<Integer>();
		ArrayList<String> numberList=new ArrayList<String>();
		ArrayList<Integer> integerList=new ArrayList<Integer>();
		spaceLocations.add(0);
		
		for(int i=0;i<arg1.length();i++) {
			
			if (arg1.substring(i, i+1).equals(" ")) {
		
				spaceLocations.add(i+1);
				
			}
		}
		spaceLocations.add(arg1.length());
		for(int j =0;j<spaceLocations.size()-1;j++) {
			
			numberList.add(arg1.substring(spaceLocations.get(j),spaceLocations.get(j+1)));
			
			
		}
		
		int biggestNumber=0;
		
		for (String k: numberList) {
	
			int newNumber=0;
			
			for (int s=0;s<k.length()-1;s++) {
				newNumber=newNumber+Integer.parseInt(k.substring(s, s+1));
	
			}
			if (biggestNumber<newNumber) {
				biggestNumber=newNumber;
						
			}
		}
	
		return biggestNumber;
		
	}
	
	
}
