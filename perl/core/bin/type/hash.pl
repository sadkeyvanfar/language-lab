#!/usr/bin/perl
use strict;
use warnings;

# Declare a hash of user ages
my %ages = (
    "Alice" => 30,
    "Bob"   => 25,
    "Carol" => 28,
);

# Access a value by key
print "Alice is $ages{'Alice'} years old\n";

# Add a new key-value pair
$ages{'David'} = 35;

# Check if a key exists
if (exists $ages{'Bob'}) {
    print "Bob is in the hash\n";
}

# Delete a key
delete $ages{'Carol'};

# Print all keys and values
print "All users and their ages:\n";
foreach my $name (keys %ages) {
    print "$name => $ages{$name}\n";
}
