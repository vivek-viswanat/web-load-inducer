# JVM loader Project

Start the project locally using the below command:
```shell script
./mvnw compile quarkus:dev
```
The instance can be accessed via http://localhost:8080/loader

## Containerize the app

Kubernetes configuration is part of application.properties file. Build the app using the below command:

```shell script
./mvnw package
```

Build the docker image using the below command (refer Dockerfile.jvm):
```shell script
docker build -f src/main/docker/Dockerfile.jvm -t viswanat/jvm-load-inducer .
```

Deploy in docker runtime using the below command:
```shell script
docker run -i --rm -p 8080:8080 viswanat/jvm-load-inducer

# or for debug use the one below
docker run -i --rm -p 8080:8080 -p 5005:5005 -e JAVA_ENABLE_DEBUG="true" viswanat/jvm-load-inducer
```

To deploy in kubernetes, use the below command:
```shell script
 ./mvnw compile quarkus:dev
kubectl apply -f target/kubernetes/kubernetes.yml
```

## CPU Load
To induce a cpu load, provide the number of iterations for computations.

http://localhost:8080/load/cpu/iter/1000000000

Note: Internally, the code uses sum & division to induce load.

## Mem Load
To induce a memory load, provide the size of items in map

http://localhost:8080/load/mem/iter/10000000

http://localhost:8080/load/mem/iter/10000000/delay/2000

Note: Internally, the code uses map to induce memory load.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using: 
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Related Guides


## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
