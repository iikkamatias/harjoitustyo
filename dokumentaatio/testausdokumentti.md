# Testausdokumentti

Ohjelmaa on testattu sekä automatisoiduin yksikkötestein JUnitilla että manuaalisesti järjestelmätasolla.

## Yksikkötestaus

Ohjelmaa on testattu automatisoiduilla Junit testeillä. Testit testaavat sekä tiedon tallentamista että pelilogiikan toimintaa.

### Sovelluslogiikka
Kansion Domain toimintaa testaavat luokat DaoTest ja LogicTest. LogicTest-luokka testaa pelattavan pelin eri vaiheita. DaoTest testaa tiedon tallentamiseen liittyviä asioita.

### Testikattavuus

Sovelluksen testauksen rivikattavuus on 80% ja haaraumakattavuus on 78%

<img src="https://github.com/iikkamatias/harjoitustyo/blob/master/dokumentaatio/Testikattavuus.png" width="1500">
 
 
## Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.

### Asennus ja konfigurointi

Sovellus on ladattu githubista ja sen juureen on asetettu ohjeiden mukaisesti config.properties-tiedosto.

### Toiminnallisuudet

Kaikki vaatimusmäärittelyn toiminnallisuudet on testattu.

## Sovellukseen jääneet laatuongelmat

Sovelluksessa on muutamia liian pitkiä metodeja.

