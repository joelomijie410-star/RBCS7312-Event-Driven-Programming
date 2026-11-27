package com.university.modules.week06;
import javafx.application.Application;import javafx.fxml.FXMLLoader;import javafx.scene.Scene;import javafx.stage.Stage;
/** Loads the Week 6 declarative FXML form with its controller. */
public class FxmlLoginDemo extends Application {@Override public void start(Stage stage)throws Exception{var url=getClass().getResource("/com/university/modules/week06/login.fxml");if(url==null)throw new IllegalStateException("login.fxml is missing");stage.setTitle("Week 6 — FXML Login Demo");stage.setScene(new Scene(FXMLLoader.load(url),420,220));stage.show();}public static void main(String[]a){launch(a);}}
