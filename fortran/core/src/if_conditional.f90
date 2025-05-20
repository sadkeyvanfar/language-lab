! This program demonstrates the use of conditional statements in Fortran.
program conditional
  implicit none

  integer :: a = 5, b = 10, c = 15
  logical :: condition

  ! Check if a is less than b and c is greater than a
  ! Operators in Fortran:
  ! .lt.  : less than
  ! .gt.  : greater than
  ! .le.  : less than or equal to
  ! .ge.  : greater than or equal to
  ! .eq.  : equal to
  ! .ne.  : not equal to
  ! .and. : logical AND
  ! .or.  : logical OR
  ! .not. : logical NOT
  ! .neqv.: not equal (logical)
  ! .eqv. : equal (logical)
  condition = (a < b) .and. (c > a)

  ! Print the result of the condition
  if (condition) then
    print *, "Condition is true: a < b and c > a"
  else
    print *, "Condition is false: either a >= b or c <= a"
  end if

end program conditional