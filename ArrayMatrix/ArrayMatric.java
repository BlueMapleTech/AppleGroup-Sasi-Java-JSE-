package com.sasi.ArrayMatrix;

import java.util.Scanner;

public class ArrayMatric {

	public static void main(String arg[]) {

		Scanner scr = new Scanner(System.in);
		System.out.println("enter no of rows");
		int row = scr.nextInt();
		System.out.println("enter no of column");
		int column = scr.nextInt();

		int[][] matrixArray = new int[row][column];
		int[][] matrix = new int[column][row];

		System.out.println("Now enter the data");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {

				matrixArray[i][j] = scr.nextInt();
			}
		}

		System.out.println("\nThe Matrix 1 is :");

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < column; j++) {

				System.out.print("\t" + matrixArray[i][j]);
				//matrix[j][i] = matrixArray[j][i];
			}
			System.out.println("");
		}

		System.out.println(" Tel me the Selected  row 1st");
		int a = scr.nextInt();

		System.out.println("Selected row  in 1st time" + a);

		/*
		 * System.out.println("Now enter the data");
		 * 
		 * 
		 * for(int j=0;j<row;j++){
		 *  for(int i=0;i<column;i++){ 
		 * matrix[j][i] =matrixArray[j][i]; 
		 * System.out.print("\t" +matrix[j][i]); 
		 * }
		 * System.out.println(""); }
		 */

		int[][] second = { { 1, 6, 5, 12 }, { 2, 7, 10, 13 }, { 3, 8, 15, 14 },
				{ 4, 9, 11, 16 } };

		for (int i = 0; i < second.length; i++) {
			for (int j = 0; j < second.length; j++) {
				System.out.print(second[i][j] + " ");
			}
			System.out.println("");
		}

		System.out.println("Tel me the Selected  row 2st");
		int b = scr.nextInt();

		System.out.println("Selected row in 2nd time:" + b);

		int c = 0;
		int k = 0;
		int w = 0;
		for (int a1 = 0; a1 < 4; a1++) {
			for (int b1 = 0; b1 < 4; b1++) {

				if (matrixArray[a][a1] == second[b][b1]) {
					c = c + 1;
					w = w + matrixArray[a][a1];
				}
			}

		}

		if (c == 1) {
			System.out.println("the value is" + w);
		} else if (1 < c) {
			System.out.println("bad");
		} else if (c == 0) {
			System.out.println("cheated");
		}
	}
}
