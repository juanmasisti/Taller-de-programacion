
Program Imp3;

Const 
  dimF = 8;
  dimF2 = 30;

Type 
  prod = Record
    cod: integer;
    rubro: 1..dimF;
    precio: real;
  End;
  lista = ^nodo;
  nodo = Record
    elem: prod;
    sig: lista;
  End;
  libros = array[1..dimF] Of lista;
  librosRubro3 = array[1..dimF2] Of prod;

  //A

Procedure iniciarListas(Var v: libros);

Var 
  i: integer;
Begin
  For i:= 1 To dimF Do
    V[i] := Nil;
End;

Procedure cargarRegistro(Var r: prod);
Begin
  writeln('Ingrese el precio del libro: ');
  readln(r.precio);
  If (r.precio<>0) Then
    Begin
      writeln('Ingrese el codigo del libro: ');
      readln(r.cod);
      writeln('Ingrese el rubro del libro: ');
      readln(r.rubro); 
    End;
End;

Procedure insertarOrdenado(Var pri: lista; r: prod);

Var 
  nuevo, act, ant: lista;
Begin
  new(nuevo);
  nuevo^.sig := Nil;
  nuevo^.elem := r;
  act := pri;
  ant := pri;
  While (act<>Nil) And (nuevo^.elem.cod>act^.elem.cod) Do
    Begin
      ant := act;
      act := act^.sig;
    End;
  If (act=ant) Then
    pri := nuevo
  Else
    ant^.sig := nuevo;
  nuevo^.sig := act;
End;

Procedure cargarArreglo(Var v: libros);

Var 
  R: prod;
Begin
  randomize;
  writeln('----------------Ingrese una libro----------------');
  cargarRegistro(R);
  While (R.precio<>0) Do
    Begin
      insertarOrdenado(V[R.rubro], R);
      writeln('----------------Ingrese un libro----------------');
      cargarRegistro(R);
    End;
End;

//B
Procedure cargarArregrlo2(Var V2: librosRubro3; Var dimL2: integer; pri: lista);
Begin
  While (dimL2<dimF2) And (pri<>Nil) Do
    Begin
      dimL2 := dimL2 + 1;
      V2[dimL2] := pri^.elem;
      pri := pri^.sig;
    End;
End;

//C
Procedure ordenarPorInsersion(Var V2: librosRubro3; dimL2: integer);

Var 
  i, j: integer;
  act: prod;
Begin
  For i:= 2 To dimL2 Do
    Begin
      act := V2[i];
      j := i-1;
      While (j>0) And (V2[j].precio>act.precio) Do
        Begin
          V2[j+1] := V2[j];
          j := j-1;
        End;
      V2[j+1] := act;
    End;
End;


Procedure  imprimirLista(pri: lista);
Begin
  While (pri<>Nil) Do
    Begin
      writeln('Codigo del Libro:');
      writeln(pri^.elem.cod);
      writeln('Precio del libro:');
      writeln(pri^.elem.precio:2:2);
      pri := pri^.sig;
    End;
End;

Procedure imprimirArreglo(v: libros);

Var 
  i: integer;
Begin
  writeln('----------------------------------------');
  For i:= 1 To dimF Do
    Begin
      writeln('Rubro ', i,':');
      imprimirLista(v[i]);
    End;
  writeln('----------------------------------------');
End;

Procedure imprimirArreglo2(V2: librosRubro3; dimL2: integer);

Var 
  i: integer;
Begin
  writeln('----------------------------------------');
  For i:= 1 To dimL2 Do
    Begin
      writeln('Codigo del Libro:');
      writeln(V2[i].cod);
      writeln('Precio del libro:');
      writeln(V2[i].precio:2:2);
    End;
  writeln('----------------------------------------');
End;

Var 
  V: libros;
  V2: librosRubro3;
  dimL2: integer;
Begin
  dimL2:= 0;
  iniciarListas(V);
  cargarArreglo(V);
  imprimirArreglo(V);
  cargarArregrlo2(V2, dimL2, V[3]);
  ordenarPorInsersion(V2, dimL2);
  imprimirArreglo2(V2, dimL2);
End.
