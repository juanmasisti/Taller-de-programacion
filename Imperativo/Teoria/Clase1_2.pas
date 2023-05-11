
Program Clase1_2;

Const 
  dimF = 20;

Type 
  participante = Record
    cod: integer;
    edad: integer;
  End;
  arreglo = array[1..dimF] Of participante;
  lista = ^nodo;
  nodo = Record
    elem: participante;
    sig: lista;
  End;

Procedure cargarRegistro(Var r: participante);
Begin
  writeln('Ingrese el codigo del Participante: ');
  readln(r.cod);
  If (r.cod<>-1) Then
    Begin
      writeln('Ingrese la edad del Participante: ');
      readln(r.edad);
    End;
End;

Procedure cargarArreglo(Var v: arreglo; Var dimL: integer);

Var 
  R: participante;
Begin
  writeln('Ingrese un Participante:');
  cargarRegistro(R);
  While (dimL<dimF) And (R.cod<>-1) Do
    Begin
      dimL := dimL + 1;
      v[dimL] := R;
      writeln('Ingrese un Participante:');
      cargarRegistro(R);
    End;
End;

Procedure imprimirArreglo(v: arreglo; dimL: integer);

Var 
  i: integer;
Begin
  writeln('----------------------------------------');
  For i:= 1 To dimL Do
    Begin
      writeln('Codigo del participante numero ', i, ':');
      writeln(v[i].cod);
      writeln('Edad del participante numero ', i, ':');
      writeln(v[i].edad);
    End;
  writeln('----------------------------------------');
End;

Procedure ordenarArreglo(Var v: arreglo; dimL: integer);

Var 
  i, j, p: integer;
  item: participante;
Begin
  For i:= 1 To dimL-1 Do
    Begin
      p := i;
      For j:= i+1 To dimL Do
        If v[j].edad < v[p].edad Then p := j;
      item := v[p];
      v[p] := v[i];
      v[i] := item;
    End;
End;

Function busquedaArreglo(v: arreglo; x, dimL: integer): integer;

Var 
  i: integer;
Begin
  i := 1;
  While (i<=dimL) And (x <> v[i].edad) Do
    Begin
      i := i + 1;
    End;
  busquedaArreglo := i;
End;

Procedure eliminarArreglo(Var v: arreglo; x: integer; Var dimL: integer);
// Mal

Var 
  pos, i: integer;
Begin
  pos :=  busquedaArreglo(v, x, dimL);
  If (pos>0) And (pos<=dimL) Then
    Begin
      For i:= pos To dimL-1 Do
        v[i] := v[i+1];
      dimL := dimL - 1;
    End;
End;

Procedure agregarAdelante(Var pri: lista; r: participante);

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

Procedure crearLista(Var pri: lista; v: arreglo; dimL: integer);

Var 
  i: integer;
Begin
  writeln('----------------------------------------');
  For i:= 1 To dimL Do
    Begin
      agregarAdelante(pri, v[i]);
    End;
  writeln('----------------------------------------');
End;

Procedure  imprimirLista(pri: lista);
Begin
  While (pri<>Nil) Do
    Begin
      writeln(pri^.elem.edad);
      pri := pri^.sig;
    End;
End;

Var 
  v: arreglo;
  i, dimL: integer;
  pri: lista;
Begin
  dimL := 0;
  pri := Nil;
  cargarArreglo(v, dimL);
  imprimirArreglo(v, dimL);
  ordenarArreglo(v, dimL);
  imprimirArreglo(v, dimL);
  imprimirArreglo(v, dimL);
  crearLista(pri,v, dimL);
  imprimirLista(pri);
End.
