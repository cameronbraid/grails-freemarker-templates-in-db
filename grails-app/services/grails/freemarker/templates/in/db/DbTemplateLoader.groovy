package grails.freemarker.templates.in.db

import freemarker.cache.TemplateLoader;

class DbTemplateLoader implements TemplateLoader {

	void closeTemplateSource(Object templateSource) throws IOException {
		
	}
	
	Object findTemplateSource(String name) throws IOException {
		Long id = DbTemplate.findByName(name)?.id
		return id == null ? null : new DbTemplateSource(id:id)
	}
	
	Reader getReader(Object templateSource, String encoding) throws IOException {
		DbTemplate t = DbTemplate.get(templateSource.id)
		return new StringReader(t.source)
	}
	
	long getLastModified(Object templateSource) {
		DbTemplate.get(templateSource.id).lastUpdated.time
	}	


	static class DbTemplateSource implements Serializable {
		long id
		
		/**
		 * must implement equals for a tempplate source, otherwise the template will be re-parsed by freemarker every time
		 */
		public boolean equals(Object o) {
			return (o instanceof DbTemplateSource) && o.id == this.id 
		}
		
		@Override
		public int hashCode() {
			return id.hashCode()
		}
	}	
}
