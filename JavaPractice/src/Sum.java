import java.util.HashMap;
import java.util.HashSet;

public class Sum {
	public static void main(String[] args) {
		int[] a = { 8, 1, 3, 2, 6, 4, 5, 9, 10 };
		int finalSum = 6;
		int first = -1;
		int sec = -1;
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < a.length; i++) {
			if (a[i] < finalSum) {
				first = a[i];
			}
			for (int j = 1; j < a.length; j++) {
				if (a[j] < finalSum) {
					if (a[i] + a[j] == finalSum) {
						System.out.println(a[i] + " " + a[j]);
						set.add(a[i]);
						set.add(a[j]);

					}
				}
			}

			//System.out.println("Final - " + set.toString());
		}
	}
}
