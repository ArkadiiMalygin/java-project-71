run-dist:
	./build/install/app/bin/app

.PHONY: build

build:
	./gradlew clean
	./gradlew checkstyleMain
	./gradlew checkstyleTest
	./gradlew test
	./gradlew build
