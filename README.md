# BIKE-SHOP PROJECT

## WorkFlow
Pasos para trabajar en un mismo repositorio con git.  

1. Clona el reposotrio  
`git clone <url>`  

2. Crea y cambiate a tu rama con  
`git switch -c <nombreDeTuRama>`  

3. Trabaja a gusto en tu rama, realiza commits con  
`git add .`  
`git commit`  
pushea a tu rama remota con  
`git push -u origin <nombreDeTuRama>`  
> Nota:  
Agrega el parametro `-u` solo en el primer push, en los demas ya no es necesario.

4. Por ultimo, solicita un **pull request** desde GitHub para fusionar tu rama de desarrollo  
a master, no aceptar el **pull request** tu mismo, el resto de integrantes deberan de dar el visto  
bueno a tu código antes de la fusión.
