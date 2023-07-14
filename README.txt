AsroTalk Assessment
```````````````````````````
Hospital Management - REST API's
~~~~~~~~~~~~~~~~~~~~~~~~~~~
Important points to keep in mind:
------------------------------------------

1. JDK Version: 1.8
2. DataBase: MySQL WorkBench 8.0 CE
3. DB Name: hospital (Need to create this in MySQL WorkBench 8.0 CE)
4. Check with the root password in application.properties file. It should be changed according to your DB root password.
5. Choose the default PORT: 8080, otherwise need to change the urls as well.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Important links for each REST API's:

1. Staff Sign-up API: Choose the Request Mapping as POST and enter the below URL
	http://localhost:8080/api/auth/signup
	signup API should contain below JSON object if any field is empty it will return error
EX:
	{
    "username": "mike",
    "name": "Mike",
    "email": "mike@gmail.com",
    "password": "testing"
	}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Staff Login API: Choose the Request Mapping as POST and enter the below URL
	http://localhost:8080/api/auth/login
	login API should contain below JSON object if any field is empty it will return error. 
	User must register before login otherwise it will return error
EX:
	{
    "username": "mike",
    "password": "testing"
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Add Patient API: Choose the Request Mapping as POST and enter the below URL
	http://localhost:8080/api/addpatient
	Add patient API should contain below JSON object if any field is empty it will return error. 
	
EX:
	{
  "name": "Will Smith",
  "age": 34,
  "room": 102,
  "expenses": 10000,
  "doctor_name": "Dr. Darby",
  "admit_date": "2023-07-15",
  "status": "Admitted"
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Get All Patients API: Choose the Request Mapping as GET and enter the below URL
	http://localhost:8080/api/auth/login
	Send the Request and you'll get a response as below, it will return all the patients admitted.
EX:
[
    {
        "id": 1,
        "name": "John Doe",
        "age": 30,
        "room": 101,
        "expenses": 5000,
        "doctor_name": "Dr. Smith",
        "admit_date": "2023-07-14",
        "status": "Admitted"
    },
    {
        "id": 2,
        "name": "Will Smith",
        "age": 34,
        "room": 102,
        "expenses": 10000,
        "doctor_name": "Dr. Darby",
        "admit_date": "2023-07-15",
        "status": "Admitted"
    }
]
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Discharge Patient API: Choose the Request Mapping as PUT and enter the below URL
	http://localhost:8080/api/{id}
here in place of {id} you need enter the patient id.
for Example, http://localhost:8080/api/1
	it will return the below response. this will also change the status field of the patient as Discharged.
EX:
Patient "Patient Name" been 'Discharged'

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Submitted By: Gautam Jaiswal
Email: gautam.jaiswal.gj.8811@gmail.com
Contact: 9110126364, 7762949477

	











