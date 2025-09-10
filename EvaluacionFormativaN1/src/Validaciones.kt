
/**
 *
 * Parte 3: Implementación de Validación Asíncrona (Corrutinas)
 * 1. Modelado de Estados de Validación:
 * o Debes definir una sealed class llamada EstadoValidacion para representar los tres posibles resultados de la operación:
 * Validando, Valida y NoValida.
 * o Los estados Valida y NoValida deben ser capaces de contener datos adicionales (el detalle de la entrada o un mensaje de error).
 * 2. Creación de la Función Asíncrona:
 * o Debes crear una suspend fun llamada validarEntrada que acepte un id y la lista de entradas.
 * o La función debe simular un retraso de 2 segundos.
 * o Debe contener la lógica para buscar la entrada por su id y devolver el estado (Valida o NoValida) que corresponda.
 * 3. Ejecución y Manejo del Resultado:
 * o En la función main, debes llamar a validarEntrada desde un bloque runBlocking.
 * o Debes usar una expresión when para manejar todos los posibles estados devueltos por la función e imprimir un resultado
 * diferente para cada caso.
 *
 * */
import kotlinx.coroutines.delay

sealed class EstadosValidaciones(){
    object Validando :EstadosValidaciones()
    data class Valida(val entrada: Entrada): EstadosValidaciones()
    data class NoValida(val mensaje: String): EstadosValidaciones()
}

suspend fun validarEntrada(id: Int, lista: List<Entrada>): EstadosValidaciones {

    println("Validando entrada")
    delay(2000)

    val entradaEncontrada = lista.find { it.id == id }
    return if (entradaEncontrada != null) {
        EstadosValidaciones.Valida(entradaEncontrada)
    }else{
        EstadosValidaciones.NoValida("No se a encontrado el id: $id")
    }
}

