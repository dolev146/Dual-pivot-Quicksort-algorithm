/**
 * DualQuikSort 
 * whats up !
 * The code in front of you sorts an array of integer
 * numbers By activating the main function, you run the code.
 * Task: 
 * Write a sorting plan based on quick sort,
 * but instead of selecting one Pivot,
 * it selects two Pivots, and at each stage divides the array into three parts.
 * What is the runtime of the program at worst and at best?
 * In the course Data Structures there is a great emphasis
 * on a deep understanding of algorithms for sorting information,
 * finding the right sort for the information,
 * is a difficult problem, one must understand in depth the issue
 * in order to solve future problems in dealing with large databases.
 * Familiarity with the algorithms allows for creativity and finding the best
 * algorithms for the problem.
 * 
 * 
 * Emphasis on efficiency and understanding the conduct around the issue of
 * memory management and runtime.for short Big O :)
 * have fun!
 */

public class DualQuikSort {

    // Main function that bootstrap the code :)
    public static void main(String[] args) {
        int[] arr = { 10, 50, 106, 592, 700255, 252320, 2, 7420, 9565, 1000000 };

        dualPivotQuickSort(arr, 0, 7);

        System.out.print("arr: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    static void dualPivotQuickSort(int[] arr, int small, int big) {
        if (small < big) {

            // Partition is the main array we will work with
            
            int[] PartitionArr;
            PartitionArr = breakApartAndBringTogether(arr, small, big);

            dualPivotQuickSort(arr, small, PartitionArr[0] - 1);
            // 0 index will be the leftPivot pivot and
            // 1 index will be the right pivot
            dualPivotQuickSort(arr, PartitionArr[0] + 1, PartitionArr[1] - 1);
            // so now the stuff is splitted to three arrays and at the end we will do the calculations :)
            dualPivotQuickSort(arr, PartitionArr[1] + 1, big);
        }
    }

    static void replaceWithAdress(int[] arr, int k, int p) {
        int temp = arr[k];
        arr[k] = arr[p];
        arr[p] = temp;
    }

    

    static int[] breakApartAndBringTogether(int[] arr, int small, int big) {
        if (arr[small] > arr[big])
            replaceWithAdress(arr, small, big);


        // initiolazing some of the indexing counters that will help us in the proccess
        int bottomIndex1 = small + 1;
        int topIndex = big - 1;
        int bottomIndex2 = small + 1;
        int leftPivot = arr[small];
        int RightPivot = arr[big];

        // exit when top is less than bottom 
        // inside the loop we just follow the proccess that is required for making
        // the algorithm work properly as expected 
        // so we use some logic and makeing it work with love and bug free
        while (bottomIndex2 <= topIndex) {

            if (arr[bottomIndex2] < leftPivot) {
                replaceWithAdress(arr, bottomIndex2, bottomIndex1);
                bottomIndex1++;
            } 
            else if (arr[bottomIndex2] >= RightPivot) {
                while (arr[topIndex] > RightPivot && bottomIndex2 < topIndex) {
                    topIndex--;
                }                    
                replaceWithAdress(arr, bottomIndex2, topIndex);
                topIndex--;
                if (arr[bottomIndex2] < leftPivot) {
                    replaceWithAdress(arr, bottomIndex2, bottomIndex1);
                    bottomIndex1++;
                }
            }
            bottomIndex2++;
        }
        bottomIndex1--;
        topIndex++;

        // now we are bring the pivots to their right places where they belong.
        replaceWithAdress(arr, small, bottomIndex1);
        replaceWithAdress(arr, big, topIndex);
        // returning and array of the indexes of the pivots 
        return new int[] { bottomIndex1, topIndex };
    }

}