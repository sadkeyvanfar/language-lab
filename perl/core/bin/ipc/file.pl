# This script demonstrates file-based inter-process communication (IPC) using locks in Perl.
# It creates a file, writes to it in the parent process, and reads from it in the child process.
# The parent uses an exclusive lock while writing, and the child uses a shared lock while reading.
# This ensures that the child reads the data only after the parent has finished writing.
# The script uses the `flock` function to manage file locks

#!/usr/bin/perl
use strict;
use warnings;
use Fcntl qw(:flock);

my $file = "ipc_shared.txt";
unlink $file if -e $file;  # Clean up before starting

my $pid = fork();

if (!defined $pid) {
    die "Fork failed: $!";
}

if ($pid == 0) {
    # 👶 Child process
    sleep 1;  # Give the parent time to write first
    open my $fh, '<', $file or die "Child can't open file: $!";
    flock($fh, LOCK_SH);  # Shared lock
    my @lines = <$fh>;
    close $fh;
    print "Child: Read from file:\n", @lines;
    exit(0);
} else {
    # 👨 Parent process
    open my $fh, '>', $file or die "Parent can't open file: $!";
    flock($fh, LOCK_EX);  # Exclusive lock
    print $fh "Hello from parent process PID $$\n";
    close $fh;
    wait();  # Wait for child to finish
    print "Parent: Done.\n";
}
