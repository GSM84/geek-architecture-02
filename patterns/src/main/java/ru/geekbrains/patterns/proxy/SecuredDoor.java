package ru.geekbrains.patterns.proxy;

public class SecuredDoor {
    private Door door;


    public SecuredDoor(Door door) {
        this.door = door;
    }


    public void open(String pass){
        if (authenticate(pass)){
            this.door.open();
        } else {
            System.out.println("wrong password");
        }
    }

    private boolean authenticate (String pass) {
        return pass.equals("secret")?true:false;
    }

    public void close(){
        this.door.close();
    }

}
