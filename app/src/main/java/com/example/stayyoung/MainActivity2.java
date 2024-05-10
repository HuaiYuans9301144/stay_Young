package com.example.stayyoung;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.Ringtone;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.VibrationEffect;
import android.provider.Settings;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import android.location.Address;
import android.location.Geocoder;
import com.google.android.gms.maps.GoogleMap;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity2 extends AppCompatActivity {
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 101;
    private TextView output;
    private LocationManager lc;
    private Location currentLocation = null;
    private LocationListener ll;
    private NotificationManager nm;
    private static Ringtone mRingtone;
    private String addresstext = null;

    private final String [][] data = {  // 資料匯入
            //台北市
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
                    {"Kaohsiung City","QiedingDistrict","9","3","9","1","8","7","4","8","3","5"},
                    {"Kaohsiung City","Yong’an District","9","3","9","7","10","8","4","8","7","3"},
                    {"Kaohsiung City","Mituo District","9","3","9","1","9","7","4","8","4","4"},
                    {"Kaohsiung City","ZiguanDistrict","9","3","10","1","8","7","6","8","3","6"},
                    {"Kaohsiung City","QishanDistrict","10","1","4","4","2","10","7","8","6","6"},
                    {"Kaohsiung City","Meinong District","10","1","3","1","8","7","6","8","7","6"},
                    {"Kaohsiung City","LiuguiDistrict","10","1","1","1","9","7","4","8","9","3"},
                    {"Kaohsiung City","JiaxianDistrict","10","1","2","1","9","7","4","8","9","1"},
                    {"Kaohsiung City","Shanlin Distric","10","1","3","1","8","7","4","8","9","2"},
                    {"Kaohsiung City","Neimen District","10","1","4","1","8","7","4","8","9","3"},
                    {"Kaohsiung City","Maolin District","10","1","1","1","9","7","3","8","10","1"},
                    {"Kaohsiung City","Taoyuan District","10","1","1","1","8","7","3","8","10","1"},
                    {"Kaohsiung City","Namaxia District","10","1","1","1","9","7","2","8","10","1"},
                    {"New TaipeiCity","Banqiao District","5","9","3","3","9","5","10","10","1","10"},
                    {"New TaipeiCity","Sanchong District","4","10","3","3","9","5","10","10","1","10"},
                    {"New TaipeiCity","Zhonghe District","5","9","3","3","9","5","10","10","1","10"},
                    {"New TaipeiCity","Yonghe District","4","10","3","2","8","6","8","10","1","10"},
                    {"New TaipeiCity","Xinzhuang District","4","9","3","3","9","5","10","10","1","10"},
                    {"New TaipeiCity","Xindian District","5","9","2","4","10","9","10","10","2","10"},
                    {"New TaipeiCity","Shulin District","5","9","3","5","10","9","10","9","2","10"},
                    {"New TaipeiCity","Yingge District","5","9","3","2","9","6","8","10","2","8"},
                    {"New TaipeiCity","Sanxia District","5","8","1","2","9","6","8","10","5","9"},
                    {"New TaipeiCity","Tamsui District","5","9","2","2","9","6","8","10","2","10"},
                    {"New TaipeiCity","Xizhi District","5","9","2","3","10","5","9","10","2","10"},
                    {"New TaipeiCity","Ruifang District","5","9","2","2","9","6","6","9","5","6"},
                    {"New TaipeiCity","Tucheng District","5","9","3","3","9","5","10","10","2","10"},
                    {"New TaipeiCity","Luzhou District","4","10","3","2","9","6","8","10","1","10"},
                    {"New TaipeiCity","Wugu District","5","9","3","2","9","6","8","10","3","8"},
                    {"New TaipeiCity","Taishan District","4","10","3","2","9","6","8","9","2","8"},
                    {"New TaipeiCity","Linkou District","5","9","2","5","10","8","8","10","3","9"},
                    {"New TaipeiCity","Shenkeng District","5","9","3","1","9","7","6","9","4","4"},
                    {"New TaipeiCity","Shiding District","5","8","2","1","9","7","4","10","10","2"},
                    {"New TaipeiCity","Pinglin District","5","8","2","1","9","7","4","10","10","1"},
                    {"New TaipeiCity","Sanzhi District","5","9","2","1","9","7","6","9","6","4"},
                    {"New TaipeiCity","Shimen District","5","9","2","1","8","7","5","9","8","2"},
                    {"New TaipeiCity","Bali District","5","9","3","8","1","10","7","9","4","6"},
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
                    {"Taichung City","Fengyuan District ","3","5","4","2","7","6","10","9","2","9"},
                    {"Taichung City","Dongshi District","4","4","2","1","8","7","7","9","7","6"},
                    {"Taichung City","Dajia District","3","4","3","2","9","6","8","9","4","8"},
                    {"Taichung City","Qingshui District","4","4","3","2","8","6","8","9","4","8"},
                    {"Taichung City","Shalu District","3","5","4","2","8","6","9","9","3","8"},
                    {"Taichung City","Wuqi District","3","6","6","3","10","5","8","9","2","7"},
                    {"Taichung City","Houli District","3","4","3","4","10","9","8","9","5","6"},
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
                    {"Tainan City","Xuejia District","6","1","10","7","4","3","6","7","6","5"},
                    {"Tainan City","Xigang District","5","2","10","7","4","3","5","7","5","5"},
                    {"Tainan City","Qigu District","7","1","7","5","6","4","5","7","8","4"},
                    {"Tainan City","Jiangjun District","6","2","10","5","6","4","4","7","7","4"},
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
    private final String [][] data2 = {{"臺北市","松山區","2","7","3","2","7","6","8","10","1","10"},
            {"臺北市","信義區","2","6","3","2","7","6","8","10","1","10"},
            {"臺北市","大安區","2","6","3","2","7","6","9","10","1","10"},
            {"臺北市","中山區","2","6","3","2","7","6","9","10","1","10"},
            {"臺北市","中正區","2","7","3","2","8","6","8","10","1","9"},
            {"臺北市","大同區","2","7","4","2","8","6","7","10","1","9"},
            {"臺北市","萬華區","2","7","3","2","7","6","8","10","1","10"},
            {"臺北市","文山區","2","5","2","6","10","10","9","10","1","10"},
            {"臺北市","南港區","2","6","2","2","8","6","7","10","2","9"},
            {"臺北市","內湖區","2","5","2","6","10","10","10","10","1","10"},
            {"臺北市","士林區","2","4","1","2","7","6","9","10","2","10"},
            {"臺北市","北投區","2","4","1","2","7","6","9","10","2","10"},
            {"高雄市","鹽埕區","9","3","10","1","8","7","4","8","1","4"},
            {"高雄市","鼓山區","9","3","10","3","10","5","7","9","1","9"},
            {"高雄市","左營區","9","3","9","2","7","6","9","9","1","10"},
            {"高雄市","楠梓區","9","3","8","2","9","6","9","9","1","10"},
            {"高雄市","三民區","9","3","9","5","10","9","10","9","1","10"},
            {"高雄市","新興區","9","3","10","1","8","7","5","8","1","7"},
            {"高雄市","前金區","9","3","10","1","8","7","5","8","1","4"},
            {"高雄市","苓雅區","9","3","10","2","7","6","9","8","1","10"},
            {"高雄市","前鎮區","9","3","9","4","10","8","9","8","1","10"},
            {"高雄市","旗津區","9","3","10","1","8","7","4","8","2","5"},
            {"高雄市","小港區","10","3","7","8","10","10","9","8","2","9"},
            {"高雄市","鳳山區","9","3","8","3","9","5","10","9","1","10"},
            {"高雄市","林園區","10","3","8","3","10","5","7","8","3","8"},
            {"高雄市","大寮區","10","2","6","4","10","10","10","8","3","9"},
            {"高雄市","大樹區","10","2","6","1","8","7","6","8","6","6"},
            {"高雄市","大社區","9","3","8","2","9","6","6","8","4","5"},
            {"高雄市","仁武區","10","3","8","7","10","10","8","8","3","8"},
            {"高雄市","鳥松區","9","3","8","2","8","6","6","8","3","6"},
            {"高雄市","岡山區","10","2","7","7","10","10","9","8","3","9"},
            {"高雄市","橋頭區","9","3","8","1","8","7","5","8","3","6"},
            {"高雄市","燕巢區","10","2","6","4","2","10","7","8","7","5"},
            {"高雄市","田寮區","10","2","4","1","9","7","2","8","9","1"},
            {"高雄市","阿蓮區","10","3","8","1","8","7","4","8","5","5"},
            {"高雄市","路竹區","10","2","7","4","3","10","7","8","4","7"},
            {"高雄市","湖內區","9","3","9","3","5","8","6","8","3","5"},
            {"高雄市","茄萣區","9","3","9","1","8","7","4","8","3","5"},
            {"高雄市","永安區","9","3","9","7","10","8","4","8","7","3"},
            {"高雄市","彌陀區","9","3","9","1","9","7","4","8","4","4"},
            {"高雄市","梓官區","9","3","10","1","8","7","6","8","3","6"},
            {"高雄市","旗山區","10","1","4","4","2","10","7","8","6","6"},
            {"高雄市","美濃區","10","1","3","1","8","7","6","8","7","6"},
            {"高雄市","六龜區","10","1","1","1","9","7","4","8","9","3"},
            {"高雄市","甲仙區","10","1","2","1","9","7","4","8","9","1"},
            {"高雄市","杉林區","10","1","3","1","8","7","4","8","9","2"},
            {"高雄市","內門區","10","1","4","1","8","7","4","8","9","3"},
            {"高雄市","茂林區","10","1","1","1","9","7","3","8","10","1"},
            {"高雄市","桃源區","10","1","1","1","8","7","3","8","10","1"},
            {"高雄市","那瑪夏區","10","1","1","1","9","7","2","8","10","1"},
            {"新北市","板橋區","5","9","3","3","9","5","10","10","1","10"},
            {"新北市","三重區","4","10","3","3","9","5","10","10","1","10"},
            {"新北市","中和區","5","9","3","3","9","5","10","10","1","10"},
            {"新北市","永和區","4","10","3","2","8","6","8","10","1","10"},
            {"新北市","新莊區","4","9","3","3","9","5","10","10","1","10"},
            {"新北市","新店區","5","9","2","4","10","9","10","10","2","10"},
            {"新北市","樹林區","5","9","3","5","10","9","10","9","2","10"},
            {"新北市","樹林區","5","9","3","2","9","6","8","10","2","8"},
            {"新北市","三峽區","5","8","1","2","9","6","8","10","5","9"},
            {"新北市","淡水區","5","9","2","2","9","6","8","10","2","10"},
            {"新北市","汐止區","5","9","2","3","10","5","9","10","2","10"},
            {"新北市","瑞芳區","5","9","2","2","9","6","6","9","5","6"},
            {"新北市","土城區","5","9","3","3","9","5","10","10","2","10"},
            {"新北市","蘆洲區","4","10","3","2","9","6","8","10","1","10"},
            {"新北市","五股區","5","9","3","2","9","6","8","10","3","8"},
            {"新北市","泰山區 ","4","10","3","2","9","6","8","9","2","8"},
            {"新北市","林口區","5","9","2","5","10","8","8","10","3","9"},
            {"新北市","深坑區","5","9","3","1","9","7","6","9","4","4"},
            {"新北市","石碇區","5","8","2","1","9","7","4","10","10","2"},
            {"新北市","坪林區 ","5","8","2","1","9","7","4","10","10","1"},
            {"新北市","三芝區","5","9","2","1","9","7","6","9","6","4"},
            {"新北市","石門區","5","9","2","1","8","7","5","9","8","2"},
            {"新北市","八里區","5","9","3","8","1","10","7","9","4","6"},
            {"新北市","平溪區","5","9","2","1","8","7","4","10","9","1"},
            {"新北市","雙溪區","5","8","2","1","9","7","4","10","9","2"},
            {"新北市","金山區","5","9","2","1","8","7","6","9","9","2"},
            {"新北市","金山區","5","9","2","1","8","7","5","10","6","4"},
            {"新北市","萬里區","5","9","2","1","8","7","5","10","7","4"},
            {"新北市","烏來區","5","6","1","1","8","7","4","10","10","1"},
            {"台中市","中區","3","7","7","1","7","8","7","5","9","1","3"},
            {"台中市","東區","3","6","7","2","7","8","6","8","9","1","7"},
            {"台中市","南區","3","6","7","2","7","9","6","8","10","1","9"},
            {"台中市","西區","3","6","7","2","7","8","6","8","9","1","8"},
            {"台中市","北區","3","6","7","2","7","8","6","9","10","1","9"},
            {"台中市","西屯區","3","5","4","2","4","7","6","10","9","2","10"},
            {"台中市","南屯區","3","6","5","5","5","10","9","10","9","2","9"},
            {"台中市","北屯區","3","4","3","2","3","7","6","10","10","2","10"},
            {"台中市","豐原區","3","5","4","2","4","7","6","10","9","2","9"},
            {"台中市","東勢區","4","4","2","1","2","8","7","7","9","7","6"},
            {"台中市","大甲區","3","4","3","2","3","9","6","8","9","4","8"},
            {"台中市","清水區","4","4","3","2","3","8","6","8","9","4","8"},
            {"台中市","沙鹿區","3","5","4","2","4","8","6","9","9","3","8"},
            {"台中市","梧棲區","3","6","6","3","6","10","5","8","9","2","7"},
            {"台中市","后里區","3","4","3","4","3","10","9","8","9","5","6"},
            {"台中市","神岡區","3","5","4","4","4","2","10","8","9","3","7"},
            {"台中市","潭子區","3","6","5","2","5","9","6","8","10","2","8"},
            {"台中市","大雅區","3","6","5","2","5","8","6","8","9","3","8"},
            {"台中市","新社區","4","4","2","2","2","8","6","6","9","7","4"},
            {"台中市","石岡區","3","6","6","1","6","8","7","6","9","6","2"},
            {"台中市","外埔區","3","5","4","7","4","4","3","7","9","6","4"},
            {"台中市","大安區","3","6","5","6","5","5","3","5","9","6","3"},
            {"台中市","烏日區","3","5","4","10","4","5","9","9","8","3","7"},
            {"台中市","大肚區","3","5","4","9","4","2","1","8","9","4","7"},
            {"台中市","龍井區","3","5","4","10","4","10","3","9","9","3","8"},
            {"台中市","霧峰區","4","4","2","9","2","2","1","9","9","6","7"},
            {"台中市","太平區","4","4","1","10","1","1","1","10","7","3","9"},
            {"台中市","大里區","3","6","5","10","5","1","9","10","3","2","10"},
            {"台中市","和平區","8","1","1","4","1","6","4","5","9","10","2"},

            {"台南市","新營區","5","2","10","9","1","10","8","6","3","8"},
            {"台南市","鹽水區","6","1","10","7","3","8","4","7","6","5"},
            {"台南市","白河區","7","1","6","7","4","3","6","7","8","5"},
            {"台南市","柳營區","6","1","9","6","5","3","5","7","7","4"},
            {"台南市","後壁區","6","1","8","6","5","3","5","7","7","5"},
            {"台南市","東山區","7","1","7","5","6","4","5","7","8","4"},
            {"台南市","麻豆區","6","1","10","8","3","2","6","7","5","7"},
            {"台南市","下營區","5","2","10","6","5","3","4","7","5","5"},
            {"台南市","六甲區","6","1","9","6","5","3","5","7","7","4"},
            {"台南市","官田區","6","1","8","7","4","10","6","7","7","4"},
            {"台南市","大內區","6","1","8","4","7","5","2","7","9","2"},
            {"台南市","佳里區","5","2","10","9","3","1","8","7","4","8"},
            {"台南市","學甲區","6","1","10","7","4","3","6","7","6","5"},
            {"台南市","西港區","5","2","10","7","4","3","5","7","5","5"},
            {"台南市","七股區","7","1","7","5","6","4","5","7","8","4"},
            {"台南市","將軍區","6","2","10","5","6","4","4","7","7","4"},
            {"台南市","北門區","6","1","10","4","5","8","2","7","8","3"},
            {"台南市","新化區","6","1","9","8","3","2","7","7","5","7"},
            {"台南市","善化區","6","1","9","8","3","2","7","7","5","7"},
            {"台南市","新市區","6","1","10","8","3","2","8","7","5","6"},
            {"台南市","安定區","5","2","10","8","2","9","7","7","5","6"},
            {"台南市","山上區","5","2","10","4","10","5","6","7","8","2"},
            {"台南市","玉井區","6","1","8","6","5","4","4","7","8","3"},
            {"台南市","楠西區","7","1","7","5","2","10","3","7","9","2"},
            {"台南市","南化區","7","1","5","3","6","8","3","7","10","2"},
            {"台南市","左鎮區","6","1","8","3","7","5","3","7","9","2"},
            {"台南市","仁德區","6","1","10","10","1","10","10","3","3","8"},
            {"台南市","歸仁區","6","1","9","9","1","9","8","7","4","8"},
            {"台南市","關廟區","6","1","10","7","4","3","6","7","6","6"},
            {"台南市","龍崎區","6","1","9","3","7","5","3","7","10","1"},
            {"台南市","永康區","6","2","10","10","1","8","10","1","2","10"},
            {"台南市","東區","5","2","10","10","1","1","10","1","1","10"},
            {"台南市","南區","5","2","10","10","1","1","10","2","2","9"},
            {"台南市","北區","5","2","10","10","1","1","10","2","1","9"},
            {"台南市","安南區","7","1","7","10","10","10","10","1","3","10"},
            {"台南市","安平區","5","2","10","9","2","1","8","6","2","8"},
            {"台南市","中西區","5","2","10","1","8","7","7","7","1","8"},
            {"桃園市","桃園區","7","10","2","10","1","9","10","1","2","10"},
            {"桃園市","中壢區","7","10","2","10","1","9","10","1","2","10"},
            {"桃園市","大溪區","7","9","1","9","2","1","9","7","5","8"},
            {"桃園市","楊梅區","7","9","1","10","1","8","10","6","3","9"},
            {"桃園市","蘆竹區","7","10","2","10","6","1","10","2","3","9"},
            {"桃園市","大園區","7","9","2","9","6","1","10","7","5","8"},
            {"桃園市","龜山區","7","10","2","10","1","1","10","2","3","9"},
            {"桃園市","八德區","7","10","2","10","1","1","10","4","2","9"},
            {"桃園市","龍潭區","7","10","2","10","3","1","10","7","3","8"},
            {"桃園市","平鎮區","7","10","2","10","1","1","10","3","2","9"},
                    {"桃園市","新屋區","7","10","2","8","10","2","7","7","6","5"},
                    {"桃園市","觀音區","7","9","1","9","10","10","8","7","5","7"},
                    {"桃園市","復興區","8","4","1","1","9","7","3","8","10","2"},
                    {"宜蘭縣","宜蘭市","2","8","6","10","1","1","9","1","2","9"},
                    {"宜蘭縣","羅東鎮","2","8","6","10","1","1","7","1","2","8"},
                    {"宜蘭縣","蘇澳鎮","2","8","5","9","10","9","7","2","6","7"},
                    {"宜蘭縣","頭城鎮","2","8","5","8","3","2","5","4","7","5"},
                    {"宜蘭縣","礁溪鄉","2","8","5","8","3","2","6","3","5","6"},
                            {"宜蘭縣","壯圍鄉","2","8","6","6","5","3","4","6","5","4"},
                            {"宜蘭縣","員山鄉","2","8","5","7","4","3","4","5","7","6"},
                            {"宜蘭縣","冬山鄉","2","8","6","9","2","2","7","2","5","7"},
                            {"宜蘭縣","五結鄉","2","8","6","9","10","10","6","3","4","7"},
                            {"宜蘭縣","三星鄉","2","8","5","7","3","9","3","6","8","4"},
                            {"宜蘭縣","大同鄉","2","7","3","3","7","5","1","6","10","2"},
                            {"宜蘭縣","南澳鄉","2","7","3","3","7","5","1","6","10","1"},
                            {"新竹縣","竹北市","3","8","6","10","1","1","10","1","2","9"},
                            {"新竹縣","竹東鎮","3","8","6","9","2","1","8","1","3","8"},
                            {"新竹縣","新埔鎮","3","8","6","7","5","3","6","3","6","5"},
                            {"新竹縣","關西鎮","3","8","5","6","9","3","4","3","8","4"},
                            {"新竹縣","湖口鄉","3","8","6","9","9","1","9","1","4","8"},
                            {"新竹縣","新豐鄉","3","8","6","9","1","10","6","2","4","7"},
                            {"新竹縣","芎林鄉","2","8","6","6","6","3","5","3","6","3"},
                            {"新竹縣","橫山鄉","3","8","6","4","6","4","2","5","8","2"},
                            {"新竹縣","北埔鄉","3","8","6","4","6","4","1","5","8","2"},
                            {"新竹縣","寶山鄉","3","8","6","5","5","4","3","4","8","3"},
                            {"新竹縣","峨眉鄉","3","8","6","4","4","9","1","5","9","1"},
                            {"新竹縣","尖石鄉","3","6","2","4","6","4","1","5","10","2"},
                            {"新竹縣","五峰鄉","3","7","4","3","7","5","1","5","10","1"},
                            {"苗栗縣","苗栗市","4","9","6","9","2","1","9","1","3","8"},
                            {"苗栗縣","苑裡鎮","4","9","5","8","3","2","6","2","6","6"},
                            {"苗栗縣","通霄鎮","4","8","4","8","10","10","5","2","7","5"},
                            {"苗栗縣","竹南鎮","4","9","6","10","4","10","9","1","3","8"},
                            {"苗栗縣","頭份市","4","9","5","10","1","9","9","1","3","9"},
                            {"苗栗縣","後龍鎮","4","9","5","8","3","8","5","2","6","5"},
                            {"苗栗縣","卓蘭鎮","4","8","5","5","6","4","2","4","8","3"},
                            {"苗栗縣","大湖鄉","4","8","4","6","2","10","2","4","8","3"},
                            {"苗栗縣","公館鄉","4","9","5","7","4","3","5","2","6","5"},
                            {"苗栗縣","銅鑼鄉","4","8","5","6","6","8","4","3","8","3"},
                            {"苗栗縣","南庄鄉","4","8","3","5","6","4","2","4","9","2"},
                            {"苗栗縣","頭屋鄉","4","9","5","5","4","8","2","4","8","2"},
                            {"苗栗縣","三義鄉","4","9","5","7","9","3","3","3","8","3"},
                            {"苗栗縣","西湖鄉","4","9","5","4","3","9","1","5","8","1"},
                            {"苗栗縣","造橋鄉","4","9","5","5","4","9","2","4","7","2"},
                            {"苗栗縣","三灣鄉","4","9","5","4","5","8","1","4","9","1"},
                            {"苗栗縣","獅潭鄉","4","8","5","3","6","8","1","5","10","1"},
                            {"苗栗縣","泰安鄉","4","4","1","4","7","5","1","5","10","1"},
                            {"彰化縣","彰化市","7","2","9","10","1","1","10","1","2","10"},
                            {"彰化縣","鹿港鎮","7","2","9","10","10","1","8","1","3","9"},
                            {"彰化縣","和美鎮","7","2","9","10","1","8","9","1","3","9"},
                            {"彰化縣","線西鄉","6","3","10","8","10","2","2","4","5","4"},
                            {"彰化縣","伸港鄉","6","3","10","8","9","2","5","3","4","6"},
                            {"彰化縣","福興鄉","7","2","9","9","3","2","7","2","5","7"},
                            {"彰化縣","秀水鄉","6","3","10","9","2","2","6","2","4","6"},
                            {"彰化縣","花壇鄉","6","2","9","9","2","2","7","2","4","7"},
                            {"彰化縣","芬園鄉","6","2","9","6","5","3","4","4","6","4"},
                            {"彰化縣","員林市","7","2","9","10","1","1","9","1","3","9"},
                            {"彰化縣","溪湖鎮","6","3","10","9","2","1","7","1","4","7"},
                            {"彰化縣","田中鎮","6","3","9","8","4","2","7","2","4","7"},
                            {"彰化縣","大村鄉","6","3","10","8","3","2","4","3","5","6"},
                            {"彰化縣","埔鹽鄉","6","2","9","8","3","2","4","3","5","6"},
                            {"彰化縣","埔心鄉","6","3","10","8","3","2","5","2","4","6"},
                            {"彰化縣","永靖鄉","6","3","10","8","3","2","5","3","4","6"},
                            {"彰化縣","社頭鄉","6","2","9","8","3","2","6","2","5","7"},
                            {"彰化縣","二水鄉","6","3","10","4","6","4","2","5","6","3"},
                            {"彰化縣","北斗鎮","6","3","10","8","3","2","5","2","3","6"},
                                    {"彰化縣","二林鎮","7","2","8","8","2","2","7","2","6","7"},
                                    {"彰化縣","田尾鄉","6","3","10","7","4","3","4","4","4","5"},
                                    {"彰化縣","埤頭鄉","7","2","9","7","4","2","6","3","5","5"},
                                    {"彰化縣","芳苑鄉","7","2","8","7","2","10","5","3","7","6"},
                                    {"彰化縣","大城鄉","7","2","9","5","6","4","1","6","8","3"},
                                    {"彰化縣","竹塘鄉","7","2","9","5","6","4","2","5","7","3"},
                                    {"彰化縣","溪州鄉","7","2","9","6","10","10","3","6","7","5"},
                                    {"南投縣","南投市","1","4","6","10","2","10","9","1","4","9"},
                                    {"南投縣","埔里鎮","2","4","6","9","2","1","9","1","6","8"},
                                    {"南投縣","草屯鎮","1","4","6","10","1","1","10","1","5","9"},
                                    {"南投縣","竹山鎮","2","3","5","9","1","10","7","1","8","7"},
                                            {"南投縣","集集鎮","1","4","6","5","5","8","2","4","8","2"},
                                            {"南投縣","名間鄉","1","4","6","7","4","2","7","2","7","6"},
                                            {"南投縣","鹿谷鄉","2","4","6","6","5","3","3","3","9","3"},
                                            {"南投縣","中寮鄉","2","4","6","4","6","4","1","5","9","3"},
                                            {"南投縣","魚池鄉","1","4","6","7","4","3","3","3","9","3"},
                                            {"南投縣","國姓鄉","2","4","5","6","5","4","3","4","9","3"},
                                            {"南投縣","水里鄉","1","4","6","6","5","3","3","3","8","3"},
                                            {"南投縣","信義鄉","2","1","1","4","6","4","2","5","10","3"},
                                            {"南投縣","仁愛鄉","2","2","1","5","5","4","2","4","10","3"},
                                            {"雲林縣","斗六市","8","4","7","10","2","1","9","1","4","9"},
                                            {"雲林縣","斗南鎮","8","5","7","9","2","9","7","1","4","7"},
                                            {"雲林縣","虎尾鎮","8","5","7","9","1","8","8","1","4","8"},
                                            {"雲林縣","西螺鎮","8","5","7","8","3","2","7","2","5","7"},
                                            {"雲林縣","土庫鎮","8","5","7","7","2","9","4","3","6","5"},
                                            {"雲林縣","北港鎮","7","5","8","8","3","2","6","2","4","7"},
                                            {"雲林縣","古坑鄉","8","4","7","7","4","3","5","3","8","6"},
                                            {"雲林縣","大埤鄉","7","5","8","6","7","3","3","4","6","4"},
                                            {"雲林縣","莿桐鄉","8","5","7","8","2","10","4","3","6","5"},
                                            {"雲林縣","林內鄉","7","5","8","5","4","8","3","4","6","4"},
                                            {"雲林縣","二崙鄉","8","5","7","6","3","9","3","4","6","5"},
                                            {"雲林縣","崙背鄉","8","5","7","7","3","8","3","3","7","5"},
                                            {"雲林縣","麥寮鄉","8","5","7","10","10","1","7","2","7","7"},
                                            {"雲林縣","東勢鄉","8","5","7","5","4","8","2","5","7","3"},
                                            {"雲林縣","褒忠鄉","7","5","8","5","4","9","2","5","7","3"},
                                            {"雲林縣","臺西鄉","8","5","7","5","6","4","2","5","7","4"},
                                            {"雲林縣","元長鄉","8","5","7","6","5","3","4","3","7","5"},
                                            {"雲林縣","四湖鄉","8","5","7","6","2","10","3","4","8","4"},
                                            {"雲林縣","口湖鄉","8","4","7","5","5","4","3","4","8","5"},
                                            {"雲林縣","水林鄉","8","5","7","6","5","3","2","4","7","5"},
                                            {"嘉義縣","太保市","10","10","1","8","5","2","7","2","5","7"},
                                            {"嘉義縣","朴子市","10","10","1","8","2","9","7","2","5","7"},
                                            {"嘉義縣","布袋鎮","10","10","1","6","5","3","6","3","6","6"},
                                            {"嘉義縣","大林鎮","10","10","1","7","3","8","6","2","6","6"},
                                            {"嘉義縣","民雄鄉","10","10","1","9","10","10","9","1","5","8"},
                                            {"嘉義縣","溪口鄉","10","10","1","4","6","4","1","5","7","4"},
                                            {"嘉義縣","新港鄉","10","10","1","7","2","9","4","3","7","6"},
                                            {"嘉義縣","六腳鄉","10","10","1","6","5","3","3","5","7","5"},
                                            {"嘉義縣","東石鄉","10","10","1","5","6","4","2","5","8","5"},
                                            {"嘉義縣","義竹鄉","10","10","1","5","6","4","2","5","8","4"},
                                            {"嘉義縣","鹿草鄉","10","10","1","7","10","10","2","5","8","4"},
                                            {"嘉義縣","水上鄉","10","10","1","8","2","9","7","2","5","8"},
                                            {"嘉義縣","中埔鄉","10","10","1","8","3","2","8","2","7","7"},
                                            {"嘉義縣","竹崎鄉","10","10","1","7","2","9","5","3","8","7"},
                                            {"嘉義縣","梅山鄉","10","10","1","6","5","4","3","5","8","4"},
                                            {"嘉義縣","番路鄉","10","10","1","4","6","4","2","5","9","3"},
                                            {"嘉義縣","大埔鄉","10","10","1","3","7","5","1","6","10","1"},
                                            {"嘉義縣","阿里山鄉","10","10","1","4","6","4","1","5","10","2"},
                                            {"屏東縣","屏東市","9","7","8","10","1","1","10","1","2","10"},
                                            {"屏東縣","潮州鎮","8","7","8","9","2","1","8","1","4","8"},
                                            {"屏東縣","東港鎮","8","7","9","9","1","10","6","2","4","7"},
                                            {"屏東縣","恆春鎮","9","7","7","9","1","10","6","2","8","6"},
                                            {"屏東縣","萬丹鄉","8","7","8","8","3","2","7","3","5","7"},
                                            {"屏東縣","長治鄉","8","7","8","7","4","3","6","4","5","6"},
                                            {"屏東縣","麟洛鄉","8","8","9","4","6","4","3","6","5","3"},
                                            {"屏東縣","九如鄉","8","7","8","6","5","3","3","6","6","4"},
                                            {"屏東縣","里港鄉","9","7","8","7","4","3","5","5","7","5"},
                                            {"屏東縣","鹽埔鄉","9","7","8","6","5","3","3","6","7","5"},
                                            {"屏東縣","高樹鄉","9","7","8","6","5","3","4","6","8","5"},
                                            {"屏東縣","萬巒鄉","9","7","8","5","5","4","3","6","7","4"},
                                            {"屏東縣","內埔鄉","9","7","8","9","4","2","7","2","5","8"},
                                            {"屏東縣","竹田鄉","8","7","9","5","6","4","4","6","6","4"},
                                            {"屏東縣","新埤鄉","8","7","8","4","6","5","2","6","8","2"},
                                            {"屏東縣","枋寮鄉","8","7","8","8","2","10","5","4","6","5"},
                                            {"屏東縣","新園鄉","8","7","8","7","4","3","5","5","5","6"},
                                            {"屏東縣","崁頂鄉","8","7","8","8","10","10","1","6","7","3"},
                                            {"屏東縣","林邊鄉","8","8","9","6","5","4","2","6","4","4"},
                                            {"屏東縣","南州鄉","8","7","9","5","3","9","3","6","6","3"},
                                            {"屏東縣","佳冬鄉","8","7","9","5","6","4","2","6","6","4"},
                                            {"屏東縣","琉球鄉","8","8","9","5","6","4","2","6","4","3"},
                                            {"屏東縣","車城鄉","8","7","8","4","6","4","2","6","8","2"},
                                            {"屏東縣","滿州鄉","9","7","7","3","7","5","2","6","10","2"},
                                            {"屏東縣","枋山鄉","8","8","9","4","7","5","3","6","7","1"},
                                            {"屏東縣","三地門鄉","9","7","7","3","7","5","1","6","10","2"},
                                            {"屏東縣","霧臺鄉","9","6","6","3","7","5","1","6","10","1"},
                                            {"屏東縣","瑪家鄉","9","7","8","3","7","5","1","6","9","2"},
                                            {"屏東縣","泰武鄉","9","7","7","3","7","5","1","6","10","1"},
                                            {"屏東縣","來義鄉","9","7","7","3","7","5","1","6","10","2"},
                                            {"屏東縣","春日鄉","9","7","7","3","7","5","1","6","10","1"},
                                            {"屏東縣","獅子鄉","9","6","6","3","7","5","1","6","10","1"},
                                            {"屏東縣","牡丹鄉","9","7","7","3","7","5","1","6","10","1"},
                                            {"臺東縣","臺東市","1","6","4","10","1","9","9","1","4","9"},
                                            {"臺東縣","成功鎮","1","6","4","6","2","10","3","3","9","3"},
                                            {"臺東縣","關山鎮","1","6","4","5","4","9","2","4","8","2"},
                                            {"臺東縣","卑南鄉","1","6","4","6","4","8","3","3","9","3"},
                                            {"臺東縣","鹿野鄉","1","6","4","5","4","8","2","4","9","2"},
                                            {"臺東縣","池上鄉","1","6","4","5","4","8","2","4","9","2"},
                                            {"臺東縣","東河鄉","1","6","4","4","4","8","2","4","10","2"},
                                            {"臺東縣","長濱鄉","1","6","4","4","5","8","1","4","9","1"},
                                            {"臺東縣","太麻里鄉","1","6","4","5","6","4","3","3","9","2"},
                                            {"臺東縣","大武鄉","1","6","4","4","3","9","1","5","9","1"},
                                            {"臺東縣","綠島鄉","1","6","4","4","4","9","1","5","9","1"},
                                            {"臺東縣","海端鄉","1","6","3","3","7","5","1","5","10","1"},
                                            {"臺東縣","延平鄉","1","6","4","3","5","8","1","5","10","1"},
                                            {"臺東縣","金峰鄉","1","6","4","3","6","8","1","5","10","1"},
                                            {"臺東縣","達仁鄉","1","6","4","3","7","5","1","5","10","1"},
                                            {"臺東縣","蘭嶼鄉","1","6","4","4","5","8","1","5","9","1"},
                                            {"花蓮縣","花蓮市","1","5","5","10","1","9","9","1","2","9"},
                                            {"花蓮縣","鳳林鎮","1","5","5","5","6","4","4","3","9","2"},
                                            {"花蓮縣","玉里鎮","1","4","4","7","3","8","5","2","9","4"},
                                            {"花蓮縣","新城鄉","1","5","5","7","3","9","5","3","5","4"},
                                            {"花蓮縣","吉安鄉","1","5","5","9","2","8","9","1","4","8"},
                                            {"花蓮縣","壽豐鄉","1","4","5","7","3","8","6","2","9","3"},
                                            {"花蓮縣","光復鄉","1","5","5","6","4","8","2","4","9","3"},
                                            {"花蓮縣","豐濱鄉","1","5","5","3","7","5","1","5","10","1"},
                                            {"花蓮縣","瑞穗鄉","1","5","5","6","4","8","3","4","9","2"},
                                            {"花蓮縣","富里鄉","1","4","5","5","4","8","3","4","9","2"},
                                            {"花蓮縣","秀林鄉","1","4","2","6","10","9","3","4","10","3"},
                                            {"花蓮縣","萬榮鄉","1","4","3","3","7","5","1","6","10","1"},
                                            {"花蓮縣","卓溪鄉","1","4","2","3","7","5","1","6","10","1"},
                                            {"基隆市","中正區","4","10","4","9","10","2","5","2","2","6"},
                                            {"基隆市","七堵區","4","10","3","9","2","2","6","2","4","7"},
                                            {"基隆市","暖暖區","4","10","3","7","4","2","4","5","3","5"},
                                            {"基隆市","仁愛區","4","10","4","9","2","1","6","1","1","6"},
                                            {"基隆市","中山區","4","10","4","8","3","2","5","4","2","6"},
                                            {"基隆市","安樂區","4","10","3","9","3","2","7","3","2","8"},
                                            {"基隆市","信義區","4","10","3","8","9","9","5","4","2","7"},
                                            {"新竹市","東區","2","4","4","10","1","1","10","1","3","10"},
                                            {"新竹市","北區","2","5","6","10","5","9","9","1","3","9"},
                                            {"新竹市","香山區","2","4","3","9","1","10","7","3","6","8"},
                                            {"新竹市","東區","7","4","2","10","1","1","9","1","4","9"},
                                            {"新竹市","西區","7","4","2","4","10","9","9","4","4","9"},
                                    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        output = (TextView) this.findViewById(R.id.T03);

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


        ImageButton ToPage3BTN = (ImageButton) findViewById(R.id.ToPage3BTN);
        ToPage3BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        ImageButton ToPage4BTN = (ImageButton) findViewById(R.id.ToPage4BTN);
        ToPage4BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, MainActivity5.class);
                startActivity(intent);
            }
        });

        ImageButton ToPage5BTN = (ImageButton) findViewById(R.id.ToPage5BTN);
        ToPage5BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, MainActivity7.class);
                startActivity(intent);
            }
        });

        ImageButton ToPage6BTN = (ImageButton) findViewById(R.id.ToPage6BTN);
        ToPage6BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, MainActivity6.class);
                startActivity(intent);
            }
        });
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, MainActivity29.class);
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onResume() {
        super.onResume();
        ll = new MyLocationListener();
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
                Toast.makeText(MainActivity2.this, "經緯度座標變更....", Toast.LENGTH_SHORT).show();
            }
            Geocoder geocoder = new Geocoder(MainActivity2.this);
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


            //  NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            final Timer timer;

            timer = new Timer();
            final TimerTask task = new TimerTask() {
                GlobalVariable gv = (GlobalVariable) getApplicationContext();
                public int tt = (gv.gettime())*60;
                int count =1;
                private void stopTimer() {
                    timer.cancel();
                }
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                        //output.setText(tt);
                        tt--;


            Intent intent = new Intent();
            GlobalVariable gv = (GlobalVariable) getApplicationContext();
            int x1 = gv.getProgress1();int x2 = gv.getProgress2();int x3 = gv.getProgress3();
            int x4 = gv.getProgress4();int x5 = gv.getProgress5();int x6 = gv.getProgress6();
            int x7 = gv.getProgress7();int x8 = gv.getProgress8();int x9 = gv.getProgress9();
            int level = gv.getLevel();
            String skin1 =gv.getSkin1();String skin2 =gv.getSkin2();String skin3 =gv.getSkin3();
            String skin4 =gv.getSkin4();String skin5 =gv.getSkin5();String skin6 =gv.getSkin6();
            String skin7 =gv.getSkin7();String skin8 =gv.getSkin8();String skin9 =gv.getSkin9();

            String edit1 = gv.getEdit1();String edit2 = gv.getEdit2();String edit3 = gv.getEdit3();
            String edit4 = gv.getEdit4();String edit5 = gv.getEdit5();String edit6 = gv.getEdit6();
            String edit7 = gv.getEdit7();String edit8 = gv.getEdit8();String edit9 = gv.getEdit9();
            String id = "1";
            String id2 = "2";
            String id3 = "3";
            String id4 = "4";
            String id5 = "5";
            String id6 = "6";
            String id7 = "7";
            String id8 = "8";
            String id9 = "9";
            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);



          //  while (tt!=0){
                for (int i = 0;i < 351; i++) {
                if (data[i][1].equals(addresstext)) {
                    int score1 = Integer.parseInt(data[i][2]);
                    int score2 = Integer.parseInt(data[i][3]);
                    int score3 = Integer.parseInt(data[i][4]);
                    int score4 = Integer.parseInt(data[i][5]);
                    int score5 = Integer.parseInt(data[i][6]);
                    int score6 = Integer.parseInt(data[i][7]);
                    int score7 = Integer.parseInt(data[i][8]);
                    int score8 = Integer.parseInt(data[i][9]);
                    int score9 = Integer.parseInt(data[i][10]);
                    int score10 = Integer.parseInt(data[i][11]);
              //  if(tt!=0||tt!=10||tt!=20||tt!=30||tt!=40){ count=0; }

                    if (score1 - x1 >= level &&count==1) {
                        Notification notification = new NotificationCompat.Builder(MainActivity2.this, id)
                                .setWhen(System.currentTimeMillis())//通知產生的時間，會在通知資訊裡顯示，一般是系統獲取到的時間
                                .setAutoCancel(true) //狀態通知後自動清除狀態列欄位
                                .setDefaults(Notification.DEFAULT_SOUND)//獲取預設鈴聲
                                .setSound(Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "6"))//獲取Android多媒體庫內的鈴聲
                                .setSmallIcon(R.drawable.acne)
                                .setContentTitle("警告").setContentText("抗發炎指數已超過 請使用:"+skin1)
                                .setContentText("備註:"+edit1)
                                .build();
                        long[] vibrates = { 0, 1000, 1000, 1000 };//延遲0ms，然後振動1000ms，再延遲1000ms，再振動1000ms
                        notification.vibrate = vibrates;
                        mNotificationManager.notify(1, notification);



                    }
                    if (score2 - x2 >= level &&count==1) {
                        Notification notification = new NotificationCompat.Builder(MainActivity2.this, id2)
                                .setWhen(System.currentTimeMillis())//通知產生的時間，會在通知資訊裡顯示，一般是系統獲取到的時間
                                .setAutoCancel(true) //狀態通知後自動清除狀態列欄位
                                .setDefaults(Notification.DEFAULT_SOUND)//獲取預設鈴聲
                                .setSound(Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "6"))//獲取Android多媒體庫內的鈴聲
                                .setSmallIcon(R.drawable.plants)
                                .setContentTitle("警告")
                                .setContentText("空氣淨化需求度已超過 請使用:"+skin2)
                                .build();
                        long[] vibrates = { 0, 1000, 1000, 1000 };//延遲0ms，然後振動1000ms，再延遲1000ms，再振動1000ms
                        notification.vibrate = vibrates;
                        mNotificationManager.notify(2, notification);

                    }
                    if (score3 - x3 >= level &&count==1) {
                        Notification notification = new NotificationCompat.Builder(MainActivity2.this, id3)
                                .setWhen(System.currentTimeMillis())//通知產生的時間，會在通知資訊裡顯示，一般是系統獲取到的時間
                                .setAutoCancel(true) //狀態通知後自動清除狀態列欄位
                                .setDefaults(Notification.DEFAULT_SOUND)//獲取預設鈴聲
                                .setSound(Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "6"))//獲取Android多媒體庫內的鈴聲
                                .setSmallIcon(R.drawable.blue_crackshield)
                                .setContentTitle("警告")
                                .setContentText("抗敏感指數已超過 請使用:"+skin3)
                                .build();
                        long[] vibrates = { 0, 1000, 1000, 1000 };//延遲0ms，然後振動1000ms，再延遲1000ms，再振動1000ms
                        notification.vibrate = vibrates;
                        mNotificationManager.notify(3, notification);

                    }
                    if (score4 - x4 > level &&count==1) {
                        Notification notification = new NotificationCompat.Builder(MainActivity2.this, id4)
                                .setWhen(System.currentTimeMillis())//通知產生的時間，會在通知資訊裡顯示，一般是系統獲取到的時間
                                .setAutoCancel(true) //狀態通知後自動清除狀態列欄位
                                .setDefaults(Notification.DEFAULT_SOUND)//獲取預設鈴聲
                                .setSound(Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "6"))//獲取Android多媒體庫內的鈴聲
                                .setSmallIcon(R.drawable.blue_fast_time)
                                .setContentTitle("警告")
                                .setContentText("抗老化指數已超過 請使用:"+skin4)
                                .build();
                        mNotificationManager.notify(4, notification);

                    }
                    if (score5 - x5 >= level&&count==1) {
                        Notification notification = new NotificationCompat.Builder(MainActivity2.this, id5)
                                .setWhen(System.currentTimeMillis())//通知產生的時間，會在通知資訊裡顯示，一般是系統獲取到的時間
                                .setAutoCancel(true) //狀態通知後自動清除狀態列欄位
                                .setDefaults(Notification.DEFAULT_SOUND)//獲取預設鈴聲
                                .setSound(Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "6"))//獲取Android多媒體庫內的鈴聲
                                .setSmallIcon(R.drawable.darkflash)
                                .setContentTitle("警告")
                                .setContentText("抗刺激性指數已超過 請使用:"+skin5)
                                .build();
                        mNotificationManager.notify(5, notification);

                    }
                    if (score6 - x6 >= level &&count==1) {
                        Notification notification = new NotificationCompat.Builder(MainActivity2.this, id6)
                                .setWhen(System.currentTimeMillis())//通知產生的時間，會在通知資訊裡顯示，一般是系統獲取到的時間
                                .setAutoCancel(true) //狀態通知後自動清除狀態列欄位
                                .setDefaults(Notification.DEFAULT_SOUND)//獲取預設鈴聲
                                .setSound(Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "6"))//獲取Android多媒體庫內的鈴聲
                                .setSmallIcon(R.drawable.dark1)
                                .setContentTitle("警告")
                                .setContentText("抗黑斑指數已超過 請使用:"+skin6)
                                .build();
                        long[] vibrates = { 0, 1000, 1000, 1000 };//延遲0ms，然後振動1000ms，再延遲1000ms，再振動1000ms
                        notification.vibrate = vibrates;
                        mNotificationManager.notify(6, notification);

                    }
                    if (score7 - x6 >= level &&count==1) {
                        Notification notification = new NotificationCompat.Builder(MainActivity2.this, id7)
                                .setWhen(System.currentTimeMillis())//通知產生的時間，會在通知資訊裡顯示，一般是系統獲取到的時間
                                .setAutoCancel(true) //狀態通知後自動清除狀態列欄位
                                .setDefaults(Notification.DEFAULT_SOUND)//獲取預設鈴聲
                                .setSound(Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "6"))//獲取Android多媒體庫內的鈴聲
                                .setSmallIcon(R.drawable.dark1)
                                .setContentTitle("警告")
                                .setContentText("抗黑斑指數已超過 請使用:"+skin6)
                                .build();
                        long[] vibrates = { 0, 1000, 1000, 1000 };//延遲0ms，然後振動1000ms，再延遲1000ms，再振動1000ms
                        notification.vibrate = vibrates;
                        mNotificationManager.notify(7, notification);

                    }
                    if (score8 - x7 >= level &&count==1l) {
                        Notification notification = new NotificationCompat.Builder(MainActivity2.this, id8)
                                .setWhen(System.currentTimeMillis())//通知產生的時間，會在通知資訊裡顯示，一般是系統獲取到的時間
                                .setAutoCancel(true) //狀態通知後自動清除狀態列欄位
                                .setDefaults(Notification.DEFAULT_SOUND)//獲取預設鈴聲
                                .setSound(Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "6"))//獲取Android多媒體庫內的鈴聲
                                .setSmallIcon(R.drawable.uv_sun)
                                .setContentTitle("警告")
                                .setContentText("抗紫外線的程度已超過 請使用:"+skin7)
                                .build();
                        long[] vibrates = { 0, 1000, 1000, 1000 };//延遲0ms，然後振動1000ms，再延遲1000ms，再振動1000ms
                        notification.vibrate = vibrates;
                        mNotificationManager.notify(8, notification);

                    }
                    if (score9 - x8 >= level &&count==1) {
                        Notification notification = new NotificationCompat.Builder(MainActivity2.this, id9)
                                .setWhen(System.currentTimeMillis())//通知產生的時間，會在通知資訊裡顯示，一般是系統獲取到的時間
                                .setAutoCancel(true) //狀態通知後自動清除狀態列欄位
                                .setDefaults(Notification.DEFAULT_SOUND)//獲取預設鈴聲
                                .setSound(Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "6"))//獲取Android多媒體庫內的鈴聲
                                .setSmallIcon(R.drawable.cancer)
                                .setContentTitle("警告")
                                .setContentText("可承受皮膚病變的程度已超過 請使用:"+skin8)
                                .build();
                        long[] vibrates = { 0, 1000, 1000, 1000 };//延遲0ms，然後振動1000ms，再延遲1000ms，再振動1000ms
                        notification.vibrate = vibrates;
                        mNotificationManager.notify(9, notification);


                    }
                    if (score10 - x9 >= level &&count==1) {
                        Notification notification = new NotificationCompat.Builder(MainActivity2.this, id9)
                                .setWhen(System.currentTimeMillis())//通知產生的時間，會在通知資訊裡顯示，一般是系統獲取到的時間
                                .setAutoCancel(true) //狀態通知後自動清除狀態列欄位
                                .setDefaults(Notification.DEFAULT_SOUND)//獲取預設鈴聲
                                .setSound(Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "6"))//獲取Android多媒體庫內的鈴聲
                                .setSmallIcon(R.drawable.cancer)
                                .setContentTitle("警告")
                                .setContentText("可承受皮膚病變的程度已超過 請使用:"+skin9)
                                .build();
                        long[] vibrates = { 0, 1000, 1000, 1000 };//延遲0ms，然後振動1000ms，再延遲1000ms，再振動1000ms
                        notification.vibrate = vibrates;
                        mNotificationManager.notify(9, notification);


                    }


                  //  if(tt!=0){break;}

                }
                }
                            if(tt>=0){count=0;}


            }


                    });
                    if(tt>0){count=0;}
                    if(tt<0){stopTimer();}

        }};
        timer.schedule(task,1000,1000);

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
