
Program merge;

Type 
  lista = ^nodo1;
  gastos = Record
    monto: real;
    tipo: string;
  End;
  nodo1 = Record
    dato: gastos;
    sig: lista;
  End;
  familia = array[1..4] Of lista;
  arbol = ^nodo2;
  nodo2 = Record
    dato: gastos;
    HI: arbol;
    HD: arbol;
  End;

  // A
Procedure inicializarFamilia(Var v: familia);

Var 
  i: integer;
Begin
  For i:= 1 To 4 Do
    v[i] := Nil;
End;

Procedure agregarAtrasViejo(Var pri: lista; r: gastos);

Var 
  nuevo, aux: lista;
Begin
  new(nuevo);
  nuevo^.sig := Nil;
  nuevo^.dato := r;
  If (pri = Nil) Then
    pri := nuevo
  Else
    Begin
      aux := pri;
      While (aux^.sig<>Nil) Do
        aux := aux^.sig;
      aux^.sig := nuevo;
    End;
End;

Procedure generarRegistro(Var r: gastos);
Begin
  writeln('Indicar el tipo de gasto: ');
  readln(r.tipo);
  If (r.tipo<>'ZZ') Then
    Begin
      writeln('Indicar el monto del gasto');
      readln(r.monto);
    End;
End;

Procedure generarFamilia(Var v: familia);

Var 
  i: integer;
  r: gastos;
Begin
  For i:= 1 To 4 Do
    Begin
      generarRegistro(r);
      While (r.tipo<>'ZZ') Do
        Begin
          agregarAtrasViejo(v[i], r);
          generarRegistro(r);
        End;
    End;
End;

// B
Procedure imprimirVectorListas(v: familia);

Var 
  i: integer;
Begin
  For i:= 1 To 4 Do
    Begin
      writeln('--------El familiar numero ', i, ' tiene en su registro--------')
      ;
      While (v[i]<>Nil) Do
        Begin
          writeln('El tipo de gasto es: ', v[i]^.dato.tipo);
          writeln('Y su monto es: ', v[i]^.dato.monto:2:2);
          v[i] := v[i]^.sig;
        End;
      writeln('---------------------------------------------------------------')
      ;
    End;
End;

// C
Procedure minimo (Var todos: familia; Var nomM: String; Var monto: real);

Var 
  indiceMin,i: integer;

Begin
  nomM := 'ZZ';
  indiceMin := -1;
  For i:= 1 To 4 Do
    If (todos[i] <> Nil) Then
      If (todos[i]^.dato.tipo <= nomM) Then
        Begin
          indiceMin := i;
          nomM := todos[i]^.dato.tipo;
        End;
  If (indiceMin <> -1) Then
    Begin
      nomM := todos[indiceMin]^.dato.tipo;
      monto := todos[indiceMin]^.dato.monto;
      todos[indiceMin] := todos[indiceMin]^.sig;
    End;
End;

Procedure agregarAtrasNuevo(Var pri: lista; z: String; x: real);

Var 
  nuevo, aux: lista;
Begin
  new(nuevo);
  nuevo^.sig := Nil;
  nuevo^.dato.monto := x;
  nuevo^.dato.tipo := z;
  If (pri = Nil) Then
    pri := nuevo
  Else
    Begin
      aux := pri;
      While (aux^.sig<>Nil) Do
        aux := aux^.sig;
      aux^.sig := nuevo;
    End;
End;

Procedure merge(todos: familia; Var familiaCompleta:lista);

Var 
  min, actual: String;
  monto, montoTotal: real;
Begin
  familiaCompleta := Nil;
  minimo (todos, min, monto);
  While (min <> 'ZZ') Do
    Begin
      actual := min;
      montoTotal := 0;
      While ((min <> 'ZZ') And (min = actual) ) Do
        Begin
          montoTotal := montoTotal + monto;
          minimo (todos, min, monto);
          writeln(min);
        End;
      agregarAtrasNuevo(familiaCompleta, actual, montoTotal);
    End;
End;

Procedure imprimirLista(l: lista);
Begin
  While (l<>Nil) Do
    Begin
      writeln('El tipo de gasto es: ', l^.dato.tipo);
      writeln('Y su monto es: ', l^.dato.monto:2:2);
      l := l^.sig;
    End;
End;

// D
Procedure generarArbol(Var abb: arbol; r: gastos);
Begin
  If (abb = Nil) Then
    Begin
      new(abb);
      abb^.dato := r;
      abb^.HI := Nil;
      abb^.HD := Nil;
    End
  Else
    Begin
      If (r.monto <= abb^.dato.monto) Then
        generarArbol(abb^.HI, r)
      Else
        generarArbol(abb^.HD, r);
    End;
End;

Procedure generarABB(Var abb: arbol; l: lista);
Begin
  While (l<>Nil) Do
    Begin
      generarArbol(abb, l^.dato);
      l := l^.sig;
    End;
End;

Procedure minimoGasto(a: arbol);
Begin
  If (a^.HI = Nil) Then
    writeln('El tipo del minimo gasto en la familia fue: ', a^.dato.tipo)
  Else
    Begin
      minimoGasto(a^.HI);
    End;
End;

Var 
  todos: familia;
  familiaCompleta: lista;
  abb: arbol;
Begin
  abb := Nil;
  inicializarFamilia(todos);
  generarFamilia(todos);
  imprimirVectorListas(todos);
  merge(todos, familiaCompleta);
  imprimirLista(familiaCompleta);
  generarABB(abb, familiaCompleta);
  minimoGasto(abb);
End.
