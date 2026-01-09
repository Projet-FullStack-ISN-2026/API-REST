# API-REST

## Installation (DOCKER UNIQUEMENT SOUS WSL)

- Installer Docker Desktop au préalable (si vous êtes sous windows, installer WSL2 : https://docs.docker.com/desktop/windows/wsl/)
- Cloner le projet

Dans un terminal bash:

```
git clone [URL du projet]
```

- Copier le fichier `.env.example` de la racine du projet en `.env`

## Pour lancer le projet

Lancer l'environnement Docker :

```
docker compose up --build -d
```

Le projet va se construire tout seul et s'afficher dans Docker Desktop.
Le container du backend va démarrer en dernier à cause d'un healthcheck effectué sur le container MySQL

Ou alors :
- Lancez l'application du backend depuis votre IDE (si pas de Docker)

### Initialisation BDD

#### Docker:
- La base de données s'initialise avec l'environnement Docker.

#### UwAmp:
- Installez et démarrez le logiciel UwAmp pour bénéficier d'un serveur mySQL virtuel.
- La base de données doit être créée en amont directement depuis votre logiciel de SGBD (ex: MySQLWorkbench).
- Pour finir, relancez votre application sur l'IDE pour que les tables se créent dans la BDD.

> Les données doivent être ajoutées manuellement peu importe la configuration.

## Urls Dev

- Accès Site (nécessite le démarrage du serveur npm frontend) : http://localhost:3000