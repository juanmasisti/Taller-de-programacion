programa Ejercicio-2
procesos
  proceso procesarPapeles (ES papel: numero)
  variables 
    papeles: numero
  comenzar
    papeles:= 0
    mientras HayPapelEnLaEsquina
      tomarPapel 
      papel:= papel + 1
      papeles:= papeles + 1
    repetir papeles
      depositarPapel
  fin
  proceso procesarFlores(ES flor: numero)
  variables
    flores: numero
  comenzar 
    flores:= 0
    mientras HayFlorEnLaEsquina
      tomarFlor
      flor:= flor + 1
      flores:= flores + 1
    repetir flores  
      depositarFlor
        
  fin
  proceso realizarEscalon(E n: numero; ES papel: numero; ES flor:numero)
  comenzar
    repetir n
      procesarPapeles(papel)
      procesarFlores(flor)
      mover
    derecha  
    repetir n
      procesarPapeles(papel)
      procesarFlores(flor)
      mover
    repetir 3
      derecha  
    procesarPapeles(papel)
    procesarFlores(flor)
  fin
  proceso superaPapeles(E papel: numero; E flor: numero; ES cant:numero)
  variables 
    condicion: numero
  comenzar
    condicion := papel - flor
    si (condicion = 1)
      cant:= cant +1
  fin
areas
  ciudad1 : AreaC(5,5,35,35)
robots 
  robot tipo1
  variables
    papel: numero
    flor: numero
    n: numero
    cant:numero
  comenzar
    papel:=0
    flor:=0
    n:= 0
    cant:=0
    repetir 4
      n:=n+1 
      realizarEscalon(n, papel, flor)
      superaPapeles(papel,flor,cant)
      flor:= 0
      papel:= 0
    Informar(cant)
  fin
variables 
  robot1: tipo1
  robot2: tipo1
  robot3: tipo1
comenzar 
  AsignarArea(robot1,ciudad1)
  AsignarArea(robot2,ciudad1)
  AsignarArea(robot3,ciudad1)
  Iniciar(robot1, 12, 14)
  Iniciar(robot2, 17, 10)
  Iniciar(robot3, 22, 6)
fin




