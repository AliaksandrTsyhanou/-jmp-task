import by.epam.jmp.facade.DBConnectionFacade;

public class FacadeMain {

    public static void main(String[] args) {

        DBConnectionFacade.getConnection(DBConnectionFacade.DBTypes.MYSQL);
        DBConnectionFacade.getConnection(DBConnectionFacade.DBTypes.ORACLE);
        DBConnectionFacade.getConnection(DBConnectionFacade.DBTypes.MONGO);
    }
}
