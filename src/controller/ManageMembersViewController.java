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
        main.updateMembersWindow();
    }

    public void addMemberHandler(){
        main.addMembersWindow();
    }

    public void deleteMemberHandler(){
        main.deleteMembersWindow();
    }

    public void exitMembersHandler(){
        dialog.close();
    }
}
