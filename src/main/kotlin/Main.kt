package org.example
import java.io.File


fun main(args: Array<String>) {
    when (args.size) {
        0 -> {
            println("Aucun argument. Saisissez du texte (tapez 'exit' pour quitter) :")
            while (true) {
                val input = readln()
                // turn the input to a list of words
                val words = input.split(" ")
                // print the words
                println("Liste des mots : $words")
                if (input.lowercase() == "exit") break
                println("Vous avez saisi : $input")
            }
        }
        1 -> {
            val fileName = args[0]
            if (!fileName.endsWith(".mamamia")) {
                println("Erreur : Le fichier doit avoir l'extension '.mylang'.")
                return
            }
            val file = File(fileName)
            val fileContent: String
            if (file.exists() && file.isFile) {
                println("Contenu du fichier $fileName :")
                fileContent = file.readText();
                println(file.readText())
                val wordsList = fileContent.split(" ")
                println("Liste des mots : $wordsList")
            } else {
                println("Erreur : le fichier $fileName n'existe pas ou n'est pas valide.")
            }
        }
        else -> {
            println("Usage :")
            println("  Aucun argument : Attendre les inputs utilisateur.")
            println("  Un argument : Chemin vers un fichier '.mylang' à lire et afficher.")
            println("  Plusieurs arguments : Affiche cette aide.")
        }
    }
}

