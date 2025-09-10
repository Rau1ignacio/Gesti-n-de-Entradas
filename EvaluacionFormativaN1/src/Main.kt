import kotlinx.coroutines.runBlocking
/**
 *➢ Caso de Negocio
 *      Actuarás como el desarrollador de un módulo principal para un sistema de gestión de eventos.
 *      Tu tarea es crear la lógica para modelar, analizar y validar las entradas vendidas
 */

fun main() = runBlocking{

    val entrada: List<Entrada> = listOf(
        EntradaGeneral(1,20000),
        EntradaVIP(2, 50000, "Bebidas gratis + baños exlusivos del VIP"),
        EntradaGeneral(3, 30000),
        EntradaVIP(4, 200000, "Fotos con el artista")
    )

    println("=== LISTADO DE ENTREDAS ===")
    entrada.forEach {println(it.mostrarDetalle())}

    // Calculo de cantidad recaudada de las entradas
    val ingresoTotal = entrada.sumOf { it.precio }
    println("\nIngresos totales: $ingresoTotal"
    )

    // Total de entradas vendidas
    val totalEntradas = entrada.count()
    println("Entradas totales: $totalEntradas")

    // Total de entradas VIP
    val totalEntradasVIP = entrada.count { it is EntradaVIP }
    print("Total de entradas VIP: $totalEntradasVIP")

    // Validación de una entrada por ID
    println("\n\nIngrese el ID de la entrada a validar:") // le puse 2 \n porque con una no me hacia el salto de linea
    val idEntrada = readLine()?.toIntOrNull() ?: -1

    val resultado = validarEntrada(idEntrada, entrada)

    // Manejo de estados con when
    when (resultado) {
        is EstadosValidaciones.Validando -> println("La entrada se está validando...")
        is EstadosValidaciones.Valida -> println("--- Entrada válida: ${resultado.entrada.mostrarDetalle()} ---")
        is EstadosValidaciones.NoValida -> println("--- ${resultado.mensaje} ---")
    }
}