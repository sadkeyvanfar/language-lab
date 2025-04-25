cmake_minimum_required(VERSION 3.10)
project(c-samples C)

# Set the C standard
set(CMAKE_C_STANDARD 99)

# Add the subdirectory where your source code is located
add_subdirectory(src)

# Optionally, specify include directories if they are separate
include_directories(include)