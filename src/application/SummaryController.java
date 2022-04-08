package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SummaryController implements Initializable {

	@FXML
	Label hrsStudiedLbl;
	@FXML
	Label optimalHrsStudiedLbl;
	@FXML
	Label mealsEatenLbl;
	@FXML
	Label optimalMeals;
	@FXML
	Label hrsSleptLbl;
	@FXML
	Label optimalHrsSleptLbl;
	@FXML
	Label userGPALb1;
	@FXML
	Label userOptimalGPALb1;

	String status;
	String status1;
	String status2;
	String status3;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		if (buttonController.user.getOptimalStudyHrs() <= 3) {
			status = "Below average study time, please try to study more hours a day";
		} else if (buttonController.user.getOptimalStudyHrs() <= 6) {
			status = "Average number of study hours, good job!";
		} else if (buttonController.user.getOptimalStudyHrs() <= 9) {
			status = "Above average study hours, keep up the good work!";
		} else if (buttonController.user.getOptimalStudyHrs() <= 12) {
			status = "Productive study day! Well done ";

		} else if (buttonController.user.getOptimalStudyHrs() <= 24) {
			status = "Please make sure to take study breaks, keep up the good work!";

		}

		hrsStudiedLbl.setText("Hours Studied: " + buttonController.user.getOptimalStudyHrs());
		optimalHrsStudiedLbl.setText(status);
		
		if (buttonController.user.getOptimalEatMins() <= 2) {
	        status1 = "You are eating too little! Maybe eat more to feel more energized.";
	    } else if (buttonController.user.getOptimalEatMins() == 3) {
	        status1 = "This is the recommended meals eaten for most people, good job!"; 
	    } else if (buttonController.user.getOptimalEatMins() > 3) {
	    	status1 = "The recommended meals eaten per day is 3. This may cause sluggishness.";
	    }
		
		mealsEatenLbl.setText("Meals Eaten: " + buttonController.user.getOptimalEatMins());
		optimalMeals.setText(status1);
		
		if (buttonController.user.getOptimalSleepHrs() < 6) {
	        status2 = "You are sleeping too little, try to get more rest to feel more energized.";
	    } else if (buttonController.user.getOptimalSleepHrs() > 6 && buttonController.user.getOptimalSleepHrs() <= 8) {
	        status2 = "This is the recommended amount of sleep each night. Good job!";
	    } else if (buttonController.user.getOptimalSleepHrs() > 8 && buttonController.user.getOptimalSleepHrs() <= 24) {	
	    	status2 = "You are sleeping too much, this could lead to laziness throughout the day";
	    }
		
		hrsSleptLbl.setText("Hours Slept: " + buttonController.user.getOptimalSleepHrs());
		optimalHrsSleptLbl.setText(status2);
		
		if (buttonController.user.getGpa() <= 2) {
			status3 = "Below average GPA, please consider taking a break or changing your major";

		} else if (buttonController.user.getGpa() <= 3) {
			status3 = "You can do it, keep studying hard to get above 3.0 GPA";
		} else if (buttonController.user.getGpa() <= 3.4) {
			status3 = "You are doing fine. Your new goal is to get above 3.5 GPA";
		} else if (buttonController.user.getGpa() <= 3.7) {
			status3 = "Keep up the good work. Nice!";

		} else if (buttonController.user.getGpa() <= 4) {
			status3 = "Please make sure to take study breaks. GOOD JOB!";

		}
		
		userGPALb1.setText("GPA: " + buttonController.user.getGpa());
		userOptimalGPALb1.setText(status3);
		
	}

	// handle Home Button
	public void handleMain(ActionEvent event) throws Exception {

		Parent mainView = FXMLLoader.load(getClass().getResource("main.fxml"));
		Scene mainScene = new Scene(mainView);

		// this line gets the stage info
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(mainScene);
		window.show();

	}

}
