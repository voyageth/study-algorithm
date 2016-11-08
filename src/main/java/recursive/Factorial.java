package recursive;

/**
 * @author voyageth
 *         2016-11-08
 */
public class Factorial {
	public int[] allFactorial(int n) {
		int[] results = new int[n];
		factorialRec(n, results, 0);
		return results;
	}

	public int factorialRec(int n, int[] results, int level) {
		if (n <= 1) {
			results[level] = 1;
			return 1;
		}
		int factorialValue = n * factorialRec(n - 1, results, level + 1);
		results[level] = factorialValue;
		return factorialValue;
	}

	public int factorialRec(int n) {
		if (n <= 1) {
			return 1;
		}
		return n * factorialRec(n - 1);
	}

	public int factorialIter(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
}
