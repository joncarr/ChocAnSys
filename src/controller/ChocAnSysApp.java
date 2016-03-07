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

    public static void main(String[] args) {
        launch(args);
    }
}

