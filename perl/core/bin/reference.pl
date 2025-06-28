#!/usr/bin/perl
use strict;
use warnings;

# This script demonstrates the use of references in Perl
# References allow you to create complex data structures like arrays of hashes, hashes of arrays, etc.
# References are scalar values that point to other data types
# You can create references to arrays, hashes, scalars, and even subroutines

print "=== Array Reference ===\n";
my @colors = ("red", "green", "blue");
my $aref = \@colors;            # Create reference
print "First color: $aref->[0]\n";  # Dereference

print "\n=== Hash Reference ===\n";
my %person = ( name => "Alice", age => 30 );
my $href = \%person;
print "$href->{name} is $href->{age} years old\n";

print "\n=== Scalar Reference ===\n";
my $x = 42;
my $sref = \$x;
print "Scalar value via ref: $$sref\n";

print "\n=== Subroutine Reference ===\n";
my $square = sub {
    my ($n) = @_;
    return $n * $n;
};
print "Square of 5: ", $square->(5), "\n";

print "\n=== Nested Structure (Array of Hashes) ===\n";
my @people = (
    { name => "Bob",   age => 25 },
    { name => "Carol", age => 28 },
);
foreach my $p (@people) {
    print "$p->{name} is $p->{age}\n";
}
