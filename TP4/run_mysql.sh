
#lancement serveur sql
docker run -d --name tp4-sql --network net-tp4 -e MYSQL_ROOT_PASSWORD=foo -p 3307:3306 mysql:latest
