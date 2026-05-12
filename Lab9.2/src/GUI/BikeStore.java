package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.ReadFile;

import java.io.File;

public class BikeStore extends Application {

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    TextArea ta01;
    ReadFile pricelist;

    @Override
    public void init() throws Exception {
        super.init();
        this.buildUI();
    }

    private void buildUI() {


        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Bike Store price list");

        Tab tab2 = new Tab("Tab 2");

        // Tab1 content

        Button btn01  = new Button("Read");
        btn01.setOnAction(e->btn01ReadFile());
        Button btn02 = new Button("Clear");
        btn02.setOnAction(e->btn02ClearArea());
        Button btn03 = new Button("Sort");
        btn03.setOnAction(e->btn03Sort());
        Button btn04 = new Button("Sort 2");
        btn04.setOnAction(e->bnt04Sort2());

        ta01 = new TextArea();
        ta01.setEditable(false);

        HBox hbox01 = new HBox(10,btn01,btn02,btn03,btn04);

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

    private void bnt04Sort2() {
        pricelist.sortWheel2();
        ta01.clear();
        String s = pricelist.toString();
        ta01.appendText(s);
    }

    private void btn03Sort() {
        pricelist.sortWheelModel();
        ta01.clear();
        String s = pricelist.toString();
        ta01.appendText(s);
    }

    private void btn01ReadFile() {
        pricelist = new ReadFile();
        String path = new File("src/files/bike.txt").getAbsolutePath();
        pricelist = new ReadFile(path);
        ta01.clear();
        String s = pricelist.toString();
        ta01.appendText(s);
    }

    private void btn02ClearArea() {
        ta01.clear();
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
