
Program Imp6;

Type 
  indice = -1..10;
  vector = array[1..10] Of integer;

Procedure cargarVector(Var v: vector; Var dL: integer);

Var 
  x: integer;
Begin
  writeln('Ingresar un numero: ');
  readln(x);
  While (x<>-1) and (dL<10) Do
    Begin
      dL := dL + 1;
      v[dL] := x;
      writeln('Ingresar un numero: ');
      readln(x);
    End;
End;

Procedure busquedaDicotomica(v: vector; ini, fin: indice; dato:integer; Var pos: indice);
Begin
  If (ini>fin) Then
    pos := -1
  Else
    Begin
      pos := (ini+fin) DIV 2;
      If (v[pos]<>dato) Then
        Begin
          If (dato<v[pos]) Then
            busquedaDicotomica(v, ini, pos-1, dato, pos)
          Else
            busquedaDicotomica(v, pos+1, fin, dato, pos);
        End;
    End;
End;

Var 
  v: vector;
  dL, dato: integer;
  pos: indice;
Begin
  dL := 0;
  cargarVector(v, dL);
  pos := 0;
  writeln('Ingrese el dato a buscar: ');
  readln(dato);
  busquedaDicotomica(v, 1, dL, dato, pos);
  writeln(pos);
End.
