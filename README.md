familie-ks-kontrakter
================

Interne kontrakter for kontantstøtte-applikasjonene.

Kontrakten er uttrykt som et sett med klasser og deres avhengigheter til hverandre. Denne strukturen skal gjenbrukes i andre prosjekter, så man ikke spesifiserer den samme strukturen i flere prosjekter. Enkel felt-validering spesifiseres også i denne kontrakten.

Foreløpig har vi en kontrakt for datastrukturen som skal ligge til grunn for saksbehandlingen. En del av dataene kommer fra brukeren selv i søknadsdialogen, resten kommer fra oppslag mot TPS o.l.

# Komme i gang

Prosjektet tas inn som en dependency for de som skal produsere eller konsumere disse objektene.

[CircleCI](https://circleci.com/gh/navikt/familie-ks-kontrakt) benyttes for å bygge prosjektet og laste det opp til Maven Central. Av ukjente grunner vil dette feile ofte, så tålmodighet er påkrevd når man laster opp ny versjon.

Lokalt bygg utføres med `./gradlew build -x test`, og en .jar vil bli produsert under /build/libs.

# Henvendelser

Spørsmål knyttet til koden eller prosjektet kan rettes mot:

* Tor Narland, tor.narland@nav.no
* Geirmund Simonsen, geirmund.simonsen@nav.no

## For NAV-ansatte

Interne henvendelser kan sendes via Slack i kanalen #team-familie
