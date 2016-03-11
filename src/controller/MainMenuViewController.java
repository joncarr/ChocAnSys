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
        main.manageProvidersWindow();
    }

    public void manageServicesBtnHandler(){
        main.manageServicesWindow();
    }

    public void viewReportsBtnHandler(){
        main.viewReportsWindow();
    }

    public void processVisitBtnHandler(){
        main.processVisitWindow();
    }

    public void weeklyProcessBtnHandler(){

    }

    public void acmeUpdateBtnHandler(){

    }

    public void systemExitBtnHandler(){
        System.exit(0);
    }

}