# FascicoloDocumentaleMvcRepository
Configurazione di base IBRIDA (senza utilizzo di applicationContext.xml) di un'applicazione Spring mvc, integrata con Tiles3 e distribuita con  wildfly17

Applicazione web che gestisce i documenti sanitari. 
Modulo padre per gestire la configurazione esterna,
architettura basata su spring mvc con configurazione xml minima. 
Orm jpa.
Application server WILDFLY 17.
Database POSTGRES.
I layout sono gestiti con il framework TILES3, che ho integrato in modo programmatico
con spring.
Il framework per i css è Bootstrap-italia (usato in anbito PA).

La profilazione verrà gestita interamente con spring security, mentre l'autenticazione sarà
delegata ad un provider di autenticazione come wso2.