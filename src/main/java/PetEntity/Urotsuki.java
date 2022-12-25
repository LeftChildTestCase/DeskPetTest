package PetEntity;

import GraphicUtil.RePaint;

import javax.swing.*;
import java.util.Calendar;

import static PetEntity.State.Uro_Direction.*;
import static PetEntity.State.Uro_Effect_State.*;
import static PetEntity.State.Uro_Speed.Motor;
import static PetEntity.State.Uro_Speed.Walk;


public class Urotsuki {
    private static int x;
    private static int y;
    private static int direction;
    private static final int delta_move = 7;
    private static int Screen_Width;
    private static int Screen_Height;
    private static int State;
    private static JFrame jFrame;
    private static JPanel jPanel;
    private static boolean IsSit = false;
    private static boolean changeEffect = false;
    private static boolean IsControlled = Mode_Free;
    private static boolean IsinControl = false;
    public void setFrame(JFrame jFrame, JPanel jPanel) {
        Urotsuki.jFrame = jFrame;
        Urotsuki.jPanel = jPanel;
    }
    public void ScreenEdgeCheck(int Screen_Width,int Screen_Height) {
        this.Screen_Width = Screen_Width;
        this.Screen_Height = Screen_Height;
    }
    private void initial(){
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(2) == 11 && calendar.get(5) == 25){
            if (Math.random() > 0.3){
                State = Is_Walk;
            }else {
                if (Math.random() > 0.1){
                    State = Is_Santa;
                }else {
                    if (Math.random() > 0.1){
                        State = Is_TwinTail;
                    }else {
                        State = Is_Cat_Black;
                    }
                }
            }
        }else {
            if (Math.random() > 0.1){
                State = Is_Walk;
            }else {
                if (Math.random() > 0.1){
                    State = Is_TwinTail;
                }else {
                    State = Is_Cat_Black;
                }
            }
        }

        y = (int) (Math.random() * Screen_Height - 100) + 100;
        x = (int) (Math.random() * Screen_Width - 150) + 150;

