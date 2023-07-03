
public class EcoFriendlyStringsConcatenationInLoop {
	public String concatenateString(String[] sampleStrings){
	    StringBuilder finalString = new StringBuilder();
	    for(String eachString: sampleStrings){
	        finalString.append(eachString);
	    }
	    return finalString.toString();
	}
	public String concatenateStringAlt1(){
	    String finalString = "";
	    finalString += "sample string";
	    return finalString;
	}
	public String concatenateStringAlt2(){
	    String finalString = "";
	    finalString = finalString + "sample string";
	    return finalString;
	}
}
