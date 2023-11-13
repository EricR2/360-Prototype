import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class AccountCreate extends VBox {
    public AccountCreate(Stage primaryStage) {
        Label titleLabel = new Label("New User Account Creation");
        Label usernameLabel = new Label("Username: " );
        Label passwordLabel = new Label("Password: " );
        Label creationCodeLabel = new Label("Verification Code: " );
        Button Register = new Button("Register");

        //TextField nameField = new TextField();
        TextField usernameField = new TextField();
        TextField passwordField = new TextField();
        TextField creationCodeField = new TextField();


        Register.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String creationCode = creationCodeField.getText();
            int code = Integer.parseInt(creationCode);

            // Check username and password here (implement your logic)
        if (isValidUsernamePassword(username, password)) {    

            if (isValidCode(code)) {
                // If valid user, show employee/employer view
                if (isEmployeeCode(code)) {
                    // Show employee view
                    //add password to database
                    Employee employeeView = new Employee(primaryStage, username);
                    Scene employeeScene = new Scene(employeeView, 400, 400);
                    primaryStage.setScene(employeeScene);
                } else if (isManagerCode(code)) {
                    // Show employer view
                    //add password to database
                    Manager employerView = new Manager(primaryStage);
                    Scene employerScene = new Scene(employerView, 400, 400);
                    primaryStage.setScene(employerScene);
                }
            } else {
                // Invalid user
                primaryStage.close();
            }
        }
        });
        this.getChildren().addAll(titleLabel, usernameLabel, usernameField, passwordLabel, passwordField, creationCodeLabel, creationCodeField, Register);
    }

    private boolean isValidCode(int code) {
        if (code == 1234 || code == 1111) {
            return true;
        }
        else {
            return false;
        }
    }
    private boolean isEmployeeCode(int code) {
        if (code == 1111) {
            return true;
        }
        else {
            return false;
        }
    }
    private boolean isManagerCode(int code) {
        if (code == 1234) {
            return true;
        }
        else {
            return false;
        }
    }
    private boolean isValidUsernamePassword(String username, String password) {
        // Implement your logic for user validation
        // You can check against a predefined username and password
        return true;
    }
}