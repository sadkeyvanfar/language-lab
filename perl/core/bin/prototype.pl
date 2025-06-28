#!/usr/bin/perl
use strict;
use warnings;

# This script demonstrates the use of prototypes in Perl
# Prototypes allow you to define the expected number and types of arguments for a subroutine
# They help catch errors at compile time and improve code readability
# it is like a function signature in other languages, but not as strict
# A prototype allow calling functions without parentheses or to emulate built-in function behavior,
# but it’s not a strict type or arity checker.

# Define a subroutine with a prototype that expects two scalars
sub add_two ($$) {
    my ($a, $b) = @_;
    print $a + $b, "\n";
}

add_two 3, 4;        # OK: no parentheses needed
# add_two(3);        # Runtime error: too few arguments
# add_two 3;         # Compile-time error: prototype expects two scalars
