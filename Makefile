# Compiler and flags
CC = gcc
CFLAGS = -Wall -Wextra -I./include

# Directories
SRC_DIR = src
BUILD_DIR = build
INCLUDE_DIR = include

# Find all .c files in the src/ directory and create a list of corresponding executables
SRC = $(wildcard $(SRC_DIR)/*.c)
EXECUTABLES = $(patsubst $(SRC_DIR)/%.c, $(BUILD_DIR)/%, $(SRC))

# Object files (replace .c with .o)
OBJ = $(SRC:.c=.o)

# Default target: build all executables
all: $(EXECUTABLES)

# Rule to create the executables
$(BUILD_DIR)/%: $(SRC_DIR)/%.c
	$(CC) $(CFLAGS) -o $@ $^

# Rule to compile .c files into .o object files
$(BUILD_DIR)/%.o: $(SRC_DIR)/%.c
	$(CC) $(CFLAGS) -c $< -o $@

# Clean up the build (remove object files and executables)
clean:
	rm -rf $(BUILD_DIR)/*

# Phony targets (targets that are not actual files)
.PHONY: all clean
