package main;


public class NameFormatManager {
	
	char [] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',};
	
	public NameFormatManager() {
	}

	public int getPosition(char c) {
		
		c = Character.toLowerCase(c);
		
		int pos;
		
		for(pos = 0; pos<alphabet.length; pos++){
			if(alphabet[pos]==c) {
				return pos;
			}
		}
		
		return -1;
		
	}
	
	public int getCollumn(String collstr) {
		
		char[] collumn = collstr.toCharArray();
		int pos = 0;
		
		for(int i = collumn.length; i>0; i--) {
			
			pos += getPosition(collumn[i])*Math.pow(10, (collumn.length-i));
			
		}
		
		
		return -1;
		
	}
	
	
}
