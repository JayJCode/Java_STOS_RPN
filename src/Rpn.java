package Stack;

public class Rpn {
    private String[] stringArray;

    public String RPN(String input) {
        Stack stack = new Stack();
        stringArray = input.split(" ");


        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] == null) {continue;}
            try {
                Integer.parseInt(stringArray[i]);
                stack.push(stringArray[i]);

            } catch (NumberFormatException operator) {
                if (stack.elementsArray.length < 2) {
                    return "Bledna notacja";
                }

                try {
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());

                    switch (stringArray[i]) {
                        case "+":
                            stack.push(String.valueOf(a + b));
                            break;
                        case "-":
                            stack.push(String.valueOf(a - b));
                            break;
                        case "*":
                            stack.push(String.valueOf(a * b));
                            break;
                        case "/":
                            if (b == 0) {
                                return "Dzielenie przez zero";
                            }
                            stack.push(String.valueOf(a / b));
                            break;
                        default:
                            return "Bledna wartosc!";
                    }
                } catch (IllegalStateException e) {
                    return "Błąd: " + e.getMessage();
                }
            }
        }

        if (stack.elementsArray.length != 1) {
            return "Bledna notacja";
        }

        return stack.pop();
    }
}
