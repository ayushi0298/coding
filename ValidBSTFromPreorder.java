import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ValidBSTFromPreorder {

    //O(n2) complexity
    public boolean validBST(ArrayList<Integer> input, int start, int end) {
        boolean v1, v2;
        int justGreater = end + 1;

        if (start >= end) {
            return true;
        }
        int root = input.get(start);
        for (int i = start; i <= end; i++) {
            if (input.get((i)) > root) {
                justGreater = i;
                break;
            }
        }
        for (int i = justGreater; i <= end; i++) {
            if (input.get(i) < root) {
                return false;
            }
        }

        v1 = validBST(input, start + 1, justGreater - 1);
        System.out.println(v1);
        v2 = validBST(input, justGreater, end);
        System.out.println(v2);
        if (v1 == true && v2 == true) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        ValidBSTFromPreorder bst = new ValidBSTFromPreorder();
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(40, 30, 35, 20, 80, 100));
        int start = 0, end = input.size() - 1;
//        input.add(2);
//        input.add(4);
//        input.add(1);
        System.out.println(bst.validBST(input, start, end));

    }
}




























