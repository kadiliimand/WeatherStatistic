## Steps to Setup

**1. Clone the application**
```bash
https://github.com/kadiliimand/WeatherStatistic
```

**2. Run**
```bash
src / main / java / com / kadi / WeatherStatistic / WeatherStatisticApplication 
```

**3. Database**
```bash
Database: H2
```


+ Go to browser:  `http://localhost:8085/h2-console`
+ In Login window click: `Connect`

**Important: Please add into CITIES table at least one city, before making requests from a database!**

To do that, insert into terminal, for example:
```bash
INSERT INTO CITIES (CITY) VALUES ('Tallinn');
```

**4. Endpoints**


| Method | Url | Description |
| ------ | --- | ----------- | 
| GET    | http://localhost:8085/v1/system/health | Check does application works | 
| POST   | http://localhost:8085/v1/basic/addCity?city= | Add new city | 
| GET    | http://localhost:8085/v1/basic/listOfCities | Get a list of cities from database | 
| DELETE | http://localhost:8085/v1/basic/deleteCity?city= | Delete city by name | 
| POST   | http://localhost:8085/v1/statistic/averageTemp?city= | Get average temperature by city name | 
| POST   | http://localhost:8085/v1/statistic/averageWindSpeed?city= | Get average wind speed (mph) by city name |
| POST   | http://localhost:8085/v1/statistic/popularWindDir?city=Tallinn | Get most popular wind direction by city name |
| GET    | http://localhost:8085/v1/cityStatistic/maxTemp | Get warmest city (by average temperature) from database |
| GET    | http://localhost:8085/v1/cityStatistic/minTemp | Get coldest city (by average temperature) from database |
| GET    | http://localhost:8085/v1/cityStatistic/maxWind | Get windier city (by average wind speed) from database |
| GET    | http://localhost:8085/v1/cityStatistic/maxTemp | Get wind-silent city (by average wind speed) from database |
