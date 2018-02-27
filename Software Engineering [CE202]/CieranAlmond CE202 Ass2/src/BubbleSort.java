import java.util.Arrays;

/**
 * Created by ca16873 on 22/11/2017.
 */
//Cieran Almond
public	class	BubbleSort	{

//bubblesort taken from pdf document
    public	static int[] bubble_sort(int array[]) {
        int	n =	array.length;
        int	k, temp;
        //changed pseudocode so system prints unsorted array, Array.toString used on array so it isnt jargan.
        System.out.println("Unsorted: " + Arrays.toString(array));
        for	(int m= n; m > 0; m--) {
            for	(int i = 0;	i <	n - 1; i++)	{
                k = i + 1;
                if (array[i] > array[k])	{
                    temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
            }
        }
        //changed pseudocode so system prints sorted array, Array.toString used on array so it isnt jargan.
        System.out.println("Sorted: " + Arrays.toString(array));
        return array;
    }
}