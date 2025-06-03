unit Utils;

interface

function Greet(const Name: string): string;

implementation

function Greet(const Name: string): string;
begin
  Greet := 'Hello, ' + Name + '!';
end;

end.
