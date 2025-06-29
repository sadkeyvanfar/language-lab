#!/usr/bin/perl
use strict;
use warnings;

package Dog;
use Moo;

# This script demonstrates how to create a simple object-oriented Perl module using Moo.
# Moo is a minimalist object system for Perl 5 that provides most of the nice features of Moose, but without the heavy startup cost.

# Declare an attribute
has 'name' => (
    is  => 'rw',
    required => 1,
);

# Add method
sub speak {
    my $self = shift;
    print $self->name . " says Woof!\n";
}

# Package must return true
1;

package main;

my $dog = Dog->new(name => 'Buddy');
$dog->speak();  # Buddy says Woof!
