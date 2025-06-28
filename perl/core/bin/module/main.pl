#!/usr/bin/perl
use strict;
use warnings;

use lib 'lib';                    # Add lib dir to @INC so Perl can find My/Greeter.pm
use Greeter_Module;             # Load the module (and its package)

my $msg = Greeter_Module::hello("Alice");
print "$msg\n";
