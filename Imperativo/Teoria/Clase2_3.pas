
Program Clase2_2;

Type 
  arbol = ^nodo;

  nodo = Record
    dato: integer;
    HI: arbol;
    HD: arbol;
  End;

  // 1
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

// 2
Procedure imprimirPreOrden (a : arbol);
Begin
  If ( a<> Nil ) Then
    Begin
      writeln(a^.dato);
      imprimirPreOrden(a^.HI);
      imprimirPreOrden(a^.HD);
    End;
End;

//3
Procedure multiPor2 (a : arbol);
Begin
  If ( a<> Nil ) Then
    Begin
      a^.dato := a^.dato * 2;
      multiPor2(a^.HI);
      multiPor2(a^.HD);
    End;
End;

//4
Procedure maxArbol (a : arbol; Var x: integer);
Begin
  If ( a<> Nil ) Then
    Begin
      If (a^.dato>x) Then x := a^.dato;
      maxArbol(a^.HI, x);
      maxArbol(a^.HD, x);
    End;
End;

Procedure maxArbol2 (a : arbol; Var x: integer);
Begin
  If ( a<> Nil ) Then
    Begin
      x := a^.dato;
      maxArbol(a^.HD, x);
    End;
End;

Function maxArbol3(a:arbol): arbol;
Begin
  If (a=Nil)Then
    maxArbol3 := Nil
  Else
    Begin
      If (a^.HD<>Nil)Then
        maxArbol3 := maxArbol3(a^.HD)
      Else
        maxArbol3 := a;
    End;
End;


Var 
  abb: arbol;
  x, max: integer;
Begin
  abb := Nil;
  max := -1;
  read (x);
  While (x<>58) Do
    Begin
      crear(abb,x);
      read(x);
    End;
  imprimirPreOrden(abb);
  multiPor2(abb);
  imprimirPreOrden(abb);
  maxArbol(abb, max);
  writeln(max);
End.
