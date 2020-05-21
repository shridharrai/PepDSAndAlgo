package arraysAndStrings;

public class FibonacciNumber_509 {
	//O(logn)
	public static int fib(int N) {
		int[][] ans = new int[][] {{1,0},{0,1}};
		int[][] x = new int[][] {{1,1},{1,0}};
		while (N != 1) {
			if (N%2 != 0) {
				ans = multiply(ans, x);;
				N--;
			}
			x = multiply(x, x);
			N = N/2;
		}
		ans = multiply(ans, x);
		return ans[0][1];
	}
	
	public static int[][] multiply(int M1[][], int M2[][]) 
    { 
    int x =  M1[0][0]*M2[0][0] + M1[0][1]*M2[1][0]; 
    int y =  M1[0][0]*M2[0][1] + M1[0][1]*M2[1][1]; 
    int z =  M1[1][0]*M2[0][0] + M1[1][1]*M2[1][0]; 
    int w =  M1[1][0]*M2[0][1] + M1[1][1]*M2[1][1]; 
       
    M1[0][0] = x; 
    M1[0][1] = y; 
    M1[1][0] = z; 
    M1[1][1] = w;
    
    return M1;
    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fib(6));
	}

}
