# slApiTest

Implementationen är byggd med Java 8 som en webservice så det behövs en tomcat (eller motsv) för att exekvera den. Jag har testat på 9.0.37 och det har funkat bra.
Man bygger war-fil med maven (mvn clean package) och deployar sen den filen på tomcaten.
Min nyckel till Trafiklab ligger hårdkodad i klassen SLApiService och nyckeln har bara några få användningar per dag.

Det finns tre ändpunkter:
/demoSLHallplats/toplines/ Ger de tio busslinjer med flest antal hållplatser
/demoSLHallplats/toplines/(int n) Ger de n busslinjer med flest antal hållplatser
/demoSLHallplats/busstops/(int l) Ger busshållplatsnamnen för linje l

Svaren kommer som enkel html så det går bra att anropa från webläsare (istället för tex postman/GET).
