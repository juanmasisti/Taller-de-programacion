
Program Clase1_1;

Const 
  dimF = 20;

Type 
  arreglo = array[1..dimF] Of integer;
  lista = ^nodo;
  nodo = Record
    elem: integer;
    sig: lista;
  End;

  // Punto 1
Procedure cargarArreglo(Var v: arreglo; Var dimL: integer);

Var 
  x: integer;
Begin
  writeln('Ingrese un numero:');
  readln(x);
  While (dimL<dimF) And (x<>0) Do
    Begin
      dimL := dimL + 1;
      v[dimL] := x;
      writeln('Ingrese un numero:');
      readln(x);
    End;
End;

//Punto 2
Procedure imprimirArreglo(v: arreglo; dimL: integer);

Var 
  i: integer;
Begin
  For i:= 1 To dimL Do
    writeln(v[i]);
End;

//Punto 3
Function busquedaArreglo(v: arreglo; x, dimL: integer): integer;

Var 
  i: integer;
Begin
  i := 1;
  While (i<=dimL) And (x <> v[i]) Do
    Begin
      i := i + 1;
    End;
  busquedaArreglo := i;
End;

Procedure eliminarArreglo(Var v: arreglo; x: integer; Var dimL: integer);

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

//Punto 4
Procedure agregarAdelante(Var pri: lista; x: integer);

Var 
  nuevo, aux: lista;
Begin
  new(nuevo);
  nuevo^.sig := Nil;
  nuevo^.elem := x;
  If (pri=Nil) Then pri := nuevo
  Else
    Begin
      aux := pri;
      While (aux^.sig<>Nil) Do
        aux := aux^.sig;
      aux^.sig := nuevo;
    End;
End;

Procedure crearLista(Var pri: lista);

Var 
  x: integer;
Begin
  randomize;
  x := random(16);
  While (x<>15) Do
    Begin
      agregarAdelante(pri, x);
      x := random(16);
    End;
End;

Procedure  imprimirLista(pri: lista);
Begin
  While (pri<>Nil) Do
    Begin
      writeln(pri^.elem);
      pri := pri^.sig;
    End;
End;

Var 
  v: arreglo;
  x, dimL: integer;
  pri: lista;
Begin
  dimL := 0;
  pri := Nil;
  cargarArreglo(v, dimL);
  imprimirArreglo(v, dimL);
  writeln('Ingresar un elemento para eliminar:');
  readln(x);
  eliminarArreglo(v, x, dimL);
  imprimirArreglo(v, dimL);
  crearLista(pri);
  imprimirLista(pri);
End.
