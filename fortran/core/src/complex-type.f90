! This program demonstrates the use of complex numbers in Fortran.
! It simulates the motion of a particle in 2D space.
! The particle's position and velocity are represented as complex numbers.
! Complex numbers are commonly used in simulations or physics problems to represent 2D vectors, such as position, velocity, or forces — where:
!    The real part is the X coordinate,
!    The imaginary part is the Y coordinate.
! This is elegant for things like rotations, wave equations, or signal processing.
! This Fortran program simulates and prints the 2D motion of a particle moving with constant velocity over time.

program particle_motion
  implicit none

  ! Declare a complex variable to hold the particle's position (x + y*i)
  complex :: position

  ! Declare a complex variable to represent the velocity (vx + vy*i)
  complex :: velocity

  ! Loop counter
  integer :: i

  ! Time step
  real :: dt

  ! ----------------------------
  ! Initialize position and velocity
  ! Position starts at (x=1.0, y=2.0)
  ! Velocity is (vx=0.5, vy=-0.2)
  ! Time step is 1.0 units
  ! ----------------------------
  position = (1.0, 2.0)
  velocity = (0.5, -0.2)
  dt = 1.0

  ! Print table header
  print *, "Time", "X", "Y"

  ! Simulate motion over 5 time steps
  do i = 0, 5
    ! Print current time, x (real part), and y (imaginary part) of position
    print "(I3, 2F8.3)", i, real(position), aimag(position)

    ! Update position using: position = position + velocity * dt
    ! position.real = position.real + velocity.real * dt
    ! position.imag = position.imag + velocity.imag * dt
    position = position + velocity * dt
  end do

end program particle_motion
