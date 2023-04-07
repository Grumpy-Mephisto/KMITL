package PolishNotation;

import java.util.ArrayList;

public class Notation {

    private String equation;
    
    public Notation(String equation) {
        this.equation = equation;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public String getInfix() {
        return equation;
    }

    public String getPrefix() {
        return infixToPrefix(equation);
    }

    public String getPostfix() {
        return infixToPostfix(equation);
    }

    private String infixToPrefix(String infix) {
        String prefix = "";
        ArrayList<Character> list = new ArrayList<>();
        for (int i = infix.length() - 1; i >= 0; i--) {
            char c = infix.charAt(i);
            if (Character.isLetter(c)) {
                list.add(c);
            } else {
                while (!list.isEmpty() && getPrecedence(c) < getPrecedence(list.get(list.size() - 1))) {
                    prefix += list.remove(list.size() - 1);
                    prefix += " ";
                }
                list.add(c);
            }
        }
        for(int i = list.size() - 1; i >= 0; i--) {
            prefix += list.get(i);
        }
        return prefix;
    }

    private String infixToPostfix(String infix) {
        return "Infix to Postfix";
    }

    private int getPrecedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}
