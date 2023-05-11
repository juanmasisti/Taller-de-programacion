
Program Imp8;

Type 
  arbol = ^nodo;
  nodo = Record
    dato: integer;
    HI: arbol;
    HD: arbol;
  End;

  // A
Procedure cargarArbol(Var a: arbol; x: integer);
Begin
  If (a = Nil) Then
    Begin
      new(a);
      a^.dato := x;
      a^.HI := Nil;
      a^.HD := Nil;
    End
  Else
    Begin
      If (x<a^.dato)Then
        cargarArbol(a^.HI, x)
      Else
        cargarArbol(a^.HD, x);
    End;
End;

Procedure generarArbol(Var a: arbol);

Var 
  x: integer;
Begin
  writeln('Ingresar un numero para agregar: ');
  readln(x);
  While (x<>0) Do
    Begin
      cargarArbol(a, x);
      writeln('Ingresar un numero para agregar: ');
      readln(x);
    End;
End;

//B

//i
Function numeroMaximo(a: arbol): integer;
Begin
  If (a = Nil) Then
    numeroMaximo := -1
  Else
    Begin
      If (a^.HD= Nil) Then
        numeroMaximo := a^.dato
      Else
        numeroMaximo := numeroMaximo(a^.HD);
    End;
End;

//ii
Function numeroMinimo(a: arbol): integer;
Begin
  If (a = Nil) Then
    numeroMinimo := -1
  Else
    Begin
      If (a^.HI= Nil) Then
        numeroMinimo := a^.dato
      Else
        numeroMinimo := numeroMinimo(a^.HI);
    End;
End;

//iii
Procedure cantidadElementos(a: arbol; Var cantElem: integer);
Begin
  If (a<>Nil) Then
    Begin
      cantElem := cantElem + 1;
      cantidadElementos(a^.HD, cantElem);
      cantidadElementos(a^.HI, cantElem);
    End;
End;

//iv
Procedure ordenCreciente(a: arbol);
Begin
  If (a<>Nil) Then
    Begin
      ordenCreciente(a^.HI);
      writeln(a^.dato);
      ordenCreciente(a^.HD);
    End;
End;

//v
Procedure ordenDecreciente(a: arbol);
Begin
  If (a<>Nil) Then
    Begin
      ordenDecreciente(a^.HD);
      writeln(a^.dato);
      ordenDecreciente(a^.HI);
    End;
End;

Var 
  a: arbol;
  cantElem: integer;
Begin
  a := Nil;
  cantElem := 0;
  generarArbol(a);
  writeln('El numero maximo es ', numeroMaximo(a));
  writeln('El numero minimo es ', numeroMinimo(a));
  cantidadElementos(a, cantElem);
  writeln('La cantidad de elementos es ', cantElem);
  writeln('Los numeros en orden Creciente: ');
  ordenCreciente(a);
  writeln('Los numeros en orden Decreciente: ');
  ordenDecreciente(a);
End.
