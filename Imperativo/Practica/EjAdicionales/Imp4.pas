
Const 
  dimF = 2018;

Type 
  str20 = string[20];
  auto = Record
    patente: longInt;
    anoFabri: 2010..2018;
    marca: str20;
    modelo: str20;
  End;
  arbol = ^nodo;
  nodo = Record
    HD: arbol;
    HI: arbol;
    dato: auto;
  End;
  autosAnoFabri = array[2010..dimF] Of arbol;

  //a
Procedure cargarArbol(Var a: arbol; x: auto);
Begin
  If (a = Nil) Then
    Begin
      new(a);
      a^.dato := x;
      a^.HI := Nil;
      a^.HD := Nil;
    End
  Else
    Begin
      If (x.patente<a^.dato.patente)Then
        cargarArbol(a^.HI, x)
      Else
        cargarArbol(a^.HD, x);
    End;
End;

Procedure cargarRegistro(Var r: auto);
Begin
  writeln('Ingresar patente: ');
  readln(r.patente);
  If (r.patente <> -1) Then
    Begin
      writeln('Ingresar ano de fabricacion: ');
      readln(r.anoFabri);
      writeln('Ingresar marca del auto: ');
      readln(r.marca);
      writeln('Ingresar modelo del auto: ');
      readln(r.modelo);
    End;
End;

Procedure generarArbol(Var a: arbol);

Var 
  x: auto;
Begin
  writeln('-----Nuevo Auto-----');
  cargarRegistro(x);
  While (x.patente <> -1) Do
    Begin
      cargarArbol(a, x);
      writeln('-----Nuevo Auto-----');
      cargarRegistro(x);
    End;
End;

//b
Procedure cantAutosMarca(a: arbol; marca: str20; Var cant: integer);
Begin
  If (a <> Nil) Then
    Begin
      If (a^.dato.marca = marca) Then
        cant := cant + 1;
      cantAutosMarca(a^.HD, marca, cant);
      cantAutosMarca(a^.HI, marca, cant);
    End;
End;

//c
Procedure inicializarVector(Var v: autosAnoFabri);

Var 
  i : integer;
Begin
  For i:= 2010 To 2018 Do
    v[i] := Nil;
End;

Procedure cargarVector(a: arbol; Var v: autosAnoFabri);
Begin
  If (a <> Nil) Then
    Begin
      cargarArbol(v[a^.dato.anoFabri], a^.dato);
      cargarVector(a^.HD, v);
      cargarVector(a^.HI, v);
    End;
End;

//d
Function anoFabriPatente(a: arbol; patente: longInt): longInt;
Begin
  If (a <> Nil) Then
    Begin
      If (a^.dato.patente < patente) Then
        anoFabriPatente := anoFabriPatente(a^.HD, patente)
      Else
        If (a^.dato.patente > patente) Then
          anoFabriPatente := anoFabriPatente(a^.HI, patente)
      Else
        Begin
          If (a^.dato.patente = patente) Then
            anoFabriPatente := a^.dato.anoFabri
          Else
            anoFabriPatente := anoFabriPatente(a^.HI, patente) + anoFabriPatente
                               (a^.HD, patente);
        End;
    End;
End;

// Testing
Procedure imprimirArbol(a: arbol);
Begin
  If (a <> Nil) Then
    Begin
      writeln('El ano de Fabricacion del auto es: ', a^.dato.anoFabri);
      writeln('La patente del auto es: ', a^.dato.patente);
      writeln('La marca del auto es: ', a^.dato.marca);
      writeln('El modelo del auto es: ', a^.dato.modelo);
      imprimirArbol(a^.HD);
      imprimirArbol(a^.HI);
    End;
End;
Procedure imprimirVector(v: autosAnoFabri);

Var 
  i : integer;
Begin
  For i:= 2010 To 2018 Do
    Begin
      imprimirArbol(v[i]);
    End;
End;

Var 
  a: arbol;
  v: autosAnoFabri;
  marca: str20;
  patente: longInt;
  cant: integer;
Begin
  a := Nil;
  cant := 0;
  writeln('-----Cargar Datos-----');
  generarArbol(a);
  writeln('-----Procesamiento de Datos-----');
  writeln('Arbol:');
  imprimirArbol(a);
  writeln('Ingresar la marca que buscar: ');
  readln(marca);
  cantAutosMarca(a, marca, cant);
  writeln('La cantidad de autos con tal marca es: ', cant);
  cargarVector(a, v);
  writeln('Vector');
  imprimirVector(v);
  writeln('Ingresar patente a buscar: ');
  readln(patente);
  writeln('El ano de Fabricacion de la patente: ', anoFabriPatente(a, patente));
End.
