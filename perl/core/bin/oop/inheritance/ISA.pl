#!/usr/bin/perl
use strict;
use warnings;

# This script demonstrates Inheritance in Perl using ISA without 'use parent'.

package Animal;

sub new {
    my ($class, $name) = @_;
    my $self = { name => $name };
    bless $self, $class;  # bless turns hashref into object
    return $self;
}

package Dog;

our @ISA = qw(Animal);  # Inherit from Animal without 'use parent'

# Override speak
sub speak {
    my $self = shift;
    print $self->{name} . " the " . $self->{species} . " says: Woof!\n";
}

# Add custom method
sub fetch {
    my $self = shift;
    print $self->{name} . " is fetching the stick!\n";
}


# use Dog;     # Load the Dog class
# Create a Dog object
my $d = Dog->new("Buddy", "Dog");
$d->speak();   # Buddy the Dog says: Woof!
$d->fetch();   # Buddy is fetching the stick!
