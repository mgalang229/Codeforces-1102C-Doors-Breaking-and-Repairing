import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*

notes & observations:
- game lasts 10^100 turns
- cannot repair doors with 0 durability
- skipping turns (iff a player cannot make a move)
- policeman's goal: maximize doors with 0 durability
- slavik's goal: opposite of the policeman
- the order of the doors doesn't matter

Test case 1:
6 3 2
2 3 1 3 4 2
[1, 2, 2, 3, 3, 4]
[0, 0, 0, 0, 0, 0]

answer = 6

Test case 2:
5 3 3
1 2 4 2 3
[1, 2, 2, 3, 4]
[0, 5, 0, 6, 0]

answer = 2

Test case 3:
5 5 6
1 2 6 10 3
[1, 2, 3, 6, 10]
[0, 8, 0, 12, 0]

answer = 2

 */

public class Main {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		//T = fs.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = fs.nextInt();
			int x = fs.nextInt();
			int y = fs.nextInt();
			int[] a = fs.readArray(n);
			Arrays.sort(a);
			if (x > y) {
				out.print(n);
			} else {
				int cnt = 0;
				for (int i = 0; i < n; i += 2) {
					if (a[i] <= x) {
						cnt++;
					}
				}
				out.println(cnt);
			}
		}
		out.close();
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for (int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
	
	static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
