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
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
            e.printStackTrace();
        }
    }

    public void systemSettingWindow(){

        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/SystemSettingView.fxml"));
            primaryStage.setTitle("Chocoholics Anonymous System");
            AnchorPane pane = loader.load();

            SystemSettingViewController controller = loader.getController();
            controller.setMain(this);

            primaryStage.setScene(new Scene(pane, 400, 300));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    public void updateMembersWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/UpdateMemberView.fxml"));
            AnchorPane pane = loader.load();

            UpdateMemberViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 600, 400));
            dialog.show();

        } catch (IOException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    public void deleteMembersWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/deleteMemberView.fxml"));
            AnchorPane pane = loader.load();

            DeleteMemberViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 600, 400));
            dialog.show();

        } catch (IOException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    public void updateProvidersWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/UpdateProviderView.fxml"));
            AnchorPane pane = loader.load();

            UpdateProviderViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 600, 400));
            dialog.show();

        } catch (IOException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    public void deleteProvidersWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/deleteProviderView.fxml"));
            AnchorPane pane = loader.load();

            DeleteProviderViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 600, 400));
            dialog.show();

        } catch (IOException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    public void updateServicesWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/UpdateServiceView.fxml"));
            AnchorPane pane = loader.load();

            UpdateServiceViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 600, 350));
            dialog.show();

        } catch (IOException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    public void deleteServicesWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/deleteServiceView.fxml"));
            AnchorPane pane = loader.load();

            DeleteServiceViewController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            controller.setMain(this, dialog);

            dialog.setTitle("Chocoholics Anonymous System");
            dialog.setScene(new Scene(pane, 600, 350));
            dialog.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewReportsWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ChocAnSysApp.class.getResource("../view/ViewReportsView.fxml"));
            Stage dialog = new Stage();
            dialog.setTitle("Chocoholics Anonymous System");
            AnchorPane pane = loader.load();

            ViewReportsViewController controller = loader.getController();
            controller.setMain(this, dialog);

            dialog.setScene(new Scene(pane, 400, 300));
            dialog.show();

        } catch (IOException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

