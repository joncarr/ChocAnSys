package controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ProcessVisitViewController {

    ChocAnSysApp main;
    Stage dialog;

    @FXML public static DatePicker datePickerServiceDate;
    @FXML private Label lblServiceFee;
    @FXML private Label lblServiceName;
    @FXML private Label lblCurrentMemberStatus;

    public void setMain(ChocAnSysApp main, Stage dialog){
        this.main = main;
        this.dialog = dialog;
    }

    @FXML
    public void validateMemberBtnHandler(){

    }

    @FXML
    public void submitClaimBtnHandler(){

    }

    @FXML
    public void cancelBtnHandler(){
        dialog.close();
    }
}
