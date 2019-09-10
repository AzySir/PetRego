# PetRego
---

# API Docs
## Pet API - v1.0 

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

> Get Pet By Name - This will return more columns as v2.0 has been enhanced

```
"/v2/pet/name/{name}"
```

> Get Pet By Owner Id - This will return more columns as v2.0 has been enhanced

```
"/v2/pet/owner/{ownerid}"
```

## Owner API 

> Get ALL Owners

```
GET - "/v1/owners"
```

> Get Owner By Id

```
GET - "/v1/owner/{id}"
```

> Get Owner By Name (First_Name & Last_Name)

```
GET - "/v1/owner/name/{name}"
```

> Get Owner by Pet Name

```
GET - "/v1/owner/pets/{petname}"
```

> Add Single Owner (JSON)

```
PUT - "/v1/owner"
```

> Add Batch of Owners (JSON Array)

```
POST - "/v1/owner"
```
