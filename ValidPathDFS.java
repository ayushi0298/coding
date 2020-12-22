import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://www.interviewbit.com/problems/valid-path/
public class ValidPathDFS {
    boolean[][] markReachable;
    //arrays for finding 8 adjecent of a point
    int xOffset[] = {1, -1, 0, 0,1,-1,-1,1};
    int yOffset[] = {0, 0, 1, -1,1,-1,1,-1};

    //to print the visited matrix
    public void print2d(boolean visited[][], int rows, int columns) {
        //System.out.println("circles: " + circle +"rows: " + rows + "columns: " + columns + "radius: " + radius);

        for (int j = 0; j <= rows; j++) {
            for (int k = 0; k <= columns; k++) {
                System.out.print(visited[j][k] + " ");
            }
            System.out.println("");
        }

    }
   //this API is the first part of the question in which we are travelling to all the points present in the grid.
    public void markCoordinates(int circle, int rows, int columns, int radius, int A[], int B[]) {
        //System.out.println("circles: " + circle +"rows: " + rows + "columns: " + columns + "radius: " + radius);
        markReachable = new boolean[rows+1][columns+1];
        for (int i = 0; i < circle; i++) {
            for (int j = 0; j <= rows; j++) {
                for (int k = 0; k <= columns; k++) {
                    if (checkDistance(j, A[i], k, B[i]) <= radius) {
                        markReachable[j][k] = true;
                    }
                }
            }
        }
    }
    //called from callingDFS
    public void DFS(int x, int y, boolean visited[][], int rows, int columns) {
        int adjacentx, adjacenty;
        if (markReachable[x][y] != true) {
            visited[x][y] = true;
            for (int i = 0; i < xOffset.length; i++) {
                adjacentx = x + xOffset[i];
                adjacenty = y + yOffset[i];
                if (validCoordinates(adjacentx, adjacenty, rows, columns) == true && visited[adjacentx][adjacenty] == false) {
                    DFS(adjacentx, adjacenty, visited, rows, columns);
                }
            }
        }
    }

    boolean validCoordinates(int adjacentx, int adjacenty, int rows, int columns) {
        if (adjacentx >=0 && adjacentx <= rows && adjacenty >=0 && adjacenty <= columns) {
            return true;
        }
        return false;
    }
   //this API is second part of the question in which we are starting from the source and checking if this point is reachable or not
    String callingDFS(int rows, int columns) {
        boolean visited[][] = new boolean[rows + 1][columns + 1];
        // print2d(visited,rows,columns);
        visited[0][0] = true;
        DFS(0, 0, visited, rows, columns);
        // print2d(visited,rows,columns);
        if (visited[rows][columns] == true) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public double checkDistance(double x1, double x2, double y1, double y2) {

        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));

    }
//    public String solve(int rows, int columns, int circles, int radius, ArrayList<Integer> E, ArrayList<Integer> F) {
//        ValidPathDFS vd = new ValidPathDFS();
//        vd.markCoordinates(circles, rows, columns, radius, convertIntegers(E), convertIntegers(F));
//        return callingDFS(rows, columns);
//    }

    public int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    public static void main(String args[]) {
        ValidPathDFS vd = new ValidPathDFS();
        int rows, columns, circles, radius;
        rows = 41;
        columns = 67;
        circles = 5;
        radius = 0;
        int A[] = {17, 16, 12, 0, 40};
        int B[] = {52, 61, 61, 25, 31};
        vd.markCoordinates(circles, rows, columns, radius, A, B);
        System.out.println(vd.callingDFS(rows, columns));
//        System.out.println(vd.checkDistance(1, 2, 1, 3));

    }
}
