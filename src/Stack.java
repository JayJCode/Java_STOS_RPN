package Stack;

public class Stack {
	public String[] elementsArray;

	public Stack() {
		elementsArray = new String[0];
	}
	
	public void push(String element) {
		String[] newArray = new String[elementsArray.length + 1];
		System.arraycopy(elementsArray, 0, newArray, 0, elementsArray.length);
		newArray[elementsArray.length] = element;
		elementsArray = newArray;
	}
	
	public String pop() {
		if (elementsArray.length > 0) {
			String temp = elementsArray[elementsArray.length - 1];
			String[] newArray = new String[elementsArray.length - 1];
			System.arraycopy(elementsArray, 0, newArray, 0, elementsArray.length - 1);
			elementsArray = newArray;
			return temp;
		}
		else return "Stos jest pusty :)";
	}

	public String peek() {
        if (elementsArray.length > 0) {
            return elementsArray[elementsArray.length - 1];
        } else return "Stos jest pusty :)";
    }
}
