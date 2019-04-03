#!/usr/bin/env bash
set -e

echo "build service jar"
./gradlew build

echo "run docker compose"
docker-compose up
