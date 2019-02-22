package io.weeku.data.repository.meal

import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "dish")
data class JpaDish(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String,
    val preparationTime: Int = 0,
    @OneToMany(mappedBy = "dishId", fetch = FetchType.LAZY)
    @Fetch(value= FetchMode.SELECT)
    val ingredients: Set<JpaIngredients> = emptySet()
) {
    private constructor() : this(0, "")
}

@Entity(name = "dish_ingredient")
data class JpaIngredients(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @JoinColumn
    @Column(name = "dish_id")
    val dishId: Int,
    val name: String,
    val amount: BigDecimal,
    val unit_type: String
)
