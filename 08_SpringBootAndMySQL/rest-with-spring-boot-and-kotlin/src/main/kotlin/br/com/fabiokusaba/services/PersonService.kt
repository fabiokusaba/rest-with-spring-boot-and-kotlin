package br.com.fabiokusaba.services

import br.com.fabiokusaba.controller.PersonController
import br.com.fabiokusaba.exceptions.ResourceNotFoundException
import br.com.fabiokusaba.model.Person
import br.com.fabiokusaba.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonController::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding All Persons")

        return repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("Finding Person with ID $id")

        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("Person with ID $id not found") }
    }

    fun create(person: Person): Person {
        logger.info("Creating Person with ID ${person.id}")

        return repository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("Updating Person with ID ${person.id}")

        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("Person with ID ${person.id} not found") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        return repository.save(entity)
    }

    fun delete(id: Long) {
        logger.info("Deleting Person with ID $id")

        val person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("Person with ID $id not found") }

        repository.delete(person)
    }

}