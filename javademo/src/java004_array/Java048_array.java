package java004_array;
/*
 * 1  2  3  4  5
 * 6  7  8  9  10
 * 11 12 13 14 15
 * 16 17 18 19 20
 * 
 *   
 * [출력 결과] =index 
 * 1  2  3  4  5  정방향
 * 10 9  8  7  6  역방향
 * 11 12 13 14 15  정방향
 * 20 19 18 17 16  역방향
 */
public class Java048_array {

	public static void main(String[] args) {
		int[][] num = { { 1, 2, 3, 4, 5 },
				        { 6, 7, 8, 9, 10 },
				        { 11, 12, 13, 14 ,15 },
				        { 16, 17, 18, 19, 20 } };
		
		for(int i = 0; i < num.length; i++) {
			for(int j = 0; j < num[i].length; j++) {
				if(i % 2 == 0) {
					System.out.printf("%4d", num[i][j]);
				} else {
					System.out.printf("%4d", num[i][num[i].length-1-j]);
				}
			}
			System.out.println();
		}
		
	}//end main

}//end class
