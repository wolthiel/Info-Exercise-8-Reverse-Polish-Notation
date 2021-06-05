public class Postfix {
	
	public int evaluate(String pfx) {

		StackAsList stackforDigits = new StackAsList();
		int result = 0;
		int firstdigit = 0;
		int seconddigit = 0;

		char[] c = pfx.toCharArray();
		
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
	    public static String infixToPostfix(String exp)
	    {
	        // initializing empty String for result
	        String result = new String("");
	          
	        // initializing empty stack
	        StackAsList stackforDigits = new StackAsList();
	          
	        for (int i = 0; i<exp.length(); ++i)
	        {
	            char c = exp.charAt(i);
	              
	            // If the scanned character is an
	            // operand, add it to output.
	            if (Character.isLetterOrDigit(c))
	                result += c;
	               
	            // If the scanned character is an '(', 
	            // push it to the stack.
	            else if (c == '(')
	            	stackforDigits.addFirstNode(c);
	              
	            //  If the scanned character is an ')', 
	            // pop and output from the stack 
	            // until an '(' is encountered.
	            else if (c == ')')
	            {
	                while (!stackforDigits.isEmpty() && 
	                		stackforDigits.peek().toString().charAt(0) != '(')
	                    result += stackforDigits.removeFirst();
	                  
	                stackforDigits.removeFirst();
	            }
	            else // an operator is encountered
	            {
	                while (!(stackforDigits.removeFirst() && Prec(c) 
	                         < Prec(stackforDigits.peek()))){
	                    
	                    result += stackforDigits.removeFirst();
	             }
	                stackforDigits.addFirstNode(c);
	            }
	       
	        }
	        
	       
	        // pop all the operators from the stack
	        while (!stackforDigits.isEmpty()){
	            if(stackforDigits.peek().toString().charAt(0) == '(')
	                return "Invalid Expression";
	            result += stackforDigits.removeFirst();
	         }
	        return result;
	    			
	}
	    public static void main(String[] args) 
	    {
	        String exp = "a+b*(c^d-e)^(f+g*h)-i";
	        System.out.println(infixToPostfix(exp));
	    }
	}
