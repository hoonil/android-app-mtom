package com.hillssoft.mtom.sample;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import base.BaseActivity;

import com.hillssoft.mtom.R;

public class GraphActivity extends BaseActivity {
	ImageView graph;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample_graph);
		initializeView();
		initializeBindService();
		setInitializeViewEventListener();
		
		
	}

	
	@Override
	protected void initializeView() {
		// TODO Auto-generated method stub
		super.initializeView();
		
		
		

//		/**
//		 * [ 그래프 EX2) - achartengine ]
//		 */
//		
//		ShapeDrawable shapeDraw = new ShapeDrawable(new OvalShape());
//		shapeDraw.getPaint().setColor(Color.MAGENTA);
//		shapeDraw.setIntrinsicHeight(100);
//		shapeDraw.setIntrinsicWidth(100);
//		
//		graph = (ImageView)findViewById(R.id.graph);
//		graph.setImageDrawable(shapeDraw);
//		graph.setVisibility(View.INVISIBLE);
//
//		
//		
		/**
		 * [ 그래프 EX2) - achartengine ]
		 */
		
//		DefaultRenderer chart = new DefaultRenderer();
//		chart.setChartTitle(null);
//		chart.setChartTitleTextSize(35);
//		chart.setZoomButtonsVisible(false);
//		chart.setZoomEnabled(false);
//		chart.setShowLabels(false);
//		chart.setShowLegend(false);
//		chart.setInScroll(false);
//		chart.setZoomEnabled(false);
//		chart.setClickEnabled(false);
//		chart.setPanEnabled(false);
//		
//		double[] chartValues = new double[]{40, 60};
//		int[] chartColors = {Color.BLUE, Color.GRAY};
//		
//		CategorySeries chartCategory = new CategorySeries("Test Chart");
//		chartCategory.add("40%", chartValues[0]);
//		chartCategory.add("60%", chartValues[1]);
//
//		
//		chart.setLabelsTextSize(15);
//		chart.setLegendTextSize(25);
//		
//		for(int color : chartColors){
//			SimpleSeriesRenderer r = new SimpleSeriesRenderer();
//			r.setColor(color);
//			chart.addSeriesRenderer(r);
//		}
//		
//		GraphicalView gv = ChartFactory.getPieChartView(this, chartCategory, chart);
//		
//		LinearLayout chartLayout = (LinearLayout)findViewById(R.id.graph_layout);
//		chartLayout.addView(gv);
		
		
		
		
		
		
		
		
		
		
		
	}
	
	@Override
	protected void setInitializeViewEventListener() {
		// TODO Auto-generated method stub
		super.setInitializeViewEventListener();
	}

}
