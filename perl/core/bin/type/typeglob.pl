#!/usr/bin/perl
use strict;
use warnings;

# This script demonstrates the use of typeglobs in Perl.
# Typeglobs allow you to access all types of a symbol (scalar, array, hash, subroutine, etc.) using a single name.
# Typeglobs are often used in dynamic programming scenarios, such as when you want to pass around references to different types of data.
# Typeglobs give raw access to Perl's symbol table, which is powerful but dangerous if misused.
# They were more common in older Perl, before references and Exporter made safer alternatives.

our $foo = "scalar";
our @foo = ("a", "b", "c");
our %foo = (one => 1, two => 2);
our sub foo { return "I'm a subroutine"; }

# The typeglob *foo points to all of the above
print *foo{SCALAR}, "\n";  # Reference to $foo
print *foo{ARRAY},  "\n";  # Reference to @foo
print *foo{HASH},   "\n";  # Reference to %foo
print &foo(),       "\n";  # Call subroutine foo
