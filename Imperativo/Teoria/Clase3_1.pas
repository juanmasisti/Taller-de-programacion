
Program merge;

Type 
  lista = ^nodo;
  nodo = Record
    dato: string;
    sig: lista;
  End;
  estantes = array[1..5] Of lista;

Procedure minimo (todos:estantes; Var nomM:String);

Var 
  indiceMin,i: integer;

Begin
  nomM := 'ZZZ';
  indiceMin := -1;
  For i:= 1 To 5 Do
    If (todos[i] <> Nil) Then
      If (todos[i]^.dato <= nomM) Then
        Begin
          indiceMin := i;
          nomM := todos[i]^.dato;
        End;
  If (indiceMin <> -1) Then
    Begin
      nomM := todos[indiceMin]^.dato;
      todos[indiceMin] := todos[indiceMin]^.sig;
    End;
End;

Procedure merge (todos:estantes; Var Enuevo:lista);
Var
  min: string;
Begin
  Enuevo := Nil;
  minimo (todos,min);
  While (min <> 'ZZZ') Do
    Begin
      // agregarAtras (Enuevo,min);
      minimo (todos,min);
    End;
End;

Var 
  todos: estantes;
  estanteNuevo: lista;
Begin
  // generarEstantes(todos);
  merge(todos, estanteNuevo);
End.
