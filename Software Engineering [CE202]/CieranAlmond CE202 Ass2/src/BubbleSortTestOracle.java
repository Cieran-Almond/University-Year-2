/**
 * Created by ca16873 on 22/11/2017.
 */
//Cieran Almond
public	class BubbleSortTestOracle {


    public static boolean bubble_sort(int array[]) {
        //if length of array is 5, compare array to expected array declared below, loop through all elements and return true if matches each index i. else return false
        if (array.length == 5) {
            int expectedArray[] = {-5, 1, 5, 12, 16};
            for (int i = 0; i < array.length; i++) {
                if (array[i] != expectedArray[i]) {
                    return false;
                }
            }
            return true;
        }

        //if length of array is 1, compare array to expected array declared below,  loop through all elements and return true if matches each index i. else return false
        if (array.length == 1) {
            int expectedArray[] = {5};
            for (int i = 0; i < array.length; i++) {
                if (array[i] != expectedArray[i]) {
                    return false;

                }
            }
            return true;
        }

        //if length of array is 0, return true. else return false
        if (array.length == 0) {
                return true;
            }
            return false;
        }


    }



