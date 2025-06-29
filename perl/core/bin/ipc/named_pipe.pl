# This script demonstrates how to create a named pipe (FIFO) for inter-process communication in Perl.
# It creates a FIFO, forks a child process that writes to the FIFO, and the parent process reads from it.
# The FIFO is created in the /tmp directory, and the script ensures that the FIFO exists before attempting to use it.
# The script uses the POSIX module to create the FIFO and handles reading and writing to it
#!/usr/bin/perl
use strict;
use warnings;

use POSIX qw(mkfifo);

my $fifo = "/tmp/myfifo";
mkfifo($fifo, 0600) unless -p $fifo;

if (fork() == 0) {
    open my $w, '>', $fifo;
    print $w "Data through FIFO\n";
    close $w;
    exit;
} else {
    open my $r, '<', $fifo;
    print "Parent read: " . <$r>;
    close $r;
    wait();
}
