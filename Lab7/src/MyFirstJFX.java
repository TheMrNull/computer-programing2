import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MyFirstJFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Button btn01;
    @Override
    public void start(Stage primaryStage) {

        btn01 = new Button();
        btn01.setText("You clicked me "+counter + " times!");
        btn01.setOnAction(e->btn01Click());

        BorderPane root = new BorderPane();
        root.setCenter(btn01);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("My application");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    static int counter = 1;
    private void btn01Click() {
        System.out.println("You clicked me " + counter + " times");
        btn01.setText("You clicked me "+counter + " times!");
        counter++;
    }
}
