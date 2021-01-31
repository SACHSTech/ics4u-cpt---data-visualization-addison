package controller;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import model.CovidTableModel;


public class CompareCountryController extends Controller {

    @FXML
    private Label country1NameLb;
    @FXML
    private Label country2NameLb1;
    @FXML
    private Label country2NameLb;
    @FXML
    private Button backBtn;
    @FXML
    private ComboBox<String> country1CB;
    @FXML
    private ComboBox<String> country2CB;
    @FXML
    private Button compareBtn;
    @FXML
    private Pane lineChartPane;
    @FXML
    private LineChart<String, Number> lineChart;
    @FXML
    private Pane barChartPane;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private ComboBox<String> graphFilter;

    ObservableList<String> graphFilterList = FXCollections.observableArrayList("BarGraph","LineGraph");
    /**
     * Initializes the controller class.
	 * @author Engelbert.Aroozoo
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	try {
			country1CB.setItems(getCountryName());
			country2CB.setItems(getCountryName());
		} catch (FileNotFoundException e) {AlertBox(e.toString());}
    	
    	country1CB.getSelectionModel().select(getCompareCountry1());
    	country2CB.getSelectionModel().select(getCompareCountry2());
    	
    	country1NameLb.setText(getCompareCountry1());
    	country2NameLb.setText(getCompareCountry2());
    	
    	graphFilter.setItems(graphFilterList);
    	graphFilter.getSelectionModel().select("LineGraph");
    	lineChartPane.setVisible(true);
    	barChartPane.setVisible(false);	
    	try {
			drawChart("Line");
		} catch (FileNotFoundException e) {AlertBox(e.toString());}
    }    

    @FXML
    private void backBtnAction(ActionEvent event) {
    	newWindow("MainWindow");
    	((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void country1CBAction(ActionEvent event) {
    	setCompareCountry1(country1CB.getSelectionModel().getSelectedItem().toString());
    }

    @FXML
    private void country2CBAction(ActionEvent event) {
    	setCompareCountry2(country2CB.getSelectionModel().getSelectedItem().toString());
    }

    @FXML
    private void compareBtnAction(ActionEvent event) {
    	if(country1CB.getSelectionModel().isEmpty() || country2CB.getSelectionModel().isEmpty()) {
    		AlertBox("Please Selecte Both Countries To Continue!");
    		
    	}else {
    		try {
    			country1NameLb.setText(getCompareCountry1());
    			country2NameLb.setText(getCompareCountry2());
    			if(graphFilter.getSelectionModel().getSelectedItem().toString().equals("BarGraph")) {
            		barChartPane.setVisible(true);
            		lineChartPane.setVisible(false);
            		drawChart("Bar");
            	}else {
            		barChartPane.setVisible(false);
            		lineChartPane.setVisible(true);
            		drawChart("Line");
            	}
    		} catch (FileNotFoundException e) {
    			AlertBox(e.toString());
    		}
    	}
    	
    }
    
    @FXML
    void grapFilterAction(ActionEvent event)  {
    	try {
    		if(graphFilter.getSelectionModel().getSelectedItem().toString().equals("BarGraph")) {
        		barChartPane.setVisible(true);
        		lineChartPane.setVisible(false);
        		drawChart("Bar");
        	}else {
        		barChartPane.setVisible(false);
        		lineChartPane.setVisible(true);
        		drawChart("Line");
        	}
		} catch (FileNotFoundException e) {AlertBox(e.toString());}
    }
    
    
    /**
	 * FXML Controller class
	 *
	 * @author Addison Chan
	 */
    private void drawChart(String type) throws FileNotFoundException {
    	
    	XYChart.Series series1 = new XYChart.Series();
    	XYChart.Series series2 = new XYChart.Series();
    	
    	for(CovidTableModel data:getCovidData()) {
    		//Preparing the data points for the country1
    		if(data.getCountry().equals(getCompareCountry1())) {
    			series1.getData().add(new XYChart.Data("Jan", data.getJanCol()));
    	        series1.getData().add(new XYChart.Data("Feb", data.getFebCol()));
    	        series1.getData().add(new XYChart.Data("March", data.getMarCol()));
    	        series1.getData().add(new XYChart.Data("April", data.getAprCol()));
    	        series1.getData().add(new XYChart.Data("May", data.getMayCol()));
    	        series1.getData().add(new XYChart.Data("June", data.getJunCol()));
    	        series1.getData().add(new XYChart.Data("July", data.getJulCol()));
    	        series1.getData().add(new XYChart.Data("August", data.getAugCol()));
    	        series1.getData().add(new XYChart.Data("Sep", data.getSepCol()));
    	        series1.getData().add(new XYChart.Data("Oct", data.getOctCol()));
    	        series1.getData().add(new XYChart.Data("Nov", data.getNovCol()));
    	        series1.getData().add(new XYChart.Data("Dec", data.getDecCol()));
    		}
    		//Preparing the data points for the country2
    		if(data.getCountry().equals(getCompareCountry2())) {
    			series2.getData().add(new XYChart.Data("Jan", data.getJanCol()));
    	        series2.getData().add(new XYChart.Data("Feb", data.getFebCol()));
    	        series2.getData().add(new XYChart.Data("March", data.getMarCol()));
    	        series2.getData().add(new XYChart.Data("April", data.getAprCol()));
    	        series2.getData().add(new XYChart.Data("May", data.getMayCol()));
    	        series2.getData().add(new XYChart.Data("June", data.getJunCol()));
    	        series2.getData().add(new XYChart.Data("July", data.getJulCol()));
    	        series2.getData().add(new XYChart.Data("August", data.getAugCol()));
    	        series2.getData().add(new XYChart.Data("Sep", data.getSepCol()));
    	        series2.getData().add(new XYChart.Data("Oct", data.getOctCol()));
    	        series2.getData().add(new XYChart.Data("Nov", data.getNovCol()));
    	        series2.getData().add(new XYChart.Data("Dec", data.getDecCol()));
    		}
    	}
        
    	//Setting the name to the series
    	series1.setName(getCompareCountry1());
        series2.setName(getCompareCountry2());
        //Draw Bar Chart if barGraph is selected 
    	if(type.equals("Bar")) {
        	barChart.setAnimated(true);
        	lineChart.getData().clear();
        	barChart.getYAxis().setLabel("# Of Active Cases");
            barChart.getXAxis().setLabel("Month");
            barChart.getData().clear();
            barChart.getData().addAll(series1, series2);
            barChart.setAnimated(false);
        }//Draw Line Chart if LineGrapht is selected
    	else {
        	lineChart.setAnimated(true);
        	barChart.getData().clear();
        	lineChart.getYAxis().setLabel("# Of Active Cases");
            lineChart.getXAxis().setLabel("Month");
            lineChart.getData().clear();
            lineChart.getData().addAll(series1, series2);
            lineChart.setAnimated(false);
        }
        
        
        
    }
    
}
