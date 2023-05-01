package com.mu.ruslotto.database

class RuslottoRepository(private val dao: RuslottoDao) {
    val issues = dao.getIssues()

    suspend fun addKeg(keg: Keg): Long {
        return dao.insertKeg(keg)
    }

    suspend fun editKeg(keg: Keg): Int {
        return dao.updateKeg(keg)
    }

    suspend fun deleteKeg(keg: Keg): Int {
        return dao.deleteKeg(keg)
    }

    /*suspend fun addIssue(issue: Issue): Long {
        return dao.addIssue(issue)
    }

    suspend fun editIssue(issue: Issue): Int {
        return dao.editIssue(issue)
    }

    suspend fun delIssue(issue: Issue): Int {
        return dao.delIssue(issue)
    }*/
}