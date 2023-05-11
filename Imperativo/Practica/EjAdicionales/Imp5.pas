
Const 
  dimF = 5;

Type 
  fechaR = Record
    dia: 1..31;
    mes: 1..12;
    ano: integer;
  End;
  cliente = Record
    codS: integer;
    cod: integer;
    DNI: longInt;
    fecha: fechaR;
    min: integer;
  End;
  cliente2 = Record
    DNI: integer;
    asentimiento: integer;
  End;
  lista = ^nodo;
  nodo = Record
    sig: lista;
    dato: cliente;
  End;
  sucursales = array[1..dimF] Of lista;
  arbol = ^nodo2;
  nodo2 = Record
    HD: arbol;
    HI: arbol;
    dato: cliente2;
  End;

  //a
Procedure cargarRegistro(Var r: cliente);
Begin
  writeln('Ingresar el codigo del cliente: ');
  readln(r.cod);
  If (r.cod <> -1) Then
    Begin
      writeln('Ingresar el codigo de sucursal: ');
      readln(r.codS);
      writeln('Ingresar el DNI del cliente: ');
      readln(r.DNI);
      writeln('Ingresar la fecha de asentimiento: ');
      writeln('Ingresar el dia de asentimiento: ');
      readln(r.fecha.dia);
      writeln('Ingresar el mes de asentimiento: ');
      readln(r.fecha.mes);
      writeln('Ingresar el ano de asentimiento: ');
      readln(r.fecha.ano);
      writeln('Ingresar los minutos de asentimiento: ');
      readln(r.min);
    End;
End;

Procedure insertarOrdenado(Var pri: lista; r: cliente);

Var 
  act, ant, nuevo: lista;
Begin
  new(nuevo);
  nuevo^.dato := r;
  act := pri;
  ant := pri;
  While (act <> Nil) And (act^.dato.cod > r.cod) Do
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

Procedure inicializarVector(Var v: sucursales);

Var 
  i: integer;
Begin
  For i:= 1 To dimF Do
    v[i] := Nil;
End;

Procedure cargarVector(Var v: sucursales);

Var 
  r: cliente;
Begin
  writeln('-----Nuevo cliente-----');
  cargarRegistro(r);
  While (r.cod <> -1) Do
    Begin
      insertarOrdenado(v[r.codS], r);
      writeln('-----Nuevo cliente-----');
      cargarRegistro(r);
    End;
End;

//b
Procedure cargarArbol(Var a: arbol; dni: integer; cant: integer);
Begin
  If (a = Nil) Then
    Begin
      new(a);
      a^.dato.asentimiento := cant;
      a^.dato.DNI := DNI;
      a^.HI := Nil;
      a^.HD := Nil;
    End
  Else
    Begin
      If (dni<a^.dato.DNI)Then
        cargarArbol(a^.HI, dni, cant)
      Else
        cargarArbol(a^.HD, dni, cant);
    End;
End;


Procedure min(Var v: sucursales; Var minD: cliente);

Var 
  i, dia: integer;
Begin
  minD.DNI := 9999;
  dia := -1;
  For i:= 1 To dimF Do
    If (v[i] <> Nil) And (v[i]^.dato.DNI < minD.DNI) Then
      Begin
        minD := v[i]^.dato;
        dia := i;
      End;
  If (dia <> -1) Then
    v[dia] := v[dia]^.sig;
End;

Procedure merge(v: sucursales; Var a: arbol);

Var 
  act: integer;
  acum: integer;
  minD: cliente;
Begin
  a := Nil;
  min(v, minD);
  While (minD.DNI <> 9999) Do
    Begin
      acum := 0;
      act := minD.DNI;
      While (minD.DNI <> 9999) And (act = minD.DNI) Do
        Begin
          acum := acum + 1;
          min(v, minD);
        End;
      cargarArbol(a, act, acum);
    End;
End;


//Testing
Procedure imprimirArbol(a: arbol);
Begin
  If (a <> Nil) Then
    Begin
      writeln('El dni del cliente es: ', a^.dato.DNI);
      writeln('La cantidad de asentimientos es: ', a^.dato.asentimiento);
      imprimirArbol(a^.HD);
      imprimirArbol(a^.HI);
    End;
End;

Procedure imprimirLista(pri: lista);
Begin
  While (pri <> Nil) Do
    Begin
      writeln('El codigo del cliente es: ', pri^.dato.cod);
      writeln('El DNI del cliente es: ', pri^.dato.DNI);
      writeln('La fecha de asentimiento es: ');
      writeln('Dia: ', pri^.dato.fecha.dia);
      writeln('Mes: ', pri^.dato.fecha.mes);
      writeln('Ano: ', pri^.dato.fecha.ano);
      writeln('Los minutos de asentimiento son: ', pri^.dato.min);
      pri := pri^.sig;
    End;
End;

Procedure imprimirVector(v: sucursales);

Var 
  i: integer;
Begin
  For i:= 1 To dimF Do
    Begin
      writeln('-----Nueva sucursal-----');
      imprimirLista(v[i]);
    End;
End;

Var 
  a: arbol;
  v: sucursales;
Begin
  a := Nil;
  writeln('-----Nuevos Datos-----');
  inicializarVector(v);
  cargarVector(v);
  writeln('-----Procesamiento-----');
  writeln('Vector: ');
  imprimirVector(v);
  merge(v, a);
  writeln('Arbol:');
  imprimirArbol(a);
End.
