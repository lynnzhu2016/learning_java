import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number between 1 and 20. Enter 0 to quit:\n");
        int num = scan.nextInt();
        int[] myArray = new int[20];
        while (num != 0) {
            if (num < 1 || num > 20) {
                System.out.println("Please enter a number between 1 and 20. Enter 0 to quit:\n");
                num = scan.nextInt();
                continue;
            }
            for (int i = 0; i < 20; i++) {
                int randomNumber = (int) (Math.random() * 20 + 1);
                myArray[i] = randomNumber;
            }
            System.out.println("Number array is: " + Arrays.toString(myArray));
            Arrays.sort(myArray);
            int found = binarySearch(myArray, num);

            if (found == -1)
                System.out.printf("Number %s not found.\n", num);
            else
                System.out.printf("Number %s found.\n", num);

            System.out.println("Please enter a number between 1 and 20. Enter 0 to quit:\n");
            num = scan.nextInt();
        }
    }

    static int binarySearch(int sortedArray[], int value){
        int midIndex = sortedArray.length/2;
        int midValue = sortedArray[midIndex];

        if(sortedArray.length == 0 ){
            return -1;
        }else if (midIndex == 0){
            if (midValue == value){
                return midValue;
            }else{
                return -1;
            }
        }else if(midValue == value){
            return midValue;
        }else if (value < midValue){
            return binarySearch(Arrays.copyOfRange(sortedArray, 0, midIndex), value);
        }else{
            return binarySearch(Arrays.copyOfRange(sortedArray, midIndex, sortedArray.length), value);
        }
    }
}
