package location

import io.ktor.locations.*

/**
 * @author    yiliyang
 * @date      2022/3/28 上午10:53
 * @version   1.0
 * @since     1.0
 */
//http://localhost:8081/list/movies/page/10
@Location("/list/{name}/page/{page}")
data class Listing(val name: String, val page: Int)

///list/movies?page=10&count=20
//@Location("/list/{name}")
//data class Listing(val name: String, val page: Int, val count: Int)
