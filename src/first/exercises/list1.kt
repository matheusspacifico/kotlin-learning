package first.exercises

fun main() {
    val inputs: List<Int> = listOf(100, 5, 20, -5)
    for (n in inputs) {
        println(exercicio1(n))
    }
    println("========================")
}

fun exercicio1(qtdLivros: Int): String {
    if (qtdLivros < 0) return "Erro"

    val precoA: Double = (0.25 * qtdLivros) + 7.50
    val precoB: Double = (0.50 * qtdLivros) + 2.50

    if (precoA == precoB) return "Indiferente"
    if (precoA > precoB) return "Critério A"
    return "Critério B"
}