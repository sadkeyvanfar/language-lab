CC = clang
CFLAGS = -Wall -g

# Find all .c files recursively under src/
SRC := $(shell find src -name '*.c')

# Map source files to object files in build/ (preserving folder structure)
OBJ := $(patsubst src/%.c,build/%.o,$(SRC))

# Binaries correspond to each .c file (same relative path, no extension)
BIN := $(patsubst src/%.c,build/%,$(SRC))

.PHONY: all clean

all: build $(BIN)

build:
	mkdir -p build

# Make sure all necessary build subfolders exist
$(BIN): | build_dirs

build_dirs:
	@mkdir -p $(sort $(dir $(BIN)))
	@mkdir -p $(sort $(dir $(OBJ)))

# Link executable from object file
build/%: build/%.o
	$(CC) $(CFLAGS) $< -o $@

# Compile source file into object file
build/%.o: src/%.c
	$(CC) $(CFLAGS) -c $< -o $@

clean:
	rm -rf build
