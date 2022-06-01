package hessam.rastegari.weroom.data;

public class WelcomeClass {

    private CategoriesClass categoriesClass;
    private ActiveWeroomClass activeWeroomClass;
    private StatusResponseClass statusResponseClass;

    public WelcomeClass(CategoriesClass categoriesClass, ActiveWeroomClass activeWeroomClass, StatusResponseClass statusResponseClass) {
        this.categoriesClass = categoriesClass;
        this.activeWeroomClass = activeWeroomClass;
        this.statusResponseClass = statusResponseClass;
    }

    public CategoriesClass getCategoriesClass() {
        return categoriesClass;
    }

    public void setCategoriesClass(CategoriesClass categoriesClass) {
        this.categoriesClass = categoriesClass;
    }

    public ActiveWeroomClass getActiveWeroomClass() {
        return activeWeroomClass;
    }

    public void setActiveWeroomClass(ActiveWeroomClass activeWeroomClass) {
        this.activeWeroomClass = activeWeroomClass;
    }

    public StatusResponseClass getStatusResponseClass() {
        return statusResponseClass;
    }

    public void setStatusResponseClass(StatusResponseClass statusResponseClass) {
        this.statusResponseClass = statusResponseClass;
    }
}
