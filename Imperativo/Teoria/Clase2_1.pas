
Program Clase2_1;

Type 
  lista = ^nodo;
  nodo = Record
    dato: integer;
    sig: lista;
  End;

  // 1

Procedure agregarAdelante(Var pri: lista; x: integer);

Var 
  nuevo, aux: lista;
Begin
  new(nuevo);
  nuevo^.dato := x;
  nuevo^.sig := pri;
  pri := nuevo;
End;

Procedure agregarAtras(Var pri: lista; x: integer);

Var 
  nuevo, aux: lista;
Begin
  new(nuevo);
  nuevo^.dato := x;
  nuevo^.sig := Nil;
  If (pri = Nil) Then
    pri := nuevo
  Else
    Begin
      aux := pri;
      While (aux^.sig <> Nil) Do
        aux := aux^.sig;
      aux^.sig := nuevo;
    End;
End;

Procedure imprimirRecursivo(pri: lista);
Begin
  If (pri <> Nil) Then
    Begin
      writeln(pri^.dato);
      pri := pri^.sig;
      imprimirRecursivo(pri);
    End;
End;

//2
Procedure imprimirNumero(x: integer);
Begin
  If (x > 0) Then
    Begin
      imprimirNumero(x Div 10);
      write(x Mod 10, ' ');
    End;
End;

Var 
  L: lista;
  i, x: integer;
Begin
  L := Nil;
  randomize;
  For i:= 1 To 7 Do
    agregarAdelante(L, random(100)+1);
  imprimirRecursivo(L);
  read(x);
  While (x<>0) Do
    Begin
      imprimirNumero(x);
      Read(x);
    End;
End.
