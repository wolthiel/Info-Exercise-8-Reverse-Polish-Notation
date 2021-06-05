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
