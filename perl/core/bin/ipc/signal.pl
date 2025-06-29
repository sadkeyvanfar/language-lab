use strict;
use warnings;

$SIG{INT} = sub {
    print "Caught SIGINT, exiting gracefully...\n";
    exit;
};

print "Running... Press Ctrl+C to send SIGINT\n";
sleep(10);  # Try interrupting with Ctrl+C
