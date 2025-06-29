#!/usr/bin/perl
use strict;
use warnings;

package Dog;

# This package demonstrates how to create a class-like structure in Perl
# using closures to encapsulate state, similar to private attributes in other languages.
# The Dog class has a private attribute `$secret_name` that cannot be accessed directly from outside the class.
sub new {
    my ($class, $name) = @_;

    # Lexical variable — this is private!
    my $secret_name = $name;

    # Return an object (blessed closure)
    my $self = sub {
        my ($method, @args) = @_;

        return $secret_name if $method eq 'get_name';
        return "$secret_name says Woof!" if $method eq 'speak';
        return "$secret_name is fetching the stick!" if $method eq 'fetch';

        die "Unknown method: $method";
    };

    bless $self, $class;
    return $self;
}

# Class-style methods that delegate to the closure
sub get_name { $_[0]->('get_name') }
sub speak    { $_[0]->('speak') }
sub fetch    { $_[0]->('fetch') }

1;  # always end packages with true value

package main;

my $dog = Dog->new("Shadow");

print $dog->get_name(), "\n";  # Shadow
print $dog->speak(), "\n";     # Shadow says Woof!
print $dog->fetch(), "\n";     # Shadow is fetching the stick!

# You cannot access $secret_name from outside:
# print $dog->{name};  # This would crash
