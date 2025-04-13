package br.com.fabiokusaba.services

import br.com.fabiokusaba.controller.PersonController
import br.com.fabiokusaba.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonController::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding All Persons")

        val persons = mutableListOf<Person>()

        for (i in 0 .. 7) {
            val person = mockPerson(i)
            persons.add(person)
        }

        return persons
    }

    fun findById(id: Long): Person {
        logger.info("Finding Person with ID $id")

        val person = mockPerson(1)

        return person
    }

    fun create(person: Person): Person {
        logger.info("Creating Person with ID ${person.id}")
        return person
    }

    fun update(person: Person): Person {
        logger.info("Updating Person with ID ${person.id}")
        return person
    }

    fun delete(id: Long) = logger.info("Deleting Person with ID $id")

    private fun mockPerson(i : Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person Name $i"
        person.lastName = "Person Last Name $i"
        person.address = "Some Address in Brazil"
        person.gender = "Male"

        return person
    }
}