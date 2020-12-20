# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattelee kolmitasoista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraava:

<img src="https://github.com/iikkamatias/harjoitustyo/blob/master/dokumentaatio/arkkitehtuurikuva.png" width="300">

Pakkaus _userinterface_ sisältää JavaFX:llä toteutetun käyttöliittymän _domain_ sovelluslogiikan ja _dao_ tietojen pysyväistallennuksesta vastaavan koodin.

## Käyttöliittymä

 Sovelluksen käyttöliittymä koostuu kahdesta kokonaisuudesta:
 * Ristinolla peli ja siihen liittyvät valinnat
	* Aloitusnäkymä, jossa pelaaja voi siirtyä peliin, tai lopetusnäkymään
	* Pelinäkymä, jossa pelataan peliä
	* Loppunäkymä, jossa pelaaja voi siirtyä aloitusnäkymään.

Kaikki scenet on omia BorderPane-olioita, jotka asetetaan Game:ssa luotuun päänäkymään.

Käyttäjä tekee käyttöliittymässä valintoja, jotka vaikuttavat toimintaan. Esim. klikkaa uuden siirron tai valitsee ruudukon koon.## Sovelluslogiikka


## Sovelluslogiikka

 Sovelluksessa on kolme kerrosta. Userinterface sisältää käyttöliittymän koodin. Domain sisältää sovelluksen sovelluslogiikan. Dao sisältää tietojen tallentamisen. 
 
Käyttäjän toiminnan seurauksena Userinterface siirtää metodien avulla tietoja, sekä komentoja sovelluslogiikkaan.

<img src="https://github.com/iikkamatias/harjoitustyo/blob/master/dokumentaatio/luokkakaavio.png" width="600">


 
 ## Sekvenssikaavio
 
 Toimintalogiikka, kun käyttäjä tekee siirjota pelissä ja peli päättyy.
 
 <img src="https://github.com/iikkamatias/harjoitustyo/blob/master/dokumentaatio/Kaavio.png" width="500">
 
Käyttöliittymä kutsuu Logic-luokkaa, jossa on tiedot pelistä. Kun pelaaja asettaa siirtonsa tyhjään kohtaan, vuoro vaihtuu. Kun siirto tehdään ja löytyy voittava suora, kutsutaan metodia end(), jonka jälkeen käyttöliittymä luo uuden näkymän endlayout.
 
 ## Ohjelman rakenteeseen jääneet heikkoidet

### Käyttöliittymä

 Sovellus luo uusia näkymiä aina, kun sellaiseen siirrytään. Javan roskankerääjä kerää ne pois, mutta olisi ehkä käytännöllisempää uusien näkymien luonnin sijaan päivittää jo olemassa olevia näkymiä.

### Dao  
 Tietokanta ei toimi vielä
