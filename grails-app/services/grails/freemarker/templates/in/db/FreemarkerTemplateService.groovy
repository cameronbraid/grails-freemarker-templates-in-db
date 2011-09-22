package grails.freemarker.templates.in.db

import freemarker.cache.MultiTemplateLoader
import freemarker.cache.TemplateLoader
import freemarker.template.Configuration
import freemarker.template.Template

class FreemarkerTemplateService {

	Configuration configuration
	
	public FreemarkerTemplateService() {
		configuration = new Configuration()
		
		configuration.localizedLookup = false
		
		configuration.templateLoader = new MultiTemplateLoader([ new DbTemplateLoader() ] as TemplateLoader[])
		
		configuration.templateUpdateDelay = 0
		
	}
	
	public Template getTemplate(String name) {
		return configuration.getTemplate(name)
	}
	
}
