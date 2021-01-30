
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class CompareCountryController implements Initializable {

    @FXML
    private Label country1NameLb;
    @FXML
    private Label country2NameLb1;
    @FXML
    private Label country2NameLb;
    @FXML
    private Button backBtn;
    @FXML
    private Label totalNoOfCasesLb1;
    @FXML
    private ComboBox<?> country1CB;
    @FXML
    private ComboBox<?> country2CB;
    @FXML
    private Button compareBtn;
    @FXML
    private Pane lineChartPane;
    @FXML
    private LineChart<?, ?> lineChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backBtnAction(ActionEvent event) {
        //e
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
    
}
