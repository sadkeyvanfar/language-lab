# Collect all .c files in the src directory
file(GLOB SOURCES "*.c")

# Tell CMake to create an executable using these source files
add_executable(c-samples ${SOURCES})

# Link any additional libraries if needed
# target_link_libraries(my_project some_library)

# Specify include directories if they are not in the default location
target_include_directories(c-samples PUBLIC ../include)