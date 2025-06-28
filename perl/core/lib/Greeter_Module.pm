# lib/Greeter_Module.pm

package Greeter_Module; # defines a namespace.

use strict;
use warnings;

sub hello {
    my ($name) = @_;
    return "Hello, $name!";
}

1;  # This must be true to indicate module loaded successfully
