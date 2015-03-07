//max sum with two numbers
package JavaExamples;
import java.util.Scanner;

public class MaxSubArraySum
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Number of elements");
		int N = scan.nextInt();
		int[] arr = new int[N];
		System.out.println("Enter " + N + " elements");
		for(int i = 0; i < N; i++)
		{
			arr[i] = scan.nextInt();
		}
		System.out.println("Max sub array sum is "+ max_sum(arr));
	}
	public static int max_sum(int[] arr)
	{
		int N = arr.length;
		int max = 0;
		int sum = 0;
		System.out.println("Initial max value is " + max);
		for(int i = 0; i < N; i++)
		{
			if(i+1 < N)
			{
				sum = arr[i] + arr[i+1];
			}
			if(sum > max)
			{
				max = sum;
			}
			sum = 0;
		}
		return max;
	}
}
