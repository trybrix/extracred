/*
Develop an algorithm (Java or C++) that can find the ratio of the sum of the largest two numbers divided 
by the sum of the smallest two numbers in an array. 
The solution should be linear or better.  

For example:
If the input is 
int[] a={3,5,12,450,1,1,5,6,23,6,8,9,321,2,3};

The ratio is (450+321) / (1+1) = 385.5. 
*/

public class extracred {
    public static double findRatio(int[] nums) {
        int max1 = Integer.MIN_VALUE; 
        int max2 = Integer.MIN_VALUE; 
        
        int min1 = Integer.MAX_VALUE; 
        int min2 = Integer.MAX_VALUE; 

        //iterate num
        for (int num : nums) {
            //update num
            if (num > max1) {
                max2 = max1; //make old max to 2nd max
                max1 = num; //then set 1st max to curr num
            } else if (num > max2) {
                max2 = num; //then set max2 to curr num
            }
            
            //same thing but min
            if (num < min1) {
                min2 = min1; 
                min1 = num; 
            } else if (num < min2) {
                min2 = num; 
            }
        }
        //calc
        double sumMax = max1 + max2;
        double sumMin = min1 + min2;

        //return
        return sumMax / sumMin;
    }

    public static void main(String[] args) {
        int[] nums = {4, 7, 10, 369, 5, 5, 8, 9, 18, 4, 7, 11, 321, 4, 6};
        double ratio = findRatio(nums);
        System.out.println("The ratio is: " + ratio);
    }   //the output should be 385.5 which is ((450+321)/(1+1))
}
