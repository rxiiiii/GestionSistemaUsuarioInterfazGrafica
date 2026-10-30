module org.example.proyectogestiondeusuarios {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.proyectogestiondeusuarios to javafx.fxml;
    exports org.example.proyectogestiondeusuarios;
}