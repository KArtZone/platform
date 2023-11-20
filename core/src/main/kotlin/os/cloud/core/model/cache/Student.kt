package os.cloud.core.model.cache

import org.springframework.data.redis.core.RedisHash
import java.io.Serializable


@RedisHash("Student")
class Student(
    private val id: String,
    private val name: String,
    private val gender: Gender,
    private val grade: Int
) : Serializable {
    enum class Gender {
        MALE,
        FEMALE
    }

    override fun toString(): String {
        return """            
            {
            "id": ${id},
            "name": ${name},
            "gender": ${gender},
            "grade": $grade
            }
        """.trimIndent()
    }
}