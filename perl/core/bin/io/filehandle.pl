#!/usr/bin/perl
use strict;
use warnings;

# This script demonstrates the use of filehandles in Perl
# Filehandles are used to read from and write to files, as well as to handle input
# Perl provides built-in filehandles like STDIN, STDOUT, and STDERR
# You can also create your own filehandles using the open function

# Open a file for reading
my $filename = 'input.txt';
open(my $fh, '<', $filename) or die "Could not open file '$filename ' $!";
print "Reading from file '$filename':\n";
while (my $line = <$fh>) {
    print $line;  # Print each line from the file
}
close($fh);  # Close the filehandle

# Open a file for writing
my $output_file = 'output.txt';
open(my $out_fh, '>', $output_file) or die "Could not open file '$output_file' $!";
print $out_fh "This is a test output.\n";
print $out_fh "Writing to a file using filehandles in Perl.\n";
close($out_fh);  # Close the output filehandle

# Open a file for appending
my $append_file = 'append.txt';
open(my $append_fh, '>>', $append_file) or die "Could not open file '$append_file' $!";
print $append_fh "Appending this line to the file.\n";
close($append_fh);  # Close the append filehandle

# Using filehandles with STDIN, STDOUT, and STDERR
print "Enter some input: ";
my $input = <STDIN>;  # Read input from the user
chomp($input);  # Remove the newline character
print "You entered: $input\n";  # Print the input to STDOUT
print STDERR "This is an error message printed to STDERR.\n";  # Print an error message
