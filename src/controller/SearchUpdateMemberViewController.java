package controller;


import javafx.stage.Stage;

public class SearchUpdateMemberViewController {

    private ChocAnSysApp main;
    private Stage dialog;

    public void setMain(ChocAnSysApp main, Stage dialog){
        this.main = main;
        this.dialog = dialog;
    }

    public void lookupBtnHandler(){
        // QUERY THE DB AND STORE INFO TO POPULATE FIELDS
        main.updateMembersWindow();


    }

    public void cancelBtnHandler(){
                dialog.close();
    }



}
