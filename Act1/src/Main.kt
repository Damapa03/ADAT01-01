import java.nio.file.Path

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val fichero = Path.of("src/ficheros/cotizacion.csv")
    val lectura = LecturaEscrituraFichero(fichero)

    lectura.escritura(lectura.lectura())

}