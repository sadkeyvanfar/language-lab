#!/bin/sh


# This script demonstrates various types of expansions in shell scripting.
# It includes variable expansion, command substitution, and arithmetic expansion.

# command substitution
# Usage: $(command)
echo "Kernel version is: $(uname -r)"
# or using backticks (deprecated)
echo "Kernel version is: `uname -r`"

# arithmetic expansions
# Usage: $((expression))
echo "Sum of 5 and 3 is: $((5 + 3))"

# variable expansion
# Usage: ${variable} echo $variable
greeting="Hello, World!"
echo "Greeting message is: ${greeting}"
# or simply
echo "Greeting message is: $greeting"

# brace expansion
# Usage: {a,b,c}
echo {A,B,C}

# sample of brace expansion with a range
echo {1..5}s
