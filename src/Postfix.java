public class Postfix {
	
	
	public int evaluate(String pfx) {
		
		String ffff =  infixToPostfix(pfx);
		
		StackAsList stackforDigits = new StackAsList();
		int result = 0;
		int firstdigit = 0;
		int seconddigit = 0;

		char[] c = ffff.toCharArray();
		
		for (char chr: c) {
			if(Character.isDigit(chr)){
				stackforDigits.addFirstNode(chr);	
			} else if (!(Character.isDigit(chr))){
				
				firstdigit = Integer.parseInt(stackforDigits.removeFirst().toString());
				seconddigit = Integer.parseInt(stackforDigits.removeFirst().toString());
				
				switch(chr) {
				case '+':
					result = seconddigit+firstdigit;
					break;
				case '/':
					result = seconddigit/firstdigit;
					break;
				case '-':	
					result = seconddigit-firstdigit;
					break;
				case '*' :
					result = seconddigit*firstdigit;
					break;	
				}
				stackforDigits.addFirstNode(result);
				}
		}
		return result;
	}
	
	public static char makeObjectToChar(){
		StackAsList stackforDigits = new StackAsList();
		String string = stackforDigits.peekAsString();
		char[] ch = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {
			ch[i] = string.charAt(i);
			}
		for (char character : ch) {
			return character;
		}
		return 0;
	}

	      
	    // A utility function to return 
	    // precedence of a given operator
	    // Higher returned value means 
	    // higher precedence
	    public static int Prec(char ch)
	    {
	        switch (ch)
	        {
	        case '+':
	        case '-':
	            return 1;
	       
	        case '*':
	        case '/':
	            return 2;
	       
	        case '^':
	            return 3;
	        }
	        return -1;
	    }
	       
	    // The main method that converts 
	    // given infix expression
	    // to postfix expression.
	    /* neue Var für opperator
	     * 1: loop für jedes Element im Stack
	     * 2: in loop switch-statement -> switch für opperatoren + defaultwert für alles andere defwert wird in anderen Stack gegeben
	     * 3:am ende wird der opperator hinzugefügt 
	     * 
	     */
	    
	    
	    
	    public static String infixToPostfix(String exp)
	    {
	    	char operator = 0;
	    	StackAsList stackforDigits = new StackAsList();
	    	char[] c = exp.toCharArray();
	    	String string;
	    	StackAsList.StackListIterator iterator = stackforDigits.new StackListIterator();
			
			for (char chr: c) {
				if(Character.isDigit(chr)){
					iterator.add(chr);
				} else if (!(Character.isDigit(chr))){
										
					switch(chr) {
					case '+':
						operator = '+';
					case '/':
						operator = '/';
					case '-':	
						operator = '-';
					case '*' :
						operator = '*';
					}
			}
	    }
			iterator.add(operator);
			string = stackforDigits.allNodesToString();
			return string;

	}
}
