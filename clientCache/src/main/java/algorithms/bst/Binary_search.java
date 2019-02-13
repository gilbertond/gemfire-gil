package algorithms.bst;

class Binary_search {
    //a is sorted array
    static int bin_search(int[] a, int key) {
        //TODO: Write - Your - Code
        if (a == null) return -1;

        return bin_search(a, 0, a.length - 1, key);
    }

    static int bin_search(int[] a, int start, int end, int key) {

        if (start > end) {
            return -1;
        }

        int mid = start + ((end - start) / 2);
        //if(mid<0) return -1;

        //System.out.println(start + ">"+key+"<" + end);
        if (a[mid] == key) {
            return mid;
        } else if (a[mid] > key) {
            return bin_search(a, start, mid - 1, key);
        } else {
            return bin_search(a, mid + 1, end, key);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100};
        System.out.println("Key(12) found at: " + bin_search(arr1, 12));
        System.out.println("Key(44) found at: " + bin_search(arr1, 44));
        System.out.println("Key(80) found at: " + bin_search(arr1, 80));
    }
}