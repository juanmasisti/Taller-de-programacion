
Program Imp11;

Type 
  pelicula = Record
    cod: longInt;
    gen: 1..8;
    punt: real;
  End;
  lista = ^nodo;
  nodo = Record
    dato: pelicula;
    sig: lista;
  End;
  peliculas = array[1..8] Of lista;

  // A
Procedure inicializarVector(Var v: peliculas);

Var 
  i: integer;
Begin
  For i:= 1 To 8 Do
    v[i] := Nil;
End;

Procedure cargarRegistro(Var r: pelicula);
Begin
  writeln('Ingrese el codigo de la pelicula: ');
  readln(r.cod);
  If (r.cod <> -1) Then
    Begin
      writeln('Ingrese el genero de la pelicula: ');
      readln(r.gen);
      writeln('Ingrese el puntaje promedio de la pelicula: ');
      readln(r.punt);
    End;
End;

Procedure insertarOrdenado(Var pri: lista; r: pelicula);

Var 
  nuevo, act, ant: lista;
Begin
  new(nuevo);
  nuevo^.dato := r;
  act := pri;
  ant := pri;
  While (act <> Nil) And (nuevo^.dato.cod>act^.dato.cod) Do
    Begin
      ant := act;
      act := act^.sig;
    End;
  If (pri = act) Then
    pri := nuevo
  Else
    ant^.sig := nuevo;
  nuevo^.sig := act;
End;

Procedure cargarVector(Var v: peliculas);

Var 
  r: pelicula;
Begin
  writeln('------------Ingresar una nueva pelicula------------');
  cargarRegistro(r);
  While (r.cod <> -1) Do
    Begin
      insertarOrdenado(v[r.gen], r);
      writeln('------------Ingresar una nueva pelicula------------');
      cargarRegistro(r);
    End;
End;

//B
Procedure agregarAtras(Var pri, fin: lista; minP: pelicula);

Var 
  nuevo: lista;
Begin
  new(nuevo);
  nuevo^.sig := Nil;
  nuevo^.dato := minP;
  If (pri = Nil) Then
    pri := nuevo
  Else
    fin^.sig := nuevo;
  fin := nuevo;
End;

Procedure min(Var v: peliculas; Var minP: pelicula);

Var 
  i, gen: integer;
Begin
  minP.cod := 99999999;
  gen := -1;
  For i:= 1 To 8 Do
    If (v[i] <> Nil) And (v[i]^.dato.cod < minP.cod) Then
      Begin
        minP := v[i]^.dato;
        gen := i;
      End;
  If (gen <> -1) Then
    v[gen] := v[gen]^.sig;
End;

Procedure merge(v: peliculas; Var pri: lista);

Var 
  minP: pelicula;
  fin: lista;
Begin
  pri := Nil;
  min(v, minP);
  While (minP.cod <> 99999999) Do
    Begin
      agregarAtras(pri, fin, minP);
      min(v, minP);
    End;
End;

// Testing

Procedure imprimirLista(l: lista);

Begin
  writeln('------------Lista completa de peliculas------------');
  While (l <> Nil) Do
    Begin
      writeln('Codigo de la pelicula: ', l^.dato.cod);
      writeln('Genero de la pelicula: ', l^.dato.gen);
      writeln('Puntaje de la pelicula: ', l^.dato.punt:2:2);
      l := l^.sig;
    End;
End;

Procedure imprimirVector(v: peliculas);

Var 
  i: integer;
Begin
  For i:= 1 To 8  Do
    Begin
      writeln('------------Peliculas del genero ', i, '------------');
      imprimirLista(v[i]);
    End;
End;

Var 
  pri: lista;
  v: peliculas;
Begin
  inicializarVector(v);
  cargarVector(v);
  imprimirVector(v);
  merge(v, pri);
  imprimirLista(pri);
End.
