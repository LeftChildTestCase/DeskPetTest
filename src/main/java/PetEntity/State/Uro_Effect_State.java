package PetEntity.State;

public interface Uro_Effect_State {
    int Is_Sit = -1;
    int Is_Walk = 0;
    int Is_Motor = 1;
    int Is_TwinTail = 2;
    int Is_Bat = 3;
    int Is_BatFly = 4;
    int Is_Cat_Black = 5;
    int Is_Santa = 6;
    boolean Mode_Free = false;
    boolean Mode_Controlled = true;
    String Is_Sit_String = "Sit";
    String Is_Walk_String = "Walk";
    String Is_Motor_String = "Motor";
    String Is_TwinTail_String = "TwinTail";
    String Is_Bat_String = "Bat";
    String Is_BatFly_String = "BatFly";
    String Is_Cat_Black_String = "CatBlack";
    String Is_Santa_String = "Santa";
}
