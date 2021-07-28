class Controller : User("CPU",0), ICalculateWinner {
    private var scoreboard: MutableMap<String, Int> = mutableMapOf()
    private var playerList: MutableList<User> = arrayListOf()
    private val choice: Array<String> = arrayOf("batu", "gunting", "kertas")
    private val userInputTemp: MutableList<String> = arrayListOf()
    private val playerTemp: MutableList<String> = arrayListOf()

    fun menu() {
        userInputTemp.clear()
        playerTemp.clear()
        println("")
        println("")
        println("1) Game Suit")
        println("2) Hasil")
        println("")
        println("")

        val userMenuChoice: Int? = readLine()?.toInt()
        try {
            if (userMenuChoice is Int) {
                when (userMenuChoice) {
                    1 -> gameLogic()
                    2 -> calculatewinner()
                    else -> {
                        println("Please choose between 1-3")
                    }
                }
            }
        } catch (e: Exception) {
            println(e)
        }


    }

    private fun gameLogic(){

        println("Masukkan nama pemain 1 ")
        val playerName1: String = readLine().toString().lowercase()

        println("Masukkan nama pemain 2 ")
        val playerName2: String = readLine().toString().lowercase()
        if(scoreboard.containsKey(playerName1) && scoreboard.containsKey(playerName2)){
            val player1 = User(playerName1,scoreboard.getValue(playerName1))
            val player2 = User(playerName2,scoreboard.getValue(playerName2))
            playerList.add(player1)
            playerList.add(player2)
            playerTemp.add(player1.name)
            playerTemp.add(player2.name)
            println("Pesertanya adalah $playerName1 VS $playerName2")
            println("======================")
            println("Input (batu,gunting,kertas) $playerName1 : ")
            val playerChoice1: String = readLine().toString().lowercase()
            println("Input (batu,gunting,kertas) $playerName2 : ")
            val playerChoice2: String = readLine().toString().lowercase()
            if (choice.contains(playerChoice1) && choice.contains(playerChoice2)) {
                userInputTemp.add(playerChoice1)
                userInputTemp.add(playerChoice2)
                if (userInputTemp.size == 2) {
                    when {
                        ((userInputTemp[0] == "gunting" && userInputTemp[1] == "kertas")
                                || (userInputTemp[0] == "kertas" && userInputTemp[1] == "batu")
                                || (userInputTemp[0] == "batu" && userInputTemp[1] == "gunting")) -> {

                            player1.score += 1
                            scoreboard[player1.name] = scoreboard.getValue(player1.name)+1
                            println("${player1.name} WIN!")
                            menu()

                        }
                        ((userInputTemp[1] == "gunting" && userInputTemp[0] == "kertas")
                                || (userInputTemp[1] == "kertas" && userInputTemp[0] == "batu")
                                || (userInputTemp[1] == "batu" && userInputTemp[0] == "gunting")) -> {

                            player2.score += 1
                            scoreboard[player2.name] = scoreboard.getValue(player2.name)+1
                            println("${player2.name} WIN!")
                            menu()

                        }
                        else -> {
                            println("DRAW!")
                            menu()
                        }
                    }
                }
            } else {
                println("Available input = 'gunting','batu','kertas'")
                gameLogic()
            }
        }else {
            val player1 = User(playerName1, 0)
            val player2 = User(playerName2, 0)
            playerList.add(player1)
            playerList.add(player2)
            scoreboard[player1.name] = 0
            scoreboard[player2.name] = 0
            playerTemp.add(player1.name)
            playerTemp.add(player2.name)
            println("Pesertanya adalah $playerName1 VS $playerName2 ")
            println("======================")
            println("Input $playerName1 : ")
            val playerChoice1: String = readLine().toString().lowercase()
            println("Input $playerName2 : ")
            val playerChoice2: String = readLine().toString().lowercase()
            if (choice.contains(playerChoice1) && choice.contains(playerChoice2)) {
                userInputTemp.add(playerChoice1)
                userInputTemp.add(playerChoice2)
                if (userInputTemp.size == 2) {
                    when {
                        ((userInputTemp[0] == "gunting" && userInputTemp[1] == "kertas")
                                || (userInputTemp[0] == "kertas" && userInputTemp[1] == "batu")
                                || (userInputTemp[0] == "batu" && userInputTemp[1] == "gunting")) -> {

                            player1.score += 1
                            scoreboard[player1.name] = scoreboard.getValue(player1.name)+1
                            println("${player1.name} WIN!")
                            menu()

                        }
                        ((userInputTemp[1] == "gunting" && userInputTemp[0] == "kertas")
                                || (userInputTemp[1] == "kertas" && userInputTemp[0] == "batu")
                                || (userInputTemp[1] == "batu" && userInputTemp[0] == "gunting")) -> {

                            player2.score += 1
                            scoreboard[player2.name] = scoreboard.getValue(player2.name)+1
                            println("${player2.name} WIN!")
                            menu()

                        }
                        else -> {
                            println("DRAW!")
                            menu()
                        }
                    }
                }
            } else {
                println("Available input = 'gunting','batu','kertas'")
                gameLogic()
            }
        }

    }


    override fun calculatewinner() {
        println("")
        println("______ HASIL _______")
        println("")
        for (key in scoreboard.keys) {
            println("${key} = ${scoreboard[key]}")
        }
    }

}