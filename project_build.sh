echo "## Build Project ##"
./gradlew build -x test

echo "## Docker Build ##"
docker build --build-arg DEPENDENCY=build/dependency -t dbstjr5517/secret-diary .

echo "## Push to Docker ##"
docker push dbstjr5517/secret-diary