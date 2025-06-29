#!/usr/bin/perl
use strict;
use warnings;
use lib '.';

# This script demonstrates Inheritance in Perl using the `use parent` pragma.

package Animal;

sub new {
    my ($class, $name) = @_;
    my $self = { name => $name };
    bless $self, $class;  # bless turns hashref into object
    return $self;
}

package Dog;

use parent 'Animal';  # Inherit from Animal

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
