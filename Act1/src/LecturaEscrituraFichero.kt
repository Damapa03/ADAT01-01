import java.io.BufferedReader
import java.io.BufferedWriter
import java.nio.file.Files
import java.nio.file.Path

class LecturaEscrituraFichero(private val rutaFichero: Path){
    fun lectura() : Map<String, List<String>>{
        // Abrimos el flujo de lectura
        val br: BufferedReader = Files.newBufferedReader(rutaFichero)
        val diccionario: MutableMap<String, List<String>> = mutableMapOf()
        //
        br.use {
            it.forEachLine {
                line ->
                val lineSplit = line.split(";")
                diccionario[lineSplit[0]] = listOf(lineSplit[1], lineSplit[2],lineSplit[3], lineSplit[4], lineSplit[5])
                }
            return diccionario
        }

    }

    fun escritura(diccionario : Map<String, List<String>>){
        val fichero = Path.of("src/ficheros/MMM.csv")
        val bw: BufferedWriter = Files.newBufferedWriter(fichero)
        var aux = 0
        if (!Files.exists(fichero)){
            Files.createFile(fichero)
        }

        bw.use{
            diccionario.forEach { (clave, valor) ->
                bw.append("${clave}; ")
                if (aux == 0){
                    bw.append("${valor[1]}; ${valor[2]}; Media")
                    bw.newLine()
                    aux++
                }else {

                    val media = (valor[1].replace(".","").replace(",",".").toFloat() + valor[2].replace(".","").replace(",",".").toFloat())/2
                    bw.append("${valor[1]}; ${valor[1]}; $media ")
                    bw.newLine()
                }


            }

        }

    }

}