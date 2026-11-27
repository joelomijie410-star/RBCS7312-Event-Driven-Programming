package com.university.modules.week08;
import javafx.application.Application;import javafx.beans.property.*;import javafx.geometry.Insets;import javafx.scene.Scene;import javafx.scene.control.*;import javafx.scene.layout.*;import javafx.stage.Stage;
/** Week 8: JavaFX observable properties, listeners, and unidirectional/bidirectional bindings. */
public class ReactiveFormDemo extends Application {
 private final StringProperty name=new SimpleStringProperty("");private final StringProperty email=new SimpleStringProperty("");
 @Override public void start(Stage stage){TextField nameInput=new TextField(),emailInput=new TextField();Label preview=new Label();Button submit=new Button("Register");nameInput.textProperty().bindBidirectional(name);emailInput.textProperty().bindBidirectional(email);preview.textProperty().bind(name.concat(" — ").concat(email));submit.disableProperty().bind(name.isEmpty().or(email.isEmpty()));name.addListener((o,oldValue,newValue)->System.out.println("Name changed: "+oldValue+" -> "+newValue));submit.setOnAction(e->new Alert(Alert.AlertType.INFORMATION,"Registered: "+name.get()+" (demo only)").showAndWait());GridPane g=new GridPane();g.setPadding(new Insets(20));g.setHgap(10);g.setVgap(10);g.addRow(0,new Label("Name"),nameInput);g.addRow(1,new Label("Email"),emailInput);g.addRow(2,new Label("Live model preview"),preview);g.add(submit,1,3);stage.setScene(new Scene(g,520,220));stage.setTitle("Week 8 — Reactive Form");stage.show();}
 public static void main(String[]a){launch(a);}
}
