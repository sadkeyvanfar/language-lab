use strict;
use warnings;

# This script demonstrates how to create a child process using fork in Perl.
# It prints the process IDs of both the parent and child processes, and the child sleeps for 2 seconds before exiting.

my $pid = fork();

if (!defined $pid) {
    die "Fork failed: $!";
}

if ($pid == 0) {
    # Child process
    print "Child: My PID is $$\n";
    print "Child: Sleeping for 2 seconds...\n";
    sleep 2;
    print "Child: Done sleeping, exiting.\n";
    exit(0);
} else {
    # Parent process
    print "Parent: My PID is $$\n";
    print "Parent: Created child with PID $pid\n";
    wait();  # Wait for child to finish
    print "Parent: Child has finished.\n";
}
