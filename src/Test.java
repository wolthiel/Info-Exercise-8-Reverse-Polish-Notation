
public class Test {
	
	public Test() {
		Postfix postf = new Postfix();
		try {
			System.out.println(postf.evaluate("4*4"));	
		}catch(Exception e) {System.out.println("Error occurred");}
	}

	public static void main(String[] args) {
		new Test();
		
	}

}
