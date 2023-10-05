all: testPeterson

testPeterson: testPeterson.o peterson.o
	gcc -o testPeterson testPeterson.o peterson.o

testPeterson.o: testPeterson.c
	gcc -c testPeterson.c

peterson.o: peterson.c
	gcc -c peterson.c

clean:
	rm -rf *.o testPeterson
