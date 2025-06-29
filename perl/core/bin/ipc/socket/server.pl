# This script demonstrates a simple server using sockets in Perl.
# It listens for incoming connections on port 5000, accepts a connection,
# reads a message from the client, and sends a reply back to the client.

use strict;
use warnings;
use IO::Socket::INET;

# Create a listening socket on port 5000
my $server = IO::Socket::INET->new(
    LocalPort => 5000,
    Type      => SOCK_STREAM,
    Reuse     => 1,
    Listen    => 5
) or die "Couldn't start server: $!";

print "Server listening on port 5000...\n";

# Accept a connection
while (my $client = $server->accept()) {
    my $peer_address = $client->peerhost();
    my $peer_port    = $client->peerport();
    print "Accepted connection from $peer_address:$peer_port\n";

    # Read message
    my $data = "";
    $client->recv($data, 1024);
    print "Received: $data\n";

    # Send a reply
    $client->send("Message received: $data");

    close($client);
}
