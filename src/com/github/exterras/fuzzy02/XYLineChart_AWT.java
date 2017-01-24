package com.github.exterras.fuzzy02;

import java.awt.Color;
import java.awt.BasicStroke;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class XYLineChart_AWT extends ApplicationFrame {
	private double[] fuzzyHeights;
	
	public XYLineChart_AWT(String applicationTitle, String chartTitle, double[] fuzzyHeights) {
		super(applicationTitle);
		this.fuzzyHeights = fuzzyHeights;
		JFreeChart xylineChart = ChartFactory.createXYLineChart(chartTitle, 
				"Height", // x's category
				"Fuzzy", // y's category
				createDataset(), PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(xylineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 600)); // window
																		// size
		final XYPlot plot = xylineChart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesPaint(1, Color.GREEN);
		renderer.setSeriesPaint(2, Color.YELLOW);

		renderer.setSeriesStroke(0, new BasicStroke(4.0f));
		renderer.setSeriesStroke(1, new BasicStroke(3.0f));
		renderer.setSeriesStroke(2, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		setContentPane(chartPanel);
	}

	private XYDataset createDataset() {
		
		// line 1
		final XYSeries LOW = new XYSeries("Low");
		// obj.add(x, y)
		LOW.add(fuzzyHeights[0], 1.0);
		LOW.add(fuzzyHeights[1], 0.0);

		// line 2
		final XYSeries AVG = new XYSeries("Average");
		AVG.add(fuzzyHeights[2], 0.0);
		AVG.add(fuzzyHeights[3], 1.0);
		AVG.add(fuzzyHeights[4], 0.0);

		// line 3
		final XYSeries HIGH = new XYSeries("High");
		HIGH.add(fuzzyHeights[5], 0.0);
		HIGH.add(fuzzyHeights[6], 1.0);

		// add lines
		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(LOW);
		dataset.addSeries(AVG);
		dataset.addSeries(HIGH);
		return dataset;
	}

	// public static void main( String[ ] args )
	// {
	// XYLineChart_AWT chart =
	// new XYLineChart_AWT(
	// "Fuzzy Graphics",
	// "Height Fuzzy Graphics");
	// //XYLineChart_AWT chart = new XYLineChart_AWT(window title, graph title)
	//
	// chart.pack( );
	// RefineryUtilities.centerFrameOnScreen( chart );
	// chart.setVisible( true );
	// }
}
