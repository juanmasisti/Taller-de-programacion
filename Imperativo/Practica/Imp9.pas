
Program Imp9;

Type 
  str = string[20];
  arbol = ^nodo;
  nodo = Record
    dato: str;
    HI: arbol;
    HD: arbol;
  End;

Procedure cargarArbol(Var a: arbol; x: str);
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
  x: str;
Begin
  writeln('Ingresar un nombre para agregar: ');
  readln(x);
  While (x<>'ZZZ') Do
    Begin
      cargarArbol(a, x);
      writeln('Ingresar un nombre para agregar: ');
      readln(x);
    End;
End;

Function busquedaNombre(a: arbol; x: str): boolean;
Begin
  If (a = Nil) Then
    busquedaNombre := false
  Else
    Begin
      If (x=a^.dato) Then
        busquedaNombre := True
      Else
        If (x<a^.dato) Then
          busquedaNombre := busquedaNombre(a^.HI, x)
      Else
        busquedaNombre := busquedaNombre(a^.HD, x);
    End;
End;

Var 
  a: arbol;
  nombre: str;
Begin
  a := Nil;
  generarArbol(a);
  writeln('Ingresar un nombre para buscarlo: ');
  readln(nombre);
  writeln(busquedaNombre(a, nombre));
End.
