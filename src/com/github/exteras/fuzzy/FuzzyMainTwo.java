package com.github.exteras.fuzzy;

public class FuzzyMainTwo {
	
	private static int tryCatch(String _heightString){
		int heightInt = 0;
		try {
			heightInt = Integer.parseInt(_heightString);
		} catch (Exception e) {
			System.out.println("Height is only numbers not a character");	
			System.exit(1);
		}
		return heightInt;
	}
	
	public static void main(String[] args) {
		
		// databases
		String[] heights = {"180", "175", "179", "194", "172", "165", "184", "159", "182", "190"};
		double[] stdFuzzys = {1.0, 0.8, 0.6, 0.4, 0.2, 0.0};
		
		// variable initialize
		int highHeight = 0;
		int lowHeight = 0;
		int tempHeight = 0;
		int[] heightNumber = new int[heights.length];
		double[] heightFuzzy = new double[heights.length];
		
		// constant 
		final int percent = 100;
//		final int stdHeight = 180;
//		final double stdFuzzy = 0.8;
		
		// exception in cast (string to int)
		highHeight = FuzzyMainTwo.tryCatch(heights[0]);
		lowHeight = FuzzyMainTwo.tryCatch(heights[0]);
		
		// highHeight, lowHeight calculation
		for (int i = 0; i < heights.length; i++) {
	
			heightNumber[i] = FuzzyMainTwo.tryCatch(heights[i]);
			
			if (heightNumber[i] > highHeight) {
				highHeight = heightNumber[i];
			}
			
			if (heightNumber[i] < lowHeight) {
				lowHeight = heightNumber[i];
			}
		}
		
		// bubble sort
		for (int i = 0; i < heightNumber.length; i++) {
			for (int j = 0; j < heightNumber.length - 1; j++) {
				if (heightNumber[j] > heightNumber[j+1]) {
					tempHeight = heightNumber[j];
					heightNumber[j] = heightNumber[j+1];
					heightNumber[j+1] = tempHeight;
				}
			}
		}
		
		// Ascending
		System.out.println("[Ascending Bubble Sort]");
		for(int k = 0; k< heightNumber.length; k++) {
			if (k == heightNumber.length-1) {
				System.out.println(heightNumber[k]);
			} else {
				System.out.print(heightNumber[k] + ", ");
			}
		} 
		
		// Descending
		System.out.println("[Descending Bubble Sort]");
		for(int l = heightNumber.length-1; l >= 0; l--) {
			if (l == 0) {
				System.out.println(heightNumber[l]);
			} else {
				System.out.print(heightNumber[l] + ", ");
			}
		} 
		
		System.out.println();
		
		// sort print 
		System.out.println("[The Most Highest Height] : " + highHeight);
		System.out.println("[The Most Lowest Height] : " + lowHeight);
		
		System.out.println();
		
		// fuzzy calculation
		double fuzzyOne = Double.parseDouble(
				String.format("%.2f", (percent / (double)(highHeight - lowHeight))));
		
		for (int m = 0; m < heightNumber.length; m++) {	
			double temp = (fuzzyOne * (heightNumber[m] - lowHeight)) / percent;
			heightFuzzy[m] = Double.parseDouble(String.format("%.2f", temp));
		} 
		
		// fuzzy print
		System.out.println("[Height Fuzzy]");
		for (int n = 0; n < heightNumber.length; n++) {
			if (n == heightNumber.length-1) {
				System.out.println(heightFuzzy[n]);
			} else {
				System.out.print(heightFuzzy[n] + ", ");
			}
		}
		
		System.out.println();
		
		// fuzzy decision
		System.out.println("[Fuzzy Decision]");
		for (int o = 0; o < heightFuzzy.length; o++) {
			if (heightFuzzy[o] > stdFuzzys[1]) {
				System.out.println("Fuzzy " + (o+1) + " : " + "Tall");
			} else if( heightFuzzy[o] >= stdFuzzys[3] && heightFuzzy[o] < stdFuzzys[1]){
				System.out.println("Fuzzy " + (o+1) + " : " + "Middle");
			} else {
				System.out.println("Fuzzy " + (o+1) + " : " + "Small");
			}
		}
	}
}
