program TestUtils;

uses
  Utils,
  SysUtils;

procedure RunTests;
begin
  if Greet('Test') = 'Hello, Test!' then
  begin
    WriteLn('Test passed!');
    Halt(0);  // success exit code
  end
  else
  begin
    WriteLn('Test failed!');
    Halt(1);  // failure exit code
  end;
end;

begin
  RunTests;
end.
