package by.epam.jmp.BO;

import by.epam.jmp.DAO.LoginDAO;

import javax.inject.Inject;

/**
 * Created by Alexandr on 28.02.2016.
 */
public class LoginBO {

    @Inject
    private LoginDAO loginDAO;

    public String getLoginName(long id){
        return loginDAO.getLoginName(id);
    }
}
