#!/usr/bin/perl
use strict;
use warnings;

# This script demonstrates various scalar types in Perl.
# Scalar types in Perl can be integers, floating-point numbers, strings, booleans (via truthy/falsy values), and undefined values.
# Scalars may also hold references to arrays, hashes, subroutines, globs, filehandles, regular expressions, or other scalars.

# Numeric Scalars
# Perl supports both integers and floating-point numbers as scalar types.
my $integer = 42; # an integer
print "Integer: $integer\n";

my $float = 3.14; # a floating-point number
print "Float: $float\n";

# String Scalars
# Strings in Perl can be single-quoted or double-quoted. Single quotes do not interpolate variables, while double quotes do.
my $string = "Hello, World!"; # a string
print "String: $string\n";

# boolean Scalars
# Perl does not have a dedicated boolean type, but it uses truthy and falsy values.
# Any non-zero number or non-empty string is considered true, while zero and the empty string are considered false.
# However, Perl does have a special value `undef` which represents an undefined value.
my $boolean = 1; # a boolean (true)
print "Boolean: ", $boolean ? "true" : "false", "\n";


# References
# Perl allows scalars to hold references to other data types, such as arrays, hashes,
# subroutines, globs, filehandles, regular expressions, and typeglobs.
my $scalar_ref = \$integer; # a scalar reference

my $array_ref = [1, 2, 3]; # an array reference
print "Array: ", join(", ", @$array_ref), "\n";

my $hash_ref = { key1 => 'value1', key2 => 'value2' }; # a hash reference
print "Hash: ", join(", ", map { "$_ => $hash_ref->{$_}" } keys %$hash_ref), "\n";

my $code_ref = sub { return "This is a code reference"; }; # a code reference
print "Code Reference: ", $code_ref->(), "\n";

my $glob_ref = \*STDOUT; # a glob reference
print "Glob Reference: ", *$glob_ref{IO}, "\n";

my $regex_ref = qr/abc/; # a regular expression reference
print "Regex Reference: ", $regex_ref, "\n";

my $filehandle_ref = \*STDOUT; # a filehandle reference
print "Filehandle Reference: ", *$filehandle_ref{IO}, "\n";

my $package_ref = 'main'; # a package reference
print "Package Reference: $package_ref\n";

my $undef_ref; # an undefined reference
print "Undefined Reference: ", defined $undef_ref ? $undef_ref : "undef", "\n";
