
Program Imp4;

Type 
  lista = ^nodo;
  nodo = Record
    dato: integer;
    sig: lista;
  End;

  //A
Procedure agregarAdelante(Var pri: lista; x: integer);

Var 
  nuevo: lista;
Begin
  new(nuevo);
  nuevo^.dato := x;
  nuevo^.sig := pri;
  pri := nuevo;
End;

Procedure cargarLista(Var pri: lista);

Var 
  x: integer;
Begin
  writeln('Ingrese un numero: ');
  readln(x);
  While (x<>-1) Do
    Begin
      agregarAdelante(pri, x);
      writeln('Ingrese un numero: ');
      readln(x);
    End;
End;

//B
Procedure valorMinimo(l: lista; Var min: integer);
Begin
  If (l<>Nil) Then
    Begin
      valorMinimo(l^.sig, min);
      If (l^.dato<min) Then
        min := l^.dato;
    End
  Else
    min := 9999;
End;

//C
Procedure valorMaximo(l: lista; Var max: integer);
Begin
  If (l<>Nil) Then
    Begin
      valorMaximo(l^.sig, max);
      If (l^.dato>max) Then
        max := l^.dato;
    End
  Else
    max := -1;
End;

//D
Function estaLista(l: lista; x: integer): boolean;
Begin
  If (l=Nil) Then
    estaLista := False
  Else
    Begin
      If (x=l^.dato) Then
        estaLista := true
      Else
        estaLista := estaLista(l^.sig, x);
    End;
End;

Var 
  pri: lista;
  min, max, x: integer;
Begin
  pri := Nil;
  min := 9999;
  max := -1;
  cargarLista(pri);
  valorMinimo(pri, min);
  valorMaximo(pri, max);
  writeln(min);
  writeln(max);
  writeln('Ingresar un numero para buscar: ');
  readln(x);
  writeln(estaLista(pri, x));
End.
