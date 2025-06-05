TARGET = build/hello
SRC = src/hello.s
OBJ = build/hello.o
SDK_PATH := $(shell xcrun --sdk macosx --show-sdk-path)

all: $(TARGET)

$(TARGET): $(OBJ)
	ld -arch arm64 -o $(TARGET) $(OBJ) -lSystem -syslibroot $(SDK_PATH) -e _main

$(OBJ): $(SRC)
	mkdir -p build
	as -arch arm64 -o $(OBJ) $(SRC)

run: $(TARGET)
	./$(TARGET)

clean:
	rm -rf build
