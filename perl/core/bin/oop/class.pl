#!/usr/bin/perl
use strict;
use warnings;

# this script demonstrates how to create a simple object-oriented Perl module as a class.
# It defines a class `Animal` with a constructor and a method.
# a class is a package in Perl that encapsulates data and behavior.
package Animal;

sub new {
    my ($class, $name) = @_;
    my $self = { name => $name }; # name is an attribute of the object
    # `bless` associates the hashref with the class, turning it into an object
    # `bless` is a built-in function that associates a reference (like a hashref) with a class
    # It allows the reference to be treated as an object of that class
    # The first argument is the reference to bless, and the second is the class name
    # `bless` returns the blessed reference, which is now an object of the class
    bless $self, $class;  # bless turns hashref into object
    return $self;
}

sub speak {
    my $self = shift;
    print $self->{name}, " makes a sound.\n";
}

my $a = Animal->new("Generic animal");
$a->speak();        # Generic animal makes a sound.
