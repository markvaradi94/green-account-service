package ro.asis.green.account.service.repository

import org.springframework.data.mongodb.repository.MongoRepository
import ro.asis.green.account.service.model.entity.AccountEntity

interface AccountRepository : MongoRepository<AccountEntity, String>
