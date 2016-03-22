/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: SystemSettingViewController.java
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


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;



public class SystemSettingViewController {

    private ChocAnSysApp main;
    private String currentDir = System.getProperty("user.dir");
    public static LocalDate currentDate;
    public static File workingDirectory;
    @FXML private DatePicker datePicker;
    @FXML private Label lblCurrentDir;

    public void setMain(ChocAnSysApp main){
        this.main = main;
        datePicker.setValue(LocalDate.now());
        datePicker.setOnAction(event ->{
            currentDate = datePicker.getValue();
        });
        // to populate currentDate field when the datePicker is not used
        if (currentDate == null){
            datePicker.setValue(LocalDate.now());
            currentDate = datePicker.getValue();

        }




        lblCurrentDir.setText(currentDir);
        System.out.println(currentDate);
    }

    @FXML
    private void exitSystemBtnHandler(){
        System.exit(0);
    }

    @FXML
    private void changeDirBtnHandler(){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        workingDirectory = directoryChooser.showDialog(new Stage());
        if (workingDirectory == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Change Directory");
            alert.setContentText("Your directory was not changed.");
            alert.showAndWait();

        } else {
            lblCurrentDir.setText(workingDirectory.getAbsolutePath());
        }
    }

    @FXML
    private void runSystemBtnHandler(){
        main.mainMenuWindow();
    }

}
