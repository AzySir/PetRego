# PetRego 

## Set Up
<br />

> Clone Git Repository


```
git clone https://github.com/AzySir/PetRego.git
```

<br />

> Ensure the below Java Version is installed on your system

```
java version "1.8.0_181"
Java(TM) SE Runtime Environment (build 1.8.0_181-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.181-b13, mixed mode)
```

<br />

## To Run Application

<br />

> Run the Clean Package Maven command below 

```
mvn clean package
```

<br />

> Run Application 

```
mvn spring-boot:run
```

<br />

> Once the application is runnin you may access the H2 Database from the following url. Due to the absence of security no Username or Password is required to sign in 

``` 
http://localhost:8080/h2-console
```

<br />

> Below are some SQL Queries also you may be able to inject directly into H2-Database 

```
INSERT INTO owners (id, first_name, last_name, dob, email, phone_number, pets) VALUES (123, 'Adam', 'Sir', '04/03/1992','adam.sir@mypet.com', '0400000000', 'Dog');
INSERT INTO owners (id, first_name, last_name, dob, email, phone_number, pets) VALUES (232, 'Bob', 'Builder', '04/03/1992','bob.builder@mypet.com', '0411111111', 'Cat');
INSERT INTO owners (id, first_name, last_name, dob, email, phone_number, pets) VALUES (444, 'Super', 'Man', '04/03/1992','super.man@mypet.com', '042323212323', 'Chicken');
INSERT INTO owners (id, first_name, last_name, dob, email, phone_number, pets) VALUES (777, 'Adam', 'Johnson', '04/03/1992','adam.johnson@mypet.com', '047777777','Snake');
INSERT INTO owners (id, first_name, last_name, dob, email, phone_number, pets) VALUES (789, 'Bob', 'Adam', '04/03/1992','bob.adam@mypet.com', '0423489723', 'Dog');

INSERT INTO pets (id, pet_type, pet_food, age, pet_name, owner_id) VALUES (911, 'Dog', 'Bones', 10, 'Bucket', 777);
INSERT INTO pets (id, pet_type, pet_food, age, pet_name, owner_id) VALUES (232, 'Cat', 'Fish', 7, 'Whiskers', 232);
INSERT INTO pets (id, pet_type, pet_food, age, pet_name, owner_id) VALUES (465, 'Chicken', 'Corn', 3, 'Chook',  444);
INSERT INTO pets (id, pet_type, pet_food, age, pet_name, owner_id) VALUES (134, 'Snake', 'Mice', 20, 'Voldimort', 789);

```

<br />

## Testing 

<br />

> To run Unit Tests use the following command in the terminal

```
mvn test
```

<br />

> For API Tests there have been Mocks added in the /mocks folder of the root directory for Postman. Import these into Postman  Application and run the requests for CREATE and READ functionalities

<br />

## API Docs

### Pet API - v1.0 
---
<br />

> Retrieve ALL pets 

```
GET - "/v1/pets"
```

<br />

> Retrieve Pet Information By Id

```
GET - "/v1/pet/{id}"
```

<br />

> Retrieve Pet by Name

```
GET - "/v1/pet/name/{petname}"
```

<br />

> Retrieve Pet By Owner Id

```
GET - "/v1/pet/owner/{ownerid}"
```

<br />

> Add Single Pet via JSON

```
PUT - "/v1/pet"
```

<br />

> Add Multiple Pets via JSON Array

```
POST - "/v1/pet"
```

<br />
<br />

### Pet API v2.0
---
<br />

> Get Pet By Name - This will return more columns as v2.0 has been enhanced

```
GET - "/v2/pet/name/{name}"
```

> Get Pet By Owner Id - This will return more columns as v2.0 has been enhanced

```
GET - "/v2/pet/owner/{ownerid}"
```

### Owner API 
---
<br />
<br />

> Get ALL Owners

```
GET - "/v1/owners"
```

<br />

> Get Owner By Id

```
GET - "/v1/owner/{id}"
```

<br />

> Get Owner By Name (First_Name & Last_Name)

```
GET - "/v1/owner/name/{name}"
```

<br />

> Get Owner by Pet Name

```
GET - "/v1/owner/pets/{petname}"
```

<br />

> Add Single Owner (JSON)

```
PUT - "/v1/owner"
```

<br />

> Add Batch of Owners (JSON Array)

```
POST - "/v1/owner"
```
