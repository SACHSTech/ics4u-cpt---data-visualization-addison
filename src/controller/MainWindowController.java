package controller;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.CovidTableModel;

/**
 * FXML Controller class
 *
 * @author Engelbert.Aroozoo
 */
public class MainWindowController extends Controller {

    @FXML
    private Label totalNoOfCasesLb;
    @FXML
    private ComboBox<String> country1CB;
    @FXML
    private ComboBox<String> country2CB;
    @FXML
    private Button compareBtn;
    @FXML
    private TableView<CovidTableModel> covidTable;
    @FXML
    private TableColumn<CovidTableModel, String> countryCol;
    @FXML
    private TableColumn<CovidTableModel, Integer> janCol;
    @FXML
    private TableColumn<CovidTableModel, Integer> febCol;
    @FXML
    private TableColumn<CovidTableModel, Integer> marCol;
    @FXML
    private TableColumn<CovidTableModel, Integer> aprCol;
    @FXML
    private TableColumn<CovidTableModel, Integer> mayCol;
    @FXML
    private TableColumn<CovidTableModel, Integer> junCol;
    @FXML
    private TableColumn<CovidTableModel, Integer> julCol;
    @FXML
    private TableColumn<CovidTableModel, Integer> augCol;
    @FXML
    private TableColumn<CovidTableModel, Integer> sepCol;
    @FXML
    private TableColumn<CovidTableModel, Integer> octCol;
    @FXML
    private TableColumn<CovidTableModel, Integer> novCol;
    @FXML
    private TableColumn<CovidTableModel, Integer> decCol;
    @FXML
    private TextField searchCountryTF;
    
    ObservableList<CovidTableModel> oblist = FXCollections.observableArrayList();
    private static ObservableList<CovidTableModel> filterList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	PopulateCovidTable();
    	try {
			country1CB.setItems(getCountryName());
			country2CB.setItems(getCountryName());
			totalNoOfCasesLb.setText(getTotalNoOfCases()+"");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			AlertBox(e.toString());
		}
    	
    	//OnMouseClicked Event for covidTable to show Selected Country stats
    	covidTable.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 1) {
                showCountryStats(event);
            }
        });
    	
    	
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
    		newWindow("CompareCountry");
    		((Node) (event.getSource())).getScene().getWindow().hide();
    	}
    	
    }
    
    @FXML
    void exitCircleClicked(MouseEvent event) {
    	System.exit(0);

    }
    
    
    
    /**
     * METHOD TO POLULATE CovidTable
     */
    public void PopulateCovidTable() {
    	
    	try {
			oblist=(ObservableList<CovidTableModel>) getCovidData();
		} catch (FileNotFoundException e) {AlertBox(e.toString());}

        countryCol.setCellValueFactory(new PropertyValueFactory<CovidTableModel, String>("country"));
        janCol.setCellValueFactory(new PropertyValueFactory<CovidTableModel, Integer>("janCol"));
        febCol.setCellValueFactory(new PropertyValueFactory<CovidTableModel, Integer>("febCol"));
        marCol.setCellValueFactory(new PropertyValueFactory<CovidTableModel, Integer>("marCol"));
        aprCol.setCellValueFactory(new PropertyValueFactory<CovidTableModel, Integer>("aprCol"));
        mayCol.setCellValueFactory(new PropertyValueFactory<CovidTableModel, Integer>("mayCol"));
        junCol.setCellValueFactory(new PropertyValueFactory<CovidTableModel, Integer>("junCol"));
        julCol.setCellValueFactory(new PropertyValueFactory<CovidTableModel, Integer>("julCol"));
        augCol.setCellValueFactory(new PropertyValueFactory<CovidTableModel, Integer>("augCol"));
        sepCol.setCellValueFactory(new PropertyValueFactory<CovidTableModel, Integer>("sepCol"));
        octCol.setCellValueFactory(new PropertyValueFactory<CovidTableModel, Integer>("octCol"));
        novCol.setCellValueFactory(new PropertyValueFactory<CovidTableModel, Integer>("novCol"));
        decCol.setCellValueFactory(new PropertyValueFactory<CovidTableModel, Integer>("decCol"));
        covidTable.setItems(null);
        covidTable.setItems(oblist);
        searchCountry();

    }
    
    /**
     * Search Country Based On Country Name Enter In SearchCountry TextField
     */
    public void searchCountry(){
        FilteredList<CovidTableModel> filteredData = new FilteredList<>(oblist, p -> true);
        
        searchCountryTF.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(record -> {
            // If  searchSongTextField is empty display all songs 
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();
            
            if (record.getCountry().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                return true; // country found.
            }
            return false; // Does not found.
            });
        });        
        SortedList<CovidTableModel> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(covidTable.comparatorProperty());
        covidTable.setItems(sortedData);
        
    }
    
    /**
     * Return total No of Cases 
     * by adding up all the cases
     * @throws FileNotFoundException 
     */
    public int getTotalNoOfCases() throws FileNotFoundException {
    	int sum=0;
    	for(CovidTableModel data: getCovidData()) {
    		sum=sum+data.getDecCol();
    	}
    	return sum;
    }
    
    
    /**
     * Show Statistics Of Selected Country from Table
     */
    public void showCountryStats(MouseEvent event){
        if (covidTable.getSelectionModel().getSelectedItem() != null) {
            CovidTableModel record = (CovidTableModel) covidTable.getSelectionModel().getSelectedItem();
            setCountryStatsName(record.getCountry());
            setCountryStatsTotalCases(record.getDecCol());
            newWindow("CountryStats");
            ((Node) (event.getSource())).getScene().getWindow().hide();
    
        }
    }
}
