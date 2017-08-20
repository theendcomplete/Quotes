package quotes

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

//        "/"(view:"/index")
        "/"(controller: 'quotes', action: 'index')
//        "/"(controller: 'quotes', action: 'index', view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
