import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.*;
import javafx.stage.Stage;

public class tabexample extends Application {

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    TextArea ta01;
    TextField tf01;

    @Override
    public void init() throws Exception {   // like the start method
        super.init();                       // it can be overloaded
        this.buildUI();
    }

    private void buildUI() {

        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Tab 01 - TextArea+Buttons");

        Tab tab2 = new Tab("Tab 02");

        // Tab1 content

        Button btn1  = new Button("Buttton 1 - Try me");
        btn1.setOnAction(e->saySomething());
        Button btn2 = new Button("Clear Area");
        btn2.setOnAction(e->clearAll());
        Button btn3 = new Button("Append");
        btn3.setOnAction(e->appendToTa());
        ta01 = new TextArea();
        ta01.setEditable(false);
        tf01 = new TextField();
        HBox hbox01 = new HBox(10,btn1,btn2, tf01,btn3);
        BorderPane bp01 = new BorderPane();
        bp01.setCenter(ta01);
        bp01.setBottom(hbox01);



        // Add content to tabs
        tab1.setContent(bp01);
        tab2.setContent(new BorderPane(new TextArea("Content 2")));

        //Set tab as non closable
        tab1.setClosable(false);
        tab2.setClosable(false);

        // Add tabs to the TabPane
        tabPane.getTabs().addAll(tab1, tab2);

        // Add the TabPane to the BorderPane layout manager
        this.parent.setCenter(tabPane);

    }

    private void appendToTa() {
        String s = tf01.getText();
        ta01.appendText(s+"\n");
    }

    private void clearAll() {
        System.out.println("Button 2 pressed");
        ta01.clear();
    }

    private void saySomething() {
        System.out.println("Btn1 pressed");
        ta01.appendText("Button 1 has been pressed\n");
    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX TabPane: Building User-Friendly Tabbed Interfaces");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}
