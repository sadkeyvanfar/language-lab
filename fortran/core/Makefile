FC = gfortran
FFLAGS = -Wall -g

# Find all .f90 files recursively under src/
SRC := $(shell find src -name '*.f90')

# Map source files to object files in build/ (preserving folder structure)
OBJ := $(patsubst src/%.f90,build/%.o,$(SRC))

# Binaries correspond to each .f90 file (same relative path, no extension)
BIN := $(patsubst src/%.f90,build/%,$(SRC))

.PHONY: all clean

all: build $(BIN)

build:
	mkdir -p build

# Ensure necessary build subdirectories exist
$(BIN): | build_dirs

build_dirs:
	@mkdir -p $(sort $(dir $(OBJ)))
	@mkdir -p $(sort $(dir $(BIN)))

# Link object file into executable
build/%: build/%.o
	$(FC) $(FFLAGS) $< -o $@

# Compile .f90 source into object file
build/%.o: src/%.f90
	$(FC) $(FFLAGS) -c $< -o $@

clean:
	rm -rf build
