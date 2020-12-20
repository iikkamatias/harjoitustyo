# Ohjelmistotekniikka harjoitustyö Ristinolla-peli

[Arkkitehtuuri](https://github.com/iikkamatias/harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Määrittelydokumentti](https://github.com/iikkamatias/harjoitustyo/blob/master/dokumentaatio/dokumentaatio.md)

[Tuntikirjanpito](https://github.com/iikkamatias/harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Käyttöohje](https://github.com/iikkamatias/harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Testausdokumentti](https://github.com/iikkamatias/harjoitustyo/blob/master/dokumentaatio/testausdokumentti.md)

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

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

### Ohjelman suorittaminen

 Sovellusta voi käyttää terminaalin kautta komennolla:
 ```
  mvn compile exec:java -Dexec.mainClass=main.Main
 ``` 
