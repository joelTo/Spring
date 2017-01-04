package fr.console;

import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.ihm.IhmUtil;
import fr.ihm.MainMenu;

public class PizzeriaAdminConsoleApp {

	public static Boolean Arret = false;

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException, SavePizzaException, DeletePizzaException, UpdatesPizzaException {

		/**
		 * Pour le lancement
		 */
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dao-jdbc-config.xml",
				"application-config.xml")) {
			IhmUtil ihmUtil = context.getBean(IhmUtil.class);
			MainMenu core = new MainMenu(ihmUtil);

			core.displayMenu();
			core.parseAndExec();

		}

	}
}