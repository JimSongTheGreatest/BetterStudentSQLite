# BetterStudent

Using Java, SQL, and JavaFx

Our program features

  - This software will incorporate Java, and JavaFX.
  -	A flexible and easy to use software would fill the gap of the correlation between achieving higher grades/GPA and taking care of oneself.
  -	Track eating, sleeping, and studying to see how the individual is.
  -	Give a survey on their current habits and lifestyle and give personalized advice on how they can do better.
  -	Users' data would be stored permanently until they choose to add, delete, or change their data input for a renewed personalized advice.
  -	Running it shall be easy and won’t need installing anything else.
  -	It shall run on all existing OS’s (windows, mac, linux) with JavaFX.
  -	Future plans would be to modify the software to let users know they could benefit from more sleep, more meals eaten, and more hours studied, depending on their GPA.
### Project Structure
```html
.
├── README.md
├── Screen-Shot-2019-02-19-at-7.52.02-PM.png
├── bin
│   └── application
│       ├── Main.class
│       ├── application.css
│       ├── buttonController.class
│       ├── eating.fxml
│       ├── gpa.fxml
│       ├── logIn.fxml
│       ├── main.fxml
│       ├── resources
│       │   ├── EAT1.jpg
│       │   ├── GPA1\ (1).jpg
│       │   ├── Loggin\ (1).jpeg
│       │   ├── SLEEP\ (1).jpg
│       │   ├── SLEEP1.jpg
│       │   ├── STUDY.jpg
│       │   ├── SUM.jpg
│       │   ├── apple.jpeg
│       │   ├── eatchart1.jpg
│       │   ├── gpachart.jpg
│       │   ├── sleepchart.png
│       │   ├── studychart1.png
│       │   ├── sumchart.jpg
│       │   └── summary.jpg
│       ├── sleep.fxml
│       ├── study.fxml
│       ├── studychart1.png
│       └── summary.fxml
├── build.fxbuild
├── requirements.txt
└── src
    └── application
        ├── Main.java
        ├── application.css
        ├── buttonController.java
        ├── eating.fxml
        ├── gpa.fxml
        ├── logIn.fxml
        ├── main.fxml
        ├── resources
        │   ├── EAT1.jpg
        │   ├── GPA1\ (1).jpg
        │   ├── Loggin\ (1).jpeg
        │   ├── SLEEP\ (1).jpg
        │   ├── SLEEP1.jpg
        │   ├── STUDY.jpg
        │   ├── SUM.jpg
        │   ├── apple.jpeg
        │   ├── eatchart1.jpg
        │   ├── gpachart.jpg
        │   ├── sleepchart.png
        │   ├── studychart1.png
        │   ├── sumchart.jpg
        │   └── summary.jpg
        ├── sleep.fxml
        ├── study.fxml
        ├── studychart1.png
        └── summary.fxml
```

### Project Set-Up requirements
```HTML
Settings:
IDE: Eclipse

Java1.8.202
mysql-connector-java-8.0.16.jar - BetterStudent
JavaFX
Database: SQL, XAMPP, Apache
```
```HTML
Instruction For Windows:
Click start button next to Apache and MySQL
  Copy the link http://localhost/phpmyadmin/index.php?route=/sql&server=1&db=sms&table=users&pos=0 and past it in url
  Click "New" on the left panel
    type "sms" in database name and click "Create"
      Now you are at empty db so now we click "import" on top panels
        Click Choose File
          Find sms.sql file within base directory of our project.
            Make sure you click "Go" on the right below to proceed.
              Now you should see forms for database is created
Then you just run on main.java in any IDE (i.e Eclipse)



Instruction For Mac:
First check the settings above,
Second, install and run XAMPP
  Direct to "Manage Server"
    Start MySQL Database
      Start Apache Web Server
Back to "Welcome" and click "Go to Application"]
    On URL type: http://localhost/phpmyadmin/index.php?route=/sql&server=1&db=sms&table=users&pos=0
  Here you should see localhost through phpMyAdmin
    Click "New" on the left panel
      type "sms" and click "Create"
        Now you are at empty db so now we click "import" on top panels
          Click Choose File
            Find sms.sql file within base directory of our project.
              Make sure you click "Go" on the right below to proceed.
                Now you should see forms for database is created
Then you just run on main.java in any IDE (i.e Eclipse)
```
