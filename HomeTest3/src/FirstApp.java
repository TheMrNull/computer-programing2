import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class FirstApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Button btn1;
    Button btnAdd;
    Button btn3;

    @Override
    public void start(Stage primaryStage) {

        btn1 = new Button();
        btn1.setText("Click me");
        btn1.setOnAction(e->btn1Click());

        btnAdd = new Button();
        btnAdd.setText("Add");
        btnAdd.setOnAction(e->btnAddClick());

        btn3 = new Button();
        btn3.setText("Open new window");
        btn3.setOnAction(e->btn3Click());


        BorderPane root = new BorderPane();
        root.setCenter(btn1);
        root.setLeft(btnAdd);
        root.setBottom(btn3);

        Scene scene1 = new Scene(root, 300, 300);


        primaryStage.setTitle("App 1");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    private void btn3Click() {
        Stage stage2 = new Stage();
        VBox root2 = new VBox();
        HBox menuBar = new HBox();
        menuBar.getChildren().add(btn1);
        root2.getChildren().addAll(menuBar);

        Scene scene2 = new Scene(root2,300,300);
        stage2.setScene(scene2);
        stage2.setTitle("New window");
        stage2.show();
    }


    private void btnAddClick() {
        System.out.println("added");
    }

    static int counter = 1;
    private void btn1Click() {
        System.out.println("Clicked "+counter);
        btn1.setText(""+counter);
        counter++;

    }
}
