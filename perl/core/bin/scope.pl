#!/usr/bin/perl
use strict;
use warnings;

# Scoped Variable Declarations
# This script demonstrates variable scope in Perl.
# Variables declared with 'my' are lexically scoped, meaning they are only visible within the block they are defined in.
my $x = 10;
if ($x > 5) {
    my $y = 99;
    print "$x and $y\n";  # both are visible here
}
print "$x\n";     # OK
# print "$y\n";   # ERROR: $y is not visible outside block


# Variables declared with 'our' are package-scoped, meaning they are visible throughout the package.
# They can be accessed from anywhere in the package, including from other files that use the package.
package MyApp;
use strict;
use warnings;

our $version = "1.0";  # accessible as $MyApp::version

package main;
print $MyApp::version;  # works


# This script demonstrates the use of 'local' to temporarily change the value of a variable.
# 'local' creates a temporary value for the variable that is visible in the current block and any nested blocks.
# When the block ends, the original value is restored.
our $message = "Hello";

sub speak {
    print "$message\n";
}

sub shout {
    local $message = "HEY!";
    speak();  # prints "HEY!"
}

speak();  # prints "Hello"
shout();
speak();  # prints "Hello" again


# This script demonstrates the use of 'state' variables in Perl.
# 'state' variables retain their value between calls to the subroutine, but are not visible outside the subroutine.
# They are initialized only once, the first time the subroutine is called.
# This is useful for maintaining state without using global variables.
use feature 'state';
use strict;
use warnings;

sub counter {
    state $count = 0;
    $count++;
    print "Count: $count\n";
}

counter();  # Count: 1
counter();  # Count: 2
counter();  # Count: 3
