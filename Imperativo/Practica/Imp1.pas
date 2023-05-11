
Program Imp1;

Const 
  dimF = 300;

Type 
  oficina = Record
    cod: integer;
    DNI: LongInt;
    valor: integer;
  End;
  oficinas = array[1..dimF] Of oficina;

  //A
Procedure leerRegistro(Var R: oficina);

Begin
  writeln('Ingresar codigo de la oficina: ');
  readln(R.cod);
  If (R.cod<>-1) Then
    Begin
      writeln('Ingresar DNI del propietario: ');
      readln(R.DNI);
      writeln('Ingresar valor de la expensa: ');
      readln(R.valor);
    End;
End;

Procedure cargarVector(Var V: oficinas; Var dimL: integer);

Var 
  R: oficina;
Begin
  writeln('---------Nueva Oficina---------');
  leerRegistro(R);
  While (dimL<dimF) And (R.cod<>-1) Do
    Begin
      dimL := dimL + 1;
      V[dimL] := R;
      writeln('---------Nueva Oficina---------');
      leerRegistro(R);
    End;
End;

//B
Procedure ordenarPorSeleccion(Var V: oficinas; dimL: integer);

Var 
  pos, i, j: integer;
  item: oficina;
Begin
  For i:= 1 To dimL-1 Do
    Begin
      pos := i;
      For j:= i+1 To dimL Do
        If V[j].cod<V[pos].cod Then pos := j;
      item := v[pos];
      v[pos] := v[i];
      V[i] := item;
    End;
End;

//C
Procedure ordenarPorInsersion(Var V: oficinas; dimL: integer);

Var 
  i, j: integer;
  act: oficina;
Begin
  For i:= 2 To dimL Do
    Begin
      act := v[i];
      j := i-1;
      While (j>0) And (V[j].cod>act.cod) Do
        Begin
          V[j+1] := v[j];
          j := j-1;
        End;
      v[j+1] := act;
    End;
End;

Procedure imprimirArreglo(v: oficinas; dimL: integer);

Var 
  i: integer;
Begin
  writeln('----------------------------------------');
  For i:= 1 To dimL Do
    Begin
      writeln('Codigo de la oficina numero ', i, ':');
      writeln(v[i].cod);
      writeln('DNI del propietario de la oficina numero ', i, ':');
      writeln(v[i].DNI);
      writeln('Valor de las expensas de la oficina numero ', i, ':');
      writeln(v[i].valor);
    End;
  writeln('----------------------------------------');
End;

Var 
  Vec: oficinas;
  dimL: integer;
Begin
  cargarVector(Vec, dimL);
  ordenarPorSeleccion(Vec, dimL);
  ordenarPorInsersion(Vec, dimL);
  imprimirArreglo(Vec, dimL);
End.
