#!/usr/bin/perl
use strict;
use warnings;

# Declare an array of colors
my @colors = ("red", "green", "blue");

# Print the array
print "Colors: @colors\n";

# Access a single element (scalar context)
print "First color: $colors[0]\n";

# Get the number of elements
my $count = scalar @colors;
print "Number of colors: $count\n";

# Add a new element
push @colors, "yellow";
print "After adding yellow: @colors\n";

# Remove the last element
my $last = pop @colors;
print "Removed last color: $last\n";
print "Colors now: @colors\n";

# Iterate over the array
print "Iterating over colors:\n";
foreach my $color (@colors) {
    print "$color\n";
}
