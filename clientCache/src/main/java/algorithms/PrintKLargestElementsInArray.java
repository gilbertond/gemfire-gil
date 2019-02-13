package algorithms;

import java.util.PriorityQueue;

public class PrintKLargestElementsInArray {
    public static void main(String[] args){

        int[] arr = new int[]{1, 23, 12, 9, 30, 2, 50};

//        printKlargestElements(new int[]{1, 23, 12, 9, 30, 2, 50}, 3);
        printKlargestElementsCustom(arr, 3);
        printArray(arr, 3);
    }

    //----Using a priority queue for a MAX heap----------//
    private static void printKlargestElements(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> -1 * o1.compareTo(o2));

        for(int val: arr){
            priorityQueue.offer(val);
        }

        System.out.println(priorityQueue);
        for (int i=1; i<=k; i++){
            System.out.println(priorityQueue.poll());
        }
    }

    //-----Using custom MAX heap implementation
    static void printKlargestElementsCustom(int[] arr, int n){
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[], int n)
    {
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
