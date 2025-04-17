package br.com.fabiokusaba.repository

import br.com.fabiokusaba.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long?> {
}