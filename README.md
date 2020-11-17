# Ohjelmistotekniikka harjoitustyö

[laskarit viikko 3](https://github.com/iikkamatias/harjoitustyo/tree/master/laskarit/viikko3)

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

### Ohjelman suorittaminen

 Sovellusta voi käyttää terminaalin kautta komennolla:
 ```
  mvn compile exec:java -Dexec.mainClass=main.Main
 ``` 
