package controller;


public class MainMenuViewController {

    private ChocAnSysApp main;


    public void setMain(ChocAnSysApp main){
        this.main = main;
    }

    public void manageMembersBtnHandler(){
        main.manageMembersWindow();
    }

    public void manageProvidersBtnHandler(){

    }

    public void manageServicesBtnHandler(){

    }

    public void viewReportsBtnHandler(){

    }

    public void processVisitBtnHandler(){

    }

    public void weeklyProcessBtnHandler(){

    }

    public void acmeUpdateBtnHandler(){

    }

    public void systemExitBtnHandler(){
        System.exit(0);
    }

}