use strict;
use warnings;

# This script demonstrates how to handle signals in Perl.
# It sets up a signal handler for SIGINT (Ctrl+C) to gracefully exit the program.
$SIG{INT} = sub {
    print "Caught SIGINT, exiting gracefully...\n";
    exit;
};

print "Running... Press Ctrl+C to send SIGINT\n";
sleep(10);  # Try interrupting with Ctrl+C
