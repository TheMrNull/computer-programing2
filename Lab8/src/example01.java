import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;

public class example01 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Button btn01;
    Button btn02;
    Button btn03;
    TextArea ta01;
    Label lab01;
    TextField input01;
    int counter = 1;

    @Override
    public void start(Stage primaryStage) {

        btn01 = new Button("Press me");
        btn01.setOnAction(e->btn01Click());
        btn02 = new Button("Clear all");
        btn02.setOnAction(e->btn02ClearArea());
        btn03 = new Button("Add");
        btn03.setOnAction(e->btn03Add());
        lab01 = new Label("Input something below:");
        input01 = new TextField();
        input01.setText("Write here");
        ta01 = new TextArea("Here you will write clicking button\n");
        ta01.setEditable(false);

        BorderPane root = new BorderPane();
        HBox hbox = new HBox(btn01,btn02);// Define the horizontal box that contains the buttons
        VBox vbox = new VBox(lab01,input01,btn03); // Define vertical box that contains input and add button
        root.setBottom(hbox); //placing hbox at the bottom of the border pane (root)
        root.setTop(vbox); //placing vbox at the top of the border pane (root)
        root.setCenter(ta01); // placing the text area in the center of the border pane (root)
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Title here");
        primaryStage.show();


    }

    private void btn03Add() {    //adds the text present in the input to the text area below
        String s = input01.getText();
        ta01.appendText(s+"\n");
    }

    private void btn02ClearArea() {
        ta01.clear();
    }

    private void btn01Click() {
        String s = "My counter is: " + counter + "\n";
        counter++;
        ta01.appendText(s);
    }
}
