import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*ALGORITHM:


 */
public class NextGreaterElementTree {
    public void findGreater(ArrayList<Integer> input) {
        ArrayList<Integer> storeIndexes = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.size(); i++) {
            storeIndexes.add(-1);
        }
        //System.out.println(storeIndexes);
        for (int i = 0; i < input.size(); i++) {
            while (!stack.isEmpty() && input.get(i) > input.get(stack.peek())) {
                storeIndexes.set(stack.peek(), i);
                stack.pop();
            }
            stack.push(i);
//            System.out.println(i);
        }
        System.out.println(storeIndexes);
    }
    public static void main(String args[]) {
        NextGreaterElementTree bst = new NextGreaterElementTree();
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(40, 32, 30, 35));
        bst.findGreater(input);
    }
}
