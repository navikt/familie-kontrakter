familie-ks-kontrakter
================

Interne kontrakter for kontantstøtte-applikasjonene.

Kontrakten er uttrykt som et sett med klasser og deres avhengigheter til hverandre. Denne strukturen skal gjenbrukes i andre prosjekter, så man ikke spesifiserer den samme strukturen i flere prosjekter. Enkel felt-validering spesifiseres også i denne kontrakten.

Foreløpig har vi en kontrakt for datastrukturen som skal ligge til grunn for saksbehandlingen. En del av dataene kommer fra brukeren selv i søknadsdialogen, resten kommer fra oppslag mot TPS o.l.

# Komme i gang

Prosjekter som har avhengigheter til familie-ks-kontrakt må legge til følgende elemeter i pom.xml:

```xml
<project>
  ...
  <dependencies>
    ...
    <dependency>
      <groupId>no.nav.familie.ks</groupId>
      <artifactId>kontrakt</artifactId>
      <version>KONTRAKT_VERSION</version>
    </dependency>
    ...
  </dependencies>
  ...
  <repositories>
    ...
    <repository>
      <id>github</id>
      <url>https://maven.pkg.github.com/navikt/familie-ks-kontrakt</url>
    </repository>
    ...
  </repositories>
  ...
</project>
```

Deretter må følgende legges inn i ~/.m2/settings.xml for at det fortsatt skal bygge lokalt:

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">  
  ...
  <servers>
    ...
    <server>
      <id>github</id>
      <username>navikt</username>
      <password>PERSONAL_ACCESS_TOKEN</password>
    </server>
    ...
  </servers>
  ...
</settings>
```
Personal access token kan opprettes Fra Develeoper settings siden, via kontoinnstillingene på Github.
Den må minimum ha read:packages tilgang, og må autoriseres ved å trykke på 'Enable SSO' knappen etter at den er opprettet. 

For å slippe å kjøre Maven med ekstra parametre, gå til
- Preferences > Build Tools > Maven

i IntelliJ og huk av for 'Override' ved siden av 'User settings file'
 
Github Actions benyttes for å bygge prosjektet og laste det opp til Github Package.

Lokalt bygg av prosjektet utføres med `mvn clean install`.

# Henvendelser

Spørsmål knyttet til koden eller prosjektet kan rettes mot:

* Tor Narland, tor.narland@nav.no
* Geirmund Simonsen, geirmund.simonsen@nav.no

## For NAV-ansatte

Interne henvendelser kan sendes via Slack i kanalen #team-familie
