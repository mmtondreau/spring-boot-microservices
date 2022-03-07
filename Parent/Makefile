package:
	mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

docker-build:
	DOCKER_BUILDKIT=0 docker build --tag tonberry/parent:latest .

all: package docker-build