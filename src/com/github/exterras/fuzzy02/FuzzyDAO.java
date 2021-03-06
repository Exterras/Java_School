package com.github.exterras.fuzzy02;

import org.jfree.ui.RefineryUtilities;

public class FuzzyDAO {
	// variable initialize
	private int highHeight;
	private int lowHeight;
	
	private FuzzyDTO dto = new FuzzyDTO();
	private String[] heights = dto.getHeights();
		
	private int[] heightNumber = new int[heights.length];
	private double[] heightFuzzyEntire = new double[heights.length];
	private double[] heightFuzzyLow = new double[heights.length];
	private double[] heightFuzzyHigh = new double[heights.length];
	
	private double[] heightFuzzyLowToAvg = new double[heights.length];
	private double[] heightFuzzyAvgToHigh = new double[heights.length];
	
	private double[] fuzzyHeights = new double[7];
	
	public FuzzyDAO(){
		// bubble sort method
		bubbleSort();
	}

	private void bubbleSort(){
		// exception in cast (string to int)
		highHeight = FuzzyExceptions.stringToInt(heights[0]);
		lowHeight = FuzzyExceptions.stringToInt(heights[0]);
		
		int tempHeight = 0;
		
		// highHeight, lowHeight calculation
		for (int i = 0; i < heights.length; i++) {
			heightNumber[i] = FuzzyExceptions.stringToInt(heights[i]);
			if (heightNumber[i] > highHeight) { highHeight = heightNumber[i]; }
			if (heightNumber[i] < lowHeight) { lowHeight = heightNumber[i]; }
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
	}
	
	private double calcuAverage(){
		int heightSum = 0;
		double heightAvg = 0.0;
		
		for (int i = 0; i < heightNumber.length; i++) {
			heightSum += heightNumber[i];
		}
		heightAvg = (double)heightSum / (double)heightNumber.length;
		
		System.out.println();
		
		return heightAvg;
	}
	
	private double doubleFormat(String formatType, double value){
		return Double.parseDouble(String.format(formatType, value));
	}
	
	private void calcFuzzy(double heightAvg, int high_LowHeight, double averageRate){
		// fuzzy calculation
		int low_HighHeight = 0;
		double heightFuzzyLowZero = 0.0;
		
		//final int high_stdHeight = 180;
		
		// lowAverageFuzzy == start of average fuzzy, lowFuzzy
		// highAverageFuzzy == end of average fuzzy
		double lowAverageFuzzy = averageRate;
		double highAverageFuzzy = averageRate;
		
		// low fuzzy 중 가장 키가 큰 변수를 골라내는 과정
		for (int i = 0; i < heightNumber.length; i++) {
			if (heightNumber[i] < heightAvg) {
				low_HighHeight = heightNumber[i];
			} 
		}
		
		// fuzzyEntire == Entire Height Fuzzy
		// fuzzyLow == Low Height Fuzzy 
		// fuzzyHigh == High Height Fuzzy
		// 100 나누기 각 소속 집단별로 최대값과 최소값를 구하여 그 차액 -> 전체 집단에서 한 눈금이 차지하는 비율
		double fuzzyEntire = doubleFormat( "%.2f" , (100 / (double)(highHeight - lowHeight)) );
		double fuzzyLow = doubleFormat( "%.2f" , (100 / (double)(low_HighHeight - lowHeight)) );
		double fuzzyHigh = doubleFormat( "%.2f" , (100 / (double)(highHeight - high_LowHeight)) );
		
		// lowHalffuzzy == a height of lowFuzzy is lowAverageFuzzy
		// highHalffuzzy == a height of highFuzzy is highAverageFuzzy
		double height_LowfuzzyHalf = doubleFormat( "%.2f" ,  
				(double)low_HighHeight - ( (lowAverageFuzzy*100) / (double)fuzzyLow) );
		// Low 집단 중 Average 집단에 소속될 수 있는 최소한의 키 ==
		// low 집단 중 가장 큰 키  - (low 집단 중 평균으로 속할 수 있는 소속도 * 100) / low 집단전체 한 눈금이 차지하는 비율
		
		double height_HighfuzzyHalf = doubleFormat( "%.2f" , 
				( (highAverageFuzzy*100) / (double)fuzzyHigh ) + (double)high_LowHeight );
		// High 집단 중 Average 집단에 소속될 수 있는 최대한의 키 ==
		// (high 집단 중 평균으로 속할 수 있는 소속도 * 100) / low 집단에서 한 눈금이 차지하는 비율 + 큰 키를 판별하는 기준 키
		
		// Average 집단을 구하기 위해 집단의 평균 키를 구하고 올라가는 곡선(fuzzyLowToAvg)과 내려가는 곡선(fuzzyAvgToHigh)의 1cm별 소속도 구하기
		double averageHeight = (height_HighfuzzyHalf + height_LowfuzzyHalf) / 2;
		double fuzzyLowToAvg = doubleFormat( "%.2f" , (100 / (double)(averageHeight - height_LowfuzzyHalf)) );
		double fuzzyAvgToHigh = doubleFormat( "%.2f" , (100 / (double)(height_HighfuzzyHalf - averageHeight)) );
		
		// 각 집단별 fuzzy 구하기
		for (int m = 0; m < heightNumber.length; m++) {	
			double tempEntire = (fuzzyEntire * (heightNumber[m] - lowHeight)) / 100;
			double tempLow = (fuzzyLow * (low_HighHeight - heightNumber[m])) / 100;
			double tempHigh = (fuzzyHigh * (heightNumber[m] - high_LowHeight)) / 100;
			
			double tempLowToAvg = (fuzzyLowToAvg * (heightNumber[m] - height_LowfuzzyHalf)) / 100;
			double tempAvgToHigh = (fuzzyAvgToHigh * (height_HighfuzzyHalf - heightNumber[m])) / 100;
			// 각 집단들의 퍼지 논리 (0~1 사이의 실수값) = (눈금자 * (최대범위 - 최소범위)) / 100
			
			heightFuzzyEntire[m] = doubleFormat( "%.2f" , tempEntire);
			heightFuzzyLow[m] = doubleFormat( "%.2f" , tempLow);
			heightFuzzyHigh[m] = doubleFormat( "%.2f" , tempHigh);
			heightFuzzyLowToAvg[m] = doubleFormat( "%.2f" , tempLowToAvg);
			heightFuzzyAvgToHigh[m] = doubleFormat( "%.2f" , tempAvgToHigh);
			// Fuzzy 값의 범위 = 0.0 ~ 1.0
		} 
		
		// fuzzy print - entire
		System.out.print("[Height Entire Fuzzy] : ");
		for (int n = 0; n < heightNumber.length; n++) {
			if (n == heightNumber.length-1) {
				System.out.println(heightFuzzyEntire[n]);
			} else {
				System.out.print(heightFuzzyEntire[n] + ", ");
			}
		}
		
		// fuzzy print - low
		System.out.print("[Height Low Fuzzy] : ");
		for (int n = 0; n < heightNumber.length; n++) {
			if((double)heightNumber[n] > heightAvg){
				break;
			} else {
				if (heightFuzzyLow[n] > 0.0) {
					System.out.print(heightFuzzyLow[n] + ", ");
				} else if(heightFuzzyLow[n] == 0.0){
					heightFuzzyLowZero = heightNumber[n];
					System.out.println(heightFuzzyLow[n]);
				}
			}
		}
		
		// fuzzy print - high
		System.out.print("[Height High Fuzzy (std = 0.00)] : ");
		for (int n = 0; n < heightNumber.length; n++) {
			if ((double)heightNumber[n] >= high_LowHeight) {
				if (heightFuzzyHigh[n] < 1.0) {
					System.out.print(heightFuzzyHigh[n] + ", ");
				} else if(heightFuzzyHigh[n] == 1.0){
					System.out.println(heightFuzzyHigh[n]);
				}
			}
		}
		
		System.out.println();
		
		// fuzzy print - average
		System.out.println("[Height Average Fuzzy(Low Fuzzy : "+lowAverageFuzzy+"~0, "
				+ "High Fuzzy : 0.0~"+highAverageFuzzy+")]");
		
		// fuzzy print - lowToAvg
		System.out.print("[Height lowToAvg Fuzzy] : ");
		for (int n = 0; n < heightNumber.length; n++) {
			if ((double)heightNumber[n] >= height_LowfuzzyHalf) {
				if (heightFuzzyLowToAvg[n] < 1.0) {
					System.out.print(heightFuzzyLowToAvg[n] + ", ");
				} else if(heightFuzzyLowToAvg[n] == 1.0){
					System.out.println(heightFuzzyLowToAvg[n]);
				}
			}
		}
		
		System.out.println("");
		
		// fuzzy print - avgToHigh
		System.out.print("[Height avgToHigh Fuzzy] : ");
		for (int n = 0; n < heightNumber.length; n++) {
//			if((double)heightNumber[n] > height_HighfuzzyHalf){
//				break;
//			} else 
				if((double)heightNumber[n] >= averageHeight){
					if (heightFuzzyAvgToHigh[n] > 0.0) {
						System.out.print(heightFuzzyAvgToHigh[n] + ", ");
					} else if(heightFuzzyAvgToHigh[n] == 0.0){
						System.out.println(heightFuzzyAvgToHigh[n]);
					}
					
			}
		}
		
		System.out.println("\n");
		
		// sort print (each fuzzy to height)
		System.out.println("[High 1.0 Height] : " + highHeight); 
		fuzzyHeights[6] = highHeight;
		System.out.println("[High "+highAverageFuzzy+" Height] : " + height_HighfuzzyHalf); 
		fuzzyHeights[4] = height_HighfuzzyHalf;
		System.out.println("[High 0.0 Height (Standard)] : " + high_LowHeight); 
		fuzzyHeights[5] = high_LowHeight;
		
		System.out.println("[Entire Average Height] : "+(int)heightAvg);
		System.out.println("[Average Fuzzy Standard Height] : " + averageHeight); 
		fuzzyHeights[3] = averageHeight;
		
		System.out.println("[Low Fuzzy 0.0 Height] : " + heightFuzzyLowZero); 
		fuzzyHeights[1] = heightFuzzyLowZero;
		System.out.println("[Low Fuzzy "+lowAverageFuzzy+" Height] : " + height_LowfuzzyHalf);  
		fuzzyHeights[2] = height_LowfuzzyHalf;
		System.out.println("[Low 1.0 Height] : " + lowHeight); 
		fuzzyHeights[0] = lowHeight;
		
		System.out.println();
		
		// fuzzy decision
		System.out.println("[Fuzzy Entire Decision]");

		for (int o = 0; o < heightNumber.length; o++) {
			if (heightNumber[o] > height_HighfuzzyHalf) {
				System.out.println("Tall");
			} else if (heightNumber[o] >= high_LowHeight && heightNumber[o] < height_HighfuzzyHalf) {
				System.out.println("Average Tall");
			} else if (heightNumber[o] >= heightFuzzyLowZero && heightNumber[o] < high_LowHeight) {
				System.out.println("Average");
			} else if (heightNumber[o] >= height_LowfuzzyHalf && heightNumber[o] < heightFuzzyLowZero) {
				System.out.println("Average Small");
			} else if (heightNumber[o] >= lowHeight) {
				System.out.println("Small");
			}
		}
	}
	
	public void doFuzzy(int high_lowHeight, double averageRate){
		
		// calcuAverage() : whole average calculation method
		// fuzzy calculation method
		
		if (high_lowHeight < lowHeight || high_lowHeight > highHeight) {
			System.out.println("Wrong Input the High 0.0 Height");
			return;
		}
		
		if (averageRate < 0.0 || averageRate > 1.0) {
			System.out.println("Wrong Input the Average Rate");
			return;
		} else {
			try {
				calcFuzzy(calcuAverage(), high_lowHeight, averageRate);
			} catch (NumberFormatException e) {
				System.out.println("Number Format Exception Occured"); 
			} catch (Exception e) {
				System.out.println("Exception Occured");
			}
			
			XYLineChart_AWT chart = 
					new XYLineChart_AWT(
							"Fuzzy Graphics", 
							"Height Fuzzy Graphics", 
							fuzzyHeights);
			chart.pack();
			RefineryUtilities.centerFrameOnScreen(chart);
			chart.setVisible(true);
		}
	}
}
