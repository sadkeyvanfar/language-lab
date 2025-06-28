#!/usr/bin/perl
use 5.10.0;
use strict;
use warnings;

# This script demonstrates the use of conditional statements in Perl
# Conditional statements allow you to execute code based on certain conditions
# The main conditional statements in Perl are if, elsif, and else
# Perl do not have switch-case statements like some other languages, but you can use if-elsif-else for similar functionality
# given-when is a feature in Perl 5.10 and later that provides a switch-like syntax


my $input = 42;

if ($input > 100) {
    print "That's a big number!\n";
} elsif ($input > 50) {
    print "That's a medium number.\n";
} elsif ($input > 10) {
    print "That's a small number.\n";
} else {
    print "That's a tiny number.\n";
}


# Logical operators demo
print "\n== Logical Operator Example ==\n";
my $a = 5;
my $b = 10;

if ($a < 10 && $b > 5) {
    print "Both conditions are true.\n";
}

if ($a == 5 || $b == 3) {
    print "At least one condition is true.\n";
}

if (!($a > $b)) {
    print "Not greater: \$a is not greater than \$b.\n";
}

my $fruit = "apple";

given ($fruit) {
    when ("apple")  { say "It's an apple."; }
    when ("banana") { say "It's a banana."; }
    when ("orange") { say "It's an orange."; }
    default         { say "Unknown fruit."; }
}
