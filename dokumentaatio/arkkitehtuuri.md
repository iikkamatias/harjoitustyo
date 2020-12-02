# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattelee kolmitasoista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraava:

<img src="https://github.com/iikkamatias/harjoitustyo/blob/master/dokumentaatio/arkkitehtuurikuva.png" width="160">

Pakkaus _userinterface_ sisältää JavaFX:llä toteutetun käyttöliittymän _domain_ sovelluslogiikan ja _dao_ tietojen pysyväistallennuksesta vastaavan koodin.

## Käyttöliittymä

 Sovelluksen käyttöliittymä koostuu kahdesta kokonaisuudesta:
 * Ristinolla peli ja siihen liittyvät valinnat
	* Aloitusnäkymä, jossa pelaaja voi valita nimen
	* Pelinäkymä, jossa pelataan peliä
	* Loppunäkymä, jossa pelaaja voi siirtyä katselemaan, ketkä ovat peliä pelanneet.
 * Näkymän Pelaajista, jotka ovat peliä pelanneet
	* Peliä pelatessa listalle tulee nimimerkki automaattisesti

Kaikki scenet on omia BorderPane-olioita, jotka asetetaan GameUissa luotuun päänäkymään.

Käyttäjä tekee käyttöliittymässä valintoja, jotka vaikuttavat toimintaan. Esim. klikkaa uuden siirron tai valitsee ruudukon koon.## Sovelluslogiikka


## Sovelluslogiikka

 Sovelluksessa on kolme kerrosta. Userinterface sisältää käyttöliittymän koodin. Domain sisältää sovelluksen sovelluslogiikan. Dao sisältää tietojen tallentamisen. 
 
 ## Sekvenssikaavio
 <img src="https://github.com/iikkamatias/harjoitustyo/blob/master/dokumentaatio/sekvenssikaavio.png" width="160">
