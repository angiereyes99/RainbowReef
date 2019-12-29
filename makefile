JAVA = java
JAVAC = javac

all: compile run-file

clean:
	rm -rf bin;

compile:
	mkdir -p bin;
	$(JAVAC) src/rainbowreef/gameobjects/*.java -d bin;
	$(JAVAC) src/rainbowreef/*.java -d bin;

run-file:
	cd ./bin/; java rainbowreef.GameWorld;