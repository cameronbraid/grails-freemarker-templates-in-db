import grails.freemarker.templates.in.db.IndexController;

class UrlMappings {

	static mappings = { 
		
		"/"(controller: 'index', action: 'index')
		
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"500"(view:'/error')
	}
}
