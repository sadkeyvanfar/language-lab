program do_loop
  implicit none

  integer :: i, num_time_steps = 100

  ! Loop over time steps
  do i = 1, num_time_steps
    print *, "Time step: ", i
  end do

end program do_loop