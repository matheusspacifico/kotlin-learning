package first.exercises

fun main() {
    val inputsEx1: List<Int> = listOf(100, 5, 20, -5)
    for (n in inputsEx1) {
        println(exercicio1(n))
    }
    println("========================")
    println(exercicio2(2, 3, 2))
    println(exercicio2(2, 2, 2))
    println(exercicio2(1, 2, 4))
    println(exercicio2(-1, 2, 4))
}

fun exercicio1(qtdLivros: Int): String {
    if (qtdLivros < 0) return "Erro"

    val precoA: Double = (0.25 * qtdLivros) + 7.50
    val precoB: Double = (0.50 * qtdLivros) + 2.50

    if (precoA == precoB) return "Indiferente"
    if (precoA > precoB) return "Critério A"
    return "Critério B"
}

fun exercicio2(ladoA: Int, ladoB: Int, ladoC: Int): String {
    if (ladoA < 0 || ladoB < 0 || ladoC < 0) return "Erro"

    if ((ladoA + ladoB) < ladoC) return "Não forma triângulo"
    if ((ladoA + ladoC) < ladoB) return "Não forma triângulo"
    if ((ladoB + ladoC) < ladoA) return "Não forma triângulo"

    if (ladoA == ladoB && ladoB == ladoC) return "Equilátero"
    if (ladoA == ladoB) return "Isósceles"
    if (ladoA == ladoC) return "Isósceles"
    if (ladoB == ladoC) return "Isósceles"
    return "Escaleno"
}