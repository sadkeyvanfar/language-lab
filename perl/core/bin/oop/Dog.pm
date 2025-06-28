# Dog.pm
package Dog;

use strict;
use warnings;
use parent 'Animal';  # Inherit from Animal

# Override speak
sub speak {
    my $self = shift;
    print $self->{name} . " the " . $self->{species} . " says: Woof!\n";
}

# Add custom method
sub fetch {
    my $self = shift;
    print $self->{name} . " is fetching the stick!\n";
}

1;
