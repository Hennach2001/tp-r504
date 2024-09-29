#!/bin/bash
docker stop $(docker ps -aq) && docker rm $(docker ps -aq)
docker system prune -af && docker network prune -f && docker volume prune -f

