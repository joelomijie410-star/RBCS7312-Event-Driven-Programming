package com.university.modules.week06;
import javafx.application.Application;import javafx.geometry.Insets;import javafx.scene.Scene;import javafx.scene.control.*;import javafx.scene.layout.*;import javafx.stage.Stage;
/** Week 6: JavaFX stage, controls and nested layout panes. */
public class LayoutsDemo extends Application {
 @Override public void start(Stage stage){BorderPane root=new BorderPane();root.setPadding(new Insets(16));Label title=new Label("JavaFX Learning Dashboard");title.setStyle("-fx-font-size:22px;-fx-font-weight:bold;");root.setTop(title);VBox nav=new VBox(8,new Button("Overview"),new Button("Students"),new Button("Reports"));nav.setPadding(new Insets(16));root.setLeft(nav);
 GridPane grid=new GridPane();grid.setHgap(12);grid.setVgap(12);String[][] values={{"Revenue","$12,450"},{"Users","1,204"},{"Orders","342"}};for(int i=0;i<values.length;i++){VBox card=new VBox(8,new Label(values[i][0]),new Label(values[i][1]));card.setPadding(new Insets(18));card.setStyle("-fx-background-color:#edf3f8;-fx-background-radius:8;");grid.add(card,i,0);}root.setCenter(grid);root.setBottom(new Label("Week 6: Scene + Stage + layout-managed Nodes"));BorderPane.setMargin(grid,new Insets(18));stage.setTitle("Week 6 — Layouts");stage.setScene(new Scene(root,720,360));stage.show();}
 public static void main(String[]a){launch(a);}
}
