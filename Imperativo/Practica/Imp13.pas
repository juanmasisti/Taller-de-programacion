
Program Imp13;

Type 
  venta = Record
    asiento: integer;
    cod: longInt;
    dia: 1..7;
    monto: real;
  End;
  venta2 = Record
    cod: longInt;
    cantE: integer;
  End;
  lista = ^nodo;
  nodo = Record
    dato: venta;
    sig: lista;
  End;
  lista2 = ^nodo2;
  nodo2 = Record
    dato: venta2;
    sig: lista2;
  End;
  dias = array[1..7] Of lista;

  // A
Procedure inicializarVector(Var v: dias);

Var 
  i: integer;
Begin
  For i:= 1 To 7 Do
    v[i] := Nil;
End;

Procedure cargarRegistro(Var r: venta);
Begin
  writeln('Ingrese el codigo de la obra: ');
  readln(r.cod);
  If (r.cod <> 0) Then
    Begin
      writeln('Ingrese el dia de venta: ');
      readln(r.dia);
      writeln('Ingrese el asiento de la obra: ');
      readln(r.asiento);
      writeln('Ingrese el monto de la venta: ');
      readln(r.monto);
    End;
End;

Procedure insertarOrdenado(Var pri: lista; r: venta);

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

Procedure cargarVector(Var v: dias);

Var 
  r: venta;
Begin
  writeln('------------Ingresar una nueva venta------------');
  cargarRegistro(r);
  While (r.cod <> 0) Do
    Begin
      insertarOrdenado(v[r.dia], r);
      writeln('------------Ingresar una nueva venta------------');
      cargarRegistro(r);
    End;
End;

//B
Procedure agregarAtras(Var pri, fin: lista2; cant: integer; cod:longInt);

Var 
  nuevo: lista2;
Begin
  new(nuevo);
  nuevo^.sig := Nil;
  nuevo^.dato.cantE := cant;
  nuevo^.dato.cod := cod;
  If (pri = Nil) Then
    pri := nuevo
  Else
    fin^.sig := nuevo;
  fin := nuevo;
End;

Procedure min(Var v: dias; Var minD: venta);

Var 
  i, dia: integer;
Begin
  minD.cod := 99999999;
  dia := -1;
  For i:= 1 To 7 Do
    If (v[i] <> Nil) And (v[i]^.dato.cod < minD.cod) Then
      Begin
        minD := v[i]^.dato;
        dia := i;
      End;
  If (dia <> -1) Then
    v[dia] := v[dia]^.sig;
End;

Procedure merge(v: dias; Var pri: lista2);

Var 
  act: longInt;
  acum: integer;
  minD: venta;
  fin: lista2;
Begin
  pri := Nil;
  min(v, minD);
  While (minD.cod <> 99999999) Do
    Begin
      acum := 0;
      act := minD.cod;
      While (minD.cod <> 99999999) And (act = minD.cod) Do
        Begin
          acum := acum + 1;
          min(v, minD);
        End;
      agregarAtras(pri, fin, acum, act);
    End;
End;

// Testing
Procedure imprimirVector(v: dias);

Var 
  i: integer;
Begin
  For i:= 1 To 7 Do
    Begin
      writeln('------------Dia ', i, '------------');
      While (v[i] <> Nil) Do
        Begin
          writeln('Codigo de la obra: ', v[i]^.dato.cod);
          writeln('Monto de la venta: ', v[i]^.dato.monto:2:2);
          writeln('Asiento de la obra: ', v[i]^.dato.asiento);
          v[i] := v[i]^.sig;
        End;
    End;
End;

Procedure imprimirLista(l: lista2);

Begin
  writeln('------------Lista completa de entradas por Obra------------');
  While (l <> Nil) Do
    Begin
      writeln('Codigo de la obra: ', l^.dato.cod);
      writeln('Entradas vendidas: ', l^.dato.cantE);
      l := l^.sig;
    End;
End;

Var 
  pri: lista2;
  v: dias;
Begin
  inicializarVector(v);
  cargarVector(v);
  imprimirVector(v);
  merge(v, pri);
  imprimirLista(pri);
End.
