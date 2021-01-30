
package controller;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Collections;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import model.CovidTableModel;
/*
*
*@author Addison.Chan
*/

public class CountryStatsController implements Initializable {

    @FXML
    private Label totalNoOfCasesLb;
    @FXML
    private Label countryNameLb;
    @FXML
    private Button backBtn;
    @FXML
    private Pane barChartPane;
    @FXML
    private BarChart<?, ?> countryBarChart;
    @FXML
    private ComboBox<String> countryCB;
    @FXML 
    private Pane lineChartPane;
    @FXML
    private LineChart<String, Number> countryLineChart;
    @FXML
    private ComboBox<String> graphFilter;
    @FXML
    private ScatterChart<String, Number> ScatterChart;
    @FXML
    private Label medianLB;
    @FXML
    private Label maxLB;
    @FXML
    private Label stanDevLB;

    ObservableList<String> graphFilterList = FXCollections.observableArrayList("BarGraph","LineGraph","ScatterGraph");
    ArrayList<Integer> dataList= new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        countryNameLb.setText(getCountryStatsName());
        totalNoOfCasesLb.setText(getCountryStatsTotalCases()+"");
        graphFilter.setItems(graphFilterList);
        graphFilter.getSelectionModel().select("BarGraph");
        lineChartPane.setVisible(false);
        ScatterChart.setVisible(false);
        barChartPane.setVisible(true);

        try{
            countryCB.setItems(getCountryName());
            drawChart("Bar");
        } catch (FileNotFoundException e) {AlertBox(e.toString());}

        countryCB.getSelectionModel().select(getCountryStatsName());
    }    
    /*
    *
    *@author for menu Engelbert.Aroozoo
    */
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
    
}
