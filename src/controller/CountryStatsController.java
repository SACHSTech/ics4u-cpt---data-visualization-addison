package controller;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import model.CovidTableModel;

/**
 * FXML Controller class
 *
 * @author Addison Chan
 */
public class CountryStatsController extends Controller {

    @FXML
    private Label totalNoOfCasesLb;
    @FXML
    private Label countryNameLb;
    @FXML
    private Button backBtn;
    @FXML
    private Pane barChartPane;
    @FXML
    private BarChart<String, Number> countryBarChart;
    @FXML
    private ComboBox<String> countryCB;
    @FXML
    private Pane lineChartPane;
    @FXML
    private LineChart<String, Number> countryLineChart;
    @FXML
    private ComboBox<String> graphFilter;
    @FXML
    private Label meanLb;
    @FXML
    private ScatterChart<String, Number> scatterChart;
    @FXML
    private Label medianLb;
    @FXML
    private Label maxLb;
    @FXML
    private Label minLb;
    @FXML
    private Label stanDevLb;

    ObservableList<String> graphFilterList = FXCollections.observableArrayList("BarGraph","LineGraph","ScatterGraph");
    ArrayList<Integer> dataList= new ArrayList<>();

    /**
     * Initializes the controller class.
	 * @author Engelbert.Aroozoo
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	countryNameLb.setText(getCountryStatsName());
    	totalNoOfCasesLb.setText(getCountryStatsTotalCases()+"");
    	graphFilter.setItems(graphFilterList);
    	graphFilter.getSelectionModel().select("BarGraph");
    	lineChartPane.setVisible(false);
    	scatterChart.setVisible(false);
    	barChartPane.setVisible(true);
    	
    	try {
			countryCB.setItems(getCountryName());
			drawChart("Bar");
		} catch (FileNotFoundException e) {AlertBox(e.toString());}
    	
    	countryCB.getSelectionModel().select(getCountryStatsName());
    	
    	
    }    

    @FXML
    private void backBtnAction(ActionEvent event) {
    	newWindow("MainWindow");
    	((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void countryCBAction(ActionEvent event) {
    	setCountryStatsName(countryCB.getSelectionModel().getSelectedItem().toString());
    	try {
    		if(graphFilter.getSelectionModel().getSelectedItem().toString().equals("BarGraph")) {
        		barChartPane.setVisible(true);
        		lineChartPane.setVisible(false);
        		scatterChart.setVisible(false);
        		drawChart("Bar");
        	}else if(graphFilter.getSelectionModel().getSelectedItem().toString().equals("LineGraph")) {
        		barChartPane.setVisible(false);
        		scatterChart.setVisible(false);
        		lineChartPane.setVisible(true);
        		drawChart("Line");
        	}else {
        		barChartPane.setVisible(false);
        		scatterChart.setVisible(true);
        		lineChartPane.setVisible(false);
        		drawChart("Scatter");
        	}
		} catch (FileNotFoundException e) {AlertBox(e.toString());}
    	
    }
    @FXML
    void grapFilterAction(ActionEvent event)  {
    	try {
    		if(graphFilter.getSelectionModel().getSelectedItem().toString().equals("BarGraph")) {
        		barChartPane.setVisible(true);
        		lineChartPane.setVisible(false);
        		scatterChart.setVisible(false);
        		drawChart("Bar");
        	}else if(graphFilter.getSelectionModel().getSelectedItem().toString().equals("LineGraph")) {
        		barChartPane.setVisible(false);
        		scatterChart.setVisible(false);
        		lineChartPane.setVisible(true);
        		drawChart("Line");
        	}else {
        		barChartPane.setVisible(false);
        		scatterChart.setVisible(true);
        		lineChartPane.setVisible(false);
        		drawChart("Scatter");
        	}
		} catch (FileNotFoundException e) {AlertBox(e.toString());}
    }
    
    /**
     * drawing the graphs
 	 * @author Addison Chan
	 */
    private void drawChart(String type) throws FileNotFoundException {
    	dataList.clear();
    	XYChart.Series series1 = new XYChart.Series();
    	
    	for(CovidTableModel data:getCovidData()) {
    		//Preparing the data points for the country1
    		if(data.getCountry().equals(getCountryStatsName())) {
    			series1.getData().add(new XYChart.Data("Jan", data.getJanCol()));
    	        series1.getData().add(new XYChart.Data("Feb", data.getFebCol()-data.getJanCol()));
    	        series1.getData().add(new XYChart.Data("March", data.getMarCol()-data.getFebCol()));
    	        series1.getData().add(new XYChart.Data("April", data.getAprCol()-data.getMarCol()));
    	        series1.getData().add(new XYChart.Data("May", data.getMayCol()-data.getAprCol()));
    	        series1.getData().add(new XYChart.Data("June", data.getJunCol()-data.getMayCol()));
    	        series1.getData().add(new XYChart.Data("July", data.getJulCol()-data.getJunCol()));
    	        series1.getData().add(new XYChart.Data("August", data.getAugCol()-data.getJulCol()));
    	        series1.getData().add(new XYChart.Data("Sep", data.getSepCol()-data.getAugCol()));
    	        series1.getData().add(new XYChart.Data("Oct", data.getOctCol()-data.getSepCol()));
    	        series1.getData().add(new XYChart.Data("Nov", data.getNovCol()-data.getOctCol()));
    	        series1.getData().add(new XYChart.Data("Dec", data.getDecCol()-data.getNovCol()));
    	        
    	        dataList.addAll(Arrays.asList(data.getJanCol(),
    	        		data.getFebCol()-data.getJanCol(),data.getMarCol()-data.getFebCol(),
    	        		data.getAprCol()-data.getMarCol(),data.getMayCol()-data.getAprCol(),
    	        		data.getJunCol()-data.getMayCol(),data.getJulCol()-data.getJunCol(),
    	        		data.getAugCol()-data.getJulCol(),data.getSepCol()-data.getAugCol(),
    	        		data.getOctCol()-data.getSepCol(),data.getNovCol()-data.getOctCol(),
    	        		data.getDecCol()-data.getNovCol()
    	        		));
    	        setDataValues(dataList);
    	        countryNameLb.setText(getCountryStatsName());
    	        totalNoOfCasesLb.setText(data.getDecCol()+"");
    		}
    	}
        
        series1.setName(getCountryStatsName());
        
        if(type.equals("Bar")) {
        	countryBarChart.setAnimated(true);
        	countryLineChart.getData().clear();
        	scatterChart.getData().clear();
        	countryBarChart.getYAxis().setLabel("# Of Active Cases");
            countryBarChart.getXAxis().setLabel("Month");
            countryBarChart.getData().clear();
            countryBarChart.getData().addAll(series1);
            countryBarChart.setAnimated(false);
        }else if(type.equals("Line")){
        	countryLineChart.setAnimated(true);
        	countryBarChart.getData().clear();
        	scatterChart.getData().clear();
        	countryLineChart.getYAxis().setLabel("# Of Active Cases");
            countryLineChart.getXAxis().setLabel("Month");
            countryLineChart.getData().clear();
            countryLineChart.getData().addAll(series1);
            countryLineChart.setAnimated(false);
        }else {
        	scatterChart.setAnimated(true);
        	countryBarChart.getData().clear();
        	countryLineChart.getData().clear();
        	scatterChart.getYAxis().setLabel("# Of Active Cases");
        	scatterChart.getXAxis().setLabel("Month");
        	scatterChart.getData().clear();
        	scatterChart.getData().addAll(series1);
        	scatterChart.setAnimated(false);
        }
        
    }
    
    /**
     * Set values to summary info of dataset variable
     */
    private void setDataValues(ArrayList<Integer> list) {
    	int sum=0;
    	double mean;
    	double standDev;
    	double median;
    	int max;
    	int min;
    	
    	// calculating sum of all the cases
    	for(int data: list) {
    		sum=sum+data;
    	}
    	
    	//calculating mean
    	mean = sum/12;
    	
    	// sorting list to find min , max , median
    	Collections.sort(list);
    	min=list.get(0);
    	max=list.get(list.size()-1);
    	median=(list.get(5)+list.get(6))/2;
 
    	// Calculating Standard Deviation 
    	int sumSD = 0;
        for (Integer i : list)
            sumSD += Math.pow((i - mean), 2);
        standDev=Math.sqrt( sumSD / ( list.size() - 1 ));
    	
        //Setting up the values of mean, median, min., max., standard Deviation to Labels
    	meanLb.setText(mean+"");
    	medianLb.setText(median+"");
    	maxLb.setText(max+"");
    	minLb.setText(min+"");
    	stanDevLb.setText(String.format("%.2f",standDev));
    	
    	
    	
    }
    
}
