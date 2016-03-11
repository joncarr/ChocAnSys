package controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ViewReportsViewController {

    ChocAnSysApp main;
    Stage dialog;

    public void setMain(ChocAnSysApp main, Stage dialog){
        this.main = main;
        this.dialog = dialog;
    }

    @FXML
    public void membersReportBtnHandler(){

    }

    @FXML
    public void providerReportBtnHandler(){

    }

    @FXML
    public void managersReportBtnHandler(){

    }

    @FXML
    public void eftDataBtnHandler(){

    }

    @FXML
    public void acmeUpdateBtnHandler(){

    }

    @FXML
    public void errorLogBtnHandler(){

    }

    @FXML
    public void backToMainMenuBtnHandler(){
        dialog.close();
    }
}
