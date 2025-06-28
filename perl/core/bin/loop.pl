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

# next and last statements
print "\n=== Next and Last Statements ===\n";
for (my $i = 0; $i < 5; $i++) {
    if ($i == 2) {
        print "Skipping iteration $i\n";  # Skip the iteration when i is 2
        next;  # Skip to the next iteration, Like continue in C/Java.
    }
    if ($i == 4) {
        print "Breaking at iteration $i\n";  # Break the loop when i is 4
        last;  # Exit the loop, Like break in C/Java.
    }
    print "Iteration $i\n";  # Print the current iteration number
}

# redo statement
print "\n=== Redo Statement ===\n";
for (my $i = 0; $i < 5; $i++) {
    if ($i == 2) {
        print "Redoing iteration $i\n";  # Redo the iteration when i is 2
        redo;  # Redo the current iteration
    }
    print "Iteration $i\n";  # Print the current iteration number
}
