# Ohjelmistotekniikka harjoitustyö

[arkkitehtuuri](https://github.com/iikkamatias/harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[määrittelydokumentti](https://github.com/iikkamatias/harjoitustyo/blob/master/dokumentaatio/dokumentaatio.md)

[tuntikirjanpito](https://github.com/iikkamatias/harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

## Komentorivitoiminnot

### Testaus

 Testit suoritetaan komennolla:
 ```
  mvn test
 ```

 Testikattavuusraportti luodaan komennolla:
 ```
  mvn test jacoco:report
 ```
 
  Checkstyleraportti luodaan komennolla:
 ```
  mvn jxr:jxr checkstyle:checkstyle
 ```
 ### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _Ristinolla-1.0-SNAPSHOT.jar_

### Ohjelman suorittaminen

 Sovellusta voi käyttää terminaalin kautta komennolla:
 ```
  mvn compile exec:java -Dexec.mainClass=main.Main
 ``` 
