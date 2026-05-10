import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.border.Border;
import java.util.Optional;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    Button btn01;
    Button btn02;
    Button btn03;
    TextField tf01;
    TextArea ta01;



    @Override
    public void start(Stage primaryStage) {


        btn01 = new Button("Add");
        btn01.setOnAction(e->btn01Add());
        btn02 = new Button("Quit");
        btn02.setOnAction(e->btn02Quit());
        btn03 = new Button("Clear all");
        btn03.setOnAction(e->btn03ClearAll());

        tf01 = new TextField();
        ta01 = new TextArea();

        VBox vbox = new VBox(tf01, btn01);
        HBox hbox = new HBox(btn03,btn02);
        BorderPane root = new BorderPane();
        root.setTop(vbox);
        root.setCenter(ta01);
        root.setBottom(hbox);

        Scene scene01 = new Scene(root,350,250);
        primaryStage.setTitle("My app");
        primaryStage.setScene(scene01);
        primaryStage.show();

    }

    private void btn03ClearAll() {
        ta01.clear();
    }

    private void btn02Quit() {
        Alert closingAl;
        closingAl = new Alert(Alert.AlertType.CONFIRMATION);
        closingAl.setTitle("Closing app");
        String s = "Do you want to quit the app?";
        closingAl.setContentText(s);
        Optional<ButtonType> result = closingAl.showAndWait();

        if((result.isPresent() && (result.get() == ButtonType.OK))){
           javafx.application.Platform.exit(); // or to use stage.close, introduce a Stage stage = primaryStage line inside of start and rename all primaryStage with stage
        }
    }

    private void btn01Add() {
        String s = tf01.getText() + "\n";
        ta01.appendText(s);
    }
}
