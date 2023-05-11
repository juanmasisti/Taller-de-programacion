
Program Clase2_2;

Type 
  arbol = ^nodo;

  nodo = Record
    dato: integer;
    HI: arbol;
    HD: arbol;
  End;

Procedure crear (Var A:arbol; num:integer);
Begin
  If (A = Nil) Then
    Begin
      new(A);
      A^.dato := num;
      A^.HI := Nil;
      A^.HD := Nil;
    End
  Else
    If (num < A^.dato) Then crear(A^.HI,num)
  Else crear(A^.HD,num)
End;

// 1
Procedure preOrden (a : arbol; Var x: integer);
Begin
  If ( a<> Nil ) Then
    Begin
      x := x + a^.dato;
      preOrden (a^.HI, x);
      preOrden (a^.HD, x);
    End;
End;

//2
Function preOrden2 (a : arbol): integer;
Begin
  If ( a <> Nil ) Then
    Begin
      preOrden2 = a^.dato + preOrden2(a^.HI)+ preOrden2(a^.HD);
    End
  Else
    preOrden2 = 0;
End;

Var 
  abb: arbol;
  x, i: integer;
Begin
  abb := Nil;
  i := 0;
  read (x);
  While (x<>0) Do
    Begin
      crear(abb,x);
      read(x);
    End;
  writeln(preOrden2(abb, i));
  preorden(abb, i);
  writeln(i);
End.
