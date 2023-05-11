
Const 
  dimF = 250;

Type 
  cantCat = 1..20;
  empleado = Record
    nroLe: integer;
    DNI: integer;
    cat: cantCat;
    anoIng: integer;
  End;
  empleadoArray = Record
    nroLe: integer;
    DNI: integer;
  End;
  arbol = ^nodo;
  nodo = Record
    HI: arbol;
    HD: arbol;
    data: empleado;
  End;
  subArbol = array[1..dimF] Of empleado;

  //Testing
Procedure cargarArbol(Var a: arbol; x: empleado);
Begin
  If (a = Nil) Then
    Begin
      new(a);
      a^.data := x;
      a^.HI := Nil;
      a^.HD := Nil;
    End
  Else
    Begin
      If (x.nroLe<a^.data.nroLe)Then
        cargarArbol(a^.HI, x)
      Else
        cargarArbol(a^.HD, x);
    End;
End;

Procedure cargarRegistro(Var r: empleado);
Begin
  writeln('Numero de Legajo: ');
  readln(r.nroLe);
  If (r.nroLe <> -1) Then
    Begin
      writeln('DNI: ');
      readln(r.DNI);
      writeln('Categoria: ');
      readln(r.cat);
      writeln('Ano de ingreso: ');
      readln(r.anoIng);
    End;
End;

Procedure generarArbol(Var a: arbol);

Var 
  x: empleado;
Begin
  writeln('-----Nuevo Empleado-----');
  cargarRegistro(x);
  While (x.nroLe <> -1) Do
    Begin
      cargarArbol(a, x);
      writeln('-----Nuevo Empleado-----');
      cargarRegistro(x);
    End;
End;

Procedure imprimirArbol(a: arbol);
Begin
  If (a <> Nil) Then
    Begin
      writeln('Numero de legajo: ', a^.data.nroLe);
      writeln('Numero de DNI: ', a^.data.DNI);
      writeln('Numero de categoria: ', a^.data.cat);
      writeln('Numero de Ano de Ingreso: ', a^.data.anoIng);
      imprimirArbol(a^.HD);
      imprimirArbol(a^.HI);
    End;
End;

Procedure imprimirArreglo(v: subArbol; dimL: integer);

Var 
  i: integer;
Begin
  writeln('-----Vector-----');
  For i:= 1 To dimL Do
    Begin
      writeln('Numero de legajo: ', v[i].nroLe);
      writeln('Numero de DNI: ', v[i].DNI);
    End;
  writeln('----------------------------------------');
End;

//a
Procedure vectorSubArbol(a:arbol;Var v:subArbol;Var dimL:integer;legA:integer;
                         legB:integer;catNro:cantCat);

Begin
  If (a <> Nil)  Then
    Begin
      If (a^.data.nroLe>legB) Then
        vectorSubArbol(a^.HI, v, dimL, legA, legB, catNro)
      Else
        If (a^.data.nroLe<legA) Then
          vectorSubArbol(a^.HD, v, dimL, legA, legB, catNro)
      Else
        Begin
          If (a^.data.cat = catNro) And (dimL <= dimF) Then
            Begin
              dimL := dimL + 1;
              v[dimL].nroLe := a^.data.nroLe;
              v[dimL].DNI := a^.data.DNI;
            End;
          vectorSubArbol(a^.HI, v, dimL, legA, legB, catNro);
          vectorSubArbol(a^.HD, v, dimL, legA, legB, catNro);
        End;
    End;
End;

//b
Function promDNI(v: subArbol; i: integer; dimL: integer): real;
Begin
  If (i = 0) Then
    promDNI := promDNI(v, i + 1, dimL) / dimL
  Else
    If (i <= dimL) Then
      promDNI := promDNI(v, i + 1, dimL) + v[i].DNI
  Else
    promDNi := 0;
End;

Var 
  a: arbol;
  v: subArbol;
  i, dimL, legA, legB, catNro: integer;
Begin
  a := Nil;
  i := 0;
  dimL := 0;
  writeln('-----Nuevos Datos-----');
  generarArbol(a);
  writeln('-----Procesamiento-----');
  writeln('-----Arbol-----');
  imprimirArbol(a);
  writeln('----------------------------------------');
  writeln('Ingresar legajo techo: ');
  readln(legB);
  writeln('Ingresar legajo base: ');
  readln(legA);
  writeln('Ingresar categoria a tomar: ');
  readln(catNro);
  vectorSubArbol(a, v, dimL, legA, legB, catNro);
  imprimirArreglo(v, dimL);
  writeln('El promedio de DNI en el arreglo es: ', promDNI(v, i, dimL): 2: 2);
End.
