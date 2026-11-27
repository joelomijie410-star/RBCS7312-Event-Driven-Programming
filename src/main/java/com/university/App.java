package com.university;

import javafx.application.*;
import javafx.collections.*;
import javafx.concurrent.Task;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

/** Week 10 capstone: event-driven university student registry. */
public class App extends Application {
    private final ObservableList<Student> students=FXCollections.observableArrayList();
    private final ScheduledExecutorService scheduler=Executors.newSingleThreadScheduledExecutor(r->{Thread t=new Thread(r,"heartbeat");t.setDaemon(true);return t;});
    private Label status;
    @Override public void start(Stage stage) {
        BorderPane root=new BorderPane(); root.setPadding(new Insets(16));
        Label title=new Label("University Management System"); title.setStyle("-fx-font-size: 23px; -fx-font-weight: bold;");
        Label subtitle=new Label("RBCS7312 · Student Registry · asynchronous JDBC");
        VBox header=new VBox(4,title,subtitle); header.setPadding(new Insets(0,0,14,0)); root.setTop(header);
        TableView<Student> table=new TableView<>(students); table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        table.getColumns().add(col("ID",Student::idProperty)); table.getColumns().add(col("Registration",Student::registrationNumberProperty));
        table.getColumns().add(col("First name",Student::firstNameProperty)); table.getColumns().add(col("Last name",Student::lastNameProperty)); table.getColumns().add(col("Email",Student::emailProperty));
        TextField reg=new TextField(); reg.setPromptText("e.g. S1001"); TextField first=new TextField(); first.setPromptText("First name");
        TextField last=new TextField(); last.setPromptText("Last name"); TextField email=new TextField(); email.setPromptText("name@example.edu");
        Button save=new Button("Save student"); Button refresh=new Button("Refresh list");
        save.disableProperty().bind(reg.textProperty().isEmpty().or(first.textProperty().isEmpty()).or(last.textProperty().isEmpty()).or(email.textProperty().isEmpty()));
        GridPane form=new GridPane(); form.setHgap(8);form.setVgap(8); form.addRow(0,new Label("Registration"),reg,new Label("First"),first); form.addRow(1,new Label("Last"),last,new Label("Email"),email);
        HBox actions=new HBox(8,save,refresh); VBox content=new VBox(12,form,actions,table); VBox.setVgrow(table,Priority.ALWAYS); root.setCenter(content);
        status=new Label("Ready · Database: "+System.getenv().getOrDefault("RBCS_DB_URL","jdbc:mysql://localhost:3306/university_db")); root.setBottom(status); BorderPane.setMargin(status,new Insets(12,0,0,0));
        save.setOnAction(e->saveStudent(reg,first,last,email,save)); refresh.setOnAction(e->loadStudents());
        stage.setTitle("RBCS7312 | University Management System"); stage.setScene(new Scene(root,1000,650)); stage.show();
        loadStudents();
        scheduler.scheduleAtFixedRate(()->{String tick="Heartbeat "+LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")); Platform.runLater(()->status.setText(tick+" · background scheduler active"));},0,5,TimeUnit.SECONDS);
    }
    private <T> TableColumn<Student,T> col(String title,java.util.function.Function<Student,javafx.beans.value.ObservableValue<T>> value){TableColumn<Student,T> c=new TableColumn<>(title);c.setCellValueFactory(d->value.apply(d.getValue()));return c;}
    private void saveStudent(TextField reg,TextField first,TextField last,TextField email,Button button){
        String r=reg.getText().trim(), f=first.getText().trim(), l=last.getText().trim(), m=email.getText().trim();
        if(!m.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")){status.setText("Enter a valid email address.");return;}
        button.setDisable(true); status.setText("Saving in background…");
        Task<Void> task=new Task<>(){@Override protected Void call() throws Exception {Database.insert(r,f,l,m);return null;}};
        task.setOnSucceeded(e->{reg.clear();first.clear();last.clear();email.clear();status.setText("Student saved.");loadStudents();});
        task.setOnFailed(e->{button.setDisable(false);Throwable x=task.getException();status.setText("Save failed: "+(x==null?"unknown error":x.getMessage()));}); new Thread(task,"student-save").start();
    }
    private void loadStudents(){
        status.setText("Loading students…"); Task<java.util.List<Student>> task=new Task<>(){@Override protected java.util.List<Student> call() throws Exception{return Database.load();}};
        task.setOnSucceeded(e->{students.setAll(task.getValue());status.setText("Loaded "+students.size()+" student(s)." );});
        task.setOnFailed(e->status.setText("Could not load: "+task.getException().getMessage()+" · Configure MySQL and use Refresh.")); new Thread(task,"student-load").start();
    }
    @Override public void stop(){scheduler.shutdownNow();}
    public static void main(String[] args){launch(args);}
}
