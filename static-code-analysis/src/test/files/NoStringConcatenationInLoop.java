
public class NoStringConcatenationInLoop {
	public String concatenateString(String[] sampleStrings){
	    String finalString = "";
	    for(String eachString: sampleStrings){
	        finalString += eachString;
	    }
	    return finalString;
	}
	public String concatenateStringAlt1(){
	    String finalString = "";
	    for(int i = 0; i < 50; i++){
	        finalString += "sample string";
	    }
	    return finalString;
	}
	public String concatenateStringAlt2(){
	    String finalString = "";
	    for(int i = 0; i < 50; i++){
	        finalString = finalString + "sample string";
	    }
	    return finalString;
	}

}
