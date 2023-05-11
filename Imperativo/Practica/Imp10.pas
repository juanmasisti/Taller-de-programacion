
Program Imp10;

Type 
  str = string[20];
  alumno = Record
    legajo: LongInt;
    apellido: str;
    nombre: str;
    DNI: LongInt;
    anoIng: integer;
  End;
  arbol = ^nodo;
  nodo = Record
    dato: alumno;
    HI: arbol;
    HD: arbol;
  End;

  // A
Procedure cargarArbol(Var a: arbol; x: alumno);
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
      If (x.legajo<a^.dato.legajo)Then
        cargarArbol(a^.HI, x)
      Else
        cargarArbol(a^.HD, x);
    End;
End;

Procedure cargarRegistro(Var r: alumno);
Begin
  writeln('Ano de ingreso del alumno: ');
  readln(r.anoIng);
  If (r.anoIng>2010) Then
    Begin
      writeln('Legajo del alumno: ');
      readln(r.legajo);
      writeln('Apellido del alumno: ');
      readln(r.apellido);
      writeln('Nombre del alumno: ');
      readln(r.nombre);
      writeln('DNI del alumno: ');
      readln(r.DNI);
    End;
End;

Procedure generarArbol(Var a: arbol);

Var 
  x: alumno;
Begin
  writeln('Ingresar un alumno para agregar: ');
  cargarRegistro(x);
  While (x.anoIng>2010) Do
    Begin
      cargarArbol(a, x);
      writeln('Ingresar un alumno para agregar: ');
      cargarRegistro(x);
    End;
End;


//B
Procedure legajoM15853(a: arbol);
Begin
  If (a<>Nil) Then
    Begin
      If (a^.dato.legajo>=15853) Then
        legajoM15853(a^.HI)
      Else
        Begin
          writeln('Nombre: ', a^.dato.nombre);
          writeln('Apellido: ', a^.dato.apellido);
          legajoM15853(a^.HI);
          legajoM15853(a^.HD);
        End;
    End;
End;


//C
Procedure legajoComp1258y7692(a: arbol);
Begin
  If (a<>Nil) Then
    Begin
      If (a^.dato.legajo>=7692) Then
        legajoComp1258y7692(a^.HI)
      Else
        If (a^.dato.legajo<=1258) Then
          legajoComp1258y7692(a^.HD)
      Else
        Begin
          writeln('Nombre: ', a^.dato.nombre);
          writeln('Apellido: ', a^.dato.apellido);
          legajoComp1258y7692(a^.HI);
          legajoComp1258y7692(a^.HD);
        End;
    End;
End;

Var 
  a: arbol;
Begin
  a := Nil;
  generarArbol(a);
  writeln('Los alumnos con legajo menor a 15853 son: ');
  legajoM15853(a);
  writeln('Los alumnos con legajo comprendido entre 1258 y 7692 son: ');
  legajoComp1258y7692(a); 
End.
