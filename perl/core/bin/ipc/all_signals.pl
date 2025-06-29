use strict;
use warnings;

# This script prints the names of all signals available in Perl.
# It uses the %Config hash to access the signal names defined in the Perl configuration.
# its platform-specific, so it may not work on all systems.

use Config;
print join("\n", split(/\s+/, $Config{sig_name})), "\n";
