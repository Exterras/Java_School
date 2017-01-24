package com.github.exteras.fuzzy;

public class FuzzyMain {
	
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
		
		String[] heights = {"180", "175", "167", "194", "172"};
		double[] heightFuzzy = new double[heights.length];
		
		int highHeight = 0;
		int lowHeight = 0;
		int[] heightNumber = new int[heights.length];
		
		int tempHeight = 0;
		
		highHeight = FuzzyMain.tryCatch(heights[0]);
		lowHeight = FuzzyMain.tryCatch(heights[0]);
		
		for (int i = 0; i < heights.length; i++) {
	
			heightNumber[i] = FuzzyMain.tryCatch(heights[i]);
			
			if (heightNumber[i] > highHeight) {
				highHeight = heightNumber[i];
			}
			
			if (heightNumber[i] < lowHeight) {
				lowHeight = heightNumber[i];
			}
		}
		
		for (int i = 0; i < heightNumber.length; i++) {
			for (int j = 0; j < heightNumber.length - 1; j++) {
				if (heightNumber[j] > heightNumber[j+1]) {
					tempHeight = heightNumber[j];
					heightNumber[j] = heightNumber[j+1];
					heightNumber[j+1] = tempHeight;
				}
			}
		}
		
		System.out.println("[Ascending Bubble Sort]");
		for(int k = 0; k< heightNumber.length; k++) {
			
			if (k == heightNumber.length-1) {
				System.out.println(heightNumber[k]);
			} else {
				System.out.print(heightNumber[k] + ", ");
			}
			
			
		} // Ascending
		
		System.out.println("[Descending Bubble Sort]");
		for(int l = heightNumber.length-1; l >= 0; l--) {
			if (l == 0) {
				System.out.println(heightNumber[l]);
			} else {
				System.out.print(heightNumber[l] + ", ");
			}
		} // Descending
		
		System.out.println();
		
		System.out.println("The Most Highest Height : " + highHeight);
		System.out.println("The Most Lowest Height : " + lowHeight);
		
		System.out.println();
		
		// fuzzy calculation
		double fuzzyOne = Double.parseDouble(String.format("%.2f", (100 / (double)(highHeight - lowHeight))));
		for (int m = 0; m < heightNumber.length; m++) {
			double temp = (fuzzyOne * (heightNumber[m] - lowHeight)) / 100;
			heightFuzzy[m] = Double.parseDouble(String.format("%.2f", temp));
		}
		
		// fuzzy print
		System.out.println("Height Fuzzy");
		for (int n = 0; n < heightNumber.length; n++) {
			if (n == heightNumber.length-1) {
				System.out.println(heightFuzzy[n]);
			} else {
				System.out.print(heightFuzzy[n] + ", ");
			}
		}
	}
}
