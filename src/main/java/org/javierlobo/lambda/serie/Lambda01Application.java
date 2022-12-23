package org.javierlobo.lambda.serie;

public class Lambda01Application {
	
	public static void main(String[] args) {
		int n=0;
		Serie5 s5 = new Serie5();
		
		System.out.println("Números de 5 en 5!");
		for(int i = 0; i <= 10; i++) {
			System.out.println(n);
			n = s5.siguiente(n);
		}
		// =========== CLASES ANONIMAS ===========
		Serie s5b = new Serie() {
			
			@Override
			public int siguiente(int n) {
				return n + 5;
			}
		};
		
		n = 0;
		System.out.println("Números de 5 en 5 usando clase anonima!");
		for(int i = 0; i <= 10; i++) {
			System.out.println(n);
			n = s5b.siguiente(n);
		}

		// =========== CLASES LAMBDAS ===========
		n = 0;
		Serie s5c = (num) -> {
			return num + 5;
		};
		System.out.println("Números de 5 en 5 usando clase Lambda!");
		for(int i = 0; i <= 10; i++) {
			System.out.println(n);
			n = s5c.siguiente(n);
		}
		
		
	} // End Main
}

