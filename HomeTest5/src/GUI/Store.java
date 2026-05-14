package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.ReadFile;

import java.io.File;
import java.util.Optional;

public class Store extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    ReadFile file;
    BorderPane bp01;
    Button btn01, btn02,btn03;
    TabPane tabPane01;
    HBox hbox01;
    Tab tab01, tab02;
    TextArea ta01;
    Stage mainStage;
    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;

        //Text areas
        ta01 = new TextArea();
        ta01.setEditable(false);

        //Buttons
        btn01 = new Button("Load file");
        btn01.setOnAction(e->btn01LoadFile());
        btn02 = new Button("Clear all");
        btn02.setOnAction(e->btn02ClearAll());
        btn03 = new Button("Exit");
        btn03.setOnAction(e->btn03Exit());
        //Boxes
        hbox01 = new HBox(10, btn01,btn02,btn03);

        //Tabs
        tab01 = new Tab("Bike list");
        tab01.setClosable(false);
        tab01.setContent(ta01);
        tab02 = new Tab("Sales");
        tab02.setClosable(false);
        //Panes
        tabPane01 = new TabPane();
        bp01 = new BorderPane();
        bp01.setCenter(tabPane01);
        bp01.setBottom(hbox01);
        tabPane01.getTabs().addAll(tab01,tab02);

        //Scene
        Scene scene01 = new Scene(bp01, 850,600);
        //Stage
        primaryStage.setScene(scene01);
        primaryStage.setTitle("Bike Store");
        primaryStage.show();

    }

    private void btn03Exit() {
        Alert quit = new Alert(Alert.AlertType.CONFIRMATION);
        quit.setTitle("Quitting");
        quit.setContentText("Are you sure?");
        Optional <ButtonType> result = quit.showAndWait();
        if((result.isPresent())&&(result.get() == ButtonType.OK)){
            mainStage.close();
        }
    }

    private void btn02ClearAll() {
        Alert closeAlert = new Alert(Alert.AlertType.CONFIRMATION);
        closeAlert.setTitle("Clear all?");
        closeAlert.setContentText("Are you sure you want to clear this text area?");
        Optional <ButtonType> result = closeAlert.showAndWait();
        if((result.isPresent())&& (result.get() == ButtonType.OK)){
            ta01.clear();
            Alert cleared = new Alert(Alert.AlertType.INFORMATION);
            cleared.setTitle("All clear");
            cleared.setContentText("Text area 1 is now empty");
            cleared.showAndWait();
        }


    }

    private void btn01LoadFile() {
        file = new ReadFile();
        String path = new File("src/files/bike.txt").getAbsolutePath();
        file = new ReadFile(path);
        ta01.clear();
        String s = file.toString();
        ta01.appendText(s);

    }
}
