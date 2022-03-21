stop:
	docker-compose down -v
start:
	DOCKER_BUILDKIT=0 docker-compose up -d && docker ps -a

clean:
	mvn clean

java-build:
	mvn install

docker-build: docker-build-childone docker-build-childtwo docker-build-eureka docker-build-parent docker-build-config

docker-build-childone: java-build
	cd ChildOne; $(MAKE) all

docker-build-childtwo: java-build
	cd ChildTwo; $(MAKE) all

docker-build-parent: java-build
	cd Parent; $(MAKE) all

docker-build-eureka: java-build
	cd EurekaServer; $(MAKE) all

docker-build-config: java-build
	cd Config; $(MAKE) all

docker-build-base:
	DOCKER_BUILDKIT=0 docker build -f Dockerfile.base --tag tonberry/spring-jdk17:latest .

all: java-build docker-build start

