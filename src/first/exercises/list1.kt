package first.exercises

import java.util.*
import kotlin.math.ceil

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
    println("========================")
    println(exercicio3(1600))
    println(exercicio3(1997))
    println(exercicio3(2000))
    println(exercicio3(2016))
    println(exercicio3(0))
    println("========================")
    println(exercicio4(10, 2, 5))
    println("========================")
    println(exercicio5(60, 150.00, 10.00, 65))
    println(exercicio5(10, 100.0, 5.0, 5))
    println("========================")
    println(exercicio6(4.0, 3.0, 3.0, 3.0))
    println(exercicio6(10.0, 2.0, 5.0, 7.0))
    println("========================")
    println(exercicio7(100.0, 1.50, 1.25, 50.0))
    println(exercicio7(100.0, 1.50, 1.25, 150.0))
    println(exercicio7(80.0, 2.00, 1.50, 100.0))
    println("========================")
    println(exercicio8(5, 3))
    println(exercicio8(3, 3))
    println("========================")
    val entrada1 = listOf(10, 20, 30, 80, -1)
    val entrada2 = listOf(25, 30, 45, -1)
    val entrada3 = listOf(80, 90, 100, 18, 17, -1)
    println(exercicio9(entrada1))
    println(exercicio9(entrada2))
    println(exercicio9(entrada3))
    println("========================")
    println(exercicio10(0, 3, 4, 2))
    println(exercicio10(0, 2, 5, 3))
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
    if (ladoA < 1 || ladoB < 1 || ladoC < 1) return "Erro"

    if ((ladoA + ladoB) < ladoC) return "Não forma triângulo"
    if ((ladoA + ladoC) < ladoB) return "Não forma triângulo"
    if ((ladoB + ladoC) < ladoA) return "Não forma triângulo"

    if (ladoA == ladoB && ladoB == ladoC) return "Equilátero"
    if (ladoA == ladoB) return "Isósceles"
    if (ladoA == ladoC) return "Isósceles"
    if (ladoB == ladoC) return "Isósceles"
    return "Escaleno"
}

fun exercicio3(ano: Int): String {
    if (ano <= 0) return "Erro"

    if (ano % 400 == 0) return "Ano bissexto"
    if (ano % 4 == 0 && ano % 100 != 0) return "Ano bissexto"

    return "Ano não bissexto"
}

fun exercicio4(n: Int, c: Int, m: Int): Int {
    if (c < 1 || m < 1) return 0

    var chocolates: Int = n / c
    var embalagens: Int = chocolates

    while (embalagens >= m) {
        val newChocolates = embalagens / m
        chocolates += newChocolates
        embalagens = (embalagens % m) + newChocolates
    }

    return chocolates
}

fun exercicio5(l: Int, m: Double, a: Double, v: Int): String {
    if (l < 1 || m < 1 || a < 1 || v < 1) return "0.00"

    var result = 0.00
    if (v > l) result = m + ((v - l) * a)

    return String.format(Locale.US, "%.2f", result)
}

fun exercicio6(l: Double, a: Double, c: Double, m: Double): String {
    if (l < 1 || a < 1 || c < 1 || m < 1) return "0.00 0.00"

    val area: Double = l * a
    val latas: Int = ceil(area / m).toInt()
    val preco: Double = latas * c

    return String.format(Locale.US, "%d %.2f", latas, preco)
}

fun exercicio7(x: Double, v1: Double, v2: Double, a: Double): String {
    if (x < 0 || v1 < 0 || v2 < 0 || a < 0) return "Erro"

    val preco: Double = if (a <= x) {
        a * v1
    } else {
        (x * v1) + ((a - x) * v2)
    }

    return String.format(Locale.US, "%.2f", preco)
}

fun exercicio8(n: Int, c: Int): Int {
    if (n < 1 || c < 1) return 0

    if (n == 1) return c
    if (c == 1) return c + exercicio8(n - 1, c)

    return c + exercicio8(n - 1, c -1)
}

fun exercicio9(input: List<Int>): String {
    val tamanho = input.size - 1
    if (tamanho <= 0) return "Erro"

    var somaIdades = 0
    var deMaior = 0
    var idosos = 0

    for (idade in input) {
        if (idade < 0) break
        if (idade >= 18) deMaior++
        if (idade > 75) idosos++
        somaIdades += idade
    }

    val media = somaIdades.toDouble() / tamanho
    val porcentagemIdoso = (idosos.toDouble() / tamanho) * 100

    return String.format(Locale.US, "%.2f %d %.2f%%", media, deMaior, porcentagemIdoso)
}

fun exercicio10(x1: Int, v1: Int, x2: Int, v2: Int): String {
    val deltaX: Int = x2 - x1
    val deltaV: Int = v1 - v2

    if (deltaV == 0) return "NÃO"
    if (deltaX % deltaV == 0 && deltaX / deltaV >= 0) return "SIM"

    return "NÃO"
}