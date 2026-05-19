package GUI;

import data.Bike;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.ReadFile;
import data.Sale;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Optional;

public class Store extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    ReadFile file;
    BorderPane bp01;
    Button btn01, btn02,btn03,btn04,btn05,btn06;
    TabPane tabPane01;
    HBox hbox01, hbox02;
    VBox vbox01;
    Tab tab01, tab02;
    TextArea ta01,ta02;
    TextField tf01, tf02;
    Stage mainStage;
    Label lab01, lab02;


    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;

        // Text fields
        tf01 = new TextField();
        tf02 = new TextField();

        //Labels
        lab01 = new Label("ID:");
        lab01.setPadding(new Insets(5));
        lab02 = new Label("# of items to buy:");
        lab02.setPadding(new Insets(5));

        //Text areas
        ta01 = new TextArea();
        ta01.setEditable(false);
        ta02 = new TextArea();
        ta02.setEditable(false);

        //Buttons
        btn01 = new Button("Load file");
        btn01.setOnAction(e->btn01LoadFile());
        btn02 = new Button("Clear all");
        btn02.setOnAction(e->btn02ClearAll());
        btn03 = new Button("Exit");
        btn03.setOnAction(e->btn03Exit());
        btn04 = new Button("Buy");
        btn04.setOnAction(e->btn04Buy());
        btn05 = new Button("Sort price");
        btn05.setOnAction(e->btn05SortPrice());
        btn06 = new Button("Sort wheel size");
        btn06.setOnAction(e->btn06sortWheelSize());
        //Boxes
        hbox01 = new HBox(10,lab01,tf01,lab02, tf02,btn04,btn03);
        hbox01.setPadding(new Insets(10));
        hbox02 = new HBox(10, btn01,btn02,btn05,btn06);
        vbox01 = new VBox(hbox02,hbox01);
        //Tabs
        tab01 = new Tab("Bike list");
        tab01.setClosable(false);
        tab01.setContent(ta01);
        tab02 = new Tab("Sales");
        tab02.setClosable(false);
        tab02.setContent(ta02);
        //Panes
        tabPane01 = new TabPane();
        bp01 = new BorderPane();
        bp01.setCenter(tabPane01);
        bp01.setBottom(vbox01);
        tabPane01.getTabs().addAll(tab01,tab02);


        //Scene
        Scene scene01 = new Scene(bp01, 850,600);
        //Stage
        primaryStage.setScene(scene01);
        primaryStage.setTitle("Bike Store");
        primaryStage.show();

    }

    private void btn06sortWheelSize() {
        file.compareWheelSize();
        ta01.clear();
        ta01.appendText(file.toString());
    }

    private void btn05SortPrice() {
        file.comparePrice();
        ta01.clear();
        ta01.appendText(file.toString());
    }

    private void btn04Buy() {

        try {
            int index = Integer.parseInt(tf01.getText());
            int nb = Integer.parseInt(tf02.getText());
            Bike selectedBike = file.getCatalog().get(index);
            Sale sale = new Sale(nb, selectedBike);
            ta02.appendText(sale.toString());
            tf01.clear();
            tf02.clear();

            Alert invoice = new Alert(Alert.AlertType.INFORMATION);
            invoice.setTitle("Invoice");
            invoice.setContentText(sale.toString());
            invoice.showAndWait();
        }
        catch(Exception error){
            Alert e = new Alert(Alert.AlertType.ERROR);
            e.setTitle("Error");
            e.setContentText("There was an error with this id");
            e.showAndWait();
        }
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
