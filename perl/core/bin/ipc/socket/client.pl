# this is a simple client that connects to a server using sockets in Perl.

use strict;
use warnings;
use IO::Socket::INET;

# Connect to localhost on port 5000
my $client = IO::Socket::INET->new(
    PeerHost => '127.0.0.1',
    PeerPort => 5000,
    Proto    => 'tcp'
) or die "Cannot connect to server: $!";

# Send a message
$client->send("Hello from client!");

# Receive response
my $response = "";
$client->recv($response, 1024);
print "Server replied: $response\n";

close($client);
