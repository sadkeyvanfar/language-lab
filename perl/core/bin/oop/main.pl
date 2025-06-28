# main.pl
use strict;
use warnings;

use lib '.';        # Add current directory to @INC

use AnimalClass;  # Load the Animal class

my $a = AnimalClass->new("Generic animal");
$a->speak();        # Generic animal makes a sound.
