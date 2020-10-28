package com.webbfontaine.kotlin.services

import com.webbfontaine.kotlin.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery

interface UserService : CrudRepository<User, Long> {
    fun findAllById(id: Long): Iterable<User>
    fun findFirstByFirstNameOrderById(firstName: String): User?
}


@Service
class UserServiceImpl @Autowired constructor(val entityManager: EntityManager){



    fun getUser() : List<User?>{
        val query = entityManager.createNativeQuery("Select * from User")
       // val builder = entityManager.criteriaBuilder

     //   val cq = builder.createQuery()

       //cq.from(User.class)
       // builder.createQuery().from(User)

       // criteriaQuery.from(User.class)

      //  var user: User = query.singleResult as User

       return query.resultList.map {
           val lst = it as Array<*>
           User( firstName =  lst[1] as String, lastName = lst[2] as String, username = lst[3] as String)

       }
      //  var b = cb.createQuery(User.class)
      //  entityManager.createQuery(User.class)
    }
//    fun findByIdList(brokerIdList: List<String>): List<User> {
//        val query = JPAQuery<User>(entityManager)
//        val resultSet = query.from(qBroker)
//                .where(
//                        qBroker.id.`in`(brokerIdList)
//                )
//                .fetchResults()
//
//        return resultSet.results
//    }results

}