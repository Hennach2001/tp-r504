
#lancement serveur sql
docker run --rm -d -p 3307:3306  -v vol-sql-demo:/var/lib/mysql --name tp4-sql --network net-tp4 --env MYSQL_ROOT_PASSWORD= 'foo' mysql:8.0
