# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattelee kolmitasoista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraava:

<img src="https://github.com/iikkamatias/harjoitustyo/blob/master/dokumentaatio/arkkitehtuurikuva.png" width="160">

Pakkaus _userinterface_ sisältää JavaFX:llä toteutetun käyttöliittymän _domain_ sovelluslogiikan ja _dao_ tietojen pysyväistallennuksesta vastaavan koodin.

## Käyttöliittymä

 Sovelluksen käyttöliittymä koostuu kahdesta kokonaisuudesta:
 * Ristinolla peli ja siihen liittyvät valinnat
	* Aloitusnäkymä, jossa voi valita ruudukon sekä voittavan suoran koon
	* Pelinäkymä, jossa pelataan peliä
 * Näkymän Highscores-listoille
	* Jos pääsee listalle, voi lisätä oman nimimerkin
	* Highscores-listanäkymä näyttää pienimmillä siirroilla voitetut pelit aina tietyllä ruudukon ja voittosuoran koolla.

Kaikki scenet on omia BorderPane-olioita, jotka asetetaan GameUissa luotuun päänäkymään.

Käyttäjä tekee käyttöliittymässä valintoja, jotka vaikuttavat toimintaan. Esim. klikkaa uuden siirron tai valitsee ruudukon koon.## Sovelluslogiikka

 Sovellus toimii kolmessa eri kerroksessa. Ensimmäinen kerros eli pakkaus ristinollaapp.ui sisältää käyttöliittymän koodin. Pakkaus ristinollaapp.domain sisältää sovelluksen sovelluslogiikan
 ja viimeinen pakkaus eli ristinollaapp.dao sisältää tietojen pysyväistalletuksen.

 Käyttäjän toiminnan mukaan ui-kerroksesta siirtyy metodien avulla tietoja ja käskyjä sovelluslogiikkaan, joka mm. ylläpitää käynnissä olevan ristinollapelin tilannetta kaksiulotteisessa taulukossa. Kun pelilogiikassa huomataan, että peli 
 on päättynyt top-listalogiikka tallettaa kyseisen pelin tietoja dao-pakkauksen tietokantaan. 

## Sovelluslogiikka

 Sovelluksessa on kolme kerrosta. Userinterface sisältää käyttöliittymän koodin. Domain sisältää sovelluksen sovelluslogiikan. Dao sisältää tietojen tallentamisen. 
