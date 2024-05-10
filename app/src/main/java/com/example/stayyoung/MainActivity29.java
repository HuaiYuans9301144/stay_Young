package com.example.stayyoung;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintSet;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.Manifest;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;


import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class MainActivity29 extends AppCompatActivity {
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 101;
    private TextView output;
    private TextView score1,score2,score3,score4,score5,score6,score7,score8,score9,score10;

    private LocationManager lc;
    private Location currentLocation = null;
    private LocationListener ll;
    private NotificationManager nm;
    private String addresstext = null;
    private final String [][] data = {  // 資料匯入
            {"Taipei City","Songshan District","2","7","3","2","7","6","8","10","1","10"},
            {"Taipei City","Xinyi District","2","6","3","2","7","6","8","10","1","10"},
            {"Taipei City","Daan District","2","6","3","2","7","6","9","10","1","10"},
            {"Taipei City","Zhongshan District","2","6","3","2","7","6","9","10","1","10"},
            {"Taipei City","Zhongzheng District","2","7","3","2","8","6","8","10","1","9"},
            {"Taipei City","Datong District ","2","7","4","2","8","6","7","10","1","9"},
            {"Taipei City","Wanhua District","2","7","3","2","7","6","8","10","1","10"},
            {"Taipei City","Wenshan District ","2","5","2","6","10","10","9","10","1","10"},
            {"Taipei City","Nangang District ","2","6","2","2","8","6","7","10","2","9"},
            {"Taipei City","Neihu District","2","5","2","6","10","10","10","10","1","10"},
            {"Taipei City","Shilin District","2","4","1","2","7","6","9","10","2","10"},
            {"Taipei City","Beitou District","2","4","1","2","7","6","9","10","2","10"},
            {"Kaohsiung City","Yancheng District ","9","3","10","1","8","7","4","8","1","4"},
            {"Kaohsiung City","Gushan District","9","3","10","3","10","5","7","9","1","9"},
            {"Kaohsiung City","Zuoying District","9","3","9","2","7","6","9","9","1","10"},
            {"Kaohsiung City","NanziDistrict","9","3","8","2","9","6","9","9","1","10"},
            {"Kaohsiung City","Sanmin District ","9","3","9","5","10","9","10","9","1","10"},
            {"Kaohsiung City","XinxingDistrict","9","3","10","1","8","7","5","8","1","7"},
            {"Kaohsiung City","QianjinDistrict","9","3","10","1","8","7","5","8","1","4"},
            {"Kaohsiung City","Lingya District","9","3","10","2","7","6","9","8","1","10"},
            {"Kaohsiung City","QianzhenDistrict ","9","3","9","4","10","8","9","8","1","10"},
            {"Kaohsiung City","QijinDistrict ","9","3","10","1","8","7","4","8","2","5"},
            {"Kaohsiung City","XiaogangDistrict","10","3","7","8","10","10","9","8","2","9"},
            {"Kaohsiung City","FengshanDistrict","9","3","8","3","9","5","10","9","1","10"},
            {"Kaohsiung City","Linyuan District","10","3","8","3","10","5","7","8","3","8"},
            {"Kaohsiung City","Daliao District","10","2","6","4","10","10","10","8","3","9"},
            {"Kaohsiung City","Dashu District","10","2","6","1","8","7","6","8","6","6"},
            {"Kaohsiung City","Dashe District ","9","3","8","2","9","6","6","8","4","5"},
            {"Kaohsiung City","Renwu District","10","3","8","7","10","10","8","8","3","8"},
            {"Kaohsiung City","Niaosong District","9","3","8","2","8","6","6","8","3","6"},
            {"Kaohsiung City","Gangshan District","10","2","7","7","10","10","9","8","3","9"},
            {"Kaohsiung City","QiaotouDistrict","9","3","8","1","8","7","5","8","3","6"},
            {"Kaohsiung City","Yanchao District","10","2","6","4","2","10","7","8","7","5"},
            {"Kaohsiung City","Tianliao District","10","2","4","1","9","7","2","8","9","1"},
            {"Kaohsiung City","Alian District","10","3","8","1","8","7","4","8","5","5"},
            {"Kaohsiung City","LuzhuDistrict","10","2","7","4","3","10","7","8","4","7"},
            {"Kaohsiung City","Hunei District","9","3","9","3","5","8","6","8","3","5"},
            {"Kaohsiung City","Qieding District","9","3","9","1","8","7","4","8","3","5"},
            {"Kaohsiung City","Yong’an District","9","3","9","7","10","8","4","8","7","3"},
            {"Kaohsiung City","Mituo District","9","3","9","1","9","7","4","8","4","4"},
            {"Kaohsiung City","Ziguan District","9","3","10","1","8","7","6","8","3","6"},
            {"Kaohsiung City","Qishan District","10","1","4","4","2","10","7","8","6","6"},
            {"Kaohsiung City","Meinong District","10","1","3","1","8","7","6","8","7","6"},
            {"Kaohsiung City","Liugui District","10","1","1","1","9","7","4","8","9","3"},
            {"Kaohsiung City","Jiaxian District","10","1","2","1","9","7","4","8","9","1"},
            {"Kaohsiung City","Shanlin Distric","10","1","3","1","8","7","4","8","9","2"},
            {"Kaohsiung City","Neimen District","10","1","4","1","8","7","4","8","9","3"},
            {"Kaohsiung City","Maolin District","10","1","1","1","9","7","3","8","10","1"},
            {"Kaohsiung City","Taoyuan District","10","1","1","1","8","7","3","8","10","1"},
            {"Kaohsiung City","Namaxia District","10","1","1","1","9","7","2","8","10","1"},
            {"New Taipei City","Banqiao District","5","9","3","3","9","5","10","10","1","10"},
            {"New Taipei City","Sanchong District","4","10","3","3","9","5","10","10","1","10"},
            {"New Taipei City","Zhonghe District","5","9","3","3","9","5","10","10","1","10"},
            {"New Taipei City","Yonghe District","4","10","3","2","8","6","8","10","1","10"},
            {"New Taipei City","Xinzhuang District","4","9","3","3","9","5","10","10","1","10"},
            {"New Taipei City","Xindian District","5","9","2","4","10","9","10","10","2","10"},
            {"New Taipei City","Shulin District","5","9","3","5","10","9","10","9","2","10"},
            {"New Taipei City","YinggeDistrict","5","9","3","2","9","6","8","10","2","8"},
            {"New Taipei City","SanxiaDistrict","5","8","1","2","9","6","8","10","5","9"},
            {"New Taipei City","TamsuiDistrict","5","9","2","2","9","6","8","10","2","10"},
            {"New Taipei City","XizhiDistrict","5","9","2","3","10","5","9","10","2","10"},
            {"New Taipei City","RuifangDistrict","5","9","2","2","9","6","6","9","5","6"},
            {"New Taipei City","TuchengDistrict","5","9","3","3","9","5","10","10","2","10"},
            {"New Taipei City","LuzhouDistrict","4","10","3","2","9","6","8","10","1","10"},
            {"New Taipei City","WuguDistrict","5","9","3","2","9","6","8","10","3","8"},
            {"New Taipei City","TaishanDistrict","4","10","3","2","9","6","8","9","2","8"},
            {"New Taipei City","LinkouDistrict","5","9","2","5","10","8","8","10","3","9"},
            {"New Taipei City","ShenkengDistrict","5","9","3","1","9","7","6","9","4","4"},
            {"New Taipei City","ShidingDistrict","5","8","2","1","9","7","4","10","10","2"},
            {"New TaipeiCity","PinglinDistrict","5","8","2","1","9","7","4","10","10","1"},
            {"New TaipeiCity","SanzhiDistrict","5","9","2","1","9","7","6","9","6","4"},
            {"New TaipeiCity","ShimenDistrict","5","9","2","1","8","7","5","9","8","2"},
            {"New TaipeiCity","BaliDistrict","5","9","3","8","1","10","7","9","4","6"},
            {"New TaipeiCity","PingxiDistrict","5","9","2","1","8","7","4","10","9","1"},
            {"New TaipeiCity","ShuangxiDistrict","5","8","2","1","9","7","4","10","9","2"},
            {"New TaipeiCity","GongliaoDistrict","5","9","2","1","8","7","6","9","9","2"},
            {"New TaipeiCity","JinshanDistrict","5","9","2","1","8","7","5","10","6","4"},
            {"New TaipeiCity","WanliDistrict ","5","9","2","1","8","7","5","10","7","4"},
            {"New TaipeiCity","WulaiDistrict","5","6","1","1","8","7","4","10","10","1"},
            {"Taichung City","Central District ","3","7","7","1","8","7","5","9","1","3"},
            {"Taichung City","East District","3","6","7","2","8","6","8","9","1","7"},
            {"Taichung City","South District","3","6","7","2","9","6","8","10","1","9"},
            {"Taichung City","West District ","3","6","7","2","8","6","8","9","1","8"},
            {"Taichung City","North District","3","6","7","2","8","6","9","10","1","9"},
            {"Taichung City","XitunDistrict","3","5","4","2","7","6","10","9","2","10"},
            {"Taichung City","Nantun District ","3","6","5","5","10","9","10","9","2","9"},
            {"Taichung City","Beitun District ","3","4","3","2","7","6","10","10","2","10"},
            {"Taichung City","FengyuanDistrict ","3","5","4","2","7","6","10","9","2","9"},
            {"Taichung City","DongshiDistrict","4","4","2","1","8","7","7","9","7","6"},
            {"Taichung City","Dajia District","3","4","3","2","9","6","8","9","4","8"},
            {"Taichung City","QingshuiDistrict","4","4","3","2","8","6","8","9","4","8"},
            {"Taichung City","ShaluDistrict","3","5","4","2","8","6","9","9","3","8"},
            {"Taichung City","WuqiDistrict","3","6","6","3","10","5","8","9","2","7"},
            {"Taichung City","HouliDistrict","3","4","3","4","10","9","8","9","5","6"},
            {"Taichung City","ShengangDistrict","3","5","4","4","2","10","8","9","3","7"},
            {"Taichung City","TanziDistrict","3","6","5","2","9","6","8","10","2","8"},
            {"Taichung City","DayaDistrict","3","6","5","2","8","6","8","9","3","8"},
            {"Taichung City","XinsheDistrict","4","4","2","2","8","6","6","9","7","4"},
            {"Taichung City","ShigangDistrict","3","6","6","1","8","7","6","9","6","2"},
            {"Taichung City","Waipu District","3","5","4","7","4","3","7","9","6","4"},
            {"Taichung City","Daan District","3","6","5","6","5","3","5","9","6","3"},
            {"Taichung City","WuriDistrict","3","5","4","10","5","9","9","8","3","7"},
            {"Taichung City","Dadu District","3","5","4","9","2","1","8","9","4","7"},
            {"Taichung City","Longjing District","3","5","4","10","10","3","9","9","3","8"},
            {"Taichung City","WufengDistrict","4","4","2","9","2","1","9","9","6","7"},
            {"Taichung City","Taiping District","4","4","1","10","1","1","10","7","3","9"},
            {"Taichung City","Dali District","3","6","5","10","1","9","10","3","2","10"},
            {"Taichung City","Heping District","8","1","1","4","6","4","5","9","10","2"},
            {"Tainan City","XinyingDistrict","5","2","10","9","1","10","8","6","3","8"},
            {"Tainan City","YanshuiDistrict","6","1","10","7","3","8","4","7","6","5"},
            {"Tainan City","Baihe District ","7","1","6","7","4","3","6","7","8","5"},
            {"Tainan City","LiuyingDistrict","6","1","9","6","5","3","5","7","7","4"},
            {"Tainan City","Houbi District","6","1","8","6","5","3","5","7","7","5"},
            {"Tainan City","Dongshan District","7","1","7","5","6","4","5","7","8","4"},
            {"Tainan City","Madou District","6","1","10","8","3","2","6","7","5","7"},
            {"Tainan City","XiayingDistrict","5","2","10","6","5","3","4","7","5","5"},
            {"Tainan City","LiujiaDistrict","6","1","9","6","5","3","5","7","7","4"},
            {"Tainan City","Guantian District","6","1","8","7","4","10","6","7","7","4"},
            {"Tainan City","Danei District","6","1","8","4","7","5","2","7","9","2"},
            {"Tainan City","Jiali District","5","2","10","9","3","1","8","7","4","8"},
            {"Tainan City","XuejiaDistrict","6","1","10","7","4","3","6","7","6","5"},
            {"Tainan City","XigangDistrict","5","2","10","7","4","3","5","7","5","5"},
            {"Tainan City","QiguDistrict","7","1","7","5","6","4","5","7","8","4"},
            {"Tainan City","JiangjunDistrict","6","2","10","5","6","4","4","7","7","4"},
            {"Tainan City","Beimen District","6","1","10","4","5","8","2","7","8","3"},
            {"Tainan City","XinhuaDistrict","6","1","9","8","3","2","7","7","5","7"},
            {"Tainan City","Shanhua District","6","1","9","8","3","2","7","7","5","7"},
            {"Tainan City","XinshiDistrict","6","1","10","8","3","2","8","7","5","6"},
            {"Tainan City","Anding District","5","2","10","8","2","9","7","7","5","6"},
            {"Tainan City","Shanshang District","5","2","10","4","10","5","6","7","8","2"},
            {"Tainan City","Yujing District","6","1","8","6","5","4","4","7","8","3"},
            {"Tainan City","NanxiDistrict","7","1","7","5","2","10","3","7","9","2"},
            {"Tainan City","Nanhua District","7","1","5","3","6","8","3","7","10","2"},
            {"Tainan City","ZuozhenDistrict","6","1","8","3","7","5","3","7","9","2"},
            {"Tainan City","Rende District","6","1","10","10","1","10","10","3","3","8"},
            {"Tainan City","GuirenDistrict","6","1","9","9","1","9","8","7","4","8"},
            {"Tainan City","Guanmiao District","6","1","10","7","4","3","6","7","6","6"},
            {"Tainan City","LongqiDistrict","6","1","9","3","7","5","3","7","10","1"},
            {"Tainan City","Yongkang District","6","2","10","10","1","8","10","1","2","10"},
            {"Tainan City","East District ","5","2","10","10","1","1","10","1","1","10"},
            {"Tainan City","South District","5","2","10","10","1","1","10","2","2","9"},
            {"Tainan City","North District","5","2","10","10","1","1","10","2","1","9"},
            {"Tainan City","Annan District ","7","1","7","10","10","10","10","1","3","10"},
            {"Tainan City","Anping District ","5","2","10","9","2","1","8","6","2","8"},
            {"Tainan City","West Central District","5","2","10","1","8","7","7","7","1","8"},
            {"Taoyuan City","TaoyuanDistrict","7","10","2","10","1","9","10","1","2","10"},
            {"Taoyuan City","ZhongliDistrict","7","10","2","10","1","9","10","1","2","10"},
            {"Taoyuan City","DaxiDistrict ","7","9","1","9","2","1","9","7","5","8"},
            {"Taoyuan City","YangmeiDistrict","7","9","1","10","1","8","10","6","3","9"},
            {"Taoyuan City","LuzhuDistrict","7","10","2","10","6","1","10","2","3","9"},
            {"Taoyuan City","DayuanDistrict","7","9","2","9","6","1","10","7","5","8"},
            {"Taoyuan City","GuishanDistrict","7","10","2","10","1","1","10","2","3","9"},
            {"Taoyuan City","BadeDistrict","7","10","2","10","1","1","10","4","2","9"},
            {"Taoyuan City","LongtanDistrict","7","10","2","10","3","1","10","7","3","8"},
            {"Taoyuan City","PingzhenDistrict","7","10","2","10","1","1","10","3","2","9"},
            {"Taoyuan City","XinwuDistrict","7","10","2","8","10","2","7","7","6","5"},
            {"Taoyuan City","GuanyinDistrict","7","9","1","9","10","10","8","7","5","7"},
            {"Taoyuan City","FuxingDistrict ","8","4","1","1","9","7","3","8","10","2"},
            {"Yilan Country","YilanCity","2","8","6","10","1","1","9","1","2","9"},
            {"Yilan Country","LuodongTownship ","2","8","6","10","1","1","7","1","2","8"},
            {"Yilan Country","SuaoTownship","2","8","5","9","10","9","7","2","6","7"},
            {"Yilan Country","TouchengTownship","2","8","5","8","3","2","5","4","7","5"},
            {"Yilan Country","JiaoxiTownship","2","8","5","8","3","2","6","3","5","6"},
            {"Yilan Country","ZhuangweiTownship","2","8","6","6","5","3","4","6","5","4"},
            {"Yilan Country","YuanshanTownship","2","8","5","7","4","3","4","5","7","6"},
            {"Yilan Country","DongshanTownship","2","8","6","9","2","2","7","2","5","7"},
            {"Yilan Country","WujieTownship ","2","8","6","9","10","10","6","3","4","7"},
            {"Yilan Country","SanxingTownship","2","8","5","7","3","9","3","6","8","4"},
            {"Yilan Country","DatongTownship","2","7","3","3","7","5","1","6","10","2"},
            {"Yilan Country","NanaoTownship","2","7","3","3","7","5","1","6","10","1"},
            {"Hsinchu Country","ZhubeiCity","3","8","6","10","1","1","10","1","2","9"},
            {"Hsinchu Country","ZhudongTownship","3","8","6","9","2","1","8","1","3","8"},
            {"Hsinchu Country","XinpuTownship","3","8","6","7","5","3","6","3","6","5"},
            {"Hsinchu Country","GuanxiTownship ","3","8","5","6","9","3","4","3","8","4"},
            {"Hsinchu Country","HukouTownship","3","8","6","9","9","1","9","1","4","8"},
            {"Hsinchu Country","XinfengTownship","3","8","6","9","1","10","6","2","4","7"},
            {"Hsinchu Country","QionglinTownship","2","8","6","6","6","3","5","3","6","3"},
            {"Hsinchu Country","HengshanTownship","3","8","6","4","6","4","2","5","8","2"},
            {"Hsinchu Country","Beipu Township","3","8","6","4","6","4","1","5","8","2"},
            {"Hsinchu Country","Baoshan Township ","3","8","6","5","5","4","3","4","8","3"},
            {"Hsinchu Country","Emei Township ","3","8","6","4","4","9","1","5","9","1"},
            {"Hsinchu Country","JianshiTownship","3","6","2","4","6","4","1","5","10","2"},
            {"Hsinchu Country","WufengTownship","3","7","4","3","7","5","1","5","10","1"},
            {"Miaoli Country","Miaoli City","4","9","6","9","2","1","9","1","3","8"},
            {"Miaoli Country","Yuanli Township ","4","9","5","8","3","2","6","2","6","6"},
            {"Miaoli Country","TongxiaoTownship","4","8","4","8","10","10","5","2","7","5"},
            {"Miaoli Country","ZhunanTownship","4","9","6","10","4","10","9","1","3","8"},
            {"Miaoli Country","Toufen Township","4","9","5","10","1","9","9","1","3","9"},
            {"Miaoli Country","Houlong Township ","4","9","5","8","3","8","5","2","6","5"},
            {"Miaoli Country","ZhuolanTownship","4","8","5","5","6","4","2","4","8","3"},
            {"Miaoli Country","Dahu Township ","4","8","4","6","2","10","2","4","8","3"},
            {"Miaoli Country","Gongguan Township","4","9","5","7","4","3","5","2","6","5"},
            {"Miaoli Country","Tongluo Township ","4","8","5","6","6","8","4","3","8","3"},
            {"Miaoli Country","NanzhuangTownship","4","8","3","5","6","4","2","4","9","2"},
            {"Miaoli Country","Touwu Township ","4","9","5","5","4","8","2","4","8","2"},
            {"Miaoli Country","Sanyi Township ","4","9","5","7","9","3","3","3","8","3"},
            {"Miaoli Country","XihuTownship","4","9","5","4","3","9","1","5","8","1"},
            {"Miaoli Country","ZaoqiaoTownship","4","9","5","5","4","9","2","4","7","2"},
            {"Miaoli Country","Sanwan Township","4","9","5","4","5","8","1","4","9","1"},
            {"Miaoli Country","ShitanTownship","4","8","5","3","6","8","1","5","10","1"},
            {"Miaoli Country","Taian Township","4","4","1","4","7","5","1","5","10","1"},
            {"Changhua Country","Changhua City","7","2","9","10","1","1","10","1","2","10"},
            {"Changhua Country","LugangTownship","7","2","9","10","10","1","8","1","3","9"},
            {"Changhua Country","Hemei Township","7","2","9","10","1","8","9","1","3","9"},
            {"Changhua Country","XianxiTownship","6","3","10","8","10","2","2","4","5","4"},
            {"Changhua Country","Shengang Township","6","3","10","8","9","2","5","3","4","6"},
            {"Changhua Country","FuxingTownship ","7","2","9","9","3","2","7","2","5","7"},
            {"Changhua Country","XiushuiTownship","6","3","10","9","2","2","6","2","4","6"},
            {"Changhua Country","Huatan Township ","6","2","9","9","2","2","7","2","4","7"},
            {"Changhua Country","Fenyuan Township","6","2","9","6","5","3","4","4","6","4"},
            {"Changhua Country","Yuanlin Township ","7","2","9","10","1","1","9","1","3","9"},
            {"Changhua Country","XihuTownship","6","3","10","9","2","1","7","1","4","7"},
            {"Changhua Country","TianzhongTownship","6","3","9","8","4","2","7","2","4","7"},
            {"Changhua Country","Dacun Township ","6","3","10","8","3","2","4","3","5","6"},
            {"Changhua Country","Puyan Township","6","2","9","8","3","2","4","3","5","6"},
            {"Changhua Country","Puxin Township","6","3","10","8","3","2","5","2","4","6"},
            {"Changhua Country","Yongjing Township","6","3","10","8","3","2","5","3","4","6"},
            {"Changhua Country","Shetou Township","6","2","9","8","3","2","6","2","5","7"},
            {"Changhua Country","ErshuiTownship","6","3","10","4","6","4","2","5","6","3"},
            {"Changhua Country","Beidou Township","6","3","10","8","3","2","5","2","3","6"},
            {"Changhua Country","Erlin Township","7","2","8","8","2","2","7","2","6","7"},
            {"Changhua Country","Tianwei Township ","6","3","10","7","4","3","4","4","4","5"},
            {"Changhua Country","Pitou Township ","7","2","9","7","4","2","6","3","5","5"},
            {"Changhua Country","Fangyuan Township","7","2","8","7","2","10","5","3","7","6"},
            {"Changhua Country","Dacheng Township","7","2","9","5","6","4","1","6","8","3"},
            {"Changhua Country","ZhutangTownship","7","2","9","5","6","4","2","5","7","3"},
            {"Changhua Country","XizhouTownship","7","2","9","6","10","10","3","6","7","5"},
            {"Nantou Country","Nantou City","1","4","6","10","2","10","9","1","4","9"},
            {"Nantou Country","Puli Township","2","4","6","9","2","1","9","1","6","8"},
            {"Nantou Country","Caotun Township","1","4","6","10","1","1","10","1","5","9"},
            {"Nantou Country","ZhushanTownship","2","3","5","9","1","10","7","1","8","7"},
            {"Nantou Country","Jiji Township ","1","4","6","5","5","8","2","4","8","2"},
            {"Nantou Country","Mingjian Township","1","4","6","7","4","2","7","2","7","6"},
            {"Nantou Country","LuguTownship","2","4","6","6","5","3","3","3","9","3"},
            {"Nantou Country","ZhongliaoTownship","2","4","6","4","6","4","1","5","9","3"},
            {"Nantou Country","YuchiTownship","1","4","6","7","4","3","3","3","9","3"},
            {"Nantou Country","GuoxingTownship","2","4","5","6","5","4","3","4","9","3"},
            {"Nantou Country","ShuiliTownship","1","4","6","6","5","3","3","3","8","3"},
            {"Nantou Country","XinyiTownship","2","1","1","4","6","4","2","5","10","3"},
            {"Nantou Country","RenaiTownship","2","2","1","5","5","4","2","4","10","3"},
            {"Yunlin Country","DouliuCity","8","4","7","10","2","1","9","1","4","9"},
            {"Yunlin Country","Dounan Township ","8","5","7","9","2","9","7","1","4","7"},
            {"Yunlin Country","Huwei Township","8","5","7","9","1","8","8","1","4","8"},
            {"Yunlin Country","XiluoTownship ","8","5","7","8","3","2","7","2","5","7"},
            {"Yunlin Country","Tuku Township","8","5","7","7","2","9","4","3","6","5"},
            {"Yunlin Country","Beigang Township","7","5","8","8","3","2","6","2","4","7"},
            {"Yunlin Country","Gukeng Township","8","4","7","7","4","3","5","3","8","6"},
            {"Yunlin Country","DapiTownship","7","5","8","6","7","3","3","4","6","4"},
            {"Yunlin Country","CitongTownship","8","5","7","8","2","10","4","3","6","5"},
            {"Yunlin Country","Linnei Township","7","5","8","5","4","8","3","4","6","4"},
            {"Yunlin Country","Erlun Township ","8","5","7","6","3","9","3","4","6","5"},
            {"Yunlin Country","Lunbei Township ","8","5","7","7","3","8","3","3","7","5"},
            {"Yunlin Country","Mailiao Township ","8","5","7","10","10","1","7","2","7","7"},
            {"Yunlin Country","DongshiTownship","8","5","7","5","4","8","2","5","7","3"},
            {"Yunlin Country","BaozhongTownship","7","5","8","5","4","9","2","5","7","3"},
            {"Yunlin Country","TaixiTownship","8","5","7","5","6","4","2","5","7","4"},
            {"Yunlin Country","YuanchangTownship","8","5","7","6","5","3","4","3","7","5"},
            {"Yunlin Country","SihuTownship","8","5","7","6","2","10","3","4","8","4"},
            {"Yunlin Country","Kouhu Township","8","4","7","5","5","4","3","4","8","5"},
            {"Yunlin Country","ShuilinTownship","8","5","7","6","5","3","2","4","7","5"},
            {"Chiayi Country","Taibao City","10","10","1","8","5","2","7","2","5","7"},
            {"Chiayi Country","PuziCity","10","10","1","8","2","9","7","2","5","7"},
            {"Chiayi Country","Budai Township","10","10","1","6","5","3","6","3","6","6"},
            {"Chiayi Country","Dalin Township","10","10","1","7","3","8","6","2","6","6"},
            {"Chiayi Country","MinxiongTownship","10","10","1","9","10","10","9","1","5","8"},
            {"Chiayi Country","XikouTownship","10","10","1","4","6","4","1","5","7","4"},
            {"Chiayi Country","XingangTownship","10","10","1","7","2","9","4","3","7","6"},
            {"Chiayi Country","LiujiaoTownship","10","10","1","6","5","3","3","5","7","5"},
            {"Chiayi Country","DongshiTownship","10","10","1","5","6","4","2","5","8","5"},
            {"Chiayi Country","YizhuTownship","10","10","1","5","6","4","2","5","8","4"},
            {"Chiayi Country","LucaoTownship","10","10","1","7","10","10","2","5","8","4"},
            {"Chiayi Country","ShuishangTownship","10","10","1","8","2","9","7","2","5","8"},
            {"Chiayi Country","ZhongpuTownship","10","10","1","8","3","2","8","2","7","7"},
            {"Chiayi Country","ZhuqiTownship","10","10","1","7","2","9","5","3","8","7"},
            {"Chiayi Country","Meishan Township ","10","10","1","6","5","4","3","5","8","4"},
            {"Chiayi Country","FanluTownship ","10","10","1","4","6","4","2","5","9","3"},
            {"Chiayi Country","Dapu Township ","10","10","1","3","7","5","1","6","10","1"},
            {"Chiayi Country","Alishan Township ","10","10","1","4","6","4","1","5","10","2"},
            {"Pingtung Country","Pingdong City","9","7","8","10","1","1","10","1","2","10"},
            {"Pingtung Country","ChaozhouTownship","8","7","8","9","2","1","8","1","4","8"},
            {"Pingtung Country","Donggang Township","8","7","9","9","1","10","6","2","4","7"},
            {"Pingtung Country","Hengchun Township ","9","7","7","9","1","10","6","2","8","6"},
            {"Pingtung Country","Wandan Township ","8","7","8","8","3","2","7","3","5","7"},
            {"Pingtung Country","ChangzhiTownship","8","7","8","7","4","3","6","4","5","6"},
            {"Pingtung Country","Linluo Township","8","8","9","4","6","4","3","6","5","3"},
            {"Pingtung Country","JiuruTownship","8","7","8","6","5","3","3","6","6","4"},
            {"Pingtung Country","Ligang Township ","9","7","8","7","4","3","5","5","7","5"},
            {"Pingtung Country","Yanpu Township","9","7","8","6","5","3","3","6","7","5"},
            {"Pingtung Country","Gaoshu Township","9","7","8","6","5","3","4","6","8","5"},
            {"Pingtung Country","Wanluan Township ","9","7","8","5","5","4","3","6","7","4"},
            {"Pingtung Country","Neipu Township ","9","7","8","9","4","2","7","2","5","8"},
            {"Pingtung Country","ZhutianTownship","8","7","9","5","6","4","4","6","6","4"},
            {"Pingtung Country","XinpiTownship","8","7","8","4","6","5","2","6","8","2"},
            {"Pingtung Country","FangliaoTownship","8","7","8","8","2","10","5","4","6","5"},
            {"Pingtung Country","XinyuanTownship","8","7","8","7","4","3","5","5","5","6"},
            {"Pingtung Country","Kanding Township","8","7","8","8","10","10","1","6","7","3"},
            {"Pingtung Country","Linbian Township","8","8","9","6","5","4","2","6","4","4"},
            {"Pingtung Country","NanzhouTownship","8","7","9","5","3","9","3","6","6","3"},
            {"Pingtung Country","Jiadong Township ","8","7","9","5","6","4","2","6","6","4"},
            {"Pingtung Country","LiuqiuTownship","8","8","9","5","6","4","2","6","4","3"},
            {"Pingtung Country","Checheng Township","8","7","8","4","6","4","2","6","8","2"},
            {"Pingtung Country","ManzhouTownship","9","7","7","3","7","5","2","6","10","2"},
            {"Pingtung Country","FangshanTownship","8","8","9","4","7","5","3","6","7","1"},
            {"Pingtung Country","Sandimen Township","9","7","7","3","7","5","1","6","10","2"},
            {"Pingtung Country","Wutai Township ","9","6","6","3","7","5","1","6","10","1"},
            {"Pingtung Country","Majia Township","9","7","8","3","7","5","1","6","9","2"},
            {"Pingtung Country","Taiwu Township","9","7","7","3","7","5","1","6","10","1"},
            {"Pingtung Country","Laiyi Township ","9","7","7","3","7","5","1","6","10","2"},
            {"Pingtung Country","ChunriTownship","9","7","7","3","7","5","1","6","10","1"},
            {"Pingtung Country","ShiziTownship","9","6","6","3","7","5","1","6","10","1"},
            {"Pingtung Country","Mudan Township","9","7","7","3","7","5","1","6","10","1"},
            {"Taitung Country","Taitung City","1","6","4","10","1","9","9","1","4","9"},
            {"Taitung Country","ChenggongTownship","1","6","4","6","2","10","3","3","9","3"},
            {"Taitung Country","GuanshanTownship","1","6","4","5","4","9","2","4","8","2"},
            {"Taitung Country","Beinan Township","1","6","4","6","4","8","3","3","9","3"},
            {"Taitung Country","Luye Township ","1","6","4","5","4","8","2","4","9","2"},
            {"Taitung Country","ChishangTownship","1","6","4","5","4","8","2","4","9","2"},
            {"Taitung Country","Donghe Township","1","6","4","4","4","8","2","4","10","2"},
            {"Taitung Country","Changbin Township","1","6","4","4","5","8","1","4","9","1"},
            {"Taitung Country","Taimali Township","1","6","4","5","6","4","3","3","9","2"},
            {"Taitung Country","Dawu Township","1","6","4","4","3","9","1","5","9","1"},
            {"Taitung Country","LudaoTownship","1","6","4","4","4","9","1","5","9","1"},
            {"Taitung Country","Haiduan Township","1","6","3","3","7","5","1","5","10","1"},
            {"Taitung Country","Yanping Township","1","6","4","3","5","8","1","5","10","1"},
            {"Taitung Country","JinfengTownship","1","6","4","3","6","8","1","5","10","1"},
            {"Taitung Country","Daren Township","1","6","4","3","7","5","1","5","10","1"},
            {"Taitung Country","Lanyu Township","1","6","4","4","5","8","1","5","9","1"},
            {"Hualien Country","HualienCity","1","5","5","10","1","9","9","1","2","9"},
            {"Hualien Country","FenglinTownship","1","5","5","5","6","4","4","3","9","2"},
            {"Hualien Country","Yuli Township","1","4","4","7","3","8","5","2","9","4"},
            {"Hualien Country","XinchengTownship","1","5","5","7","3","9","5","3","5","4"},
            {"Hualien Country","Jian Township","1","5","5","9","2","8","9","1","4","8"},
            {"Hualien Country","ShoufengTownship","1","4","5","7","3","8","6","2","9","3"},
            {"Hualien Country","Guangfu Township","1","5","5","6","4","8","2","4","9","3"},
            {"Hualien Country","FengbinTownship","1","5","5","3","7","5","1","5","10","1"},
            {"Hualien Country","RuisuiTownship","1","5","5","6","4","8","3","4","9","2"},
            {"Hualien Country","Fuli Township","1","4","5","5","4","8","3","4","9","2"},
            {"Hualien Country","XiulinTownship","1","4","2","6","10","9","3","4","10","3"},
            {"Hualien Country","Wanrong Township","1","4","3","3","7","5","1","6","10","1"},
            {"Hualien Country","ZhuoxiTownship","1","4","2","3","7","5","1","6","10","1"},
            {"Keelung City","ZhongzhengDistrict","4","10","4","9","10","2","5","2","2","6"},
            {"Keelung City","QiduDistrict","4","10","3","9","2","2","6","2","4","7"},
            {"Keelung City","Nuannuan District","4","10","3","7","4","2","4","5","3","5"},
            {"Keelung City","Ren’ai Distric","4","10","4","9","2","1","6","1","1","6"},
            {"Keelung City","Zhongshan District","4","10","4","8","3","2","5","4","2","6"},
            {"Keelung City","Anle District","4","10","3","9","3","2","7","3","2","8"},
            {"Keelung City","XinyiDistrict","4","10","3","8","9","9","5","4","2","7"},
            {"Hsinchu City","East District","2","4","4","10","1","1","10","1","3","10"},
            {"Hsinchu City","North District","2","5","6","10","5","9","9","1","3","9"},
            {"Hsinchu City","XiangshanDistrict ","2","4","3","9","1","10","7","3","6","8"},
            {"Chiayi City","East District ","7","4","2","10","1","1","9","1","4","9"},
            {"Chiayi City","West District","7","4","2","4","10","9","9","4","4","9"}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main29);

        output = (TextView) this.findViewById(R.id.textView38);
        score1 = (TextView) this.findViewById(R.id.score1);
        score2 = (TextView) this.findViewById(R.id.score2);
        score3 = (TextView) this.findViewById(R.id.score3);
        score4 = (TextView) this.findViewById(R.id.score4);
        score5 = (TextView) this.findViewById(R.id.score5);
        score6 = (TextView) this.findViewById(R.id.score6);
        score7 = (TextView) this.findViewById(R.id.score7);
        score8 = (TextView) this.findViewById(R.id.score8);
        score9 = (TextView) this.findViewById(R.id.score9);
        score10 = (TextView) this.findViewById(R.id.score10);

        //Button button89 = (Button) findViewById(R.id.button89);
        Button backBTN = (Button) findViewById(R.id.backBTN);
        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity29.this, MainActivity2.class);
                startActivity(intent);

            }
        });

        lc = (LocationManager)
                getSystemService(LOCATION_SERVICE);
        //檢查是否有啟動GPS
        if (!lc.isProviderEnabled(
                LocationManager.GPS_PROVIDER)) {
            //顯示對話方塊啟用GPS
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("定位管理").setMessage("GPS目前狀態是尚未啟用.\n" + "請問你是否現在就設定啟用GPS?").setPositiveButton("啟用", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //使用物件啟動設定程式來更改GPS設定
                    Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(i);
                }
            })
                    .setNegativeButton("不啟用", null).create().show();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
        ////////////////////////////
        /* 測試show資料庫
        final TextView showdata = (TextView) findViewById(R.id.score3);
        final StringBuilder x1 = new StringBuilder();
        final StringBuilder x2 = new StringBuilder();
        final StringBuilder x3 = new StringBuilder();
        final StringBuilder x4 = new StringBuilder();
        final StringBuilder x5 = new StringBuilder();
        final StringBuilder x6 = new StringBuilder();
        final StringBuilder x7 = new StringBuilder();
        final StringBuilder x8 = new StringBuilder();
        final StringBuilder x9 = new StringBuilder();



        for (int i = 0; i < 351; i++) {
            if(data[i][1].equals(addresstext)){
                x1.append(data[i][2]);
                x2.append(data[i][3]);
                x3.append(data[i][4]);
                x4.append(data[i][5]);
                x5.append(data[i][6]);
                x6.append(data[i][7]);
                x7.append(data[i][8]);
                x8.append(data[i][9]);
                x9.append(data[i][10]);
            } }

        score1.setText(x1); score2.setText(x2); score3.setText(x3); score4.setText(x4); score5.setText(x5);
        score6.setText(x6); score7.setText(x7); score8.setText(x8); score9.setText(x9);


        button89.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });*/




        }


    @Override
        protected void onResume() {
            super.onResume();
            ll = new MainActivity29.MyLocationListener();
            int minTime = 1000; //毫秒
            float minDistance = 1; //公尺
            try { //註冊更新的傾聽者物件
                lc.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, ll);
                lc.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, minTime, minDistance, ll);
            } catch (SecurityException sex) {
                Log.e("Ch18_4_2", "GPS權限失敗..." + sex.getMessage());
            }
        }

        @Override
        protected void onPause() {
            super.onPause();
            try { //取消註冊更新的傾聽者物件
                lc.removeUpdates(ll);
            } catch (SecurityException sex) {
                Log.e("Ch18_4_2", "GPS權限失敗..." + sex.getMessage());
            }
        }

        class MyLocationListener implements LocationListener {
        @RequiresApi(api = Build.VERSION_CODES.O)
        public void onLocationChanged(Location current) {
            //double lat,lng;
            if (current != null) {
                currentLocation = current;
                //取得經緯度
                //lat = current.getLatitude();
                //lng = current.getLongitude();
                Toast.makeText(MainActivity29.this, "經緯度座標變更....", Toast.LENGTH_SHORT).show();
            }
            Geocoder geocoder = new Geocoder(MainActivity29.this);
            List<Address> addresses = null;
            String country = null;
            float latitude = (float) currentLocation.getLatitude();
            float longitude = (float) currentLocation.getLongitude();
            try {
                addresses = geocoder.getFromLocation(latitude, longitude, 1); //放入座標
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (addresses != null && addresses.size() > 0) {
                Address address = addresses.get(0);
                addresstext =
                        //address.getAdminArea(), //城市
                        address.getLocality() //區
                //address.getThoroughfare(), //路
                //address.getSubThoroughfare() //巷號
                ;
                output.setText(addresstext);
            }
            ShowData();
        }

        ////測試show資料庫
        private void ShowData() {
            final StringBuilder x1 = new StringBuilder();
            final StringBuilder x2 = new StringBuilder();
            final StringBuilder x3 = new StringBuilder();
            final StringBuilder x4 = new StringBuilder();
            final StringBuilder x5 = new StringBuilder();
            final StringBuilder x6 = new StringBuilder();
            final StringBuilder x7 = new StringBuilder();
            final StringBuilder x8 = new StringBuilder();
            final StringBuilder x9 = new StringBuilder();
            final StringBuilder x10 = new StringBuilder();
            for (int i = 0; i < 351; i++) {
                if(data[i][1].equals(addresstext)){
                    x1.append(data[i][2]);
                    x2.append(data[i][3]);
                    x3.append(data[i][4]);
                    x4.append(data[i][5]);
                    x5.append(data[i][6]);
                    x6.append(data[i][7]);
                    x7.append(data[i][8]);
                    x8.append(data[i][9]);
                    x9.append(data[i][10]);
                    x10.append(data[i][11]);
                } }
            score1.setText(x1); score2.setText(x2); score3.setText(x3); score4.setText(x4); score5.setText(x5);
            score6.setText(x6); score7.setText(x7); score8.setText(x8); score9.setText(x9); score10.setText(x10);

            // 文字匡背景依程度變色
/**
            LinearLayout id1 = null;
            if("1".equals(x1.toString())){ id1.setBackgroundResource(R.drawable.v2level1); }
            else if("2".equals(x1.toString())){ id1.setBackgroundResource(R.drawable.v2level2); }
            else if("3".equals(x1.toString())){ id1.setBackgroundResource(R.drawable.v2level3); }
            else if("4".equals(x1.toString())){ id1.setBackgroundResource(R.drawable.v2level4); }
            else if("5".equals(x1.toString())){ id1.setBackgroundResource(R.drawable.v2level5); }
            else if("6".equals(x1.toString())){ id1.setBackgroundResource(R.drawable.v2level6); }
            else if("7".equals(x1.toString())){ id1.setBackgroundResource(R.drawable.v2level7); }
            else if("8".equals(x1.toString())){ id1.setBackgroundResource(R.drawable.v2level8); }
            else if("9".equals(x1.toString())){ id1.setBackgroundResource(R.drawable.v2level9); }
            else if("10".equals(x1.toString())){ id1.setBackgroundResource(R.drawable.v2level10); }
**/

            if("1".equals(x1.toString())){ score1.setBackgroundResource(R.color.level1); } else if("2".equals(x1.toString())){ score1.setBackgroundResource(R.color.level2); }
            else if("3".equals(x1.toString())){ score1.setBackgroundResource(R.color.level3); } else if("4".equals(x1.toString())){ score1.setBackgroundResource(R.color.level4); }
            else if("5".equals(x1.toString())){ score1.setBackgroundResource(R.color.level5); } else if("6".equals(x1.toString())){ score1.setBackgroundResource(R.color.level6); }
            else if("7".equals(x1.toString())){ score1.setBackgroundResource(R.color.level7); } else if("8".equals(x1.toString())){ score1.setBackgroundResource(R.color.level8); }
            else if("9".equals(x1.toString())){ score1.setBackgroundResource(R.color.level9); } else if("10".equals(x1.toString())){ score1.setBackgroundResource(R.color.level10); }

            if("1".equals(x2.toString())){ score2.setBackgroundResource(R.color.level1); } else if("2".equals(x2.toString())){ score2.setBackgroundResource(R.color.level2); }
            else if("3".equals(x2.toString())){ score2.setBackgroundResource(R.color.level3); } else if("4".equals(x2.toString())){ score2.setBackgroundResource(R.color.level4); }
            else if("5".equals(x2.toString())){ score2.setBackgroundResource(R.color.level5); } else if("6".equals(x2.toString())){ score2.setBackgroundResource(R.color.level6); }
            else if("7".equals(x2.toString())){ score2.setBackgroundResource(R.color.level7); } else if("8".equals(x2.toString())){ score2.setBackgroundResource(R.color.level8); }
            else if("9".equals(x2.toString())){ score2.setBackgroundResource(R.color.level9); } else if("10".equals(x2.toString())){ score2.setBackgroundResource(R.color.level10); }

            if("1".equals(x3.toString())){ score3.setBackgroundResource(R.color.level1); } else if("2".equals(x3.toString())){ score3.setBackgroundResource(R.color.level2); }
            else if("3".equals(x3.toString())){ score3.setBackgroundResource(R.color.level3); } else if("4".equals(x3.toString())){ score3.setBackgroundResource(R.color.level4); }
            else if("5".equals(x3.toString())){ score3.setBackgroundResource(R.color.level5); } else if("6".equals(x3.toString())){ score3.setBackgroundResource(R.color.level6); }
            else if("7".equals(x3.toString())){ score3.setBackgroundResource(R.color.level7); } else if("8".equals(x3.toString())){ score3.setBackgroundResource(R.color.level8); }
            else if("9".equals(x3.toString())){ score3.setBackgroundResource(R.color.level9); } else if("10".equals(x3.toString())){ score3.setBackgroundResource(R.color.level10); }

            if("1".equals(x4.toString())){ score4.setBackgroundResource(R.color.level1); } else if("2".equals(x4.toString())){ score4.setBackgroundResource(R.color.level2); }
            else if("3".equals(x4.toString())){ score4.setBackgroundResource(R.color.level3); } else if("4".equals(x4.toString())){ score4.setBackgroundResource(R.color.level4); }
            else if("5".equals(x4.toString())){ score4.setBackgroundResource(R.color.level5); } else if("6".equals(x4.toString())){ score4.setBackgroundResource(R.color.level6); }
            else if("7".equals(x4.toString())){ score4.setBackgroundResource(R.color.level7); } else if("8".equals(x4.toString())){ score4.setBackgroundResource(R.color.level8); }
            else if("9".equals(x4.toString())){ score4.setBackgroundResource(R.color.level9); } else if("10".equals(x4.toString())){ score4.setBackgroundResource(R.color.level10); }

            if("1".equals(x5.toString())){ score5.setBackgroundResource(R.color.level1); } else if("2".equals(x5.toString())){ score5.setBackgroundResource(R.color.level2); }
            else if("3".equals(x5.toString())){ score5.setBackgroundResource(R.color.level3); } else if("4".equals(x5.toString())){ score5.setBackgroundResource(R.color.level4); }
            else if("5".equals(x5.toString())){ score5.setBackgroundResource(R.color.level5); } else if("6".equals(x5.toString())){ score5.setBackgroundResource(R.color.level6); }
            else if("7".equals(x5.toString())){ score5.setBackgroundResource(R.color.level7); } else if("8".equals(x5.toString())){ score5.setBackgroundResource(R.color.level8); }
            else if("9".equals(x5.toString())){ score5.setBackgroundResource(R.color.level9); } else if("10".equals(x5.toString())){ score5.setBackgroundResource(R.color.level10); }

            if("1".equals(x6.toString())){ score6.setBackgroundResource(R.color.level1); } else if("2".equals(x6.toString())){ score6.setBackgroundResource(R.color.level2); }
            else if("3".equals(x6.toString())){ score6.setBackgroundResource(R.color.level3); } else if("4".equals(x6.toString())){ score6.setBackgroundResource(R.color.level4); }
            else if("5".equals(x6.toString())){ score6.setBackgroundResource(R.color.level5); } else if("6".equals(x6.toString())){ score6.setBackgroundResource(R.color.level6); }
            else if("7".equals(x6.toString())){ score6.setBackgroundResource(R.color.level7); } else if("8".equals(x6.toString())){ score6.setBackgroundResource(R.color.level8); }
            else if("9".equals(x6.toString())){ score6.setBackgroundResource(R.color.level9); } else if("10".equals(x6.toString())){ score6.setBackgroundResource(R.color.level10); }

            if("1".equals(x7.toString())){ score7.setBackgroundResource(R.color.level1); } else if("2".equals(x7.toString())){ score7.setBackgroundResource(R.color.level2); }
            else if("3".equals(x7.toString())){ score7.setBackgroundResource(R.color.level3); } else if("4".equals(x7.toString())){ score7.setBackgroundResource(R.color.level4); }
            else if("5".equals(x7.toString())){ score7.setBackgroundResource(R.color.level5); } else if("6".equals(x7.toString())){ score7.setBackgroundResource(R.color.level6); }
            else if("7".equals(x7.toString())){ score7.setBackgroundResource(R.color.level7); } else if("8".equals(x7.toString())){ score7.setBackgroundResource(R.color.level8); }
            else if("9".equals(x7.toString())){ score7.setBackgroundResource(R.color.level9); } else if("10".equals(x7.toString())){ score7.setBackgroundResource(R.color.level10); }

            if("1".equals(x8.toString())){ score8.setBackgroundResource(R.color.level1); } else if("2".equals(x8.toString())){ score8.setBackgroundResource(R.color.level2); }
            else if("3".equals(x8.toString())){ score8.setBackgroundResource(R.color.level3); } else if("4".equals(x8.toString())){ score8.setBackgroundResource(R.color.level4); }
            else if("5".equals(x8.toString())){ score8.setBackgroundResource(R.color.level5); } else if("6".equals(x8.toString())){ score8.setBackgroundResource(R.color.level6); }
            else if("7".equals(x8.toString())){ score8.setBackgroundResource(R.color.level7); } else if("8".equals(x8.toString())){ score8.setBackgroundResource(R.color.level8); }
            else if("9".equals(x8.toString())){ score8.setBackgroundResource(R.color.level9); } else if("10".equals(x8.toString())){ score8.setBackgroundResource(R.color.level10); }

            if("1".equals(x9.toString())){ score9.setBackgroundResource(R.color.level1); } else if("2".equals(x9.toString())){ score9.setBackgroundResource(R.color.level2); }
            else if("3".equals(x9.toString())){ score9.setBackgroundResource(R.color.level3); } else if("4".equals(x9.toString())){ score9.setBackgroundResource(R.color.level4); }
            else if("5".equals(x9.toString())){ score9.setBackgroundResource(R.color.level5); } else if("6".equals(x9.toString())){ score9.setBackgroundResource(R.color.level6); }
            else if("7".equals(x9.toString())){ score9.setBackgroundResource(R.color.level7); } else if("8".equals(x9.toString())){ score9.setBackgroundResource(R.color.level8); }
            else if("9".equals(x9.toString())){ score9.setBackgroundResource(R.color.level9); } else if("10".equals(x9.toString())){ score9.setBackgroundResource(R.color.level10); }

            if("1".equals(x10.toString())){ score10.setBackgroundResource(R.color.level1); } else if("2".equals(x10.toString())){ score10.setBackgroundResource(R.color.level2); }
            else if("3".equals(x10.toString())){ score10.setBackgroundResource(R.color.level3); } else if("4".equals(x10.toString())){ score10.setBackgroundResource(R.color.level4); }
            else if("5".equals(x10.toString())){ score10.setBackgroundResource(R.color.level5); } else if("6".equals(x10.toString())){ score10.setBackgroundResource(R.color.level6); }
            else if("7".equals(x10.toString())){ score10.setBackgroundResource(R.color.level7); } else if("8".equals(x10.toString())){ score10.setBackgroundResource(R.color.level8); }
            else if("9".equals(x10.toString())){ score10.setBackgroundResource(R.color.level9); } else if("10".equals(x10.toString())){ score10.setBackgroundResource(R.color.level10); }

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }


}