
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.CovidTableModel;


public class MainWindowController implements Initializable {

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
    private TableColumn<CovidTableModel, ?> countryCol;
    @FXML
    private TableColumn<CovidTableModel, ?> janCol;
    @FXML
    private TableColumn<CovidTableModel, ?> febCol;
    @FXML
    private TableColumn<CovidTableModel, ?> marCol;
    @FXML
    private TableColumn<CovidTableModel, ?> aprCol;
    @FXML
    private TableColumn<CovidTableModel, ?> mayCol;
    @FXML
    private TableColumn<CovidTableModel, ?> junCol;
    @FXML
    private TableColumn<CovidTableModel, ?> julCol;
    @FXML
    private TableColumn<CovidTableModel, ?> augCol;
    @FXML
    private TableColumn<CovidTableModel, ?> sepCol;
    @FXML
    private TableColumn<CovidTableModel, ?> octCol;
    @FXML
    private TableColumn<CovidTableModel, ?> novCol;
    @FXML
    private TableColumn<CovidTableModel, ?> decCol;
    @FXML
    private Label totalNoOfCasesLb1;
    @FXML
    private TextField searchCountryTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void country1CBAction(ActionEvent event) {
        //e
    }

    @FXML
    private void country2CBAction(ActionEvent event) {
        //e
    }

    @FXML
    private void compareBtnAction(ActionEvent event) {
        //e
    }
    
    @FXML
    void exitCircleClicked(MouseEvent event) {
        //e
    }
    
}
