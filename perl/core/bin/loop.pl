#!/usr/bin/perl
use strict;
use warnings;

# This script demonstrates the use of loops in Perl
# Loops allow you to execute a block of code multiple times
# Perl provides several types of loops: for, foreach, while, and until

# Using a for loop
print "=== For Loop ===\n";
for (my $i = 0; $i < 5; $i++) {
    print "Iteration $i\n";  # Print the current iteration number
}

# Using a foreach loop
print "\n=== Foreach Loop ===\n";
my @fruits = ("apple", "banana", "cherry");
foreach my $fruit (@fruits) {
    print "Fruit: $fruit\n";  # Print each fruit in the array
}

# Using a while loop
print "\n=== While Loop ===\n";
my $count = 0;
while ($count < 3) {
    print "Count is $count\n";  # Print the current count
    $count++;  # Increment the count
}

# Using an until loop
# opposite of while, it continues until the condition is true
print "\n=== Until Loop ===\n";
$count = 0;
until ($count >= 3) {
    print "Count is $count\n";  # Print the current count
    $count++;  # Increment the count
}

# do-while loop
print "\n=== Do-While Loop ===\n";
$count = 0;
do {
    print "Count is $count\n";  # Print the current count
    $count++;  # Increment the count
} while ($count < 2);  # Continue until count is less than 2
