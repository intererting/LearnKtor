package location

import io.ktor.locations.*

/**
 * @author    yiliyang
 * @date      2022/3/28 上午10:59
 * @version   1.0
 * @since     1.0
 */

//  get<Type.Edit> { typeEdit -> // /type/{name}/edit
//        // ...
//    }
//    get<Type.List> { typeList -> // /type/{name}/list/{page}
//        // ...
//    }
@Location("/type/{name}")
data class Type(val name: String) {
    // In these classes we have to include the `name` property matching the parent.
    @Location("/edit")
    data class Edit(val parent: Type)

    @Location("/list/{page}")
    data class List(val parent: Type, val page: Int)
}
