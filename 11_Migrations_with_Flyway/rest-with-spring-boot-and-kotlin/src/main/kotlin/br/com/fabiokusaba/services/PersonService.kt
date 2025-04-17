package br.com.fabiokusaba.services

import br.com.fabiokusaba.controller.PersonController
import br.com.fabiokusaba.data.vo.v1.PersonVO
import br.com.fabiokusaba.exceptions.ResourceNotFoundException
import br.com.fabiokusaba.mapper.DozerMapper
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

    fun findAll(): List<PersonVO> {
        logger.info("Finding All Persons")
        val persons = repository.findAll()
        return DozerMapper.parseListObjects(persons, PersonVO::class.java)
    }

    fun findById(id: Long): PersonVO {
        logger.info("Finding Person with ID $id")

        val person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("Person with ID $id not found") }

        return DozerMapper.parseObject(person, PersonVO::class.java)
    }

    fun create(person: PersonVO): PersonVO {
        logger.info("Creating Person with ID ${person.id}")
        val entity: Person = DozerMapper.parseObject(person, Person::class.java)
        val entitySaved = repository.save(entity)
        return DozerMapper.parseObject(entitySaved, PersonVO::class.java)
    }

    fun update(person: PersonVO): PersonVO {
        logger.info("Updating Person with ID ${person.id}")

        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("Person with ID ${person.id} not found") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        val entityUpdated = repository.save(entity)

        return DozerMapper.parseObject(entityUpdated, PersonVO::class.java)
    }

    fun delete(id: Long) {
        logger.info("Deleting Person with ID $id")

        val person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("Person with ID $id not found") }

        repository.delete(person)
    }

}