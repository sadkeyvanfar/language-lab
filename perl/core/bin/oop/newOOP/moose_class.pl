#!/usr/bin/perl
use strict;
use warnings;

# This script demonstrates how to create a simple object-oriented Perl module using Moose.
# Moose is a modern object system for Perl that provides a powerful and flexible way to define classes, attributes, and methods.
package Dog;
use Moose;

has 'name' => (
    is  => 'rw',
    isa => 'Str',
);

sub speak {
    my $self = shift;
    print $self->name . " says Woof!\n";
}

# Always return true from packages
1;

package main;

my $dog = Dog->new(name => 'Buddy');
$dog->speak();  # Buddy says Woof!
