.SILENT: Lab9_q1.c peterson.c
.PHONY: all clean

CC = gcc
TARGET = goodCnt

SRCS = Lab9_q1.c peterson.c
OBJS = $(patsubst %.c, %.o, $(SRCS)) # Lab9_q1.o and peterson.o from SRCS

all: $(TARGET)

$(TARGET): $(OBJS)
	$(CC) -o $@ $^

%.o: %.c
	$(CC) -c $<

clean:
	rm -rf *.o $(TARGET)