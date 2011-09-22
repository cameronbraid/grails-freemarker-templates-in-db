<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Grails FreeMarker templates in db</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				margin: 0.25em 0;
			}

			#action-list ul {
				list-style-position: inside;
			}

			#action-list li {
				list-style-position: inside;
				margin: 0.25em 0;
				margin-bottom:5px;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<div id="status" role="complementary">
			<div id='action-list'>
				<ul>
					<g:if test='${!template}'>
						<li><g:link action="create">Create Template</g:link></li>
					</g:if>
					<g:else>
						<li><g:link action="delete">Delete Template</g:link></li>
						<li>
							<g:form action="index" method='get'>
								<g:submitButton name="update" value="Say Hi to :" />
								<g:textField size='10' name="name" value="${params.name ?: 'Grails'}" />
							</g:form>
						</li>
					</g:else>
				</ul>
				
			</div>
		</div>
		<div id="page-body" role="main">
			<h1>FreeMarker Templates in db</h1>
			<p>
				<fieldset>
					<g:if test="${rendered}">
						${rendered}
					</g:if>
					<g:else>
						No Template Exists - <g:link action="create">create the template</g:link> 
					</g:else>
				</fieldset>
			</p>
		</div>
	</body>
</html>
