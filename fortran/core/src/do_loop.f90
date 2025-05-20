program do_loop
  implicit none

  integer :: i, num_time_steps = 100

  ! Loop over time steps
  label: do i = 1, num_time_steps
    print *, "Time step: ", i
  end do label

end program do_loop