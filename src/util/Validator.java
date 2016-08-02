package util;

public class Validator {

	
	public static boolean stringNoVacio(String string){
		if(string != null && string != ""){
			return true;
		}
		return false;
	}	
}
