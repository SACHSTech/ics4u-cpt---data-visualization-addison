package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.CovidTableModel;
/*
* @author Engelbert.Aroozoo
*/
public class Controller implements Initializable{
	
	/**
	 * Declaration of private variables
	 */
	private static String compareCountry1="";
	private static String compareCountry2="";
	private static String countryStatsName="";
	private static int countryStatsTotalCases;
	private double xOffset = 0;
    private double yOffset = 0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * AlertBox to show any type of information
	 * @param error
	 */
	void AlertBox(String info) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Info");
        a.setContentText(info);
        a.showAndWait();
        a.setHeaderText(null);
    }
	
	/**
	 * Returns Covid-19 Data of all Countries as ObservableList
	 * by Getting Data from CSV Dataset File(Covid-19-AnualReport.csv) placed in main Directory
	 * @return
	 * @throws FileNotFoundException
	 */
	public ObservableList<CovidTableModel> getCovidData() throws FileNotFoundException{
		ObservableList<CovidTableModel> list = FXCollections.observableArrayList();
		String line = "";  
		try   
		{  
		//parsing a CSV file into BufferedReader
		BufferedReader br = new BufferedReader(new FileReader("Covid-19-AnualReport.csv")); 
		br.readLine();
		while ((line = br.readLine()) != null)   //returns a Boolean value  
			{ 
			String[] data = line.split(",");    // use comma as separator  
			list.add(new CovidTableModel(
					formatCountryName(data[1], data[0]),
					Integer.parseInt(data[2]),
					Integer.parseInt(data[3]),
					Integer.parseInt(data[4]),
					Integer.parseInt(data[5]),
					Integer.parseInt(data[6]),
					Integer.parseInt(data[7]),
					Integer.parseInt(data[8]),
					Integer.parseInt(data[9]),
					Integer.parseInt(data[10]),
					Integer.parseInt(data[11]),
					Integer.parseInt(data[12]),
					Integer.parseInt(data[13])
					));
			}  
		}   
		catch (IOException e)   
		{  
		  AlertBox(e.toString());
		}  
		return list;  
	
	}
	
	/**
	 * Get CountryName List
	 * @throws FileNotFoundException 
	 */
	public ObservableList<String> getCountryName() throws FileNotFoundException{
		ObservableList<String> list = FXCollections.observableArrayList();
		for(CovidTableModel data: getCovidData()) {
			list.add(data.getCountry());
		}
		
		return list;
		
	}

	
	/**
     * METHODE TO LOAD NEW WINDOW 
     * @param winName 
     */
    public void newWindow(String winName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/"+winName+".fxml"));
            Parent root = (Parent) loader.load();
            Stage primaryStage = new Stage();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();
            
          //Code to Drag window
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });
          //move around here
            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                	primaryStage.setX(event.getScreenX() - xOffset);
                	primaryStage.setY(event.getScreenY() - yOffset);
                }
            });

        } catch (Exception e) {
            AlertBox(e + "");
        }
    }
    
    /**
     * format Country Name 
     */
    private String formatCountryName(String country,String province){
    	if(province.equals("")) {
    		return country;
    	}else {
    		return country+"/"+province;
    	}
    	
    }
	
	
    /**
     * Declaration of Getters and Setters of Private Fields
     * @return
     */
	public static String getCompareCountry1() {
		return compareCountry1;
	}

	public static void setCompareCountry1(String compareCountry1) {
		Controller.compareCountry1 = compareCountry1;
	}

	public static String getCompareCountry2() {
		return compareCountry2;
	}

	public static void setCompareCountry2(String compareCountry2) {
		Controller.compareCountry2 = compareCountry2;
	}

	public static String getCountryStatsName() {
		return countryStatsName;
	}

	public static void setCountryStatsName(String countryStatsName) {
		Controller.countryStatsName = countryStatsName;
	}

	public static int getCountryStatsTotalCases() {
		return countryStatsTotalCases;
	}

	public static void setCountryStatsTotalCases(int countryStatsTotalCases) {
		Controller.countryStatsTotalCases = countryStatsTotalCases;
	} 
	
	
	
	
	
	

}
