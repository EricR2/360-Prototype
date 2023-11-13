import javafx.application.Platform;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Effortlog extends VBox {
    public Effortlog(Stage primaryStage) {
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Label usernameLabel = new Label("Username: " );
        Label passwordLabel = new Label("Password: " );
        Button registerButton = new Button("Not Registered?"); //added

        registerButton.setOnAction(event -> {
            // Close the JavaFX application
            AccountCreate registerPage = new AccountCreate(primaryStage);
            Scene registerScene = new Scene(registerPage, 400, 200);
            primaryStage.setScene(registerScene);
        });

        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Check username and password here (implement your logic)

            if (isValidUser(username, password)) {
                // If valid user, show employee/employer view
                if (isEmployee(username)) {
                    // Show employee view
                    Employee employeeView = new Employee(primaryStage, username);
                    Scene employeeScene = new Scene(employeeView, 400, 400);
                    primaryStage.setScene(employeeScene);
                } else if (isEmployer(username)) {
                    // Show employer view
                    Manager employerView = new Manager(primaryStage);
                    Scene employerScene = new Scene(employerView, 400, 400);
                    primaryStage.setScene(employerScene);
                }
            } else {
                // Invalid user
                // Show error message or handle it as you wish
            }
        });

         Button quitButton = new Button("Quit");
        quitButton.setOnAction(event -> {
            // Close the JavaFX application
            Platform.exit();
        });

        this.getChildren().addAll(usernameLabel, usernameField,passwordLabel, passwordField, loginButton, quitButton, registerButton); //added registerButton
    }

    private boolean isValidUser(String username, String password) {
        // Implement your logic for user validation
        // You can check against a predefined username and password
        return true;
    }

    private boolean isEmployee(String username) {
        if(username.equals("employee")) {
            return true;
        }else{
            return false;
        }
    }

    private boolean isEmployer(String username) {
        if(username.equals("employer")){
              return true;  
        }else{
            return false;
        }
    }
}