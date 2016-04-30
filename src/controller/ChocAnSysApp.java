/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: ChocAnSysApp.java
 Project: IntelliJ IDEA 15.0
 Assignment: Chocoholics Anonymous System
 University: McMurry University
 Course: COSC–4360 Spring 2016
 Instructor: Mr. Brozovic
 Programmer: Jon Carr
 Date: January 13, 2016
 Update by: Additional coder’s name
 Updated: Date code was updated
 Compiler: NetBeans IDE Java SE
 Description: Class Definitions for Provider class
 ********************************************************************************
 ********************************************************************************
 *******************************************************************************/

package controller;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Member;
import model.Provider;
import model.Service;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

public class ChocAnSysApp extends Application {



    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        mainWindow();
    }

    public void mainWindow(){

        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/MainWindowView.fxml"));
            primaryStage.setTitle("Chocoholics Anonymous System");
            AnchorPane pane = loader.load();

            ChocAnSysAppController controller = loader.getController();
            controller.setMain(this);

            primaryStage.setScene(new Scene(pane, 400, 300));
            primaryStage.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void systemSettingWindow(){

        try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {


        }catch(IOException e){
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }

        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/SystemSettingView.fxml"));
            primaryStage.setTitle("Chocoholics Anonymous System");
            AnchorPane pane = loader.load();

            SystemSettingViewController controller = loader.getController();
            controller.setMain(this);

            primaryStage.setScene(new Scene(pane, 400, 300));
            primaryStage.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void mainMenuWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/MainMenuView.fxml"));
            primaryStage.setTitle("Chocoholics Anonymous System");
            AnchorPane pane = loader.load();

            MainMenuViewController controller = loader.getController();
            controller.setMain(this);

            primaryStage.setScene(new Scene(pane, 400, 300));
            primaryStage.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void manageMembersWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/ManageMembersView.fxml"));
            AnchorPane pane = loader.load();

            ManageMembersViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 400, 300));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void searchDeleteMemberWindow() {
        try {

            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/SearchDeleteMemberView.fxml"));
            AnchorPane pane = loader.load();

            SearchDeleteMemberViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 400, 300));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void updateMembersWindow(Member member) {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/UpdateMemberView.fxml"));
            AnchorPane pane = loader.load();

            UpdateMemberViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog, member);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 600, 400));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }



    public void searchUpdateMemberWindow() {
        try {

            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/SearchUpdateMemberView.fxml"));
            AnchorPane pane = loader.load();

            SearchUpdateMemberViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 400, 300));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void MemberReportLookupWindow(){
        try{
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/MemberReportLookupView.fxml"));
            AnchorPane pane =  loader.load();

            MemberReportLookupViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);
            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 400, 300));
            dialog.show();

        }catch(IOException e){
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }

        }

    }

    public void ProviderReportLookupWindow(){
        try{
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/ProviderReportLookupView.fxml"));
            AnchorPane pane = loader.load();

            ProviderReportLookupController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);
            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 400, 300));
            dialog.show();





        }catch(IOException e){
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }






    }


    public void addMembersWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/addMemberView.fxml"));
            AnchorPane pane = loader.load();

            AddMemberViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 600, 400));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void deleteMembersWindow(Member member) {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/deleteMemberView.fxml"));
            AnchorPane pane = loader.load();

            DeleteMemberViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog, member);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 600, 400));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void manageProvidersWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/ManageProvidersView.fxml"));
            AnchorPane pane = loader.load();

            ManageProvidersViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 400, 300));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void updateProvidersWindow(Provider provider) {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/UpdateProviderView.fxml"));
            AnchorPane pane = loader.load();

            UpdateProviderViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog, provider);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 600, 400));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void searchUpdateProviderWindow() {
        try {

            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/SearchUpdateProviderView.fxml"));
            AnchorPane pane = loader.load();

            SearchUpdateProviderViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 400, 300));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void addProvidersWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/addProviderView.fxml"));
            AnchorPane pane = loader.load();

            AddProviderViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 600, 400));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void searchDeleteProviderWindow() {
        try {

            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/SearchDeleteProviderView.fxml"));
            AnchorPane pane = loader.load();

            SearchDeleteProviderViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 400, 300));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void deleteProvidersWindow(Provider provider) {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/deleteProviderView.fxml"));
            AnchorPane pane = loader.load();

            DeleteProviderViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog, provider);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 600, 400));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void manageServicesWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/ManageServicesView.fxml"));
            AnchorPane pane = loader.load();

            ManageServicesViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 400, 300));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void searchUpdateServicesWindow() {
        try {

            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/SearchUpdateServicesView.fxml"));
            AnchorPane pane = loader.load();

            SearchUpdateServicesViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 400, 300));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void updateServicesWindow(Service service) {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/UpdateServiceView.fxml"));
            AnchorPane pane = loader.load();

            UpdateServiceViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog, service);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 600, 350));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void addServicesWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/addServiceView.fxml"));
            AnchorPane pane = loader.load();

            AddServiceViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 600, 350));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void searchDeleteServicesWindow() {
        try {

            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/SearchDeleteServicesView.fxml"));
            AnchorPane pane = loader.load();

            SearchDeleteServicesViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 400, 300));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void deleteServicesWindow(Service service) {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/deleteServiceView.fxml"));
            AnchorPane pane = loader.load();

            DeleteServiceViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog, service);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 600, 350));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void viewReportsWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/ViewReportsView.fxml"));
            Stage dialog = new Stage();
            dialog.setTitle("Chocoholics Anonymous System");
            dialog.initModality(Modality.APPLICATION_MODAL);
            AnchorPane pane = loader.load();

            ViewReportsViewController controller = loader.getController();
            controller.setMain(this, dialog);

            dialog.setScene(new Scene(pane, 400, 300));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void processVisitWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/ProcessVisitView.fxml"));
            AnchorPane pane = loader.load();

            ProcessVisitViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 600, 400));
            dialog.show();

        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public ComboBox<String> populateState(ComboBox state){
        ComboBox<String> stateBox = new ComboBox<>();
        List<String> stateList = new ArrayList<>();
        stateList.add("AL");
        stateList.add("AK");
        stateList.add("AZ");
        stateList.add("AR");
        stateList.add("CA");
        stateList.add("CO");
        stateList.add("CT");
        stateList.add("DE");
        stateList.add("FL");
        stateList.add("GA");
        stateList.add("HI");
        stateList.add("ID");
        stateList.add("IL");
        stateList.add("IN");
        stateList.add("IA");
        stateList.add("KS");
        stateList.add("KY");
        stateList.add("LA");
        stateList.add("ME");
        stateList.add("MD");
        stateList.add("MA");
        stateList.add("MI");
        stateList.add("MN");
        stateList.add("MS");
        stateList.add("MO");
        stateList.add("MT");
        stateList.add("NE");
        stateList.add("NV");
        stateList.add("NH");
        stateList.add("NJ");
        stateList.add("NM");
        stateList.add("NY");
        stateList.add("NC");
        stateList.add("ND");
        stateList.add("OH");
        stateList.add("OK");
        stateList.add("OR");
        stateList.add("PA");
        stateList.add("RI");
        stateList.add("SC");
        stateList.add("SD");
        stateList.add("TN");
        stateList.add("TX");
        stateList.add("UT");
        stateList.add("VI");
        stateList.add("VA");
        stateList.add("WA");
        stateList.add("WV");
        stateList.add("WI");
        stateList.add("WY");
        ObservableList obsList = FXCollections.observableList(stateList);
        state.getItems().clear();
        state.setItems(obsList);

        return stateBox;
    }

    public ComboBox<String> populateStatus(ComboBox status){
        ComboBox<String> statusBox = new ComboBox<>();
        List<String> statusList = new ArrayList<>();
        statusList.add("Active");
        statusList.add("Inactive");
        ObservableList obsList = FXCollections.observableList(statusList);
        status.getItems().clear();
        status.setItems(obsList);

        return statusBox;
    }


    public static void main(String[] args) {

        launch(args);
    }
}

