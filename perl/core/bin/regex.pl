#!/usr/bin/perl
use strict;
use warnings;

# This script demonstrates the use of regular expressions in Perl
# Regular expressions are used for pattern matching and manipulation of strings.
# Perl's regex engine is powerful and supports various features like capturing groups, global matching, and substitutions.

my $text = "My email is example\@domain.com and my backup is other\@mail.org";

print "== Simple match ==\n";
if ($text =~ /email/) {
    print "The word 'email' was found.\n";
}

print "\n== Extract with capture groups ==\n";
if ($text =~ /(\w+@\w+\.\w+)/) {
    my $first_email = $1;
    print "Extracted email: $first_email\n";
}

print "\n== Global match (all emails) ==\n";
my @emails = ($text =~ /(\w+@\w+\.\w+)/g);
foreach my $e (@emails) {
    print "Found: $e\n";
}

print "\n== Substitution ==\n";
my $censored = $text;
$censored =~ s/\w+@\w+\.\w+/[REDACTED]/g;
print "Censored: $censored\n";
