
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class CountryStatsController implements Initializable {

    @FXML
    private Label totalNoOfCasesLb;
    @FXML
    private Label countryNameLb;
    @FXML
    private Button backBtn;
    @FXML
    private Label totalNoOfCasesLb1;
    @FXML
    private Pane barChartPane;
    @FXML
    private BarChart<?, ?> countryBarChart;
    @FXML
    private ComboBox<String> countryCB;

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
    private void countryCBAction(ActionEvent event) {
        //e
    }
    
}
