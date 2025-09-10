/**
 *  Parte 1: Modelado del Sistema de Entradas (POO)
 * 1. Creación de la Clase Base:
 * o Debes definir una clase open llamada Entrada.
 * o Esta clase debe tener las propiedades básicas de cualquier entrada (ej. id, precio).
 * o Debe incluir un método open llamado mostrarDetalle() que describa la información general de la entrada.
 *
 * 2. Creación de las Clases Derivadas:
 * o Debes crear dos clases que hereden de Entrada: EntradaGeneral y EntradaVIP.
 * o La clase EntradaVIP debe incluir una propiedad adicional que no exista en la clase base (ej. beneficiosExtra).
 *
 * 3. Implementación de Polimorfismo:
 * o Ambas clases (EntradaGeneral y EntradaVIP) deben sobrescribir (override) el método mostrarDetalle().
 *
 * Subdirección de Diseño Instruccional
 * Subdirección de Evaluación de Resultados de Aprendizaje
 * 2025 3
 * o Cada implementación debe mostrar la información específica de ese tipo de entrada.
 */



open class Entrada(val id: Int, val precio: Int ){

    init {
        require(precio >= 0) {"No puede ser un valor negativo"}
    }
    open fun mostrarDetalle(): String = "$id - $$precio"

}

class EntradaGeneral(

    id: Int,
    precio: Int

) : Entrada(id, precio){
    override fun mostrarDetalle(): String {
        return super.mostrarDetalle() + "- Entrada General"
    }
}


class EntradaVIP(

    id: Int,
    precio: Int,
    val beneficiosExtra: String

): Entrada(id, precio){
    override fun mostrarDetalle(): String {
        return super.mostrarDetalle() + "- Entrada VIP - Beneficios Extra: $beneficiosExtra"
    }
}
