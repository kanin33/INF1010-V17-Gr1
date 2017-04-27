public class QuickSorter<T extends Comparable<T>> {

    public T[] sort(T[] list) {
        // Handle the case of an empty or singelton list here (not covered in algo).
        if (list.length > 1)
            quickSort(list, 0, list.length - 1);
        return list;
    }

    /**
     * @param list the array to be sorted (in place).
     * @param low lower index to include in sorting (inclusive)
     * @param high upper index to include in sorting (inclusive).
     */
    private void quickSort(T[] list, int low, int high) {
        int i = low, j = high;

        // Just choose the middle element as pivot (good if partially sorted).
        T pivot = list[low + (high-low)/2];

        // Put all elements smaller than pivot to the left of pivot.
        while (i <= j) {
            // Scan for an element larger than pivot.
            while (list[i].compareTo(pivot) < 0)
                i++;
            // Scan for an element smaller than pivot.
            while (list[j].compareTo(pivot) > 0)
                j--;

            // If we found something that needed to be swapped, do it!
            if (i <= j)
                swap(list, i++, j--);
        }

        // Base case: Only recurse if more than one element to the left of pivot.
        if (low < j)
            quickSort(list, low, j);
        // Base case: Only recurse if more than one element to the right of pivot.
        if (i < high)
            quickSort(list, i, high);
    }

    private void swap(T[] list, int a, int b) {
        T tmp = list[a];
        list[a] = list[b];
        list[b] = tmp;
    }
}
