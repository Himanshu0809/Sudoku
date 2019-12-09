package sudoku;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Factorial_of_large {

	public static void factorial(int n)
	{
		int res[]=new int[500];
		res[0]=1;
		int res_size=1;
		for(int i=2;i<=n;i++)
		{
			res_size=multiply(i,res,res_size);
			
		}
		out.println("Factorial is: ");
		for(int i=res_size-1;i>=0;i--)
		{
			out.print(res[i]);
		}
	}
	
	public static int multiply(int x , int res[], int res_size)
	{
		int carry=0;
		for(int i=0;i<res_size;i++)
		{
			int prod=res[i]*x+carry;
			res[i]=prod%10;
			carry=prod/10;
			
		}
		while(carry!=0)
		{
			res[res_size]=carry%10;
			carry=carry/10;
			res_size++;
			
		}
		return res_size;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out = new PrintWriter(new BufferedOutputStream(System.out));
		FastReader s = new FastReader();
		int n=s.nextInt();
		factorial(n);
		out.close();
	}
	public static PrintWriter out;
	
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
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
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}
}
