stop:
	docker-compose down -v
start:
	DOCKER_BUILDKIT=0 docker-compose up -d && docker ps -a

clean:
	mvn clean

java-build:
	mvn install

docker-build:
	cd ChildOne; $(MAKE) all
	cd ChildTwo; $(MAKE) all
	cd Parent; $(MAKE) all
	cd EurekaServer; $(MAKE) all

docker-build-base:
	DOCKER_BUILDKIT=0 docker build -f Dockerfile.base --tag tonberry/spring-jdk17:latest .

all: java-build docker-build start

