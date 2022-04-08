package application;

import java.sql.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class buttonController {
	@FXML
	Button loginButtonID, singup, makeAccount;
	@FXML
	TextField userID,username;
	@FXML
	TextField passID,pass;
	@FXML
	Label lblStatus;
	public static User user;
	Stage signupStage;
        
        public Connection con = Database.getConnection();

	public void Login(ActionEvent action) throws Exception {

		try {
			Database db = new Database();
			db.preStatement = con.prepareStatement(
					"SELECT * FROM users JOIN schedule " + "ON users.id = schedule.id WHERE users.username = '"
							+ userID.getText() + "' AND PASSWORD = '" + passID.getText() + "'");
			db.result = db.preStatement.executeQuery();
			if (db.result.next()) {
				lblStatus.setText("Valid Login");
				user = new User(db.result.getInt("id"), db.result.getDouble("gpa"), db.result.getInt("hrsStudy"),
						db.result.getInt("hrsSlept"), db.result.getInt("eating"));
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
				Scene scene = new Scene(root, 900, 600);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} else
				lblStatus.setText("Invalid Login");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void singup(ActionEvent action) throws Exception {
		signupStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
		Scene scene = new Scene(root, 900, 600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		signupStage.setScene(scene);
		signupStage.show();
	}
	
	public void deleteAccount(ActionEvent action) throws Exception{
		try {
			Database db = new Database();
			db.preStatement = con.prepareStatement("DELETE FROM users WHERE id ='"+user.getId()+"'");
			db.preStatement.executeUpdate();
			System.exit(0);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void makeAccount(ActionEvent action) throws Exception {

		try {
			Database db = new Database();
			db.preStatement = con.prepareStatement("INSERT INTO users(username,password) VALUES(?,?)");
			db.preStatement.setString(1, username.getText());
			db.preStatement.setString(2, pass.getText());
			db.preStatement.executeUpdate();
			
			int id = getID(username.getText());
			
			db = new Database();
			db.preStatement = con.prepareStatement(
					"INSERT INTO schedule(hrsStudy,hrsSlept,eating,gpa,id) VALUES(?,?,?,?,?)");
			db.preStatement.setInt(1, 0);
			db.preStatement.setInt(2, 0);
			db.preStatement.setInt(3, 0);
			db.preStatement.setDouble(4, 0.0);
			db.preStatement.setInt(5, id);
			db.preStatement.executeUpdate();
			
			lblStatus.setText("User added");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public int getID(String name) {
		try {
			Database db = new Database();
			db.preStatement = con.prepareStatement("SELECT * FROM users WHERE username ='"+name+"'");
			db.result = db.preStatement.executeQuery();
			if(db.result.next()) {
				return db.result.getInt("id");
			}
                        db.connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// ======================== MAIN BUTTONS ========================//

	// handle Home Button
	public void handleMain(ActionEvent event) throws Exception {

		Parent mainView = FXMLLoader.load(getClass().getResource("main.fxml"));
		Scene mainScene = new Scene(mainView);

		// this line gets the stage info
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(mainScene);
		window.show();

	}

	// Move to sleep page
	public void handleSleep(ActionEvent event) throws Exception {

		Parent sleepView = FXMLLoader.load(getClass().getResource("sleep.fxml"));
		Scene sleepScene = new Scene(sleepView);

		// this line gets the stage info
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(sleepScene);
		window.show();

	}

	// Move to eating habits page
	public void handleEating(ActionEvent event) throws Exception {

		Parent eatView = FXMLLoader.load(getClass().getResource("eating.fxml"));
		Scene eatScene = new Scene(eatView);

		// this line gets the stage info
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(eatScene);
		window.show();

	}

	// Move to study hours page
	public void handleStudy(ActionEvent event) throws Exception {

		Parent studyView = FXMLLoader.load(getClass().getResource("study.fxml"));
		Scene studyScene = new Scene(studyView);

		// this line gets the stage info
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(studyScene);
		window.show();

	}

	// Move to gpa page
	public void handleGpa(ActionEvent event) throws Exception {

		Parent gpaView = FXMLLoader.load(getClass().getResource("gpa.fxml"));
		Scene gpaScene = new Scene(gpaView);

		// this line gets the stage info
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(gpaScene);
		window.show();

	}

	// Move to summary page
	public void handleSummary(ActionEvent event) throws Exception {
		
		
		Parent summaryView = FXMLLoader.load(getClass().getResource("summary.fxml"));
		Scene summaryScene = new Scene(summaryView);

		// this line gets the stage info
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		

		window.setScene(summaryScene);
		window.show();
		

	}

	// ======================== SUBMIT BUTTONS ========================//

	@FXML
	private TextField myTextField;
	@FXML
	private Button myButton;

	int numEat;
	double gpaScore;
	double hrsSleep;
	double hrsStudy;

	// submits number of meals eaten
	public void eatingSubmit(ActionEvent event) {
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Confirm");
		window.setMinWidth(350);
		window.setMinHeight(150);

		try {
			numEat = Integer.parseInt(myTextField.getText());
			Label label = new Label();
			if (numEat > 0 && numEat < 10) {
				label.setText("Your number of meals eaten," + numEat + ", is saved!");
				try {
					Database db = new Database();
					db.preStatement = con.prepareStatement(
							"UPDATE schedule set eating = '"+numEat+"' WHERE id = '"+user.getId()+"'");
					db.preStatement.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				label.setText("Invalid input!");
			}
			Button closeBtn = new Button("Close the window");
			closeBtn.setOnAction(e -> window.close());

			VBox layout = new VBox(10);
			layout.getChildren().addAll(label, closeBtn);
			layout.setAlignment(Pos.CENTER);

			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		} catch (NumberFormatException err) {
			Label label = new Label();
			label.setText("Enter only number please");
			Button closeBtn = new Button("Close the window");
			closeBtn.setOnAction(e -> window.close());

			VBox layout = new VBox(10);
			layout.getChildren().addAll(label, closeBtn);
			layout.setAlignment(Pos.CENTER);

			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		} catch (Exception err) {

			Label label = new Label();
			label.setText("ERROR");
			Button closeBtn = new Button("Close the window");
			closeBtn.setOnAction(e -> window.close());

			VBox layout = new VBox(10);
			layout.getChildren().addAll(label, closeBtn);
			layout.setAlignment(Pos.CENTER);

			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		}
	}

	// Submits GPA score
	public void SubmitGpa(ActionEvent event) {
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Confirm");
		window.setMinWidth(350);
		window.setMinHeight(150);

		try {
			gpaScore = Double.parseDouble(myTextField.getText());
			Label label = new Label();
			if (gpaScore > 0 && gpaScore <= 4) {
				label.setText("Your GPA," + gpaScore + ", is saved!");
				try {
					Database db = new Database();
					db.preStatement = con.prepareStatement(
							"UPDATE schedule set gpa = '"+gpaScore+"' WHERE id = '"+user.getId()+"'");
					db.preStatement.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				label.setText("Invalid input!");
			}
			Button closeBtn = new Button("Close the window");
			closeBtn.setOnAction(e -> window.close());

			VBox layout = new VBox(10);
			layout.getChildren().addAll(label, closeBtn);
			layout.setAlignment(Pos.CENTER);

			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		} catch (NumberFormatException err) {
			Label label = new Label();
			label.setText("Enter only number please");
			Button closeBtn = new Button("Close the window");
			closeBtn.setOnAction(e -> window.close());

			VBox layout = new VBox(10);
			layout.getChildren().addAll(label, closeBtn);
			layout.setAlignment(Pos.CENTER);

			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		} catch (Exception err) {

			Label label = new Label();
			label.setText("ERROR");
			Button closeBtn = new Button("Close the window");
			closeBtn.setOnAction(e -> window.close());

			VBox layout = new VBox(10);
			layout.getChildren().addAll(label, closeBtn);
			layout.setAlignment(Pos.CENTER);

			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		}
	}

	// Submits hours slept
	public void SubmitHrsSlept(ActionEvent event) {
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Confirm");
		window.setMinWidth(350);
		window.setMinHeight(150);

		try {
			hrsSleep = Double.parseDouble(myTextField.getText());
			Label label = new Label();
			if (hrsSleep > 0 && hrsSleep <= 24) {
				label.setText("Your hours slept," + hrsSleep + ", is saved!");
				try {
					Database db = new Database();
					db.preStatement = con.prepareStatement(
							"UPDATE schedule set hrsSlept = '"+hrsSleep+"' WHERE id = '"+user.getId()+"'");
					db.preStatement.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				label.setText("Invalid input!");
			}
			Button closeBtn = new Button("Close the window");
			closeBtn.setOnAction(e -> window.close());

			VBox layout = new VBox(10);
			layout.getChildren().addAll(label, closeBtn);
			layout.setAlignment(Pos.CENTER);

			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		} catch (NumberFormatException err) {
			Label label = new Label();
			label.setText("Enter only number please");
			Button closeBtn = new Button("Close the window");
			closeBtn.setOnAction(e -> window.close());

			VBox layout = new VBox(10);
			layout.getChildren().addAll(label, closeBtn);
			layout.setAlignment(Pos.CENTER);

			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		} catch (Exception err) {

			Label label = new Label();
			label.setText("ERROR");
			Button closeBtn = new Button("Close the window");
			closeBtn.setOnAction(e -> window.close());

			VBox layout = new VBox(10);
			layout.getChildren().addAll(label, closeBtn);
			layout.setAlignment(Pos.CENTER);

			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		}
	}

	// Submits hours study
	public void SubmitHrsStudy(ActionEvent event) {
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Confirm");
		window.setMinWidth(350);
		window.setMinHeight(150);

		try {
			hrsStudy = Double.parseDouble(myTextField.getText());
			Label label = new Label();
			if (hrsStudy > 0 && hrsStudy <= 24) {
				label.setText("Your study hours per day is," + hrsStudy + ", is saved!");
				try {
					Database db = new Database();
					db.preStatement = con.prepareStatement(
							"UPDATE schedule set hrsStudy = '"+hrsStudy+"' WHERE id = '"+user.getId()+"'");
					db.preStatement.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				label.setText("Invalid input!");
			}
			Button closeBtn = new Button("Close the window");
			closeBtn.setOnAction(e -> window.close());

			VBox layout = new VBox(10);
			layout.getChildren().addAll(label, closeBtn);
			layout.setAlignment(Pos.CENTER);

			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		} catch (NumberFormatException err) {
			Label label = new Label();
			label.setText("Enter only number please");
			Button closeBtn = new Button("Close the window");
			closeBtn.setOnAction(e -> window.close());

			VBox layout = new VBox(10);
			layout.getChildren().addAll(label, closeBtn);
			layout.setAlignment(Pos.CENTER);

			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		} catch (Exception err) {

			Label label = new Label();
			label.setText("ERROR");
			Button closeBtn = new Button("Close the window");
			closeBtn.setOnAction(e -> window.close());

			VBox layout = new VBox(10);
			layout.getChildren().addAll(label, closeBtn);
			layout.setAlignment(Pos.CENTER);

			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		}
	}

}
