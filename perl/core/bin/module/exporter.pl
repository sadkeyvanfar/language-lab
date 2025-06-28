#!/usr/bin/perl
use strict;
use warnings;

use lib 'lib';                    # Add lib dir to @INC so Perl can find My/Greeter.pm
use MyTools;                      # Imports say_hello automatically

say_hello();       # OK
# say_goodbye();   # Error unless explicitly imported
