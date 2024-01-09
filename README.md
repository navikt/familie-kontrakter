familie-kontrakter
================

Interne kontrakter for familie-applikasjonene.

Kontrakten er uttrykt som et sett med klasser og deres avhengigheter til hverandre. Denne strukturen skal gjenbrukes i andre prosjekter, så man ikke spesifiserer den samme strukturen i flere prosjekter. Enkel felt-validering spesifiseres også i denne kontrakten.

# Komme i gang

Prosjekter som har avhengigheter til en gitt modul i familie-kontrakter må legge til følgende elementer i pom.xml:

```xml
<project>
  ...
  <dependencies>
    ...
    <dependency>
      <groupId>no.nav.familie.kontrakter</groupId>
      <artifactId>kontantstotte</artifactId>
      <version>KONTRAKT_VERSION</version>
    </dependency>
    ...
  </dependencies>
  ...
  <repositories>
    ...
    <repository>
      <id>github</id>
      <url>https://maven.pkg.github.com/navikt/familie-kontrakter</url>
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

i IntelliJ og huk av for 'Override' ved siden av 'User settings file:' med referanse til filen over.
 
Github Actions benyttes for å bygge prosjektet og laste det opp til Github Package.

Lokalt bygg av prosjektet utføres med `mvn verify`.

# Henvendelser

Opprett en issue her på GitHub dersom du har spørsmål til koden, eller prosjektet

## For NAV-ansatte

Interne henvendelser kan sendes via Slack i kanalen #team-familie

## Kode generert av GitHub Copilot

Dette repoet bruker GitHub Copilot til å generere kode.
