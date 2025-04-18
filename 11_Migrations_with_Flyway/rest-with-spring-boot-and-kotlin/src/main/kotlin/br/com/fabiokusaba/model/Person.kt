package br.com.fabiokusaba.model

import jakarta.persistence.*

@Entity
@Table(name = "person")
data class Person(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "first_name", nullable = false, length = 80)
    var firstName: String = "",

    @Column(name = "last_name", nullable = false, length = 80)
    var lastName: String = "",

    @Column(name = "address", nullable = false, length = 100)
    var address: String = "",

    @Column(name = "gender", nullable = false, length = 10)
    var gender: String = ""
) {
}