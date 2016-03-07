package controller;

import javafx.stage.Stage;

public class ManageMembersViewController {

    private ChocAnSysApp main;
    private Stage dialog;

    public void setMain(ChocAnSysApp main, Stage dialog){
        this.main = main;
        this.dialog = dialog;
    }

    public void updateMemberHandler(){

    }

    public void addMemberHandler(){

    }

    public void deleteMemberHandler(){

    }

    public void exitMembersHandler(){
        dialog.close();
    }
}
