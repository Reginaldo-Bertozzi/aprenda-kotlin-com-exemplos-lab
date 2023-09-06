// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(var nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        if (!inscritos.contains(usuario) && conteudos.isNotEmpty()) {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado na formação $nome.")
        } else {
            println("Não foi possível matricular o usuário ${usuario.nome} na formação $nome.")
        }
    }
    
    fun listarInscritos() {
        println("Inscritos na formação $nome:")
        inscritos.forEachIndexed { index, usuario ->
            println("${index + 1}. ${usuario.nome}")
        }
    }
    
}
fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)

    val formacaoKotlin = Formacao("Formação Kotlin", listOf(conteudo1, conteudo2))

    formacaoKotlin.matricular(usuario1) // Deve ser bem-sucedido
    formacaoKotlin.matricular(usuario2) // Deve ser bem-sucedido

    formacaoKotlin.matricular(usuario1) // Não deve adicionar novamente

    val formacaoJava = Formacao("Formação Java", emptyList())

    formacaoJava.matricular(usuario1) // Não deve ser possível devido à falta de conteúdo

    formacaoKotlin.listarInscritos() // Deve listar os dois usuários inscritos

    formacaoJava.listarInscritos() // Não deve listar nenhum usuário

}

