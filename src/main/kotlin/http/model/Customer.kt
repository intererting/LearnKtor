package http.model

/**
 * @author    yiliyang
 * @date      2022/3/25 下午5:19
 * @version   1.0
 * @since     1.0
 */
import kotlinx.serialization.Serializable

@Serializable
data class Customer(val id: String, val firstName: String, val lastName: String, val email: String)