#include "../include/greeting.hpp"
#include <cassert>
#include <iostream>

int main() {
    assert(greet("World") == "Hello, World!");
    std::cout << "All tests passed.\n";
    return 0;
}
