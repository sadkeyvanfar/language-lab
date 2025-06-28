#!/usr/bin/perl
use strict;
use warnings;

# This script demonstrates the use of subroutines in Perl
# Subroutines are reusable blocks of code that can be called with arguments like functions in other languages

sub greet {
    print "Hello!\n";
}
greet();  # Call the subroutine

# A subroutine with parameters
sub add {
    my ($a, $b) = @_;
    return $a + $b;
}
my $sum = add(5, 10);  # Call the subroutine with arguments
print "The sum is $sum\n";

# A recursive subroutine example
sub factorial {
    my ($n) = @_;
    return 1 if $n == 0;  # Base case
    return $n * factorial($n - 1);  # Recursive case
}
my $fact = factorial(5);  # Call the subroutine
print "The factorial of 5 is $fact\n";
