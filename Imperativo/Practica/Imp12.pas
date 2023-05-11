
Program Imp12;

Type 
  fecha = Record
    dia: 1..31;
    mes: 1..12;
    ano: integer;
  End;
  venta = Record
    fec: fecha;
    cod: longInt;
    suc: 0..4;
    cant: integer;
  End;
  venta2 = Record
    cod: longInt;
    cant: integer;
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
  sucursales = array[1..4] Of lista;

  // A
Procedure inicializarVector(Var v: sucursales);

Var 
  i: integer;
Begin
  For i:= 1 To 4 Do
    v[i] := Nil;
End;

Procedure cargarRegistro(Var r: venta);
Begin
  writeln('Ingrese la sucursal: ');
  readln(r.suc);
  If (r.suc <> 0) Then
    Begin
      writeln('Ingrese el codigo del producto: ');
      readln(r.cod);
      writeln('Ingrese la cantidad de productos: ');
      readln(r.cant);
      writeln('Ingrese la fecha de la venta: ');
      readln(r.fec.dia);
      readln(r.fec.mes);
      readln(r.fec.ano);
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

Procedure cargarVector(Var v: sucursales);

Var 
  r: venta;
Begin
  writeln('------------Ingresar una nueva sucursal------------');
  cargarRegistro(r);
  While (r.suc <> 0) Do
    Begin
      insertarOrdenado(v[r.suc], r);
      writeln('------------Ingresar una nueva sucursal------------');
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
  nuevo^.dato.cant := cant;
  nuevo^.dato.cod := cod;
  If (pri = Nil) Then
    pri := nuevo
  Else
    fin^.sig := nuevo;
  fin := nuevo;
End;

Procedure min(Var v: sucursales; Var minS: venta);

Var 
  i, suc: integer;
Begin
  minS.cod := 99999999;
  suc := -1;
  For i:= 1 To 4 Do
    If (v[i] <> Nil) And (v[i]^.dato.cod < minS.cod) Then
      Begin
        minS := v[i]^.dato;
        suc := i;
      End;
  If (suc <> -1) Then
    v[suc] := v[suc]^.sig;
End;

Procedure merge(v: sucursales; Var pri: lista2);

Var 
  act: longInt;
  acum: integer;
  minS: venta;
  fin: lista2;
Begin
  pri := Nil;
  min(v, minS);
  While (minS.cod <> 99999999) Do
    Begin
      acum := 0;
      act := minS.cod;
      While (minS.cod <> 99999999) And (act = minS.cod) Do
        Begin
          acum := acum + minS.cant;
          min(v, minS);
        End;
      agregarAtras(pri, fin, acum, act);
    End;
End;

// Testing
Procedure imprimirVector(v: sucursales);

Var 
  i: integer;
Begin
  For i:= 1 To 4 Do
    Begin
      writeln('------------Sucursales ', i, '------------');
      While (v[i] <> Nil) Do
        Begin
          writeln('Codigo del producto: ', v[i]^.dato.cod);
          writeln('Cantidad de productos: ', v[i]^.dato.cant);
          writeln('Fecha de la venta: ', v[i]^.dato.fec.dia, '/', v[i]^.dato.fec
                  .mes, '/', v[i]^.dato.fec.ano);
          v[i] := v[i]^.sig;
        End;
    End;
End;

Procedure imprimirLista(l: lista2);

Begin
  writeln('------------Lista completa de Productos Vendidos------------');
  While (l <> Nil) Do
    Begin
      writeln('Codigo del producto: ', l^.dato.cod);
      writeln('Cantidad de productos: ', l^.dato.cant);
      l := l^.sig;
    End;
End;

Var 
  pri: lista2;
  v: sucursales;
Begin
  inicializarVector(v);
  cargarVector(v);
  imprimirVector(v);
  merge(v, pri);
  imprimirLista(pri);
End.
