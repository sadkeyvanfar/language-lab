cmake_minimum_required(VERSION 3.10)
project(language_lab_cpp VERSION 1.0 LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

include_directories(include)

# Set the build output directory
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/build)

# Main executable
add_executable(main src/main.cpp src/greeting.cpp)

# Test executable
add_executable(test_greeting test/test_greeting.cpp src/greeting.cpp)
