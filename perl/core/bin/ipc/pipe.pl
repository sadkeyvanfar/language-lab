#!/usr/bin/perl
use strict;
use warnings;

# This script demonstrates how to create a pipe for inter-process communication in Perl.
# It creates a pipe, forks a child process, and sends messages from the parent to the child.
# The child reads the messages from the pipe and prints them.
# this is one directional communication from parent to child.

use IO::Handle;  # For autoflush

pipe(my $reader, my $writer) or die "Cannot create pipe: $!";
$writer->autoflush(1);  # Don't buffer the output

my $pid = fork();

if (!defined $pid) {
    die "Fork failed: $!";
}

if ($pid == 0) {
    # Child process
    close $writer;  # Close the write end in child
    while (my $line = <$reader>) {
        print "Child received: $line";
    }
    close $reader;
    exit;
} else {
    # Parent process
    close $reader;  # Close the read end in parent
    print $writer "Hello from parent!\n";
    print $writer "Another message.\n";
    close $writer;
    wait();  # Wait for child to finish
}
