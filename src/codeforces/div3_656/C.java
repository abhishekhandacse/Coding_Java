package codeforces.div3_656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
// I took hint from tutorial.. Was struck here.... 
// The though is, check the mountain array compatibility from right end...
// We are choosing right end because, from left end, it would be square complexity and from right it would linear
public class C{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);    
        String testcases = br.readLine();
        int TC = Integer.parseInt(testcases);
        int SIZE=200009;
        int[] arr=new int[SIZE];
        String[] line;
        for (int tc = 0; tc < TC; tc++){
            int N=Integer.parseInt(br.readLine());
            line=br.readLine().split(" ");
            for(int i=0;i<N;i++)
                arr[i]=Integer.parseInt(line[i]);

            int prev=N-1;
            boolean peak=false;
            int i;
            for(i=N-2;i>=0;i--){
                if(peak){
                    if(arr[i]<=arr[prev]){
                        prev=i;
                        continue;
                    }else break;
                }
                else if(arr[i]>=arr[prev]){
                    prev=i;
                }else{
                    peak=true;
                    prev=i;
                }
            }
            pw.println(i+1);
        }
        pw.flush();
    }
}


/*
//// This gives Time Limit exceeded error O(N^2)
public class C{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);    
        String testcases = br.readLine();
        int TC = Integer.parseInt(testcases);
        int SIZE=200009;
        int[] arr=new int[SIZE];
        String[] line;
        for (int tc = 0; tc < TC; tc++){
            int N=Integer.parseInt(br.readLine());
            line=br.readLine().split(" ");
            for(int i=0;i<N;i++)
                arr[i]=Integer.parseInt(line[i]);

            
            int i,low,high,prev;
            for(i=0;i<N;i++){
                low=i;high=N-1;prev=Integer.MIN_VALUE;
                if(high-low+1<=2)break;// Always good
                while(low<=high){
                    if(arr[low]<arr[high]){
                        if(arr[low]>=prev){
                            prev=arr[low];
                            low=low+1;
                        }else break;
                    }else{
                        if(arr[high]>=prev){
                            prev=arr[high];
                            high=high-1;
                        }else break;
                    }
                }
                if(low>high)break;// Good
            }
            pw.println(i);
        }
        pw.flush();
    }
}
*/

/*
Analyzing the fastest java submission .... He has made some custom functions for taking input efficiently
By * Sadakant, contest: Codeforces Round #656 (Div. 3), problem: (C) Make It Good, Accepted, #, Copy
//"The Quieter You Become, The More You Are Able To Hear" - :)
import java.util.*;
import java.io.*;

public class Solution {
	public static PrintWriter w = new PrintWriter(System.out);
	public static void main(String args[] ) throws Exception {
		Reader in = new Reader();
		int t = in.nextInt();
		while(t-- > 0) {
			int n = in.nextInt();
			int[] arr = in.nextIntArray(n);
			int x=-1,y=-1,cnt=0;
			if(n < 3) {
				w.println("0");
				continue;
			}
			for (int i=n-2; i>=0; i--) {
				if(arr[i] < arr[i+1]) {
					x = i;
					cnt += (n-1-i);
					break;
				}
				if(i == 0)
					cnt += (n);
			}
			if(x == 0)
				cnt++;
			//w.println(cnt + " " + x);
			for (int i=x-1; i>=0; i--) {
				if(arr[i] > arr[i+1]) {
					y = i;
					cnt += (x-i);
					break;
				}
				if(i == 0)
					cnt = n;
			}
			//w.println(cnt);
			w.println(n-cnt);
 		}
		w.flush();
		return;
	}
}

class Reader {
	final private int BUFFER_SIZE = 1 << 16;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public Reader() {
		din = new DataInputStream(System.in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}
	public String nextLine() throws IOException {
		int c = read();
		while(isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while(!isEndOfLine(c));
		return res.toString();
	}
	public String next() throws IOException {
		int c = read();
		while(isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while(!isSpaceChar(c));
		return res.toString();
	}
	public int nextInt() throws IOException {
		int ret = 0;
		byte c = read();
		while(c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if(neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}
	public int[] nextIntArray(int n) throws IOException {
		int a[] = new int[n];
		for(int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}
	public int[][] next2dIntArray(int n, int m) throws IOException {
		int a[][] = new int[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				a[i][j] = nextInt();
		return a;
	}
	public char nextChar() throws IOException {
		return next().charAt(0);
	}
	public long nextLong() throws IOException {
		long ret = 0;
		byte c = read();
		while(c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if(neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}
	public double nextDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = read();
		while(c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if(neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while((c = read()) >= '0' && c <= '9');
		if (c == '.') {
			while((c = read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}
		if(neg)
			return -ret;
		return ret;
	}
	private void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if(bytesRead == -1)
			buffer[0] = -1;
	}
	private byte read() throws IOException {
		if(bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}
	public void close() throws IOException {
		if(din == null)
			return;
		din.close();
	}
	public boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
	private boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	}
}	

*/