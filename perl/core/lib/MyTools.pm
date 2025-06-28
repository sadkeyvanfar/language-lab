package MyTools;

use strict;
use warnings;
use Exporter 'import';  # Import Exporter's `import` method

# This module exports functions to be used in other scripts.
# The `Exporter` module allows us to specify which symbols to export.
# its similar to encapsulation in OOP, where we control what is visible outside the module.
# For object-oriented modules, exporting is less common — you usually use methods via objects.
# However, for simple utility modules, exporting functions can be convenient.

# List of symbols (subs/vars) to export automatically
our @EXPORT = qw(say_hello);

# List of optional symbols that can be exported if requested
our @EXPORT_OK = qw(say_goodbye);

sub say_hello {
    print "Hello!\n";
}

sub say_goodbye {
    print "Goodbye!\n";
}

1;  # End of module, must return true
