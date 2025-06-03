# Compiler
FPC = fpc # Free Pascal Compiler

# Output binary
TARGET = bin/hello_world

# Output binary for tests
TEST_TARGET = bin/test_hello_world

# Source files
SRC = src/hello_world.pas

# Test source files
TEST_SRC = tests/test_hello_world.pas

# Compiler flags
FLAGS = -Mobjfpc -Scgi -O2 -Sh

# Default rule
all:
	@mkdir -p bin
	$(FPC) $(FLAGS) -o$(TARGET) $(SRC)

# Test rule
test:
	@mkdir -p bin
	$(FPC) $(FLAGS) -o$(TEST_TARGET) $(TEST_SRC)
	@./$(TEST_TARGET)

# Clean rule
clean:
	rm -rf bin *.o *.ppu *.exe *.out
