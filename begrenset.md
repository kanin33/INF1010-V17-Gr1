# Begrensede typeparametere

Når vi lager generiske klasser sier vi ikke på forhånd hvilken type
den *formelle* parameteren er, men skriver

``` java
class MinKlasse<E> {
    // koden til klassen
}
```
Den formelle parameteren E bestemmes når vi lager et objekt av klassen,
for eksempel i en main-metode:
``` java
public static void main(String[] args) {
    MinKlasse<String> m = new MinKlasse<String>();
}
```
Vi kan la E være *hvilken som helst* type, her er det ingen
begrensninger.

Hvis vi vil ha en begrensning på hva slags type E kan være
kan vi gjøre E til en *begrenset typeparameter*. Hvis vi for eksempel
har et interface
``` java
public interface Kjorbar {
    public int antHjul();
}
```
kan vi gjøre parameteren E i MinKlasse *begrenset av Kjorbar* ved å skrive
``` java
class MinKlasse<E extends Kjorbar> {
    // kode
}
```
Når vi skal bruke MinKlasse i for eksempel main-metoden *må* typen
vi setter E til å være implementere Kjorbar. Main-metoden over vil
dermed ikke fungere, siden String ikke implementerer Kjorbar. Hvis vi
derimot har klassen
``` java
class Bil implements Kjorbar {
    private int antallHjul;

    public Bil() {
        antallHjul = 4;
    }

    public int antHjul() {
        return antallHjul;
    }
}
```
vil vi kunne skrive
``` java
public static void main(String[] args) {
    MinKlasse<Bil> m = new MinKlasse<Bil>();
}
```
Grunnen til at vi vil bruke begrensede typeparametere er at når vi har
sagt at objekter av typen E skal implementere Kjorbar vet vi også
at disse objektene har metoden antHjul(). Dermed kan vi bruke denne
metoden uten å vite noe om hvordan den er implementert (implementasjonen
kan også være forskjellig i de ulike klassene som implementerer
interfacet, for eksempel vil en sykkel kun ha to hjul, mens en bil 
har fire). Vi kan altså gjøre
``` java
class MinKlasse<E extends Kjorbar> {
    private E enting;
    private E entingTil;
    private int antHjulTilSammen;

    public MinKlasse(E en, E to) {
        enting = en;
        entingTil = to;
        antHjulTilSammen = en.antHjul() + to.antHjul();
    }

    public int hentAntHjulTilSammen() {
        return antHjulTilSammen;
    }
}
```
Her bruker vi metoden antHjul til parameterene en og to, uten å vite
noe om hvordan de er implementert. I Bil-klassen er denne metoden
implementert ved å returnere fire, mens i en Sykkel-klasse vil den
returnere to.

Hvis ikke vi hadde skrevet `<E extends Kjorbar>`, men kun `<E>` ville
vi ikke visst at E hadde metoden antHjul().

Main-metoden kan nå se slik ut
``` java
public static void main(String[] args) {
    Bil bil1 = new Bil();
    Bil bil2 = new Bil();
    MinKlasse<Bil> m = new MinKlasse<Bil>(bil1, bil2);
    System.out.println(m.hentAntHjulTilSammen());
}
```
og vil da printe 8, siden de to bilene har 8 hjul til sammen.
