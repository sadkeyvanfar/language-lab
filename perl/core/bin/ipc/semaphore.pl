# Description: Example of using IPC::Semaphore in Perl to manage concurrent access to a resource.
# Here's a simple Perl example of using semaphores via the IPC::SysV and IPC::Semaphore modules.
# Semaphores are used to control access to shared resources in concurrent programs.

use strict;
use warnings;
use IPC::SysV qw(IPC_CREAT S_IRUSR S_IWUSR);
use IPC::Semaphore;

# Create a semaphore set with 1 semaphore
my $key = 1234;  # Unique key to identify semaphore
my $sem = IPC::Semaphore->new($key, 1, IPC_CREAT | S_IRUSR | S_IWUSR)
    or die "Cannot create semaphore: $!";

# Initialize semaphore to 1 (unlocked)
$sem->setval(0, 1);

# Fork to simulate concurrent access
my $pid = fork();

if (!defined $pid) {
    die "Fork failed: $!";
}
elsif ($pid == 0) {
    # Child process
    print "Child: Waiting for semaphore...\n";
    $sem->op(0, -1, 0);  # P operation: acquire lock (decrement)
    print "Child: Got semaphore, working...\n";
    sleep 5;
    print "Child: Done, releasing semaphore.\n";
    $sem->op(0, 1, 0);   # V operation: release lock (increment)
    exit;
}
else {
    # Parent process
    sleep 1;  # Ensure child tries to acquire first
    print "Parent: Waiting for semaphore...\n";
    $sem->op(0, -1, 0);  # P operation: acquire lock
    print "Parent: Got semaphore, working...\n";
    sleep 3;
    print "Parent: Done, releasing semaphore.\n";
    $sem->op(0, 1, 0);   # V operation: release lock
    wait;  # Wait for child to finish
}
