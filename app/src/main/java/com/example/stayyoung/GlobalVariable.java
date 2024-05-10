package com.example.stayyoung;

import android.app.Application;
import android.text.Editable;

public class GlobalVariable extends Application {
    private int progress1=10;
    private int progress2=10;
    private int progress3=10;
    private int progress4=10;
    private int progress5=10;
    private int progress6=10;
    private int progress7=10;
    private int progress8=10;
    private int progress9=10;
    private int progress10=10;
    private int level=11;
    private int time=0;
    private String skin1,skin2,skin3,skin4,skin5,skin6,skin7,skin8,skin9,
            edit1, edit2, edit3, edit4, edit5, edit6, edit7, edit8, edit9;

    //修改 變數値

    public void setProgress1(int progress1){
        this.progress1 = progress1;
    }
    public void setProgress2(int progress2){
        this.progress2 = progress2;
    }
    public void setProgress3(int progress3){
        this.progress3 = progress3;
    }
    public void setProgress4(int progress4){
        this.progress4 = progress4;
    }
    public void setProgress5(int progress5){
        this.progress5 = progress5;
    }
    public void setProgress6(int progress6){
        this.progress6 = progress6;
    }
    public void setProgress7(int progress7){
        this.progress7 = progress7;
    }
    public void setProgress8(int progress8){
        this.progress8 = progress8;
    }
    public void setProgress9(int progress9){
        this.progress9 = progress9;
    }
    public void setProgress10(int progress10){
        this.progress9 = progress10;
    }
    public void setlevel(int level){this.level = level;}
    public void settime(int time){this.time=time;}
    public void setSkin1(String skin1){this.skin1=skin1;}
    public void setSkin2(String skin2){this.skin2=skin2;}
    public void setSkin3(String skin3){this.skin3=skin3;}
    public void setSkin4(String skin4){this.skin4=skin4;}
    public void setSkin5(String skin5){this.skin5=skin5;}
    public void setSkin6(String skin6){this.skin6=skin6;}
    public void setSkin7(String skin7){this.skin7=skin7;}
    public void setSkin8(String skin8){this.skin8=skin8;}
    public void setSkin9(String skin9){this.skin9=skin9;}

    public void setEdit1(String edit1){this.edit1=edit1;}
    public void setEdit2(String edit2){this.edit2=edit2;}
    public void setEdit3(String edit3){this.edit3=edit3;}
    public void setEdit4(String edit4){this.edit4=edit4;}
    public void setEdit5(String edit5){this.edit5=edit5;}
    public void setEdit6(String edit6){this.edit6=edit6;}
    public void setEdit7(String edit7){this.edit7=edit7;}
    public void setEdit8(String edit8){this.edit8=edit8;}
    public void setEdit9(String edit9){this.edit9=edit9;}



    //取得 變數值

    public int getProgress1(){
        return progress1;
    }
    public int getProgress2(){
        return progress2;
    }
    public int getProgress3(){
        return progress3;
    }
    public int getProgress4(){
        return progress4;
    }
    public int getProgress5(){
        return progress5;
    }
    public int getProgress6(){
        return progress6;
    }
    public int getProgress7(){
        return progress7;
    }
    public int getProgress8(){
        return progress8;
    }
    public int getProgress9(){
        return progress9;
    }

    public int getLevel(){
        return level;
    }
    public int gettime(){ return time; }

    public String getSkin1(){ return skin1; }
    public String getSkin2(){ return skin2; }
    public String getSkin3(){ return skin3; }
    public String getSkin4(){ return skin4; }
    public String getSkin5(){ return skin5; }
    public String getSkin6(){ return skin6; }
    public String getSkin7(){ return skin7; }
    public String getSkin8(){ return skin8; }
    public String getSkin9(){ return skin9; }

    public String getEdit1(){ return edit1; }
    public String getEdit2(){ return edit2; }
    public String getEdit3(){ return edit3; }
    public String getEdit4(){ return edit4; }
    public String getEdit5(){ return edit5; }
    public String getEdit6(){ return edit6; }
    public String getEdit7(){ return edit7; }
    public String getEdit8(){ return edit8; }
    public String getEdit9(){ return edit9; }




}