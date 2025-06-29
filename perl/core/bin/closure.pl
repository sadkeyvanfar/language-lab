#!/usr/bin/perl
use strict;
use warnings;

# This script demonstrates how to create a closure in Perl.
# A closure is a subroutine that captures the lexical variables from its surrounding scope.
# It allows the subroutine to maintain state between calls.
# This example creates a simple counter using a closure.
sub make_counter {
    my $count = 0;

    return sub {
        $count++;
        return $count;
    };
}

my $counter1 = make_counter();
print $counter1->();  # prints 1
print $counter1->();  # prints 2

my $counter2 = make_counter();
print $counter2->();  # prints 1 (separate state)
