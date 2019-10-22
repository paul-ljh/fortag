NAME = "Main"

default:
	@echo "Compiling..."

	javac -sourcepath src src/$(NAME).java src/*/*.java -d out

	jar cmf src/manifest.mf out/a2.jar -C out src/
	jar tf out/a2.jar

run: 
	@echo "Running..."
	# This one works
	# java -cp ./out src/Main 

	java -jar out/a2.jar

clean:
	rm out/*.jar
	rm -rf ./out/src
