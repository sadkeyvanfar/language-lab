.PHONY: build run clean

BUILD_DIR = bin
SRC_FILE = src/hello_world.bas
OUT_FILE = $(BUILD_DIR)/hello_world

build:
	mkdir -p $(BUILD_DIR)
	qb64 -c -o $(OUT_FILE) $(SRC_FILE)

run: build
	./$(OUT_FILE)

clean:
	rm -rf $(BUILD_DIR)/*
