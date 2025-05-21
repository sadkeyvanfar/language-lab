! This program demonstrates the use of different data types in Fortran.
! use column-major indexing,
! The Fortran standard allows up to 15 dimensions for arrays.

program array
  implicit none

  ! Declare an array of integers
  integer, dimension(5) :: arr ! short: integer, arr(5)
  integer :: i

  ! Initialize the array with values
  do i = 1, 5
    arr(i) = i * 10
  end do

  ! Print the array values
  print *, "Array values:"
  do i = 1, 5
    print *, arr(i)
  end do

end program array