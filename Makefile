
all:
	mkdir -p bin
	javac -d bin src/thread/Main.java

run:
	java -cp bin/ thread.Mutex

clean:
	rm -rf bin
