package application;

public class User implements TimeStudied, TimeSlept, MealsEaten {

	private int id;
	private double gpa;
	private int timeStudied;
	private int hrsSlept;
	private int numMinsEaten;
	
	public User(int id, double gpa, int timeStudied, int hrsSlept, int numMinsEaten) {
		this.id = id;
		this.gpa = gpa;
		this.timeStudied = timeStudied;
		this.hrsSlept = hrsSlept;
		this.numMinsEaten = numMinsEaten;
	}

	public void setTimeStudied(int timeStudied) {
		this.timeStudied = timeStudied;
	}

	public void setHrsSlept(int hrsSlept) {
		this.hrsSlept = hrsSlept;
	}

	public void setNumMinsEaten(int numMinsEaten) {
		this.numMinsEaten = numMinsEaten;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public int numEat() {
		// TODO Auto-generated method stub
		return numMinsEaten;
	}

	@Override
	public int avgMinEat() {
		// TODO Auto-generated method stub
		return numMinsEaten;
	}

	@Override
	public int getOptimalEatMins() {
		// TODO Auto-generated method stub
		return numMinsEaten;
	}

	@Override
	public int hrsSleep() {
		// TODO Auto-generated method stub
		return hrsSlept;
	}

	@Override
	public int avgHrsSleep() {
		// TODO Auto-generated method stub
		return hrsSlept;
	}

	@Override
	public int getOptimalSleepHrs() {
		// TODO Auto-generated method stub
		return hrsSlept;
	}

	@Override
	public int hrsStudy() {
		// TODO Auto-generated method stub
		return timeStudied;
	}

	@Override
	public int avgHrsStudy() {
		// TODO Auto-generated method stub
		return timeStudied;
	}

	@Override
	public int getOptimalStudyHrs() {
		// TODO Auto-generated method stub
		return timeStudied;
	}

}
