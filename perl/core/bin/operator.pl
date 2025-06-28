#!/usr/bin/perl
use strict;
use warnings;

# This script demonstrates various operators in Perl
# Operators are used to perform operations on variables and values.
# Perl supports arithmetic, assignment, comparison, string, and logical operators.

my $a = 10;
my $b = 3;

print "Arithmetic Operators:\n";
print "Addition: ", $a + $b, "\n";        # 13
print "Subtraction: ", $a - $b, "\n";     # 7
print "Multiplication: ", $a * $b, "\n";  # 30
print "Division: ", $a / $b, "\n";        # 3.3333
print "Modulo: ", $a % $b, "\n";          # 1
print "Exponentiation: ", $a ** $b, "\n"; # 1000

print "\nAssignment Operators:\n";
my $c = 5;
$c += 2;  # $c = $c + 2;
print "c after += 2: $c\n";

print "\nComparison Operators:\n";
print "$a == $b? ", ($a == $b ? "True" : "False"), "\n";  # False
print "$a != $b? ", ($a != $b ? "True" : "False"), "\n";  # True
print "$a < $b? ",  ($a < $b  ? "True" : "False"), "\n";  # False
print "$a > $b? ",  ($a > $b  ? "True" : "False"), "\n";  # True

print "\nString Operators:\n";
my $str1 = "Hello";
my $str2 = "World";
print "Concatenation: ", $str1 . " " . $str2, "\n";  # Hello World
print "Repeat: ", $str1 x 3, "\n";                   # HelloHelloHello

print "\nLogical Operators:\n";
if ($a > 5 && $b < 5) {
    print "Both conditions are true.\n";
}
if ($a == 10 || $b == 10) {
    print "At least one condition is true.\n";
}
if (!($a == $b)) {
    print "a is not equal to b.\n";
}
