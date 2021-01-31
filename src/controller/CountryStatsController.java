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
import jdk.internal.icu.impl.StringPrepDataReader;
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
        		ScatterChart.setVisible(false);
        		drawChart("Bar");
        	}else if(graphFilter.getSelectionModel().getSelectedItem().toString().equals("LineGraph")) {
        		barChartPane.setVisible(false);
        		ScatterChart.setVisible(false);
        		lineChartPane.setVisible(true);
        		drawChart("Line");
        	}else {
        		barChartPane.setVisible(false);
        		ScatterChart.setVisible(true);
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
        		ScatterChart.setVisible(false);
        		drawChart("Bar");
        	}else if(graphFilter.getSelectionModel().getSelectedItem().toString().equals("LineGraph")) {
        		barChartPane.setVisible(false);
        		ScatterChart.setVisible(false);
        		lineChartPane.setVisible(true);
        		drawChart("Line");
        	}else {
        		barChartPane.setVisible(false);
        		ScatterChart.setVisible(true);
        		lineChartPane.setVisible(false);
        		drawChart("Scatter");
        	}
		} catch (FileNotFoundException e) {AlertBox(e.toString());}
    }
    /*
    *Makes the chart of the country
    *
    */
    private void drawChart(String type) throws FileNotFoundException {
        dataList.clear();
        XYChart.Series series1 = new XYChart.Series<>();
        for(CovidTableModel data:getCovidData()){
            if(data.getCountry().equals(getCountryStatsName())){
                series1.getData().add(new XYChart.Data<>("Jan", data.getJanCol()));
                series1.getData().add(new XYChart.Data<>("Feb", data.getFebCol()-data.getJanCol()));
                series1.getData().add(new XYChart.Data<>("Mar", data.getMarCol()-data.getFebCol()));
                series1.getData().add(new XYChart.Data<>("Apr", data.getAprCol()-data.getMarCol()));
                series1.getData().add(new XYChart.Data<>("May", data.getMayCol()-data.getAprCol()));
                series1.getData().add(new XYChart.Data<>("Jun", data.getJunCol()-data.getMayCol()));
                series1.getData().add(new XYChart.Data<>("Jul", data.getJulCol()-data.getJunCol()));
                series1.getData().add(new XYChart.Data<>("Aug", data.getAugCol()-data.getJulCol()));
                series1.getData().add(new XYChart.Data<>("Sep", data.getSepCol()-data.getAugCol()));
                series1.getData().add(new XYChart.Data<>("Oct", data.getOctCol()-data.getSepCol()));
                series1.getData().add(new XYChart.Data<>("Noc", data.getNovCol()-data.getOctCol()));
                series1.getData().add(new XYChart.Data<>("Dec", data.getDecCol()-data.getNovCol()));
                
                dataList.addAll(Arrays.asList(data.getJanCol(),
                data.getFebCol()-data.getJanCol(),data.getMarCol()-data.getFebCol(),
                data.getAprCol()-data.getMarCol(),data.getMayCol()-data.getAprCol(),
                data.getJunCol()-data.getMayCol(),data.getJulCol()-data.getJunCol(),
                data.getAugCol()-data.getJulCol(),data.getSepCol()-data.getAugCol(),
                data.getOctCol()-data.getSepCol(),data.getNovCol()-data.getOctCol(),data.getDecCol()-data.getNovCol()));
                
                setDataValues(dataList);
                countryNameLb.setText(getCountryStatsName());
                totalNoOfCasesLb.setText(data.getDecCol()+"");

            }
        }
        /*
        *Making the different graphs
        */
        series1.setName(getCountryStatsName());
        if(type.equals("Bar")){
            countryBarChart.setAnimated(true);
            countryLineChart.getData().clear();
            ScatterChart.getData().clear();
            countryBarChart.getYAxis().setLabel("# Of Active Cases");
            countryBarChart.getXAxis().setLabel("Month");
            countryBarChart.getData().clear();
            countryBarChart.getData().addAll(series1);
            countryBarChart.setAnimated(false);

        }else if(type.equals("Line")){
            countryLineChart.setAnimated(true);
        	countryBarChart.getData().clear();
        	ScatterChart.getData().clear();
        	countryLineChart.getYAxis().setLabel("# Of Active Cases");
            countryLineChart.getXAxis().setLabel("Month");
            countryLineChart.getData().clear();
            countryLineChart.getData().addAll(series1);
            countryLineChart.setAnimated(false);
        }else{
            ScatterChart.setAnimated(true);
            countryBarChart.getData().clear();
            countryLineChart.getData().clear();
            ScatterChart.getYAxis().setLabel("# Of Active Cases");
            ScatterChart.getXAxis().setLabel("Month");
            ScatterChart.getData().clear();
            ScatterChart.getData().addAll(series1);
            ScatterChart.setAnimated(false);
        }
    }
    /**
     * making the summary of the dataset
     * 
     */
    private void setDataValues(ArrayList<Integer> list){
        int sum=0;
        double mean;
        double standDev;
        double median;
        int max;
        int min;

        for(int data:list){
          sum=sum+data;  
        }
        mean=sum/12;

        Collections.sort(list);
        min=list.get(0);
        max=list.get(list.size()-1);
        median=
    }
}
