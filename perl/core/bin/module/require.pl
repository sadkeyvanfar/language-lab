#!/usr/bin/perl
use strict;
use warnings;

# This script demonstrates how to use the `require` statement to load a module
# and how to manually import symbols from it.
# `require` is used to load a module at runtime, allowing you to use its functions
# without needing to declare it with `use` at the top of your script.

use lib 'lib';                    # Add lib dir to @INC so Perl can find My/Greeter.pm


require MyTools;
# say_hello();      #Error: not imported
MyTools::say_hello(); # Works

# OR manually import:
MyTools->import('say_hello');
say_hello();       # Now works
