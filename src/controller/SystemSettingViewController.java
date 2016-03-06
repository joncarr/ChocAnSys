package controller;


import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;
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
        lblCurrentDir.setText(currentDir);
    }

    @FXML
    private void exitSystemBtnHandler(){
        System.exit(0);
    }

    @FXML
    private void changeDirBtnHandler(){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        workingDirectory = directoryChooser.showDialog(new Stage());
        lblCurrentDir.setText(workingDirectory.getAbsolutePath());
    }

    @FXML
    private void runSystemBtnHandler(){
        main.mainMenuWindow();
    }

}
