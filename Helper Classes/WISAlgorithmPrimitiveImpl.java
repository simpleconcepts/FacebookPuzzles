package com.wisapi.alg;

//	 Weighted interval scheduling.  See Kleinberg & Tardos, chapter 6
// 	 http://ranger.uta.edu/~weems/NOTES2320/wis.bs.c
public class WISAlgorithmPrimitiveImpl {

	final int TABSIZE = 600; // maximal number of ranges
	int n; // number of elements
	int[] s; // start points
	int[] f; // finish points
	int[] v; // values
	int[] p; // previous of specific range
	int[] M; // the dynamic memory table working table
	private int[] sPerm; // Indices ordered according to s[] to find p[]'s

	// s's permutation sorted by s's start points and having
	// indices , pointers to original ranges sorted by
	// finish points

	public WISAlgorithmPrimitiveImpl(int n, int[] s, int[] f, int[] v) {

		this.n = n;
		this.s = s;
		this.f = f;
		this.v = v;

		p = new int[TABSIZE];
		M = new int[TABSIZE];
		sPerm = new int[TABSIZE];
	}

	/**
	 * processes the scheduling
	 * 
	 */
	public void process() {
		// all the arrays are initilaized

		int i, j;

		// Create table of indices to s,
		for (i = 0; i < n; i++) {
			sPerm[i] = i + 1; // i is range number i
		}

		// then sort in ascending ref order to s. , that is by start point
		// the intervals must have come sorted by finish point
		// sPerm is another arrays where intervals sorted by their start point
		// in order to find the predecessor for each interval
		qSort(sPerm, 0, n - 1);

		// Merge sPerm[] (start points sorted) and s[] , start points
		// to get p[] values.
		f[0] = (-999999); // Dummy sentinel to stop for-loop
		j = n; // Goes backward through f , that is finish points
		for (i = n - 1; i >= 0; i--) {
			// added equality f[j]>'='s[sPerm[i]] because can't take
			// intervals that share common point in same level
			while (j >= sPerm[i] || f[j] >= s[sPerm[i]]) {
				j--; // go down till find the largest index predecesor
			}
			p[sPerm[i]] = j; // found the predecessor
		}

		// algorithm run by dynamic programming
		M[0] = 0;
		for (i = 1; i <= n; i++) {
			M[i] = max(v[i] + M[p[i]], M[i - 1]);
		}
	}

	public void printStatistics() {
		int i, sum = 0;

		System.out.println("  i   s   f   v   p   wrapMatrix\n");

		for (i = 1; i <= n; i++) {
			System.out.println(i + ": " + s[i] + " " + f[i] + " " + v[i] + " "
					+ p[i] + " " + M[i]);
		}

		for (i = n; i > 0;)
			if (v[i] + M[p[i]] >= M[i - 1]) {
				System.out.println("Include interval " + i + ": " + s[i] + " "
						+ f[i]);
				sum += v[i];
				i = p[i];
			} else
				i--;
		System.out.println("sum is " + sum);
	}

	// UTILITIES

	// return the maximum of two entries
	private int max(int x, int y) {
		if (x > y)
			return x;
		return y;
	}

	// quick sort implementation for sorting int array with predicate
	private void qSort(int[] vec, int left, int right) {
		int i, last;

		if (left >= right)
			return;

		swap(vec, left, (left + right) / 2);

		last = left;

		for (i = left + 1; i <= right; i++) {
			if (orderBys(vec[i], vec[left]) < 0) {
				swap(vec, ++last, i);
			}
		}
		swap(vec, left, last);

		qSort(vec, left, last - 1);
		qSort(vec, last + 1, right);
	}

	// comparator for sorting
	private int orderBys(int index1, int index2) {
		// Used to order array of indices according to values in another array.
		int result;

		// System.out.println(index1+"  "+index2);

		// whose start is earlier

		// System.out.println("ERROR check arr size "+s.length);
		result = s[index1] - s[index2];
		if (result != 0)
			return result;
		// same start point do by finish
		if (f[index1] != f[index2]) {
			return f[index1] - f[index2];
		}

		if (v[index1] != v[index2]) {
			return v[index1] - v[index2]; // Breaks s value tie using the s
											// subscripts.
		}
		return 1;
	}

