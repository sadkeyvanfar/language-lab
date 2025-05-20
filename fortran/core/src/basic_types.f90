! This program demonstrates the use of different data types in Fortran. 
! It declares a character variable, an integer variable, and a real variable.
! It assigns values to these variables and prints them to the console.
! The program uses the implicit none statement to ensure that all variables are explicitly declared.

program types
  implicit none

  ! Declare a character variable
  ! The length of the character variable is specified as 20
  ! This means it can hold a string of up to 19 characters plus the null terminator.
  character(len=20) :: name

  ! Declare an integer variable
  ! Integers are always signed
  ! The default integer size in memory isn’t defined by the Fortran standard and is
  ! system dependent. However, on most systems, the default integer size is 4 bytes.
  integer :: age

  ! Declare a real variable
  real :: height

  ! Assign values to the variables
  name = "John Doe"
  age = 30
  height = 5.9

  ! Print the values of the variables
  print *, "Name: ", name
  print *, "Age: ", age
  print *, "Height: ", height

end program types