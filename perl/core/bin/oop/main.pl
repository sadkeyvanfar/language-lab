# main.pl
use strict;
use warnings;

use lib '.';        # Add current directory to @INC

use Animal;  # Load the Animal class

my $a = Animal->new("Generic animal");
$a->speak();        # Generic animal makes a sound.

use Dog;     # Load the Dog class
# Create a Dog object
my $d = Dog->new("Buddy", "Dog");
$d->speak();   # Buddy the Dog says: Woof!
$d->fetch();   # Buddy is fetching the stick!
