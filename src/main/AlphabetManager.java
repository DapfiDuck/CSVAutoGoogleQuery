package main;


public class AlphabetManager {
	
	char [] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',};
	
	public AlphabetManager() {
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
	
	
}
