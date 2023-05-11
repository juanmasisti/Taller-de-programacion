
Program Imp2;

Const 
  dimF = 8;

Type 
  pel = Record
    cod: integer;
    genero: 1..dimF;
    puntaje: real;
  End;
  lista = ^nodo;
  nodo = Record
    elem: pel;
    sig: lista;
  End;
  peliculas = array[1..dimF] Of lista;
  puntajes = array[1..dimF] Of pel;

  //A
Procedure cargarRegistro(Var r: pel);
Begin
  writeln('Ingrese el codigo de la pelicula: ');
  read(r.cod);
  If (r.cod<>-1) Then
    Begin
      writeln('Ingrese el genero de la pelicula: ');
      read(r.genero);
      writeln('Ingrese el puntaje de la pelicula: ');
      read(r.puntaje);
    End;
End;

Procedure agregarAtras(Var pri: lista; r: pel);

Var 
  nuevo, aux: lista;
Begin
  new(nuevo);
  nuevo^.sig := Nil;
  nuevo^.elem := r;
  If (pri=Nil) Then pri := nuevo
  Else
    Begin
      aux := pri;
      While (aux^.sig<>Nil) Do
        aux := aux^.sig;
      aux^.sig := nuevo;
    End;
End;

Procedure cargarArreglo(Var v: peliculas);

Var 
  R: pel;
Begin
  randomize;
  writeln('----------------Ingrese una pelicula----------------');
  cargarRegistro(R);
  While (R.cod<>-1) Do
    Begin
      agregarAtras(V[R.genero], R);
      writeln('----------------Ingrese una pelicula----------------');
      cargarRegistro(R);
    End;
End;

Procedure iniciarListas(Var v: peliculas);

Var 
  i: integer;
Begin
  For i:= 1 To dimF Do
    V[i] := Nil;
End;

//B
Procedure mayorPuntaje(Var R: pel; pri: lista);

Var 
  maxPunt: real;
Begin
  maxPunt := -1;
  While (pri^.sig<>Nil) Do
    Begin
      If (pri^.elem.puntaje>maxPunt) Then
        Begin
          maxPunt := pri^.elem.puntaje;
          R := pri^.elem;
        End;
      pri := pri^.sig;
    End;
End;

Procedure generarVectorPuntaje(Var V2: puntajes; V: peliculas);

Var 
  i: integer;
  R: pel;
Begin
  For i:= 1 To dimF Do
    Begin
      mayorPuntaje(R, V[i]);
      V2[i] := R;
    End;
End;

//C
Procedure ordenarPorInsersion(Var V2: puntajes);

Var 
  i, j: integer;
  act: pel;
Begin
  For i:= 2 To 8 Do
    Begin
      act := V2[i];
      j := i-1;
      While (j>0) And (V2[j].puntaje>act.puntaje) Do
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
      writeln('Codigo de la pelicula:');
      writeln(pri^.elem.cod);
      writeln('Puntaje de la pelicula:');
      writeln(pri^.elem.puntaje:2:2);
      pri := pri^.sig;
    End;
End;

Procedure imprimirArreglo(v: peliculas);

Var 
  i: integer;
Begin
  writeln('----------------------------------------');
  For i:= 1 To dimF Do
    Begin
      writeln('Genero ', i,':');
      imprimirLista(v[i]);
    End;
  writeln('----------------------------------------');
End;

Var 
  V: peliculas;
  V2: puntajes;
Begin
  iniciarListas(V);
  cargarArreglo(V);
  imprimirArreglo(V);
  generarVectorPuntaje(V2, V);
  ordenarPorInsersion(V2);
End.
