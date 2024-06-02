/**
 * Example Output
 * Second Max = 230
 */
public class JavaQuest8 {
  // Write a loop to find the second max number.
  public static void main(String[] args) {
    int[] nums = new int[] { -10, 5, 100, 240, 230, 80 }; // Second Max = 230
    int[] nums2 = new int[] { -10, 5, 100, 120, 240, 200 }; // Second Max = 200
    int[] nums3 = new int[] { -10, 5, 120, -100, 100, 240 }; // Second Max = 120
    int[] nums4 = new int[] { -10, 5, 100, 240, 240, 80 }; // Second Max = 240

    // Your program should be able to handle all the above test case.
    // int secondMax;
    // code here ...
    System.out.println("Second Max = " + findSecondMax(nums));
    System.out.println("Second Max = " + findSecondMax(nums2));
    System.out.println("Second Max = " + findSecondMax(nums3));
    System.out.println("Second Max = " + findSecondMax(nums4));
  }

  public static int findSecondMax(int[] arr) {
    int max = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        secondMax = max;
        max = arr[i];
      } else if (arr[i] > secondMax) {
        secondMax = arr[i];
      }
    }
    return secondMax;
  }

}