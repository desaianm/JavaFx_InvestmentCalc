
package investment_value_calculator;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.*;

public class FXMLDocumentController {

    @FXML
    private Button button;

    @FXML
    private Label label_Invt_Amount;

    @FXML
    private Label label_Years;

    @FXML
    private Label label_Annual_Rate;

    @FXML
    private TextField int_amt;

    @FXML
    private TextField intrestrate;

    @FXML
    private TextField years;

    @FXML
    private Label label_Fut_value;

    @FXML
    private Label label_Fut_dsply;

    @FXML
    void Calculate_Button(ActionEvent event) throws IOException{
        
        String InvestmentAmount = int_amt.getText();
        String rate = intrestrate.getText();
        String yearof = years.getText();
        
        
        double intamount = Double.parseDouble(InvestmentAmount);
        double intrate  =  Double.parseDouble(rate)/100;
        int year =  (int) Math.rint(Integer.parseInt(yearof)*12);
        
        double futurevalue = 0;
        double montintrate = intrate/12;
        
        double forpower = (1+montintrate);
        double power = Math.pow(forpower,year);
        futurevalue = Math.round(intamount*power);
        label_Fut_dsply.setText("$"+futurevalue);
        
               

		
		

		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
              new FileOutputStream("filename.txt"), "utf-8"))) {
                writer.write("Principal amount is "+intamount+" Future value is "+futurevalue);
        }
        
        
        
        
        
        

    }

}
