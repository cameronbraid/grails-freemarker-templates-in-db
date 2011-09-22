package grails.freemarker.templates.in.db

import freemarker.template.Template

class IndexController {

	def freemarkerTemplateService

	def getTemplate() {
		Template template;
		try {
			template = freemarkerTemplateService.getTemplate("test")
		}
		catch (e) {}
		template
	}
	
	def index() {

		def data = [template:getTemplate()]
		
		if (data.template) {
			StringWriter sw = new StringWriter()
			template.process(['name': params.name ?: 'World'], sw)
			data['rendered'] = sw.toString()
		}
		data 
	}

	def delete() {
		DbTemplate.findByName("test")*.delete()
		redirect(action:"index")
	} 	
	
	def create() {
		DbTemplate.findByName("test")*.delete()
		new DbTemplate(name:'test', source:'Hello ${name}').save(validate: false)
		redirect(action:"index")
		
	}
}
