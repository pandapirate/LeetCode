package LeetCode;

public class RemoveElement {
    public static int removeElement(int[] A, int elem) {

        int front = 0;
        int replaced = 0;
        int back = A.length-1;

        if (A.length == 1 && A[0] == elem)
            return 0;
        else if (A.length == 1)
            return 1;

        while (front <= back) {
            if (A[front] == elem) {
                replaced++;
                while(back > front && A[back] == elem) {
                    back--;
                    replaced++;
                }
                if (back > 0) {
                    A[front] = A[back];
                    A[back] = elem;
                    back--;
                }
                front++;
            } else {
                front++;
            }
        }

        return A.length - replaced;
    }

    public static void main (String args[]) {
        int[] list = new int[]{4, 4, 5, 5, 5};

        int x = removeElement(list, 5);
        System.out.println(x);
    }
}
