package grails.freemarker.templates.in.db



import freemarker.template.Template
import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(FreemarkerTemplateService)
@Mock(DbTemplate)
class FreemarkerTemplateServiceTests {

	void testGetTemplateFromDb() {
		
		DbTemplate.findByName("test")*.delete()
		new DbTemplate(name:'test', source:"Hello World").save(validate: false)

		Template template = service.getTemplate("test")
		assert template != null

		StringWriter sw = new StringWriter()
		template.process(['v':'Hello World'], sw)

		assert "Hello World" == sw.toString()
	}
}
