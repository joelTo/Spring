**  Projet Pizzeria Console

Objectif:

04/01/17
- Migrer pizzeria console sous Spring

Procédure :

04/01/17
- Importer dans le pom.xml parent la dependance suivante:
[importer en syntaxe xml]
<dependency>
<groupId>org.springframework</groupId>
<artifactId>spring-framework-bom</artifactId>
<version>4.2.6.RELEASE</version>
<type>pom</type>
<scope>import</scope>
</dependency>
- Importer dans le pom.xml console les ligne suivante:
[importer en syntaxe xml]
<dependency>
<groupId>org.springframework</groupId>
<artifactId>spring-context</artifactId>
</dependency>

- créer "src/main/ressources" dao-memoire-config.xm & application-config.xml 
    action : Spring--> Spring Bean Configration File

[application-Configration.xml]
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:util="http://www.springframework.org/schema/util"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util-4.2.xsd">
	
	<bean id="scanner" class="java.util.Scanner">
		<constructor-arg>
			<util:constant static-field="java.lang.System.in" />
		</constructor-arg>
	</bean>

	<bean id="ihmUtil" class="fr.ihm.IhmUtil">
		<constructor-arg ref="scanner" />
		<constructor-arg ref="pizzaDaoTableau" />
	</bean>


</beans>

[application-config.xml]
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

<bean id="pizzaDaoTableau" class="fr.dao.PizzaDaoTableau"></bean>

</beans>
 changement {PizzeriaAdminConsoleApp}

 
--> $ javac ...
--> $ java ....
--> $ (affiche la liste du menu)