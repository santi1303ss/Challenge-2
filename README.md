# Challenge-2
### Welcome to my repo! :P 👋 
### Un conversor muy simpático con codigo hecho en java, espero le den amor ya que me costo mucho 
### hacerlo. &lt;3

👋Hola, mi nombre es Kevin Santiago! soy de colombia y me puedes decir Santi, bueno en esta 
oportunidad tuve la certeza de realizar un codigo bastante limpio de un conversor, el cual 
tenia como principio ser un conversor de divisas, pero que por motivos de creatividad se le 
adjuntaron otras funciones donde espero os guste, tambien y espero mi codigo te pueda ayudar 
entender el entorno tan bello de JAVA

## 📜 Funciones de conversión:
- Longitud ⏲
- Masa ⏳
- Capacidad 📦
- Temperatura 🌡
- Divisas 💱

> Alura: 
*Bueno principalmente quiero que sepan que soy estudiante de* ***Oracle Next Education***, *mi formacion es virtual por medio de una de las mejores plataformas de aprendizaje, esta es* ***ALura***, *es aqui donde parte este ejercicio el cual fue un verdadero reto ya que puso aprueba mi logica y para mi es una asaña porder traerles este codigo para ustedes, intente hacerlo lo mas completo desde el diseño compacto hasta un funcionamiento limpio.*

### Ejemplo de codigo
Me gustaria que antes de pasar  con el codigo entiendan como lo diseñe, para la construcion de este me base en Array que son una especie de listas donde una conserva el valor de la moneda y otro lo que vendria siendo el nombre o simbolo de la moneda, pero claro el siguiente sera un ejemplo semejante al codigo fuente del programa que he diseñado.

```java
<?java
  echo "# Definimos las tasas de cambio
tasa_colombia = 3600  # 1 dólar = 3600 pesos colombianos

# Definimos una lista de opciones para el usuario
opciones = ["Dólares a pesos colombianos", "Pesos colombianos a dólares"]

# Pedimos al usuario que seleccione una opción
print("Seleccione una opción:")
for i, opcion in enumerate(opciones):
    print(f"{i+1}. {opcion}")
opcion_seleccionada = int(input("Opción seleccionada: "))

# Pedimos al usuario que ingrese la cantidad a convertir
cantidad = float(input("Ingrese la cantidad a convertir: "))

# Convertimos la cantidad según la opción seleccionada
if opcion_seleccionada == 1:
    resultado = cantidad * tasa_colombia
    print(f"{cantidad:.2f} dólares son {resultado:.2f} pesos colombianos")
elif opcion_seleccionada == 2:
    resultado = cantidad / tasa_colombia
    print(f"{cantidad:.2f} pesos colombianos son {resultado:.2f} dólares")
else:
    print("Opción inválida")";
?>
```
*En este código, definimos la tasa de cambio entre dólares y pesos colombianos como una constante. Luego, presentamos al usuario una lista de opciones para seleccionar:* **convertir dólares a pesos colombianos o pesos colombianos a dólares**. *Una vez que el usuario selecciona una opción y proporciona la cantidad a convertir, realizamos la conversión según la fórmula correspondiente y mostramos el resultado al usuario.*

> Seguido de esto podrian entender la clase que convertira las divisas, la de temperatura es muy semejante y las longitudes pues si cambiara algo pero en si todo parten de unos array que conectaran con condicionales para establecer su valor correspondiente dependeinedo la unidad de medida.

## INSTALACION 
> INSTALACIÓN: para usar este proyecto es importante que lo descarges por medio de zip o lo clones por medio de tu repositorio local, si por algun motivo escoges la segunda opcion sigue los siguentes pasos:
 - En GitHub.com, navega a la página principal del repositorio. 1. Encima de la lista de archivos, haga clic en  Código.
 - Copia la dirección URL del repositorio.

Para clonar el repositorio con HTTPS, en «HTTPS» haz clic en .
Para clonar el repositorio mediante una clave SSH, incluido un certificado emitido por la entidad de certificación SSH de la organización, haga clic en Usar SSH y luego en .
Para clonar un repositorio mediante GitHub CLI, haz clic en GitHub CLI y, después, haz clic en .
- . Abra Git Bash.
- . Cambia el directorio de trabajo actual a la ubicación en donde quieres clonar el directorio. 
- . Escriba git clone y pegue la dirección URL que ha copiado antes. *https://github.com/santi1303ss/Challenge-2.git*
- . Presione **Entrar** para crear el clon local.
```
$ git clone https://github.com/santi1303ss/Challenge-2.git
Cloning into 'Challenge-2'...
remote: Enumerating objects: 37, done.
remote: Counting objects: 100% (37/37), done.
remote: Compressing objects: 100% (34/34), done.
remote: Total 37 (delta 5), reused 0 (delta 0), pack-reused 0
Receiving objects: 100% (37/37), 20.28 MiB | 2.49 MiB/s, done.
Resolving deltas: 100% (5/5), done.
```

Listo con esto ya lo tendra en tu disposicion y buena suerte en tu camino como programador recuerda que todo es una bendicion *SALUDOS*. 👋
