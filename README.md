# PetRego 

### Set Up

<br />

> Java Version

```
java version "1.8.0_181"
Java(TM) SE Runtime Environment (build 1.8.0_181-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.181-b13, mixed mode)
```

## To Run Application

<br />

> Clean Install Packages

```
mvn clean package
```

<br />

> Run Application 

``
mvn spring-boot:run
```

### API Docs
---
## Pet API - v1.0 

<br />
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

## Pet API v2.0
<br />
<br />
> Get Pet By Name - This will return more columns as v2.0 has been enhanced

```
"/v2/pet/name/{name}"
```

> Get Pet By Owner Id - This will return more columns as v2.0 has been enhanced

```
"/v2/pet/owner/{ownerid}"
```

## Owner API 

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
