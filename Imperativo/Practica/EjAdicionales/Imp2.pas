
Const 
  dimF = 7;

Type 
  entrada = Record
    dia: 1..7;
    codObra: integer;
    asiento: integer;
    monto: real;
  End;
  entradaObra = Record
    codObra: integer;
    cantVendidas: integer;
  End;
  lista = ^nodo;
  nodo = Record
    dato: entrada;
    sig: lista;
  End;
  lista2 = ^nodo2;
  nodo2 = Record
    dato: entradaObra;
    sig: lista2;
  End;
  ventaDias = array[1..dimF] Of lista;

  //a
Procedure cargarRegistro(Var r: entrada);
Begin
  writeln('Ingresar codigo de la obra: ');
  readln(r.codObra);
  If (r.codObra <> 0) Then
    Begin
      writeln('Ingresar dia de la obra: ');
      readln(r.dia);
      writeln('Ingresar asiento de la obra: ');
      readln(r.asiento);
      writeln('Ingresar monto de la entrada: ');
      readln(r.monto);
    End;
End;

Procedure insertarOrdenado(Var pri: lista; r: entrada);

Var 
  act, ant, nuevo: lista;
Begin
  new(nuevo);
  nuevo^.dato := r;
  act := pri;
  ant := pri;
  While (act <> Nil) And (act^.dato.codObra > r.codObra) Do
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

Procedure inicializarVector(Var v: ventaDias);

Var 
  i: integer;
Begin
  For i:= 1 To dimF Do
    v[i] := Nil;
End;

Procedure cargarVector(Var v: ventaDias);

Var 
  r: entrada;
Begin
  writeln('-----Nueva entrada-----');
  cargarRegistro(r);
  While (r.codObra <> 0) Do
    Begin
      insertarOrdenado(v[r.dia], r);
      writeln('-----Nueva entrada-----');
      cargarRegistro(r);
    End;
End;

//b
Procedure agregarAtras(Var pri, fin: lista2; cant: integer; cod:integer);

Var 
  nuevo: lista2;
Begin
  new(nuevo);
  nuevo^.sig := Nil;
  nuevo^.dato.cantVendidas := cant;
  nuevo^.dato.codObra := cod;
  If (pri = Nil) Then
    pri := nuevo
  Else
    fin^.sig := nuevo;
  fin := nuevo;
End;

Procedure min(Var v: ventaDias; Var minD: entrada);

Var 
  i, dia: integer;
Begin
  minD.codObra := 9999;
  dia := -1;
  For i:= 1 To 7 Do
    If (v[i] <> Nil) And (v[i]^.dato.codObra < minD.codObra) Then
      Begin
        minD := v[i]^.dato;
        dia := i;
      End;
  If (dia <> -1) Then
    v[dia] := v[dia]^.sig;
End;

Procedure merge(v: ventaDias; Var pri: lista2);

Var 
  act: integer;
  acum: integer;
  minD: entrada;
  fin: lista2;
Begin
  pri := Nil;
  min(v, minD);
  While (minD.codObra <> 9999) Do
    Begin
      acum := 0;
      act := minD.codObra;
      While (minD.codObra <> 9999) And (act = minD.codObra) Do
        Begin
          acum := acum + 1;
          min(v, minD);
        End;
      agregarAtras(pri, fin, acum, act);
    End;
End;

//c
Procedure imprimirListaRecursivo(pri: lista2);
Begin
  If (pri <> Nil) Then
    Begin
      writeln('El codigo de la obra es: ', pri^.dato.codObra);
      writeln('La cantidad de entradas vendidas es: ', pri^.dato.cantVendidas);
      imprimirListaRecursivo(pri^.sig);
    End;
End;

//Testing

Procedure imprimirLista(pri: lista);
Begin
  While (pri <> Nil) Do
    Begin
      writeln('-----Nueva Entrada-----');
      writeln('El codigo de la obra es: ', pri^.dato.codObra);
      writeln('El dia de la obra es: ', pri^.dato.dia);
      writeln('El asiento de la obra es: ', pri^.dato.asiento);
      writeln('El monto de la entrada es: ', pri^.dato.monto);
      pri := pri^.sig;
    End;
End;

Procedure imprimirVector(v: ventaDias);

Var 
  i: integer;
Begin
  For i:= 1 To dimF Do
    Begin
      writeln('-----Nuevo dia-----');
      imprimirLista(v[i]);
    End;
End;

Var 
  pri: lista2;
  v: ventaDias;
Begin
  pri := Nil;
  writeln('-----Nuevos Datos-----');
  inicializarVector(v);
  cargarVector(v);
  writeln('-----Procesamiento-----');
  writeln('Imprimir vector: ');
  imprimirVector(v);
  merge(v, pri);
  writeln('Imprmir nueva lista:');
  imprimirListaRecursivo(pri);
End.
