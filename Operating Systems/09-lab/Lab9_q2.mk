.SILENT: Lab9_q2
.PHONY: all clean

CC = gcc
TARGET = output_q2

SRCS = Lab9_q2.c
OBJS = $(patsubst %.c, %.o, $(SRCS)) # Lab9_q2.o from SRCS

all: $(TARGET) text

$(TARGET): $(OBJS)
	$(CC) -o $@ $^

%.o: %.c
	$(CC) -c $<

text:
	./$(TARGET) > Lab9_q2_output.txt

clean:
	rm -rf *.o $(TARGET)