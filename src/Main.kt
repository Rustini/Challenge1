class Main {
    companion object : CallBack {

        @JvmStatic
        fun main(args: Array<String>) {
            //Inisialisasi pilihan
            val pilihan = arrayOf("gunting", "batu", "kertas")

            //Menangkap Pilihan Pemain
            println("Pilih Salah Satu Antara (Gunting, Batu, Kertas) ")
            print("Pemain 1 : ")
            var player1 = readLine()

            print("Pemain 2 : ")
            var player2 = readLine()

        }

        override fun calculateWinner(MainAbstract: String) {
            TODO("Not yet implemented")
        }

        override fun MainAbstract(MainAbstract: String) {
            TODO("Not yet implemented")
        }

        /*override fun calculateWinner(Result: String) {
            TODO("Not yet implemented")
        }*/

        override fun CallBack.MainAbstract(resultValue: kotlin.String) {
            println(message = "hasil nya adalah $resultValue")
        }


    }
}


