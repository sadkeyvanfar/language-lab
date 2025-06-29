#!/usr/bin/perl
use strict;
use warnings;

# This script demonstrates inheritance and roles in Perl using Moo and Role::Tiny.
# It defines a base class `Animal`, a subclass `Dog`, and a role `Pet`.

### ---------- Role: Pet ----------
{
    package Pet;
    use Role::Tiny;

    sub play {
        my $self = shift;
        print $self->name . " is playing!\n";
    }
}

### ---------- Base Class: Animal ----------
{
    package Animal;
    use Moo;
    # type library for type checks
    use Types::Standard qw(Str Int);

    has 'name' => (
        is       => 'ro',
        isa      => Str(),
        required => 1,
    );

    has 'age' => (
        is  => 'rw',
        isa => Int(),
        default => sub { 0 },
    );

    sub speak {
        my $self = shift;
        print $self->name . " makes a sound.\n";
    }
}

### ---------- Subclass: Dog ----------
{
    package Dog;
    use Moo;
    extends 'Animal';
    with 'Pet';

    sub speak {
        my $self = shift;
        print $self->name . " says Woof!\n";
    }

    sub fetch {
        my $self = shift;
        print $self->name . " is fetching the stick!\n";
    }
}

### ---------- Main ----------
{
    package main;

    my $dog = Dog->new(name => 'Rex', age => 4);

    $dog->speak();     # Rex says Woof!
    $dog->fetch();     # Rex is fetching the stick!
    $dog->play();      # Rex is playing!
    print $dog->age . "\n";  # 4
}
