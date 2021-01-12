import java.util.Stack;

public class BaseBallGame {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        for(String str : ops) {
            sb.append(str);
        }
        String str = sb.toString();
        Stack<Integer> stack = new Stack<>();
        int a=0, b=0, sum = 0;




                for(String op : ops) {
                    if (op.equals("+")) {
                        int top = stack.pop();
                        int newtop = top + stack.peek();
                        stack.push(top);
                        stack.push(newtop);
                    } else if (op.equals("C")) {
                        stack.pop();
                    } else if (op.equals("D")) {
                        stack.push(2 * stack.peek());
                    } else {
                        stack.push(Integer.valueOf(op));
                    }
                }

                int ans = 0;
                for(int score : stack) ans += score;
                System.out.println(ans);
            }
        }
