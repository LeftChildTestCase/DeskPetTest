package PetEntity;

import GraphicUtil.RePaint;
import javax.swing.*;
import static PetEntity.State.Uro_Direction.*;
import static PetEntity.State.Uro_Effect_State.*;
import static PetEntity.State.Uro_Speed.*;


public class Urotsuki {
    private static int x;
    private static int y;
    private static int direction;

    private int delta_move;
    private int Screen_Width;
    private int Screen_Height;
    private static int State;

    private JFrame jFrame;
    private JPanel jPanel;

    private static boolean IsSit = false;

    private static boolean changeEffect = false;

    public void setFrame(JFrame jFrame, JPanel jPanel) {
        this.jFrame = jFrame;
        this.jPanel = jPanel;
    }

    public void ScreenEdgeCheck(int Screen_Width,int Screen_Height) {
        this.Screen_Width = Screen_Width;
        this.Screen_Height = Screen_Height;
    }

    private void initial(){
        delta_move = 7;
        direction = Urotsuki_left;
        State = Is_Walk;
        y = (int) (Math.random() * Screen_Height - 100) + 100;
        x = (int) (Math.random() * Screen_Width - 150) + 150;
        RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+Is_Walk_String+"/left/left1.png",x,y);
    }

    public void setStateSit() {
        changeEffect = true;
        State = Is_Sit;
    }
    public void setStateWalk() {
        changeEffect = true;
        State = Is_Walk;
        IsSit = false;
    }
    public void setStateMotor() {
        changeEffect = true;
        State = Is_Motor;
        IsSit = false;
    }

    private void ChangeDirection(){
        int temp = getDirection();
        do {
            direction = (int) (Math.floor(Math.random() * 4) + 1);
        }while (direction == temp);
    }

    private void UroMove(){
        while (true){
            switch (State){
                case Is_Walk:{
                    DirectionCheck(Walk,Is_Walk_String);
                    changeEffect = false;
                    break;
                }
                case Is_Motor:{
                    DirectionCheck(Motor,Is_Motor_String);
                    changeEffect = false;
                    break;
                }
                case Is_Sit:{
                    SitCheck();
                    changeEffect = false;
                    break;
                }
            }
        }
    }

    private void DirectionCheck(int speed,String State){
        switch (direction){
            case Urotsuki_left:{
                for (int i = 0; i < 3 + (Math.random() * 97); i++) {
                    if (x > 100  && !changeEffect){
                        x -= delta_move;
                        RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + Urotsuki_left_S +"0.png", x, y);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        x -= delta_move;
                        RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + Urotsuki_left_S +"1.png", x, y);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        x -= delta_move;
                        RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + Urotsuki_left_S +"2.png", x, y);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        x -= delta_move;
                        RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + Urotsuki_left_S +"1.png", x, y);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        ChangeDirection();
                        break;
                    }
                }
                ChangeDirection();
                break;
            }
            case Urotsuki_right:{
                for (int i = 0; i < 3 + (Math.random() * 97); i++) {
                    if (x < Screen_Width - 100 && !changeEffect){
                        x += delta_move;
                        RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + Urotsuki_right_S +"0.png", x, y);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        x += delta_move;
                        RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + Urotsuki_right_S +"1.png", x, y);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        x += delta_move;
                        RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + Urotsuki_right_S +"2.png", x, y);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        x += delta_move;
                        RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + Urotsuki_right_S +"1.png", x, y);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        ChangeDirection();
                        break;
                    }
                }
                ChangeDirection();
                break;
            }
            case Urotsuki_back:{
                for (int i = 0; i < 3 + (Math.random() * 97); i++) {
                    if (y > 100 && !changeEffect) {
                        y -= delta_move;
                        RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + Urotsuki_back_S +"0.png", x, y);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        y -= delta_move;
                        RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + Urotsuki_back_S +"1.png", x, y);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        y -= delta_move;
                        RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + Urotsuki_back_S +"2.png", x, y);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        y -= delta_move;
                        RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + Urotsuki_back_S +"1.png", x, y);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        ChangeDirection();
                        break;
                    }
                }
                ChangeDirection();
                break;
            }
            case Urotsuki_front:{
                for (int i = 0; i < 3 + (Math.random() * 97); i++){
                    if (y < Screen_Height - 100 && !changeEffect) {
                        y += delta_move;
                        RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + Urotsuki_front_S +"0.png", x, y);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        y += delta_move;
                        RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + Urotsuki_front_S +"1.png", x, y);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        y += delta_move;
                        RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + Urotsuki_front_S +"2.png", x, y);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        y += delta_move;
                        RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + Urotsuki_front_S +"1.png", x, y);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        ChangeDirection();
                        break;
                    }
                }
                ChangeDirection();
                break;
            }
        }
    }

    private void SitCheck(){
        if (!IsSit){
            RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + "/sit0.png",x,y);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + "/sit1.png",x,y);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            IsSit = !IsSit;
        }
        RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + "/sit2.png",x,y);
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void Start() {
        initial();
        UroMove();
    }

    public static int getDirection() {
        return direction;
    }
}
