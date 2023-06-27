https://github.com/sameersbn/docker-postgresql/issues/112

You need to define a password for user postgres

Get container
docker ps

Enter inside of the container
docker exec -it <hash> bash

Start query console
psql

Define password
ALTER ROLE postgres WITH PASSWORD 'your_password';

Then you may grant other users as superuser and etc. (Make your volume persist)