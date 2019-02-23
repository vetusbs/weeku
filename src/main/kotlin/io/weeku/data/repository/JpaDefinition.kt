package io.weeku.data.repository

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.OneToMany

@Entity(name = "dish")
data class JpaDish(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String,
    val minutesOfPreparation: Int = 0,
    val amountOfServants: Int = 0,
    @OneToMany(mappedBy = "dishId", fetch = FetchType.EAGER)
    val ingredients: Set<JpaIngredient> = emptySet(),
    @ManyToMany
    @JoinTable(name = "dish_tag",
        joinColumns = [JoinColumn(name = "dish_id")],
        inverseJoinColumns = [JoinColumn(name = "tag_id")]
    )
    val tags: Set<JpaTag> = emptySet()
) {
    private constructor() : this(0, "")
}

@Entity(name = "dish_ingredient")
data class JpaIngredient(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @JoinColumn
    @Column(name = "dish_id")
    val dishId: Int,
    val name: String,
    val amount: BigDecimal,
    val unit_type: String
) {
    private constructor() : this(0, 0, "", BigDecimal.ZERO, "")
}

@Entity(name = "tag")
data class JpaTag(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String
) {
    private constructor() : this(0, "")
}
