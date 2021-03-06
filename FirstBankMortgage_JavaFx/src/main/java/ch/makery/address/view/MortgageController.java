package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.apache.poi.ss.formula.functions.FinanceLib;

import java.util.UUID;

import base.RateDAL;
import ch.makery.address.MainApp;
import ch.makery.address.model.Rate;


public class MortgageController {


    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MortgageController() {
    }
    

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    private Double CostOfHouse;
    private Integer creditScore;
    private Double expenses;
    private Integer term;
    private Double income;
    public static void calculateMortgage(int creditScoreParam, Double expensesParam, 
    		Double houseCostParam, Double incomeParam, Integer termParam){
    	
    	Double interestRate = RateDAL.getRate(creditScoreParam) / 100;
    	Double interestRateInstallments = interestRate / 12;
    	Integer payments = termParam * 12;
    	Double mortgage = (FinanceLib.pmt(interestRateInstallments, payments, houseCostParam, 0, false));
    }
    
   
}