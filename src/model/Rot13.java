package model;

public class Rot13 {	
	
	public String code (String doc) {
		
		String text = "";
		
		for (int i = 0; i < doc.length(); i++) {
            char c = doc.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            text += c;
		}
		return text;
	}
}
