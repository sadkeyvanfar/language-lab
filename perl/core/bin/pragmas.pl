#!/usr/bin/perl
# This script demonstrates the use of pragmas in Perl
# Pragmas are special directives that affect the compilation or execution of Perl code
# Common pragmas include strict, warnings, and features

# The strict pragma helps catch common mistakes by requiring explicit variable declarations
# For example, if we try to use a variable without declaring it, Perl will throw an error
# Uncomment the line below to see the error
# my $undeclared_variable;  # This will cause an error if strict is enabled
use strict;  # Enforces strict variable declaration

# The warnings pragma enables warnings for potential issues in the code
# It helps catch common mistakes and provides helpful messages during development
# For example, if we use a variable that is not initialized, Perl will warn us
# Uncomment the line below to see the warning
# my $uninitialized_variable;  # This will cause a warning if warnings are enabled
use warnings;  # Enables warnings for potential issues

# The feature pragma allows us to enable specific features in Perl like say, state, and switch
use feature 'say';  # Enables the say function for printing with a newline
# The say function is like print but automatically adds a newline at the end
# It is a feature of Perl 5.10 and later, so we use the 'feature' pragma to enable it
# Example usage of say
say "Hello, World!";  # Prints "Hello, World!" with a newline

use utf8;  # Enables UTF-8 encoding for the script
# This allows us to use Unicode characters in our script
# For example, we can print a Unicode character like this:
say "Unicode character: \N{U+1F600}";  # Prints a grinning face emoji

# The experimental pragma allows us to use experimental features in Perl
# Experimental features are those that are not yet fully stable and may change in future versions
use experimental 'signatures';  # Enables experimental signatures for subroutines
# Signatures allow us to define subroutines with named parameters
sub add($x, $y) {  # Using signatures to define parameters
    return $x + $y;  # Returns the sum of x and y
}
say "Sum of 2 and 3 is: ", add(2, 3);
