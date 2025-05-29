COMPIL_FILE = sources.txt

all: compil run

compil:
	find * -name "*.java" > $(COMPIL_FILE)
	javac @$(COMPIL_FILE) -d target

run:
	java -cp target com.devj2k.avaj.launcher.Simulator

clean:
	rm -f $(COMPIL_FILE)
	rm -rf target
