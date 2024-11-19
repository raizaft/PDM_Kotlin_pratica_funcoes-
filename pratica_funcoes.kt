/*
//////////////////////////
Leia o escopo do main para entender o que deverá ser feito na atividade;
//////////////////////////
*/
val materiasENotas = mutableMapOf<String, MutableList<Double>>()

/**
 * Adiciona uma disciplina no dicionário mutável,
 * Recebe um array de notas (opcional)
 * Retorna true se conseguiu, false se não.
 */
fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
    return materiasENotas.put(materia, notas) != null
}

/**
 * Adiciona uma nota à lista de notas de uma determinada matéria;
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}

/**
 *Mostra na tela todas as notas presentes em uma matéria, no seguinte formato:
 * Materia: {nome da materia}
 * Nota 1: 5.4 \n
 * Nota 2: 7.8 \n
 * ...
 * Nota n: 10.0 \n
 * \n
 * Média:  {5.4 + 7.8 + ... + 10.0 / n} \n [TO DO <////////]
 * \n
 *
 * Caso não encontre a materia no map, mostre:
 * Materia {nome da materia} não encontrada \n
 *
 * Caso não seja possível mostar as notas, mostre:
 * Não foi possível mostrar as notas da matéria {nome da materia} \n
 */
fun mostrarNotas(materia:String){

    if(!materiasENotas.containsKey(materia)){
        println("Materia $materia não encontrada")
    }
    else{
        val listaNotas = materiasENotas[materia]

        if (listaNotas != null) {
            var cont = 1
            println("$materia:")
            for(nota:Double in listaNotas){
                println("Nota ${cont++}: $nota")
            }
            println("Média: ${calcularMedia(materia)}")
        }
        else{
            println("Não foi possível mostrar as notas da matéria ${materia}")
        }

        println()
    }
}

/* Retorna a média obtida a partir de uma lista de notas */
fun calcularMedia(materia: String): Double? {
    val notas = materiasENotas[materia]
    return if (notas != null && notas.isNotEmpty()) {
        val soma = notas.sum()
        soma / notas.size
    } else {
        println("Não há notas registradas para a matéria: $materia.")
        null
    }
}

/**
 * Adiciona várias notas de uma só vez em uma matéria
 * Retorne true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarVariasNotas(materia: String, vararg notas: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]
    return if (notasDaMateria != null) {
        notasDaMateria.addAll(notas.toList())
        true
    } else {
        false
    }
}

fun main() {
    // 1. Adicionar disciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição posicional
    adicionarDisciplina("Matemática", mutableListOf(7.0, 8.5, 9.0))

    // 2. Adicionar disciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição nomeada
    adicionarDisciplina(materia = "Física", notas = mutableListOf(6.0, 7.0))

    // 3. Adicionar disciplinas -> altere a função adicionarDisciplinas para que o parâmetro notas possua um valor padrão.
    // 4. Adicionar disciplinas -> adicione 1 disciplina ao map materiasENotas, sem atribuir valores a notas
    adicionarDisciplina("Biologia")

    // 5. Adicionar nota -> adicione 3 notas para as 3 disciplinas
    adicionarVariasNotas("Matemática", 10.0, 7.5, 9.0)
    adicionarVariasNotas("Física", 8.5, 4.5, 6.8)
    adicionarVariasNotas("Biologia", 7.5, 9.2, 10.0)

    // 6. Mostrar notas -> Mostre as notas das 3 disciplinas
    mostrarNotas("Matemática")
    mostrarNotas("Física")
    mostrarNotas("Biologia")

    // 7. Adicionar disciplina -> adicione mais 1 disciplina
    adicionarDisciplina("História")

    // 8. Adicionar várias notas -> implemente o método adicionarVariasNotas()
    // 9. Adicionar várias notas -> adicione 3 notas para a disciplina que você acabou de criar
    adicionarVariasNotas("História", 8.0, 9.0, 7.0)

    // 10. Mostrar notas -> mostre as notas da disciplina que você acabou de criar;
    mostrarNotas("História")

    // Bônus: calcular média -> Implemente a função calcularMedia()
    // 12. Calcular média -> calcule a média de 2 disciplinas
    calcularMedia("Física")
    calcularMedia("Matemática")

    // 13. Mostrar notas -> altere o mostrarNotas() para que ele mostre também a média das disciplinas
    mostrarNotas("Matemática")
    mostrarNotas("Física")
    mostrarNotas("História")
    mostrarNotas("Biologia")
}
