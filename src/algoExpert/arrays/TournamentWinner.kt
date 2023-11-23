package algoExpert.arrays

object TournamentWinner {

    @JvmStatic
    fun main(arg: Array<String>) {
        val competitions = listOf(
            listOf("Bulls", "Eagles"),
            listOf("Bulls", "Bears"),
            listOf("Bears", "Eagles"),
        )
        val results = listOf(0, 0, 0)
        println(tournamentWinner(competitions, results))
    }

    private fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
        val teamToPoints = mutableMapOf<String, Int>()
        var winnerTeam = ""

        competitions.forEachIndexed { index, homeToAwayTeamList ->
            val homeTeam = homeToAwayTeamList[0]
            val awayTeam = homeToAwayTeamList[1]
            val homeTeamWins = results[index] == 1
            val localWinnerTeam = if (homeTeamWins) homeTeam else awayTeam

            if (teamToPoints.containsKey(localWinnerTeam)) {
                teamToPoints[localWinnerTeam] = teamToPoints[localWinnerTeam]!! + 3
            } else {
                teamToPoints[localWinnerTeam] = 3
            }

            if (teamToPoints.getOrDefault(winnerTeam, 0) < teamToPoints.getOrDefault(localWinnerTeam, 0)) {
                winnerTeam = localWinnerTeam
            }
        }

        return winnerTeam
    }

}