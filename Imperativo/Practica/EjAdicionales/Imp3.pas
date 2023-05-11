
Const 
  dimF = 300;

Type 
  oficina = Record
    codI: integer;
    DNI: integer;
    valor: integer;
  End;
  oficinas = array[1..dimF] Of oficina;

  //a
Procedure cargarRegistro(Var r: oficina);
Begin
  writeln('Ingresar el codigo de Identificacion: ');
  readln(r.codI);
  If (r.codI <> -1) Then
    Begin
      writeln('Ingresar el DNI del propietario: ');
      readln(r.DNI);
      writeln('Ingresar el valor de la expensa: ');
      readln(r.valor);
    End;
End;

Procedure cargarVector(Var v: oficinas; Var dimL: integer);

Var 
  r: oficina;
Begin
  dimL := 0;
  writeln('-----Nueva Oficina-----');
  cargarRegistro(r);
  While (dimL < dimF) And (r.codI <> -1) Do
    Begin
      dimL := dimL + 1;
      v[dimL] := r;
      writeln('-----Nueva Oficina-----');
      cargarRegistro(r);
    End;
End;

//b
Procedure ordenarPorInsersion(Var V: oficinas; dimL: integer);

Var 
  i, j: integer;
  act: oficina;
Begin
  For i:= 2 To dimL Do
    Begin
      act := v[i];
      j := i-1;
      While (j>0) And (V[j].codI>act.codI) Do
        Begin
          V[j+1] := v[j];
          j := j-1;
        End;
      v[j+1] := act;
    End;
End;

//c
Procedure busquedaDicotomica(v: oficinas; dimL: integer; valor: integer; Var pos
                             : integer; Var encontro: boolean);

Var 
  pri, ult: integer;
Begin
  encontro := false;
  pri := 1;
  ult := dimL;
  pos := (pri+ult) Div 2;
  While (pri <= ult) And (valor <> v[pos].codI) Do
    Begin
      If (valor < v[pos].codI) Then
        ult := pos - 1
      Else
        pri := pos + 1;
      pos := (pri+ult) Div 2;
    End;
  If (pri <= ult) And (valor = v[pos].DNI) Then encontro := true;
End;

Var 
  v: oficinas;
  codI, dimL, pos: integer;
  encontro: boolean;
Begin
  writeln('-----Nuevos datos-----');
  cargarVector(v, dimL);
  writeln('-----Procesamiento de datos-----');
  ordenarPorInsersion(v, dimL);
  writeln('Ingresar codigo de oficina a buscar: ');
  readln(codI);
  busquedaDicotomica(v, dimL, codI, pos, encontro);
  If (encontro) Then
    writeln('El dni del propietario es: ', v[pos].DNI)
  Else
    writeln('El codigo ingresado no existe');
End.
