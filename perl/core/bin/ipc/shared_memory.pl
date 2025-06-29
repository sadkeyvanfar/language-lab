#!/usr/bin/perl

# This script demonstrates how to use shared memory for inter-process communication in Perl.
# It uses the IPC::ShareLite module to create a shared memory segment, store a value in it,
# and then fetch that value from the shared memory.

use strict;
use warnings;


use IPC::ShareLite;
my $share = IPC::ShareLite->new(
    -key     => 1234,
    -create  => 'yes',
    -destroy => 'no'
);

$share->store("Hello");
print $share->fetch;
