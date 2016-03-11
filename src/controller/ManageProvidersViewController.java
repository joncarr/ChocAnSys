package controller;

import javafx.stage.Stage;

public class ManageProvidersViewController {

    private ChocAnSysApp main;
    private Stage dialog;

    public void setMain(ChocAnSysApp main, Stage dialog){
        this.main = main;
        this.dialog = dialog;
    }

    public void updateProviderHandler(){
        main.updateProvidersWindow();
    }

    public void addProviderHandler(){
        main.addProvidersWindow();
    }

    public void deleteProviderHandler(){
        main.deleteProvidersWindow();
    }

    public void exitProvidersHandler(){
        dialog.close();
    }
}
