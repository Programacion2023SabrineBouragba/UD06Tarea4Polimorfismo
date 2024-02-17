module com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo to javafx.fxml;
    exports com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo;
    exports com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.controllers;
    opens com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.controllers to javafx.fxml;
}