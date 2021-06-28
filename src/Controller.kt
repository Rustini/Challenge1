val Null: String? = null
val Result: String? = Null


class Controller(private val callBack: CallBack) {
    var gameSuit = listOf("Batu", "Gunting", "Kertas")

    fun calculateWinner(player1: Int, player2: Int) {
        when {
            ((gameSuit[player1] == "Batu" && gameSuit[player2] == "Gunting") ||
                    (gameSuit[player1] == "Kertas" && gameSuit[player2] == "Batu") ||
                    (gameSuit[player1] == "Gunting" && gameSuit[player2] == "Kertas")) -> {
                MainAbstract.PEMAIN_1_MENANG
            }
            ((gameSuit[player1] == "Batu" && gameSuit[player2] == "Kertas") ||
                    (gameSuit[player1] == "Kertas" && gameSuit[player2] == "Gunting") ||
                    (gameSuit[player1] == "Gunting" && gameSuit[player2] == "Batu")) -> {
                MainAbstract.PEMAIN_2_MENANG
            }
            else -> {
                MainAbstract.DRAW

            }
        }
    }
}