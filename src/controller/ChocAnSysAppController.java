package controller;

import javafx.fxml.FXML;

public class ChocAnSysAppController {

    private ChocAnSysApp main;


    public void setMain(ChocAnSysApp main){
        this.main = main;
    }


    @FXML
    public void exitButtonClicked(){
        System.exit(0);
    }

    @FXML
    public void processBtnHandler(){
       main.systemSettingWindow();
    }


}
