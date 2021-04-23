## Steps to Setup

**1. Clone the application**
```bash
https://github.com/AivarApsalon/Dentist-back
```

**2. Run**
```bash
src / main / java / com / example / demo / DemoApplication 
```

**3. Database**
```bash
Database: H2
```


+ Go to browser:  `http://localhost:8085/h2-console`
+ In Login window click: `Connect`

**Important: Please add into DENTIST table at least one dentist, before making requests from database!**

To do that, insert into terminal, for example:
```bash
INSERT INTO DENTIST (DENTIST_NAME) VALUES ('M.Kask');
INSERT INTO DENTIST (DENTIST_NAME) VALUES ('O.Kuusk');
INSERT INTO DENTIST (DENTIST_NAME) VALUES ('N.Palm');
INSERT INTO DENTIST (DENTIST_NAME) VALUES ('S.Pihl');
INSERT INTO DENTIST (DENTIST_NAME) VALUES ('T.Kadak');
```

**After that, open front-end application from:  https://github.com/AivarApsalon/Dentis-front  and follow README.md**

**5. Endpoints**


| Method | Url | Description |
| ------ | --- | ----------- | 
| GET    | http://localhost:8085/dentist/dentist-list | Get a list of dentists from database | 
| GET    | http://localhost:8085/dentist/registrations | Get all registrations from database | 
| GET    | http://localhost:8085/dentist/registrations-by-dentist-id/{dentist_id} | Get all registrations by dentist id | 
| POST   | http://localhost:8085/dentist/add-registration | Add new registration |
| PUT    | http://localhost:8085/dentist/change-registration/{registration_id} | Change existing registration |
| DELETE | http://localhost:8085/dentist/delete-registration/{registration_id} | Delete existing registration |



#### Samples of URLs with valid JSON Request Bodys

Get Dentist List
```bash
http://localhost:8085/dentist/dentist-list
```

Get All Registrations
```bash
http://localhost:8085/dentist/registrations
```

Get Registrations By Dentist Id
```bash
http://localhost:8085/dentist/registrations-by-dentist-id/2
```

Add Registration
```bash
http://localhost:8085/dentist/add-registration

{
    "date": "2021-03-01",
    "time": "10:00",
    "firstName": "John",
    "lastName": "Smith",
    "idCardNr": "AA000",
    "dentistId" : 2
}
```

Change Registration
```bash
http://localhost:8085/dentist/change-registration/2
{
    "date": "2020-11-05",
    "time": "14:00",
    "firstName": "John",
    "lastName": "Smith",
    "idCardNr": "AA000",
    "dentistId" : 2
}
```

Delete Registration
```bash
http://localhost:8085/dentist/delete-registration/2
```
