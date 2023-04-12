import java.util.*;

public class task1 {
    public static void main(String[] args) {
    System.out.println(isCorrectParentheses("()")); // true
    System.out.println(isCorrectParentheses("(")); // false
    System.out.println(isCorrectParentheses("())")); // false
    System.out.println(isCorrectParentheses("((()))")); // true
    System.out.println(isCorrectParentheses("()[]{}<>")); // true
    System.out.println(isCorrectParentheses("([)]")); // false
    System.out.println(isCorrectParentheses("][]")); // false
    System.out.println("[]{<()[]<>>}"); // true
}

/**
 * Дана последовательность скобочек. Проверить, что она является корректной.
 */
static boolean isCorrectParentheses(String parentheses) {
    // TODO: 07.04.2023 Вписать решение!
    // Нужно завести маппинг скобочек либо ( -> ), либо ) -> ( и так для каждой пары
    // Нужно использовать Deque.
    // Открывающуюся скобку вносим в Deque (insertFirst)
    // Если встретилась закрывающаяся скобка, то (Deque#pollFirst) и 
    // сравниваем ее с встретившейся

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');map.put('<', '>');

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (map.containsValue(c)) {
                if (stack.isEmpty() || map.get(stack.pop()) != c) {
                    return false;
                }
            }
        }    
        return stack.isEmpty();
}
    
}