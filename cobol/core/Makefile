COB_SRC := src/hello_world.cob
OUT_BIN := build/hello_world

.PHONY: run clean

build:
	cobc -x -o $(OUT_BIN) $(COB_SRC)

run: build
	./$(OUT_BIN)

clean:
	rm -f $(OUT_BIN)

.PHONY: build
