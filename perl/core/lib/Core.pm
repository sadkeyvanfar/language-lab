package Core;

use strict;
use warnings;
use Exporter 'import';

our @EXPORT_OK = ('greet');

sub greet {
    my $name = shift // 'World';
    return "$name";
}

1;
