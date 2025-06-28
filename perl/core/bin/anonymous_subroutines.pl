#!/usr/bin/perl
use strict;
use warnings;

# This script demonstrates the use of anonymous subroutines in Perl
# Anonymous subroutines are subroutines without a name, often used for callbacks or closures.
# They can be assigned to variables and passed around like any other data type.
my $hello = sub {
    print "Hi from anonymous sub!\n";
};

$hello->();  # Call it
