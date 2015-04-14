package Quick;

public class QuickSort {

    public static int[] list = {2, 5, 13, 8, 3, 44, 0,9, 7, 9, 6, 15, 33, 23, 67, 1, 23};

    public static void main (String[] args) throws Exception {
        System.out.println("Begin: ");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        quickSort(0, list.length - 1);

        System.out.println("End: ");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void quickSort(int start, int end) {
        if (end <= start)
            return;

        int pivot = start + (end - start)/2;
        int result = sortAndSplit(start, end, pivot);

        quickSort(start, result-1);
        quickSort(result + 1, end);
    }

    public static int sortAndSplit(int start, int end, int split) {
        int pivot = list[split];
        swap(end, split);

        int front = start;
        for (int i = start; i < end; i++) {
            if (list[i] < pivot) {
                swap(i, front);
                front++;
            }
        }
        swap (front, end);
        return front;
    }

    public static void swap (int x, int y) {
        int a = list[x];
        list[x] = list[y];
        list[y] = a;
    }

    public static int partitions(int low,int high)
    {
        int p=low,r=high,x=list[r],i=p-1;
        for(int j=p;j<=r-1;j++)
        {
            if (list[j]<=x)
            {

                i=i+1;
                swap(list[i],list[j]);
            }
        }
        swap(list[i+1],list[r]);
        return i+1;
    }

    public static int selection_algorithm(int left,int right,int kth)
    {
        for(;;)
        {
            int pivotIndex=partitions(left,right);          //Select the Pivot Between Left and Right
            int len=pivotIndex-left+1;

            if(kth==len)
                return list[pivotIndex];

            else if(kth<len)
                right=pivotIndex-1;

            else
            {
                kth=kth-len;
                left=pivotIndex+1;
            }
        }
    }
}
