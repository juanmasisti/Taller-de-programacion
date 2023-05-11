
Program Imp7;

Procedure numBinario(x: integer);
Begin
  If (x<>0) Then
    Begin
      numBinario(x Div 2);
      write(x Mod 2);
    End
End;

Procedure numBinarioHastaN(n: integer);

Var 
  x: integer;
Begin
  writeln('Ingresar el numero para pasarlo a binario: ');
  readln(x);
  While (x<>0) Do
    Begin
      numBinario(x);
      writeln(' ');
      writeln('Ingresar el numero para pasarlo a binario: ');
      readln(x);
    End;
End;

Begin
  numBinarioHastaN(0);
End.
