#!/usr/bin/env bash
docker-compose up --build -d

echo "Waiting for debug port 5005 to be open..."
while ! nc -z localhost 5005; do
  sleep 1
done

#Wait 2s that should be enough for docker docker image to be up.
sleep 2

echo "Port 5005 is open. Ready to debug!"