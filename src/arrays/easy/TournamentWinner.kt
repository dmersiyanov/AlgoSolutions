package arrays.easy

object TournamentWinner {

    @JvmStatic
    fun main(arg: Array<String>) {
        val competitions = listOf(
            listOf("HTML", "C#"),
            listOf("C#", "Python"),
            listOf("Python", "HTML")
        )
        val results = listOf(0, 0, 1)
        println(tournamentWinner(competitions, results))
    }

    // Time O(n), space - O(n)
    fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
        var bestTeam = ""
        val teamsToScopeMap = mutableMapOf<String, Int>()
        competitions.forEachIndexed { index, teams ->
            val winner = teams[1 - results[index]]
            putOrUpdate(winner, teamsToScopeMap)
            if (teamsToScopeMap.getOrDefault(bestTeam, 0) < teamsToScopeMap.getOrDefault(winner, 0)) {
                bestTeam = winner
            }
        }

        val array = arrayOf<String>()
        for (s: String in array) {

        }
        array.forEach {
            
        }
        return bestTeam
    }

    private fun putOrUpdate(team: String, teamToScopeMap: MutableMap<String, Int>) {
        val currentScope = teamToScopeMap.getOrDefault(team, 0)
        teamToScopeMap[team] = currentScope + 3
    }

}