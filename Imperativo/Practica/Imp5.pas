
Program Imp5;

Const 
  dF = 20;

Type 
  vector = array[1..dF] Of integer;

  //A
Procedure cargarVector(Var v: vector);

Var 
  i, x: integer;
Begin
  For i:= 1 To dF Do
    Begin
      writeln('Ingrese un numero: ');
      readln(x);
      v[i] := x;
    End;
End;

//B 
Procedure valorMaximo(v: vector; i: integer; Var max: integer);
Begin
  If (i<=dF) Then
    Begin
      valorMaximo(v, i+1, max);
      If (v[i]>max) Then
        max := v[i];
    End
  Else
    max := -1;
End;

Function MaxVR (V:vector; dimL: integer): integer;

Var 
  aux: integer;
Begin
  If (dimL > 0) Then
    Begin
      aux := MaxVR(V,dimL-1);
      If (V[dimL]> aux) Then
        MaxVR := V[dimL]
      Else
        MaxVR := aux;
    End
  Else
    MaxVR := -1;
End;

//C
Procedure sumaValores(v: vector; i: integer; Var sum: integer);
Begin
  If (i<=dF) Then
    Begin
      sumaValores(v, i+1, sum);
      sum := sum + v[i];
    End
  Else
    sum := 0;
End;

Var 
  v: vector;
  max, sum, i: integer;
Begin
  i := 1;
  cargarVector(v);
  valorMaximo(v, i, max);
  writeln(max);
  sumaValores(v, i, sum);
  writeln(sum);
End.