	private void swap(int[] v2, int i, int j) {
		int temp;
		temp = v2[i];
		v2[i] = v2[j];
		v2[j] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// test 0
		int[] s0 = { 0, 3700 };
		int[] f0 = { 0, 3735 };
		int[] v0 = { 0, 14 };

		WISAlgorithmPrimitiveImpl wISArrayManager = new WISAlgorithmPrimitiveImpl(1, s0, f0, v0);
		wISArrayManager.process();
		wISArrayManager.printStatistics();
		/*
		// test 1
		int[] s1 = { 0, 0, 1, 4, 2, 7, 8 };
		int[] f1 = { 0, 3, 5, 6, 9, 10, 11 };
		int[] v1 = { 0, 2, 4, 4, 7, 2, 1 };

		wISArrayManager = new WISArrayManager(6, s1, f1, v1);
		wISArrayManager.process();
		wISArrayManager.printStatistics();

	
		// test 2
		int[] s2 = { 0, 1, 2, 3, 4, 5, 7, 10, 14, 16, 19 };
		int[] f2 = { 0, 4, 5, 6, 7, 8, 11, 15, 17, 20, 25 };
		int[] v2 = { 0, 5, 4, 3, 2, 1, 5, 4, 3, 2, 1 };

		wISArrayManager = new WISArrayManager(10, s2, f2, v2);
		wISArrayManager.process();
		wISArrayManager.printStatistics();

		// test 3
		int[] s3 = { 0, 1, 8, 20, 20, 22, 20, 28, 40, 49, 67, 66, 80, 80, 81,
				80, 85, 80, 88, 94, 0, 90, 80, 100, 112, 137, 135, 135, 137,
				144, 143, 161, 100, 210, 251, 200, 389, 388, 300, 417, 443,
				444, 444, 447, 464, 400, 500, 0, 509, 513, 512, 543, 543, 500,
				0, 616, 636, 600, 721, 749, 749, 760, 700, 839, 866, 800, 839,
				860, 989, 992, 995, 900, 0, 0, 512, 1000, 1269, 1023, 1394,
				1413, 1417, 1433, 1220, 1500, 1520, 1521, 1536, 1645, 1748,
				1520, 1812, 1900, 2000, 2010, 2001, 2000, 2000, 2106, 2100,
				2200, 2584, 2785, 2852, 2099, 3001, 3000, 3100, 3100, 3101,
				3106, 3110, 3106, 3206, 3268, 3401, 2000, 3737, 3700, 4001,
				4000, 4011, 4001, 4011, 4100, 4200, 4505, 3737, 1024, 5000,
				5001, 5000, 5010, 5010, 4120, 5192, 5192, 5190, 5332, 5431,
				5631, 1023, 6000, 6000, 6000, 6050, 6000, 6070, 6547, 6664,
				5555, 6666, 6660, 7000, 7000, 6970, 7070, 7134, 6970, 7050,
				7770, 0, 7937, 7000, 8000, 8000, 8000, 8060, 8080, 8080, 8080,
				8000, 8000, 8804, 8000, 8830, 8991, 8000, 9000, 8777, 9021,
				9021, 9090, 9200, 9200, 9955, 9898, 9993, 9799, 2000, 10001,
				10001, 11021, 12000, 12345, 12346, 13001, 13130, 13678, 13701,
				16384, 16384, 15500, 0, 0, 0, 0, 0, 0, 20002, 20000, 0, 0,
				22014, 23678, 25701, 26000, 29300, 20211, 30210, 31337, 0,
				6770, 6970, 32000, 32771, 32770, 33420, 33433, 33678, 34266,
				34339, 38803, 43678, 44441, 50000, 51840, 55187, 1024, 1016,
				24, 6031, 7008, 7000, 2048, 1001, 5001, 988, 1661, 1600, 1023,
				31821, 601, 2001, 901, 20001, 721, 301, 101, 256, 6001, 33434,
				1, 104, 1033, 20000, 0, 7778, 32768, 61, 591, 6532 };

		int[] f3 = { 0, 2, 10, 21, 23, 23, 25, 29, 43, 51, 68, 68, 81, 82, 83,
				83, 89, 89, 91, 95, 99, 100, 103, 108, 123, 138, 138, 139, 139,
				145, 145, 162, 199, 211, 265, 299, 390, 390, 399, 419, 444,
				445, 446, 449, 465, 499, 501, 501, 510, 514, 514, 544, 545,
				599, 599, 620, 637, 699, 730, 750, 751, 761, 799, 848, 867,
				899, 909, 909, 990, 993, 996, 999, 1022, 1023, 1023, 1023,
				1274, 1340, 1395, 1415, 1420, 1434, 1500, 1502, 1521, 1527,
				1570, 1646, 1754, 1754, 1813, 1903, 2001, 2011, 2016, 2020,
				2063, 2109, 2110, 2299, 2586, 2786, 2854, 2999, 3005, 3010,
				3101, 3102, 3106, 3108, 3112, 3206, 3216, 3269, 3411, 3467,
				3752, 3800, 4004, 4009, 4012, 4012, 4014, 4110, 4203, 4506,
				4752, 5000, 5001, 5002, 5010, 5014, 5015, 5120, 5193, 5199,
				5201, 5333, 5432, 5632, 5999, 6002, 6020, 6050, 6060, 6063,
				6071, 6548, 6665, 6666, 6667, 6670, 7001, 7002, 7070, 7071,
				7135, 7170, 7300, 7771, 7776, 7938, 8000, 8009, 8020, 8024,
				8079, 8081, 8085, 8099, 8100, 8250, 8809, 8888, 8890, 8993,
				9000, 9003, 9010, 9023, 9027, 9095, 9203, 9299, 9957, 9999,
				9999, 9999, 9999, 10003, 10006, 11023, 12002, 12346, 12350,
				13010, 13150, 13679, 13721, 16400, 16480, 16999, 19087, 19091,
				19103, 19106, 19143, 19146, 20005, 20010, 20607, 20615, 22029,
				23679, 25702, 26003, 29301, 30210, 30211, 31340, 31812, 32000,
				32000, 32020, 32774, 32780, 33553, 33553, 33679, 34267, 34342,
				38804, 43679, 44443, 50002, 51842, 55207, 65000, 65535, 65535,
				65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535,
				65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535,
				65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535,
				65535, 65535, 65535, 65535 };

		int[] v3 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		wISArrayManager = new WISArrayManager(270, s3, f3, v3);
		wISArrayManager.process();
		wISArrayManager.printStatistics();*/
	}
}