import java.util.Stack;
public class Evaluator {
    public long evaluate(String s) {
        Stack<Integer> operand = new Stack<>();

        String[] Split = s.split(" ");
        for(int i=0; i < Split.length; i++) {
            if(Split[i].equals("+")) {
                operand.push(operand.pop() + operand.pop());
            }
            else if(Split[i].equals("-")) {
                operand.push(-1 * operand.pop() + operand.pop());
            }
            else if(Split[i].equals("*")) {
                operand.push(operand.pop() * operand.pop());
            }
            else if(Split[i].equals("/")){
                int a = operand.pop(), b = operand.pop();
                operand.push(b / a);
            }
            else {
                operand.push(Integer.parseInt(Split[i]));
            }
        }
        return operand.pop();
    }
}
