package Stack;

import java.util.Arrays;

public class Stack {
	private String[] elementsArray = new String[100];
	private Integer[] elementsInt = new Integer[100];
	private int kolejka = 0;
	private int kolejkaInt = 0;
	private int tempInt;
	private String temp;

	
	public void push(String element) {
		elementsArray[kolejka] = element;
		kolejka++;
	}
	
	public void push(int element) {
		elementsInt[kolejkaInt] = element;
		kolejkaInt++;
	}
	
	public String pop() {
		if (kolejka > 0) {
			kolejka--;
			temp = elementsArray[kolejka];
			elementsArray[kolejka] = null;
			return temp;
		}
		else {
			return "Stos jest pusty :)";
		}
	}
	
	public int popInt() {
		if (kolejkaInt > 0) {
	        kolejkaInt--;
	        tempInt = elementsInt[kolejkaInt];
	        elementsInt[kolejkaInt] = null;
	        return tempInt;
	    } else {
	        throw new IllegalStateException("Stos jest pusty");
	    }
	}

	public String peek() {
        if (kolejka > 0) {
            return elementsArray[kolejka - 1];
        } else {
            return "Stos jest pusty :)";
        }
    }
	
	public String RPN() {
	    for (int i = kolejka - 1; i >= 0; i--) {
	    	if (elementsArray[i] == null) {continue;}
	        try {
	        	tempInt = Integer.parseInt(elementsArray[i]);
	        	push(tempInt);
	        } catch (NumberFormatException operator) {
	            if (kolejkaInt < 2) {
	                return "Bledna notacja";
	            }
	            
	            try {
	                int b = popInt();
	                int a = popInt();

	                switch (elementsArray[i]) {
	                    case "+":
	                        push(a + b);
	                        break;
	                    case "-":
	                        push(a - b);
	                        break;
	                    case "*":
	                        push(a * b);
	                        break;
	                    case "/":
	                        if (b == 0) {
	                            return "Dzielenie przez zero";
	                        }
	                        push(a / b);
	                        break;
	                    default:
	                        return "Bledna wartosc!";
	                }
	            } catch (IllegalStateException e) {
	                return "Błąd: " + e.getMessage();
	            }
	        }
	    }
	    
	    if (kolejkaInt != 1) {
	        return "Bledna notacja";
	    }
	    
	    return String.valueOf(popInt());
	}
}