        int random = (int) (Math.floor(Math.random() * 4) + 1);
        direction = random;
        String dir = null;
        switch (random){
            case 1:{
                dir = Urotsuki_front_S;
                break;
            }
            case 2:{
                dir = Urotsuki_back_S;
                break;
            }
            case 3:{
                dir = Urotsuki_left_S;
                break;
            }
            case 4:{
                dir = Urotsuki_right_S;
                break;
            }
        }
        switch (State){
            case Is_Walk:{
                RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+Is_Walk_String+ dir + "1.png",x,y);
                break;
            }
            case Is_TwinTail:{
                RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+Is_TwinTail_String+ dir +"1.png",x,y);
                break;
            }
            case Is_Santa:{
                RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+Is_Santa_String+ dir +"1.png",x,y);
                break;
            }
            case Is_Cat_Black:{
                RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+Is_Cat_Black_String+ dir +"1.png",x,y);
                break;
            }
        }
    }
    public void setStateSit() {
        IsControlled = Mode_Free;
        changeEffect = true;
        State = Is_Sit;
    }
    public void setStateWalk() {
        IsControlled = Mode_Free;
        changeEffect = true;
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(2) == 11 && calendar.get(5) == 25){
            if (Math.random() > 0.3){
                State = Is_Walk;
            }else {
                if (Math.random() > 0.1){
                    State = Is_Santa;
                }else {
                    if (Math.random() > 0.1){
                        State = Is_TwinTail;
                    }else {
                        State = Is_Cat_Black;
                    }
                }
            }
        }else {
            if (Math.random() > 0.1){
                State = Is_Walk;
            }else {
                if (Math.random() > 0.1){
                    State = Is_TwinTail;
                }else {
                    State = Is_Cat_Black;
                }
            }
        }
        IsSit = false;
    }
    public void setStateMotor() {
        IsControlled = Mode_Free;
        changeEffect = true;
        State = Is_Motor;
        IsSit = false;
    }
    public void setStateBat(){
        IsControlled = Mode_Free;
        changeEffect = true;
        State = Is_Bat;
        IsSit = false;
    }
    public void setControlled(){
        changeEffect = true;
        IsSit = false;
        RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ Currentstate(State) + Currentdir(direction) +"1.png", x, y);
        IsControlled = Mode_Controlled;
    }
    private void ChangeDirection(){
        int temp = getDirection();
        do {
            direction = (int) (Math.floor(Math.random() * 4) + 1);
        }while (direction == temp);
    }
    private String Currentdir(int direction){
        String dir = null;
        switch (direction){
            case Urotsuki_front:{
                dir = Urotsuki_front_S;
                break;
            }
            case Urotsuki_left:{
                dir = Urotsuki_left_S;
                break;
            }
            case Urotsuki_back:{
                dir = Urotsuki_back_S;
                break;
            }
            case Urotsuki_right:{
                dir = Urotsuki_right_S;
                break;
            }
        }
        return dir;
    }
    private String Currentstate(int state){
        String sta = null;
        switch (state){
            case Is_Walk:{
                sta = Is_Walk_String;
                break;
            }
            case Is_TwinTail:{
                sta = Is_TwinTail_String;
                break;
            }
            case Is_Santa:{
                sta = Is_Santa_String;
                break;
            }
            case Is_Bat:{
                sta = Is_Bat_String;
                break;
            }
            case Is_BatFly:{
                sta = Is_BatFly_String;
                break;
            }
            case Is_Motor:{
                sta = Is_Motor_String;
                break;
            }
            case Is_Cat_Black:{
                sta = Is_Cat_Black_String;
                break;
            }
        }
        return sta;
    }
    private void UroMove(){
        while (true){
            if (!IsControlled){
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
                    case Is_Bat:{
                        DirectionCheck(Walk,Is_Bat_String);
                        changeEffect = false;
                        break;
                    }
                    case Is_BatFly:{
                        DirectionCheck(Walk,Is_BatFly_String);
                        changeEffect = false;
                        break;
                    }
                    case Is_TwinTail:{
                        DirectionCheck(Walk,Is_TwinTail_String);
                        changeEffect = false;
                        break;
                    }
                    case Is_Santa:{
                        DirectionCheck(Walk,Is_Santa_String);
                        changeEffect = false;
                        break;
                    }
                    case Is_Cat_Black:{
                        DirectionCheck(Walk,Is_Cat_Black_String);
                        changeEffect = false;
                        break;
                    }
                }
            }else {
                if (IsinControl){
                    KeyDirCheck();
                }
            }
        }
    }
    private void RepeatBlockFourFrameAnim(boolean XorY,int sign,String State,String dir,int sleep){
        if (XorY){
            x = x + (sign * delta_move);
            RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + dir +"0.png", x, y);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            x = x + (sign * delta_move);
            RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + dir +"1.png", x, y);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            x = x + (sign * delta_move);
            RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + dir +"2.png", x, y);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            x = x + (sign * delta_move);
            RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + dir +"1.png", x, y);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else {
            y = y + (sign * delta_move);
            RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + dir +"0.png", x, y);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            y = y + (sign * delta_move);
            RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + dir +"1.png", x, y);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            y = y + (sign * delta_move);
            RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + dir +"2.png", x, y);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            y = y + (sign * delta_move);
            RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ State + dir +"1.png", x, y);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        RandomAnimationSwitchEffect();
    }
    private void RepeatBlockSevenFrameAnim(String filepath,String dir){
        RePaint.ImageRepaint(jFrame,jPanel, filepath + dir +"0.png",x,y);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        RePaint.ImageRepaint(jFrame,jPanel, filepath + dir +"1.png",x,y);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        RePaint.ImageRepaint(jFrame,jPanel, filepath + dir +"2.png",x,y);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        RePaint.ImageRepaint(jFrame,jPanel, filepath + dir +"3.png",x,y);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        RePaint.ImageRepaint(jFrame,jPanel, filepath + dir +"2.png",x,y);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        RePaint.ImageRepaint(jFrame,jPanel, filepath + dir +"1.png",x,y);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        RePaint.ImageRepaint(jFrame,jPanel, filepath + dir +"0.png",x,y);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private void DirectionCheck(int speed,String State){
        switch (direction){
            case Urotsuki_left:{
                for (int i = 0; i < 3 + (Math.random() * 97); i++) {
                    if (x > 100  && !changeEffect){
                        RepeatBlockFourFrameAnim(true,-1,State,Urotsuki_left_S,speed);
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
                        RepeatBlockFourFrameAnim(true,1,State,Urotsuki_right_S,speed);
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
                        RepeatBlockFourFrameAnim(false,-1,State,Urotsuki_back_S,speed);
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
                        RepeatBlockFourFrameAnim(false,1,State,Urotsuki_front_S,speed);
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
        switch (direction){
            case Urotsuki_left:{
                if (!IsSit){
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + Urotsuki_left_S + "0.png",x,y);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + Urotsuki_left_S + "1.png",x,y);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + Urotsuki_left_S + "2.png",x,y);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    IsSit = !IsSit;
                }
                RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + Urotsuki_left_S + "3.png",x,y);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case Urotsuki_back:{
                if (!IsSit){
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + Urotsuki_back_S + "0.png",x,y);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + Urotsuki_back_S + "1.png",x,y);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + Urotsuki_back_S + "2.png",x,y);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    IsSit = !IsSit;
                }
                RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + Urotsuki_back_S + "3.png",x,y);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case Urotsuki_front:{
                if (!IsSit){
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + Urotsuki_front_S+ "0.png",x,y);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + Urotsuki_front_S + "1.png",x,y);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + Urotsuki_front_S + "2.png",x,y);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    IsSit = !IsSit;
                }
                RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + Urotsuki_front_S + "3.png",x,y);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case Urotsuki_right:{
                if (!IsSit){
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + Urotsuki_right_S + "0.png",x,y);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + Urotsuki_right_S + "1.png",x,y);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + Urotsuki_right_S + "2.png",x,y);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    IsSit = !IsSit;
                }
                RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/"+ Is_Sit_String + Urotsuki_right_S + "3.png",x,y);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }
    private void RandomAnimationSwitchEffect(){
        switch (State){
            case Is_Bat:{
                if (Math.random() < 0.05){
                    changeEffect = true;
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/Animation/BatToFly/0.png",x,y);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/Animation/BatToFly/1.png",x,y);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/Animation/BatToFly/2.png",x,y);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/Animation/BatToFly/3.png",x,y);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    State = Is_BatFly;
                    IsSit = false;
                }
                break;
            }
            case Is_BatFly:{
                if (Math.random() < 0.05){
                    changeEffect = true;
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/Animation/BatToFly/3.png",x,y);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/Animation/BatToFly/2.png",x,y);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/Animation/BatToFly/1.png",x,y);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    RePaint.ImageRepaint(jFrame,jPanel, "/img/Urotsuki/Animation/BatToFly/0.png",x,y);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    State = Is_Bat;
                    IsSit = false;
                }
                break;
            }
            case Is_TwinTail:{
                if (Math.random() < 0.01){
                    changeEffect = true;
                    switch (direction){
                        case Urotsuki_left:{
                            RepeatBlockSevenFrameAnim("/img/Urotsuki/Animation/TwinTailKick/",Urotsuki_left_S);
                            break;
                        }
                        case Urotsuki_back:{
                            RepeatBlockSevenFrameAnim("/img/Urotsuki/Animation/TwinTailKick/",Urotsuki_back_S);
                            break;
                        }
                        case Urotsuki_right:{
                            RepeatBlockSevenFrameAnim("/img/Urotsuki/Animation/TwinTailKick/",Urotsuki_right_S);
                            break;
                        }
                        case Urotsuki_front:{
                            RepeatBlockSevenFrameAnim("/img/Urotsuki/Animation/TwinTailKick/",Urotsuki_front_S);
                            break;
                        }
                    }
                }
                break;
            }
        }
    }
    public void ControlByKeyBoard(int a,int b){
        if (State != Is_Motor){
            x += a;
            y += b;
            try {
                RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ Currentstate(State) + Currentdir(direction) +"0.png", x, y);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            x += a;
            y += b;
            try {
                RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ Currentstate(State) + Currentdir(direction) +"1.png", x, y);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            x += a;
            y += b;
            try {
                RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ Currentstate(State) + Currentdir(direction) +"2.png", x, y);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            x += a;
            y += b;
            try {
                RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/"+ Currentstate(State) + Currentdir(direction) +"1.png", x, y);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else {
            x += a;
            y += b;
            try {
                RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/Motor"+ Currentdir(direction) +"0.png", x, y);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            x += a;
            y += b;
            try {
                RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/Motor"+ Currentdir(direction) +"1.png", x, y);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            x += a;
            y += b;
            try {
                RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/Motor"+ Currentdir(direction) +"2.png", x, y);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            x += a;
            y += b;
            try {
                RePaint.ImageRepaint(jFrame, jPanel, "/img/Urotsuki/Motor"+ Currentdir(direction) +"1.png", x, y);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void Start() {
        initial();
        UroMove();
    }
    public int getDirection() {
        return direction;
    }
    private void KeyDirCheck(){
        switch (direction){
            case Urotsuki_front:{
                ControlByKeyBoard(0,7);
                break;
            }
            case Urotsuki_left:{
                ControlByKeyBoard(-7,0);
                break;
            }
            case Urotsuki_back:{
                ControlByKeyBoard(0,-7);
                break;
            }
            case Urotsuki_right:{
                ControlByKeyBoard(7,0);
                break;
            }
        }
        IsinControl = false;
    }
    public void setDirection(int direction) {
        this.direction = direction;
    }
    public void setIsinControl(boolean isinControl) {
        IsinControl = isinControl;
    }
}
