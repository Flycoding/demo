package com.flyingh.demo5;

import org.junit.Test;

public class Demo {

	private static final int M = 4;
	private static final int N = 13;

	@Test
	public void test() {
		int[][] array = new int[M][N];
		int row = M;
		boolean isUp = true;
		for (int i = 0; i < N; i++) {
			if (isUp) {
				array[--row][i] = i + 1;
				if (row == 0) {
					isUp = false;
				}
			} else {
				array[++row][i] = i + 1;
				if (row == M - 1) {
					isUp = true;
				}
			}
		}
		print(array);
	}

	private void print(int[][] array) {
		for (int[] is : array) {
			for (int i : is) {
				if (i == 0) {
					System.out.print(" ");
				} else {
					System.out.print(i);
				}
			}
			System.out.println();
		}
	}
}
