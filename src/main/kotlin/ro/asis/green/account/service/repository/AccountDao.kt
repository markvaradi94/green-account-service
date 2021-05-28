package ro.asis.green.account.service.repository

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository
import ro.asis.green.account.service.model.entity.AccountEntity
import ro.asis.green.account.service.model.filters.AccountFilters
import java.util.Optional.ofNullable

@Repository
class AccountDao(private val mongo: MongoTemplate) {

    fun findAccounts(filters: AccountFilters): List<AccountEntity> {
        val query = Query()
        val criteria = buildCriteria(filters)

        if (criteria.isNotEmpty()) query.addCriteria(Criteria().andOperator(*criteria.toTypedArray()))

        return mongo.find(query, AccountEntity::class.java).toList()
    }

    private fun buildCriteria(filters: AccountFilters): List<Criteria> {
        val criteria = mutableListOf<Criteria>()

        ofNullable(filters.username)
            .ifPresent { criteria.add(Criteria.where("username").regex(".*$it.*", "i")) }
        ofNullable(filters.email)
            .ifPresent { criteria.add(Criteria.where("email").regex(".*$it.*", "i")) }
        ofNullable(filters.phoneNumber)
            .ifPresent { criteria.add(Criteria.where("phoneNumber").regex(".*$it.*", "i")) }
        ofNullable(filters.role)
            .ifPresent { criteria.add(Criteria.where("username").`is`(it)) }
        ofNullable(filters.type)
            .ifPresent { criteria.add(Criteria.where("username").`is`(it)) }

        return criteria
    }
}
