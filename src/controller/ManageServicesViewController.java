package controller;

import javafx.stage.Stage;

public class ManageServicesViewController {

    private ChocAnSysApp main;
    private Stage dialog;

    public void setMain(ChocAnSysApp main, Stage dialog){
        this.main = main;
        this.dialog = dialog;
    }

    public void updateServiceHandler(){
        main.updateServicesWindow();
    }

    public void addServiceHandler(){
        main.addServicesWindow();
    }

    public void deleteServiceHandler(){
        main.deleteServicesWindow();
    }

    public void exitServicesHandler(){
        dialog.close();
    }
}
