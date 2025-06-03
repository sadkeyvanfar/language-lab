use strict;
use warnings;
use Test::More tests => 1;

use lib 'lib';
use Core qw(greet);

is(greet('Test'), 'Test', 'greet function works');
