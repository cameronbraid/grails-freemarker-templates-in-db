package grails.freemarker.templates.in.db

class DbTemplate {

    static constraints = {
		name nullable: false
    }
	
	static mapping = {
		cache true
	}
	
	String name
	String source
	Date lastUpdated
   
   def beforeInsert() {
       lastUpdated = new Date()
   }
   def beforeUpdate() {
       lastUpdated = new Date()
   }

	
}
