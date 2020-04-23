package DP;

public class DominoAndTromino_790 {
	public static int numTilings(int N) {
		int[] full = new int[N+1];
		full[0] = 0;
		full[1] = 1;
		full[2] = 2;
		full[3] = 5;
//		int[] partial = new int[N+1];
//		partial[0] = 0;
//		partial[1] = 0;
//		partial[2] = 2;
//		for (int i = 3; i <= N; i++) {
//			full[i] = full[i-1] + partial[i-1] + full[i-2];
//			partial[i] = partial[i-1] + 2*full[i-2];
//		}
		
		//By one Dp only
		for (int i = 4; i <= N; i++) {
			full[i] = 2*full[i-1] + full[i-3];
		}
		return full[N];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTilings(30));
	}

}
